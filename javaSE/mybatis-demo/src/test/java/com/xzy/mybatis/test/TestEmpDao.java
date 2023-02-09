package com.xzy.mybatis.test;

import com.xzy.mybatis.dao.IEmpDao;
import com.xzy.mybatis.dao.Impl.EmpDaoImpl;
import com.xzy.mybatis.entity.Emp;
import com.xzy.mybatis.mapper.EmpMapper;
import com.xzy.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestEmpDao {
    private IEmpDao empDao = new EmpDaoImpl();

    /**
     * 静态条件查询
     */
    @Test
    public void testSelect(){
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> empList = empMapper.selectList(1,1);
            System.out.println(empList);

        }catch (Exception e){
            e.printStackTrace();
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
    }

    /**
     * 动态条件查询,与like ${} 模糊查询
     */
    @Test
    public void testSelectByEmp(){
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = new Emp();
            emp.setEmpCode(""); //code为空时,不作为条件
            emp.setDepId(1);
            emp.setSex(1);          //条件查询
            emp.setEmpName("王");    //模糊查询
            List<Emp> empList = empMapper.selectListByEmp(emp);
            System.out.println(empList);

        }catch (Exception e){
            e.printStackTrace();
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
    }

    @Test
    public void testInsertEmp(){
        int rows;
        Emp emp = new Emp();
        emp.setEmpCode("200115");
        emp.setEmpName("注解");
        emp.setSex(2);
        emp.setIdCard("77777777");
        emp.setMobile("13647589263");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = sdf.parse("2000-02-14");
            System.out.println(birthday);
            emp.setBirthday(birthday);
            emp.setMoney(7777);
            emp.setDepId(10);
            System.out.println(emp);
            rows = empDao.insertEmp(emp);
            System.out.println(rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdateEmp(){
        int rows;
        Emp emp = new Emp();
        emp.setEmpId(35);
        emp.setMoney(55555);
        System.out.println(emp);
        rows = empDao.updateById(emp);
        System.out.println(rows);
    }
    @Test
    public void testDeleteEmp(){
       int rows = empDao.deleteById(35);
        System.out.println(rows);
    }

    /**
     *根据Map传对应值
     */
    @Test
    public void testUpdateByMap(){
        SqlSession sqlSession = null;
        int rows;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Map<String,Object> paramMap = new HashMap<>();
            paramMap.put("emp_id",36);
            paramMap.put("money",77777);
            paramMap.put("mobile","13862375896");
            rows  = empMapper.updateByMap(paramMap);
            System.out.println(rows);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
    }

    /**
     * 关联查询
     */
    @Test
    public void testSelectById(){
       Emp emp = empDao.selectById(1);
        System.out.println(emp);
    }
}
