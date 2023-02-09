package com.xzy.orm.dao;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.xzy.orm.util.QueryWrapper;
import com.xzy.orm.util.SQLBuilderUtils;

import java.io.Serializable;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Dao基础类
 *
 * @author luliujun
 */
public abstract class BaseDao {
    public static String user;// 用户
    public static String password;// 密码
    public static String driver;// 数据库连接驱动class类
    public static String url;// 数据库连接URL

    static {
        ResourceBundle rs = ResourceBundle.getBundle("db");
        user = rs.getString("com.xzy.db.config.user");
        password = rs.getString("com.xzy.db.config.password");
        driver = rs.getString("com.xzy.db.config.driverClassName");
        url = rs.getString("com.xzy.db.config.url");
    }

    public BaseDao() {
        super();
    }

    /**
     * 获得数据库连接
     *
     * @return
     */
    public final static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    /**
     * 回滚事务
     *
     * @param conn
     */
    public void rollBack(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭资源
     *
     * @param c
     * @param s
     * @param rs
     */
    public void closeAll(ResultSet rs, Statement s, Connection c) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 执行DML语句
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object... params) {
        int status = -1;
        Connection conn = getConnection();
        if (null != conn) {
            PreparedStatement ps = null;
            try {
                ps = conn.prepareStatement(sql);
                int count = params.length;
                for (int index = 1; index <= count; index++) {
                    Object param = params[index - 1];
                    if (null == param) {
                        ps.setNull(index, Types.JAVA_OBJECT);
                        continue;
                        //throw new IllegalArgumentException("DML语句参数不能为null");
                    }
                    if (param instanceof java.util.Date) {
                        Date date = new Date(((java.util.Date) param).getTime());
                        ps.setDate(index, date);
                        continue;
                    }
                    ps.setObject(index, param.toString());
                }
                status = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            closeAll(null, ps, conn);
        }
        return status;
    }
    /**
     * 根据ID查询一个对象
     *
     * @param sql         select语句
     * @param id          ID
     * @param entityClass 实体类class类型
     * @return
     */
    public Object selectById(String sql, Serializable id, Class<?> entityClass) {
        Object entity;
        try {
            entity = entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Map<String, String> dataMap = new HashMap<>();
                ResultSetMetaData rsMetaData = ps.getMetaData();
                //检索列名列表
                int count = rsMetaData.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    //列名(字段名)
                    String columnName = rsMetaData.getColumnName(i);
                    //属性名
                    String fieldName = StrUtil.toCamelCase(columnName);//转驼峰
                    if(fieldName.equals("idcard")){
                        fieldName = "idCard";
                    }
                    //属性值
                    String fieldValue = rs.getString(columnName);
                    //用map打包数据
                    dataMap.put(fieldName, fieldValue);
                }
                //填充实体类属性值
                BeanUtil.fillBeanWithMap(dataMap, entity, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity = null;
        }
        closeAll(rs, ps, conn);
        return entity;
    }
    /**
     * 根据ID查询一个对象
     * 注:id可以是int、long、String等类型
     *
     * @param id          ID
     * @param entityClass 实体类class类型
     * @return
     */
    protected Object selectEntityById(Serializable id, Class<?> entityClass) {
        Object entity;
        try {
            entity = entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = SQLBuilderUtils.builderSelectSQL(entityClass, true);
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                entity = getEntity(entityClass, rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entity = null;
        }
        closeAll(rs, ps, conn);
        return entity;
    }

    /**
     * 添加一个对象
     * @param entity
     * @return
     */
    public int insert(Object entity){
        List<Object> paramList = new ArrayList<>();
        String sql = SQLBuilderUtils.builderInsertSQL(entity,paramList);
        return executeUpdate(sql,paramList.toArray());
    }
    /**
     * 根据ID删除记录
     * 注:id可以是int、long、String等类型
     *
     * @param id
     * @param entityClass
     * @return
     */
    protected int deleteEntityById(Serializable id, Class<?> entityClass) {
        String sql = SQLBuilderUtils.builderDeleteSQL(entityClass);
        return executeUpdate(sql, id);
    }

    /**
     * 根据ID修改
     *
     * @param entity      实体对象
     * @param columnNames 字段名列表(注:字段值设置为null)
     * @return
     */
    protected int updateEntityById(Object entity, String... columnNames) {
        List<Object> paramList = new ArrayList<>();
        String sql = SQLBuilderUtils.builderUpdateSQL(entity, paramList, columnNames);
        return executeUpdate(sql, paramList.toArray());
    }

    /**
     * 根据条件查询返回列表
     *
     * @param entityClass 实体类class类型
     * @param qw          查询条件
     * @return
     */
    protected List<Object> selectEntityList(Class<?> entityClass, QueryWrapper qw) {
        String selectPart = SQLBuilderUtils.builderSelectSQL(entityClass, false);
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append(selectPart);
        Object[] params = null;
        if (qw != null) {
            String wherePart = qw.getWherePart();
            sqlBuf.append(' ');
            sqlBuf.append(wherePart);
            params = qw.getParams();
        }
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Object> entityList = new ArrayList<>();
        try {
            String sql = sqlBuf.toString();
            ps = conn.prepareStatement(sql);
            if (params != null) {
                int count = params.length;
                //设置占位符的值
                for (int index = 1; index <= count; index++) {
                    Object param = params[index - 1];
                    if (null == param) {
                        throw new IllegalArgumentException("查询条件不能为null");
                    }
                    if (param instanceof java.util.Date) {
                        Date date = new Date(((java.util.Date) param).getTime());
                        ps.setDate(index, date);
                        continue;
                    }
                    ps.setObject(index, param.toString());
                }
            }
            rs = ps.executeQuery();
            System.out.println(ps.toString());
            ResultSetMetaData rsMetaData = ps.getMetaData();
            while (rs.next()) {
                Object entity = getEntity(entityClass, rs);
                entityList.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            entityList = null;
        }
        closeAll(rs, ps, conn);
        return entityList;
    }

    /**
     * 将一条记录打包成实体类对象
     *
     * @param entityClass 实体类class对象
     * @param rs          查询结果集
     * @return
     * @throws Exception
     */
    private Object getEntity(Class<?> entityClass, ResultSet rs) throws Exception {
        Object entity = entityClass.newInstance();
        Map<String, String> dataMap = new HashMap<>();
        ResultSetMetaData rsMetaData = rs.getMetaData();
        //检索列名列表
        int count = rsMetaData.getColumnCount();
        for (int i = 1; i <= count; i++) {
            //列名(字段名)
            String columnName = rsMetaData.getColumnName(i);
            //属性名
            String fieldName = StrUtil.toCamelCase(columnName);//转驼峰
            //属性值
            String fieldValue = rs.getString(columnName);
            //用map打包数据
            dataMap.put(fieldName, fieldValue);
        }
        //填充实体类属性值
        BeanUtil.fillBeanWithMapIgnoreCase(dataMap, entity, false);
        return entity;
    }
}
