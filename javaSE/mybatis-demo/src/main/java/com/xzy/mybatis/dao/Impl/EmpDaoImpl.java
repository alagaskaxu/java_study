package com.xzy.mybatis.dao.Impl;

import com.xzy.mybatis.dao.IEmpDao;
import com.xzy.mybatis.entity.Emp;
import com.xzy.mybatis.mapper.EmpMapper;
import com.xzy.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpDaoImpl implements IEmpDao {
    @Override
    public int insertEmp(Emp emp) {
        SqlSession sqlSession = null;
        int rows;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            rows = empMapper.insertEmp(emp);
            System.out.println(rows);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            rows = -1;
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
        return rows;
    }

    @Override
    public int deleteById(int empId) {
        SqlSession sqlSession = null;
        int rows;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            rows = empMapper.deleteById(empId);
            System.out.println(rows);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            rows = -1;
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
        return rows;
    }

    @Override
    public int updateById(Emp emp) {
        SqlSession sqlSession = null;
        int rows;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            rows = empMapper.updateById(emp);
            System.out.println(rows);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            rows = -1;
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
        return rows;
    }

    @Override
    public Emp selectById(int empId) {
        SqlSession sqlSession = null;
        Emp emp;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            //获取EmpMapper接口代理对象
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            emp = empMapper.selectById(empId);
            System.out.println(emp);

        }catch (Exception e){
            e.printStackTrace();
            emp = null;
        }
        if (sqlSession !=null){
            sqlSession.close();
        }
        return emp;
    }
}
