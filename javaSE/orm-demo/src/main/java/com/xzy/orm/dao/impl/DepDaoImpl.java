package com.xzy.orm.dao.impl;

import com.xzy.orm.dao.BaseDao;
import com.xzy.orm.dao.IDepDao;
import com.xzy.orm.entity.Dep;
import com.xzy.orm.util.QueryWrapper;

import java.util.List;

public class DepDaoImpl extends BaseDao implements IDepDao {
    @Override
    public List<Dep> selectList(int depState) {
        if (!(0 == depState || 1 == depState || 9 == depState))
        {
            throw new IllegalArgumentException("未知的查询状态"+depState);
        }
        QueryWrapper qw = new QueryWrapper();
        if (0!=depState)
        {
            qw.eq("dep_state",depState);
        }
        List<Object> depList = selectEntityList(Dep.class,qw);
        return (List<Dep>)(List) depList;
    }
}
