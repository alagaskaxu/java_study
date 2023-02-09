package com.xzy.web.ems.dao.impl;

import com.xzy.web.ems.dao.BaseDao;
import com.xzy.web.ems.dao.IDepDao;
import com.xzy.web.ems.entity.Dep;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门DAO接口实现类
 */
public class DepDaoImpl extends BaseDao implements IDepDao {
    @Override
    public List<Dep> selectList(int depState) {
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
     * 根据部门ID查询部门数据
     * @param depId
     * @return
     */
    @Override
    public Dep selectById(int depId) {
        String sql = "select `dep_id`, `dep_code`, `dep_name`, `dep_state` from `t_dep` where `dep_id` = ?";
        return (Dep)selectById(sql,depId,Dep.class);
    }
}

