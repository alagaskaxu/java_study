package com.xzy.web.ems.service.impl;

import com.xzy.web.ems.dao.IDepDao;
import com.xzy.web.ems.dao.impl.DepDaoImpl;
import com.xzy.web.ems.entity.Dep;
import com.xzy.web.ems.service.IDepService;

import java.util.List;

/**
 * 部门service实现类
 */
public class DepServiceImpl implements IDepService {
    private IDepDao depDao = new DepDaoImpl();
    @Override
    public List<Dep> selectList(int depState) {
        return depDao.selectList(depState);
    }
}
