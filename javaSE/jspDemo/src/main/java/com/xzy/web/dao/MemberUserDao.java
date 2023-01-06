package com.xzy.web.dao;

import com.xzy.web.entity.MemberUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberUserDao extends BaseDao {
    /**
     * 会员注册
     *
     * @param user
     * @return
     */
    public int registerMemberUser(MemberUser user) {
        int rows = -1;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select count(1) from `t_member` where LOWER (username)=LOWER(?)");
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count >= 1) {
                rows = 2;//表示用户名已经存在
            } else {
                //当用户名没有被注册时可以被注册
                String sql = "insert into `t_member`(`username`,`password`,`head_img`)values(?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getHeadImg());
                rows = ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeAll(rs, ps, conn);

        return rows;
    }

    public MemberUser memberLogin(String username, String password) {
        MemberUser user = new MemberUser();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "select `member_id`,`head_img` from `t_member` where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
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
