package com.xzy.orm.util;

import cn.hutool.core.util.StrUtil;
import com.xzy.orm.annotation.Column;
import com.xzy.orm.annotation.Table;
import javafx.scene.control.Tab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * SQL语句构造工具,用来生成insert,update,delete,select语句
 */
public class SQLBuilderUtils {
    /**
     * 构建insert语句(使用占位符),获取SQL语句所需参数值列表
     *
     * @param entity
     * @return
     */
    public final static String builderInsertSQL(Object entity, List<Object> paramList) {
        Class<?> entityClass = entity.getClass();
        Table table = entityClass.getDeclaredAnnotation(Table.class);
        if (table == null) {
            throw new IllegalArgumentException("未配置实体类与表映射关系:" + entityClass);
        }
        //表名
        Field[] fields = entityClass.getDeclaredFields();
        //非主键字段对应的属性列表
        List<Field> fieldList = new ArrayList<>();
        //主键字段对应的属性
        Field idField = null;
        for (Field field : fields) {
            Column column = field.getDeclaredAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            if (!column.isPK()) {
                fieldList.add(field);
                continue;
            }
            if (idField == null) {
                idField = field;
            } else {
                throw new IllegalArgumentException("配置多个ID属性");
            }
        }
        if (idField == null) {
            throw new IllegalArgumentException("未配置ID属性");
        }
        //主键字段
        Column pkColumn = idField.getDeclaredAnnotation(Column.class);
        if (!pkColumn.auto()) {
            //如果主键不是自增长,insert语句添加的字段中需要包含主键字段
            fieldList.add(idField);
        }
        if (fieldList.isEmpty()) {
            throw new IllegalArgumentException("至少配置一个非ID属性");
        }
        //表名
        String tableName = table.name();
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append(appendBlankRight("insert into"));
        sqlBuf.append(tableName);
        sqlBuf.append(" (");
        StringBuffer paramBuf = new StringBuffer();
        for (Field field : fieldList) {
            Column column = field.getDeclaredAnnotation(Column.class);
            sqlBuf.append(column.name());
            sqlBuf.append(",");
            paramBuf.append("?,");
            //获取属性的值
            Object param = getFieldValue(field, entity);
            //设置insert语句占位符的值
            paramList.add(param);
        }
        //删除最后一个逗号
        sqlBuf.deleteCharAt(sqlBuf.length() - 1);
        paramBuf.deleteCharAt(paramBuf.length() - 1);
        sqlBuf.append(")values(");
        sqlBuf.append(paramBuf.toString());
        sqlBuf.append(')');
        return sqlBuf.toString();
    }
    /**
     * 获取主键字段
     *
     * @param entityClass
     * @return
     */
    private final static Column getPKColumn(Class<?> entityClass) {
        Field[] fields = entityClass.getDeclaredFields();
        Column pkColumn = null;
        for (Field field : fields) {
            Column column = field.getDeclaredAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            if (!column.isPK()) {
                continue;
            }
            if (pkColumn == null) {
                pkColumn = column;
            } else {
                throw new IllegalArgumentException("配置多个ID属性");
            }
        }
        if (pkColumn == null) {
            throw new IllegalArgumentException("未配置ID属性");
        }
        return pkColumn;
    }

    /**
     * 通过get方法获取属性的值
     *
     * @param field
     * @param entity
     * @return
     */
    private static Object getFieldValue(Field field, Object entity) {
        String fieldName = field.getName();//属性名
        //get方法名称:get+属性名(第一个字母大写)
        String getMethodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
            //获取get方法
            Method method = entity.getClass().getDeclaredMethod(getMethodName);
            Object param = method.invoke(entity);
            return param;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 构建删除语句
     *
     * @param entityClass
     * @return
     */
    public final static String builderDeleteSQL(Class<?> entityClass) {
        Table table = entityClass.getDeclaredAnnotation(Table.class);
        if (table == null) {
            throw new IllegalArgumentException("未配置实体类与表映射关系:" + entityClass.getName());
        }
        Column pkColumn = getPKColumn(entityClass);
        StringBuffer sqlBuf = new StringBuffer("delete from ");
        sqlBuf.append(table.name());
        sqlBuf.append(appendBlankAround("where"));
        sqlBuf.append(pkColumn.name());
        sqlBuf.append(appendBlankLeft("=?"));
        String sql = sqlBuf.toString();
        return sql;
    }

    /**
     * 构建查询语句
     *
     * @param entityClass 实体类class类型
     * @param byId        是否通过ID查询(true:是;false:否)
     * @return
     */
    public final static String builderSelectSQL(Class<?> entityClass, boolean byId) {
        Table table = entityClass.getDeclaredAnnotation(Table.class);
        if (table == null) {
            throw new IllegalArgumentException("未配置实体类与表映射关系:" + entityClass.getName());
        }
        Field[] fields = entityClass.getDeclaredFields();
        //存放已配置@Column注解的属性
        List<Field> fieldList = new ArrayList<>();
        //ID属性
        Field idField = null;
        for (Field field : fields) {
            Column column = field.getDeclaredAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            fieldList.add(field);
            if (!column.isPK()) {
                continue;
            }
            if (idField == null) {
                idField = field;
            } else {
                throw new IllegalArgumentException("配置多个ID属性");
            }
        }
        if (idField == null) {
            throw new IllegalArgumentException("未配置ID属性");
        }
        //主键字段
        Column pkColumn = idField.getDeclaredAnnotation(Column.class);
        StringBuffer sqlBuf = new StringBuffer("select ");
        for (Field field : fieldList) {
            Column column = field.getDeclaredAnnotation(Column.class);
            //字段名
            String columnName = column.name();
            sqlBuf.append(columnName);
            sqlBuf.append(',');
        }
        //删除最后一个逗号
        sqlBuf.deleteCharAt(sqlBuf.length() - 1);
        sqlBuf.append(appendBlankAround("from"));
        sqlBuf.append(table.name());
        if (byId) {
            sqlBuf.append(appendBlankAround("where"));
            sqlBuf.append(pkColumn.name());
            sqlBuf.append(appendBlankLeft("=?"));
        }
        String sql = sqlBuf.toString();
        return sql;
    }

    /**
     * 构建update语句(使用占位符),获取SQL语句所需参数值列表
     *
     * @param entity      实体对象
     * @param paramList   update语句占位符参数值列表
     * @param columnNames 字段名列表(注:字段值设置为null)
     * @return
     */
    public final static String builderUpdateSQL(Object entity, List<Object> paramList, String... columnNames) {
        Class<?> entityClass = entity.getClass();
        Table table = entityClass.getDeclaredAnnotation(Table.class);
        if (table == null) {
            throw new IllegalArgumentException("未配置实体类与表映射关系:" + entityClass.getName());
        }
        Field[] fields = entityClass.getDeclaredFields();
        //存放已配置@Column注解的属性(ID属性除外)
        List<Field> fieldList = new ArrayList<>();
        //ID属性
        Field idField = null;
        for (Field field : fields) {
            Column column = field.getDeclaredAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            if (!column.isPK()) {
                fieldList.add(field);
                continue;
            }
            if (idField == null) {
                idField = field;
            } else {
                throw new IllegalArgumentException("配置多个ID属性");
            }
        }
        if (idField == null) {
            throw new IllegalArgumentException("未配置ID属性");
        }
        //主键字段
        Column pkColumn = idField.getDeclaredAnnotation(Column.class);
        if (fieldList.isEmpty()) {
            throw new IllegalArgumentException("至少配置一个非ID属性");
        }
        //ID属性值
        Object idFieldVal = getFieldValue(idField, entity);
        if (idFieldVal == null) {
            throw new IllegalArgumentException("ID属性值不能为空");
        }
        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append(appendBlankRight("update"));
        //表名
        String tableName = table.name();
        sqlBuf.append(tableName);
        sqlBuf.append(appendBlankAround("set"));
        //统计修改的字段
        int count = 0;
        for (Field field : fieldList) {
            //获取属性的值
            Object param = getFieldValue(field, entity);
            if (param == null) {
                continue;
            }
            count++;
            //属性值不为空,才会被修改
            Column column = field.getDeclaredAnnotation(Column.class);
            sqlBuf.append(column.name());
            sqlBuf.append("=?,");
            //设置update语句占位符的值
            paramList.add(param);
        }
        //主键字段名称
        String pkColumnName = pkColumn.name();
        //以下字段设置为null值
        for (String columnName : columnNames) {
            if (pkColumnName.equalsIgnoreCase(columnName)) {
                throw new IllegalArgumentException("主键字段:" + pkColumnName + "不可以设置为null");

            }
            sqlBuf.append(columnName);
            count++;
            sqlBuf.append("=null,");
        }
        if (0 == count) {
            throw new IllegalArgumentException("没有任何可修改的字段");
        }
        //设置主键字段对应的值
        paramList.add(idFieldVal);
        //删除最后一个逗号
        sqlBuf.deleteCharAt(sqlBuf.length() - 1);
        sqlBuf.append(appendBlankAround("where"));
        sqlBuf.append(pkColumnName);
        sqlBuf.append("=?");
        return sqlBuf.toString();
    }
    /**
     * 在字符串左右两边添加空格
     *
     * @param str
     * @return
     */
    private final static String appendBlankAround(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        if (StrUtil.isBlank(str)) {
            return str;
        }
        //清除原有空格
        str = StrUtil.cleanBlank(str);
        return ' ' + str + ' ';
    }

    /**
     * 在字符串左边添加空格
     *
     * @param str
     * @return
     */
    private final static String appendBlankLeft(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        if (StrUtil.isBlank(str)) {
            return str;
        }
        //清除左边空格
        str = StrUtil.trimStart(str);
        return ' ' + str;
    }

    /**
     * 在字符串右边添加空格
     *
     * @param str
     * @return
     */
    private final static String appendBlankRight(String str) {
        if (StrUtil.isEmpty(str)) {
            return str;
        }
        if (StrUtil.isBlank(str)) {
            return str;
        }
        //清除末尾空格
        str = StrUtil.trimEnd(str);
        return str + ' ';
    }

}
