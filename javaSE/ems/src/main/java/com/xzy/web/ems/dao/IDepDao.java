package com.xzy.web.ems.dao;

import com.xzy.web.ems.entity.Dep;

import java.util.List;

/**
 * 部门DAO接口
 */
public interface IDepDao {
    /**
     * 根据部门状态查询部门数据
     * @param depState
     * @return
     */
    List<Dep> selectList(int depState);

    /**
     * 根据部门ID查询部门数据
     * @param depId
     * @return
     */
    Dep selectById(int depId);
}
