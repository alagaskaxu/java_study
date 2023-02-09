package com.xzy.mybatis.dao.Impl;

import com.xzy.mybatis.dao.IDepDao;
import com.xzy.mybatis.entity.Dep;
import com.xzy.mybatis.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DepDaoImpl implements IDepDao {
    @Override
    public int insertDep(Dep dep) {
        SqlSession sqlSession = null;
        int rows;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            //开启事务
            rows = sqlSession.insert("insertDep", dep);
            System.out.println("影响行数:" + rows);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            rows = -1;
        }
        if (sqlSession!=null){
            sqlSession.close();
        }
        return rows;
    }

    @Override
    public int deleteById(int depId) {
        SqlSession sqlSession = null;
        int rows;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            //开启事务
            rows = sqlSession.delete("deleteById", depId);
            System.out.println("影响行数:" + rows);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            rows = -1;
        }
        if (sqlSession!=null){
            sqlSession.close();
        }
        return rows;
    }

    @Override
    public int updateById(Dep dep) {

        SqlSession sqlSession = null;
        int rows;
        try {
            sqlSession = SqlSessionUtils.getSqlSession();
            //开启事务
            rows = sqlSession.update("updateById", dep);
            System.out.println("影响行数:" + rows);
            //提交事务
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            rows = -1;
        }
        if (sqlSession!=null){
            sqlSession.close();
        }
        return rows;
    }

    @Override
    public Dep selectById(int depId) {
        Dep dep;
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            dep = sqlSession.selectOne("dep.selectById",depId);
            if (dep == null)
            {
                //未查询到数据
                dep=new Dep();
            }
        }catch (Exception e){
            e.printStackTrace();
            dep = null;
        }
        if (sqlSession!=null){
            sqlSession.close();
        }
        return dep;
    }

    @Override
    public List<Dep> selectList(int depState) {
        List<Dep> depList;
        SqlSession sqlSession = null;
        try{
            sqlSession = SqlSessionUtils.getSqlSession();
            depList = sqlSession.selectList("dep.selectList",depState);
        }catch (Exception e){
            e.printStackTrace();
            depList = null;
        }
        if (sqlSession!=null){
            sqlSession.close();
        }
        return depList;
    }
}
