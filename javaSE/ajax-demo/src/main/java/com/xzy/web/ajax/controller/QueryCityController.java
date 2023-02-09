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
 * 根据省份ID查询地级市数据
 */
@WebServlet(name = "QueryCityController",value = "/zone/data/city")
public class QueryCityController extends BaseController{
    private IZoneService zoneService = new ZoneServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String provId_ =req.getParameter("provId");
        ResponseData data;
        if (provId_ == null)
        {
            data = ResponseData.FAIL(100900,"缺少参数");
        }else {
            int provId = Integer.parseInt(provId_);
            data = zoneService.queryCityData(provId);
        }
        responseJSONData(data, resp);
    }
}
