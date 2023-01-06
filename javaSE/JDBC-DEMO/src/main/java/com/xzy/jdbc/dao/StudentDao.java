package com.xzy.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class StudentDao extends BaseDao {

    public int insertBatch() {
        int rows = -1;
        Connection conn = getConnection();
        PreparedStatement ps = null;
        int maxCount = 200; //批处理最大上限
        try {
            String sql = "insert into `t_student`(`stu_code`,`stu_name`,`sex`)values(?,?,?)";
            ps = conn.prepareStatement(sql);
            int count = 0;
            Random r = new Random();
            for (int c = 1; c <= 50000; c++) {
                ps.setString(1, String.valueOf(c));
                ps.setString(2, "学生" + c);
                ps.setInt(3, r.nextInt(2) + 1);
                //添加到批处理
                ps.addBatch();
                count++;
                //非整数倍的剩下的sql语句
                if (count == maxCount) {
                    //达到上限,执行批处理
                    ps.executeBatch();
                    rows = +count;
                    //清空批处理
                    ps.clearBatch();
                    count = 0;
                }
            }
            if (count > 0) {
                ps.addBatch();
                rows = +count;
                //清空批处理
                ps.clearBatch();
                count = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        closeAll(null, ps, conn);
        return rows;
    }
}
