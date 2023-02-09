package com.xzy.web.ems.controller;

import com.xzy.web.ems.entity.Dep;
import com.xzy.web.ems.service.IDepService;
import com.xzy.web.ems.service.impl.DepServiceImpl;
import com.xzy.web.ems.vo.ResponseData;

import javax.jws.Oneway;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 处理部门业务请求
 */
@WebServlet(name = "DepController",urlPatterns = {"/dep/create","/dep/remove","/dep/modify","/dep/id","/dep/list","/dep/list_data"})
public class DepController extends BaseController{
    private IDepService depService = new DepServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if ("/dep/list_data".equals(path)){
            responseDepData(req, resp);
        }else {
            resp.sendError(403,"访问资源不存在");
        }
    }

    /**
     * 向客户端返回json数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void responseDepData(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
        Integer depState = getInt(req,"depState");
        ResponseData data;
        if (depState == null){
            data = ResponseData.FAIL(100900,"缺少参数");
        }else{
            List<Dep> depList = depService.selectList(depState);
            if (depList == null){
                data=ResponseData.FAIL(100500,"查询加载部门数据时服务器异常");
            }else{
                //成功
                data = ResponseData.SUCCESS(depList);
            }
        }
        responseJSONData(data,resp);
    }
}
