package com.xzy.web.ajax.dao.impl;

import com.xzy.web.ajax.dao.BaseDao;
import com.xzy.web.ajax.dao.IMemberUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberUserDaoImpl extends BaseDao implements IMemberUserDao {
    @Override
    public int countUsername(String username) {
        Connection conn = getConnection();
        PreparedStatement ps =null;
        ResultSet rs = null;
        int count  = -1;
        try{
            String sql = "select count(1) from `t_member` where LOWER(`username`) = LOWER(?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        closeAll(rs,ps,conn);
        return count;
    }
}
