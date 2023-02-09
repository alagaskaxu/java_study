package com.xzy.mybatis.test;

import com.xzy.mybatis.dao.IDepDao;
import com.xzy.mybatis.dao.Impl.DepDaoImpl;
import com.xzy.mybatis.entity.Dep;
import org.junit.Test;

import java.util.List;

public class TestDepDao {
    private IDepDao depDao = new DepDaoImpl();
    @Test
    public void testInsert(){
        Dep dep = new Dep();
        dep.setDepCode("200012");
        dep.setDepName("发展部");
        dep.setDepState(9);
        int rows = depDao.insertDep(dep);
        System.out.println(rows);
    }

    @Test
    public void testDelete(){
        int rows = depDao.deleteById(14);
        System.out.println(rows);
    }
    @Test
    public void testUpdate(){
        Dep dep = new Dep();
        dep.setDepId(13);
        dep.setDepState(9);
        int rows = depDao.updateById(dep);
        System.out.println(rows);
    }
    @Test
    public void testSelectById(){
        Dep dep =depDao.selectById(1);
        System.out.println(dep);
    }
    @Test
    public void testSelectList(){
        List<Dep> depList =depDao.selectList(9);
        System.out.println(depList);
    }
}
