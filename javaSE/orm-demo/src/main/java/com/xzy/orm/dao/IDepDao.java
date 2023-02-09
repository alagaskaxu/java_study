package com.xzy.orm.dao;

import com.xzy.orm.entity.Dep;

import java.util.List;

public interface IDepDao {
    List<Dep> selectList(int depState);
}
