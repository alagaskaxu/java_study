package com.xzy.web.ajax.dao;

import java.util.List;

import com.xzy.web.ajax.entity.City;
import com.xzy.web.ajax.entity.County;
import com.xzy.web.ajax.entity.Province;

/**
 * 行政地区Dao
 *
 * @author bnt
 */
public interface ZoneDao {
    /**
     * 查询所有的省份/直辖市/自治区(一级行政地区)
     *
     * @return
     */
    List<Province> queryProvince();

    /**
     * 根据省份ID查询所有城市
     *
     * @param proId
     * @return
     */
    List<City> queryCity(Integer proId);

    /**
     * 根据地级市ID查询所有的县级市/区
     *
     * @param cityId
     * @return
     */
    List<County> queryCounty(Integer cityId);

}
