package com.xzy.mybatis.dao;

import com.xzy.mybatis.entity.Dep;

import java.util.List;

/**
 * 部门Dao接口
 */
public interface IDepDao {
    /**
     * 添加部门
     * @param dep
     * @return
     */
    int insertDep(Dep dep);

    int deleteById(int depId);
    int updateById(Dep depId);

    /**
     * 根据部门ID查询部门信息
     * @param depId
     * @return
     */
    Dep selectById(int depId);

    List<Dep> selectList(int depState);
}
