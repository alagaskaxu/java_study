package com.xzy.orm.test;

import com.xzy.orm.dao.IDepDao;
import com.xzy.orm.dao.impl.DepDaoImpl;
import com.xzy.orm.entity.Dep;
import org.junit.Test;

import java.util.List;

public class TestDepDao {
    private IDepDao depDao = new DepDaoImpl();
    @Test
    public void testSelectList(){
        List<Dep> depList = depDao.selectList(9);
        System.out.println(depList);
    }
}
