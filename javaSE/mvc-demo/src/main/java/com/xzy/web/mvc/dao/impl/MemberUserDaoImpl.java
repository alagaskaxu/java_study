package com.xzy.web.mvc.dao.impl;

import com.xzy.web.mvc.dao.IMemberUserDao;
import com.xzy.web.mvc.entity.MemberUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberUserDaoImpl extends BaseDao implements IMemberUserDao {

    @Override
    public MemberUser login(String username, String password) {
        MemberUser user = new MemberUser();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select `member_id`,`head_img` from `t_member` where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                //查询到数据
                int memberId = rs.getInt("member_id");
                String headImg = rs.getString("head_img");
                user.setMemberId(memberId);
                user.setUsername(username);
                user.setHeadImg(headImg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        closeAll(rs, ps, conn);
        return user;
    }
}

