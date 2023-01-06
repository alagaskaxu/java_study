package com.xzy.text;

import com.xzy.jdbc.dao.StudentDao;
import org.junit.Test;

public class StudentDaoTest {
    @Test
    public void testBatch(){
        StudentDao studentDao = new StudentDao();
        studentDao.insertBatch();
    }
}
