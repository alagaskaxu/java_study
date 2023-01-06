package com.xzy.jdbc.dao;

import com.xzy.jdbc.entity.Dep;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门数据访问层,普通Statement方法
 */
public class DepDao extends BaseDao {
    /**
     * 向数据库插入一条部门数据
     *
     * @param dep
     * @return
     */
    public int insertDep(Dep dep) {
        Connection conn = getConnection();
        Statement s = null;
        int rows = -1;
        try {
            s = conn.createStatement();

            String sql = "insert into `t_dep`(`dep_code`,`dep_name`,`dep_state`)values('" + dep.getDepCode() + "','" + dep.getDepName() + "'," + dep.getDepState() + ")";
            //利用sql语句更新sql数据库
            rows = s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //关闭资源,先关statement再关Connection
        //closeAll(null,s,conn);
        if (s != null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }

    /**
     * 根据部门状态查询部门列表数据
     *
     * @param depState
     * @return
     */
    public List<Dep> selectlist(int depState) {
        if (!(0 == depState || 1 == depState || 9 == depState)) {
            throw new IllegalArgumentException("部门状态错误:" + depState);
        }
        List<Dep> depList = null;
        Connection conn = getConnection();
        Statement s = null;
        ResultSet rs = null;    //查询结果集
        try {
            s = conn.createStatement();
            String sql;
            if (depState != 0) {
                sql = "select `dep_id`,`dep_code`,`dep_name`,`dep_state` from `t_dep` where `dep_state`=" + depState;
            } else {
                sql = "select `dep_id`,`dep_code`,`dep_name`,`dep_state` from `t_dep`";
            }
            rs = s.executeQuery(sql);
            depList = new ArrayList<>();
            while (rs.next()) {
                //获取字段值
                int depId = rs.getInt("dep_id");
                String depCode = rs.getString("dep_code");
                String depName = rs.getString("dep_name");
                int $depState = rs.getInt("dep_state");
                //打包数据
                Dep dep = new Dep(depId, depCode, depName, $depState);
                depList.add(dep);
            }
        } catch (Exception e) {
            e.printStackTrace();
            depList = null;
        }
        //关闭资源
        closeAll(rs, s, conn);
        return depList;
    }

    /**
     * 根据部门ID删除部门记录
     *
     * @param depId
     * @return
     */
    public int deleteById(int depId) {
        int rows = -1;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "delete from `t_dep` where `dep_id` = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, depId);
            rows = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeAll(null, ps, conn);
        return rows;
    }

    /**
     * 根据部门ID查询部门信息
     * @param depId
     * @return
     */
    public Dep selectById(int depId){
        Dep dep = new Dep();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "select `dep_id`,`dep_code`,`dep_name`,`dep_state` from `t_dep` where `dep_id`=?" ;
            ps = conn.prepareStatement(sql);
            ps.setInt(1,depId);
            rs = ps.executeQuery();
            if (rs.next()){
                String depCode = rs.getString("dep_code");
                String depName = rs.getString("dep_name");
                int depState = rs.getInt("dep_state");
                dep = new Dep(depId,depCode,depName,depState);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            dep = null;
        }
        return dep;
    }
    public int updateDep(Dep dep){
        int rows = -1;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "update `t_dep` set `dep_code` = ?, `dep_name` = ?, `dep_state` = ? where `dep_id` = ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,dep.getDepCode());
            ps.setString(2,dep.getDepName());
            ps.setInt(3,dep.getDepState());
            ps.setInt(4,dep.getDepId());
            rows = ps.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return rows;
    }
}
