package com.xzy.web.ajax.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xzy.web.ajax.vo.ResponseData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制器基类
 */
public abstract class BaseController extends HttpServlet {
    /**
     * 向客户端响应JSON格式数据
     *
     * @param data
     * @param response
     */
    public void responseJSONData(ResponseData data, HttpServletResponse response) {
        String jsonData = JSONObject.toJSONString(data, SerializerFeature.BrowserCompatible,
                SerializerFeature.WriteDateUseDateFormat,//日期格式化
                SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteMapNullValue,//null属性也输出
                SerializerFeature.WriteNullStringAsEmpty,//""
                SerializerFeature.WriteNullNumberAsZero,//0
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty);
        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().print(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
