package com.xzy.web.ajax.service;

import com.xzy.web.ajax.vo.ResponseData;


/**
 * 地区DAO接口
 */
public interface IZoneService {
    /**
     * 查询所有省份数据
     * @return
     */
    ResponseData queryProvinceData();

    /**
     * 城市
     * @return
     */
    ResponseData queryCityData(int provId);

    /**
     * 区
     * @return
     */
    ResponseData queryCountData(int cityId);
}
