package com.xzy.web.ajax.controller;

import com.xzy.web.ajax.service.IZoneService;
import com.xzy.web.ajax.service.impl.ZoneServiceImpl;
import com.xzy.web.ajax.vo.ResponseData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QueryCountyController",value = "/zone/data/county")
public class QueryCountyController extends BaseController{
    private IZoneService zoneService = new ZoneServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cityId_ = req.getParameter("cityId");
        ResponseData data;
        if (cityId_ == null){
            data = ResponseData.FAIL(100900,"缺少参数");
        }else{
            int cityId = Integer.parseInt(cityId_);
            data = zoneService.queryCountData(cityId);
        }
        responseJSONData(data,resp);
    }
}
