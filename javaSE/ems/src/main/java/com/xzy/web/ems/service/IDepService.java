package com.xzy.web.ems.service;

import com.xzy.web.ems.entity.Dep;

import java.util.List;

/**
 * 部门service接口
 */
public interface IDepService {
    /**
     * 根据部门状态查询部门数据
     * @param depState
     * @return
     */
    List<Dep> selectList(int depState);
}
