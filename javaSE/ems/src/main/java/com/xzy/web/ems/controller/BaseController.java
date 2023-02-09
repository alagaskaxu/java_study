package com.xzy.web.ems.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xzy.web.ems.vo.ResponseData;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * 根据请求参数名称获取参数值,并转成Integer类型
     * @param req
     * @param paramName
     * @return
     */
    protected Integer getInt(HttpServletRequest req,String paramName)
    {
        String paramValue = req.getParameter(paramName);
        if (paramValue == null)
        {
            return null;
        }else {
            return Integer.valueOf(paramValue);
        }
    }
    /**
     * 获取请求参数值,并转成java.util.Date
     *
     * @param req
     * @param paramName
     * @param format
     * @return
     */
    protected Date getUtilDate(HttpServletRequest req,String paramName,String format){
        String paramValue = req.getParameter(paramName);
        if (paramValue==null||paramValue.isEmpty())
        {
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        try{
            return sdf.parse(paramValue);
        }catch (ParseException e)
        {
            throw new IllegalArgumentException(e);
        }
    }
    /**
     * 获取form表单数据,并把数据封装成指定的class类型的对象
     * 说明:日期类型属性暂没有做特殊处理
     *
     * @param req
     * @param entityClass
     * @return
     */
    protected Object getBean(HttpServletRequest req, Class<? extends Object> entityClass) {
        //获取所有参数名枚举
        Enumeration<String> nameEnum = req.getParameterNames();
        //如果不存在请求参数,直接返回
        if (!nameEnum.hasMoreElements()) {
            return null;
        }
        //利用map打包所有的参数名(key)、参数值或参数值数组(value).
        Map<String, Object> paramMap = new HashMap<>();
        while (nameEnum.hasMoreElements()) {
            String name = nameEnum.nextElement();
            String[] paramValues = req.getParameterValues(name);
            if (1 == paramValues.length) {
                //单个参数值
                paramMap.put(name, paramValues[0]);
            } else {
                /**
                 * 参数值数组
                 */
                paramMap.put(name, paramValues);
            }
        }
        Object entity = null;
        try {
            //动态实例化实体对象
            entity = entityClass.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        //利用map填充实体对象属性值
        BeanUtil.fillBeanWithMap(paramMap, entity, false);
        return entity;
    }
}
