package com.xzy.web.ajax.service.impl;

import com.xzy.web.ajax.dao.ZoneDao;
import com.xzy.web.ajax.dao.impl.ZoneDaoImpl;
import com.xzy.web.ajax.entity.City;
import com.xzy.web.ajax.entity.County;
import com.xzy.web.ajax.entity.Province;
import com.xzy.web.ajax.service.IZoneService;
import com.xzy.web.ajax.vo.ResponseData;

import java.util.List;

public class ZoneServiceImpl implements IZoneService {
    private ZoneDao zoneDao = new ZoneDaoImpl();
    @Override
    public ResponseData queryProvinceData() {
        List <Province> provinceList = zoneDao.queryProvince();
        if (provinceList == null)
        {
            return ResponseData.FAIL(100500,"查询省份数据时失败,服务器发送异常");
        }else{
            return ResponseData.SUCCESS(provinceList);
        }
    }

    @Override
    public ResponseData queryCityData(int provId) {
        List <City> cityList = zoneDao.queryCity(provId);
        if (cityList == null)
        {
            return ResponseData.FAIL(100500,"查询地级市数据时失败,服务器发送异常");
        }else{
            return ResponseData.SUCCESS(cityList);
        }
    }

    @Override
    public ResponseData queryCountData(int cityId) {
        List <County> countyList = zoneDao.queryCounty(cityId);
        if (countyList == null)
        {
            return ResponseData.FAIL(100500,"查询县级市数据时失败,服务器发送异常");
        }else{
            return ResponseData.SUCCESS(countyList);
        }
    }
}
