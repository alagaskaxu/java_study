package com.xzy.web.ajax.controller;

import com.xzy.web.ajax.service.IZoneService;
import com.xzy.web.ajax.service.impl.ZoneServiceImpl;
import com.xzy.web.ajax.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查询省份数据
 */
@WebServlet(name = "QueryProvinceController",value = "/zone/data/province")
public class QueryProvinceController extends BaseController{
    private IZoneService zoneService = new ZoneServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResponseData data = zoneService.queryProvinceData();
        responseJSONData(data,resp);
    }
}
