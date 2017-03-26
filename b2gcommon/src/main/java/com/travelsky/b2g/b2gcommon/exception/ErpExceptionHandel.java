/**
package com.travelsky.b2g.b2gcommon.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ErrorHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class ErpExceptionHandel extends SimpleMappingExceptionResolver implements ErrorHandler {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        logger.error(ex.getMessage(), ex);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        ResponseBody body = handlerMethod.getMethodAnnotation( ResponseBody.class);

        DefaultJsonResponse resp = new DefaultJsonResponse();


        if (ex instanceof ErpControllerException) {
            ErpControllerException be = (ErpControllerException) ex;
            resp.setErr(be.getCode().getErr());
            resp.setMsg(be.getMessage());
            resp.setStatus("failure");
        }
        else if (ex instanceof ErpMqException) {
            ErpMqException es = (ErpMqException) ex;
            resp.setErr(es.getCode().getErr());
            resp.setMsg(es.getMessage());
            resp.setStatus("failure");
        }
        else if (ex instanceof ErpServiceException) {
            ErpServiceException es = (ErpServiceException) ex;

            resp.setErr(es.getCode().getErr());
            resp.setMsg(es.getMessage());
            resp.setStatus("failure");
        }
        else if (ex instanceof DataIntegrityViolationException) {
            DataIntegrityViolationException dive = (DataIntegrityViolationException) ex;

            ResponseCode responseCode = ResponseCode.UNKNOWN_ERROR;
            resp.setErr(responseCode.getErr());

            resp.setMsg(responseCode.getMessage());
            resp.setStatus("failure");
        }
        else if (ex instanceof SQLException) {
            SQLException upe = (SQLException) ex;
            ResponseCode responseCode = ResponseCode.UNKNOWN_ERROR;
            resp.setErr(responseCode.getErr());
            resp.setMsg(responseCode.getMessage());
            resp.setStatus("failure");
        }else if (ex instanceof JSONException) {
            JSONException je = (JSONException) ex;
            ResponseCode responseCode = ResponseCode.PARAMETER_FORMAT_ERROR;
            resp.setErr(responseCode.getErr());
            resp.setMsg(responseCode.getMessage("json error"));
            resp.setStatus("failure");
        }else {
            resp.setErr(ResponseCode.UNKNOWN_ERROR.getErr());
            resp.setMsg(ex.getMessage());
            resp.setStatus("failure");
        }

        //判断有没有 @ResponseBody 的注解没有的话调用父方法
//        if(body == null) {
//            return super.doResolveException(request, response,handlerMethod,ex);
//        }
        ModelAndView mv =new ModelAndView();
        //设置状态码,注意这里不能设置成500，设成500JQuery不会出错误提示
        //并且不会有任何反应
        response.setStatus(HttpStatus.OK.value());
        //设置ContentType
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        //避免乱码
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            ex.printStackTrace();
            PrintWriter writer = response.getWriter();
            writer.write(JSON.toJSONString(resp));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }

    @Override
    public void handleError(Throwable throwable) {
        //TODO 分类异常处理
        logger.error("fail", throwable);
    }
}
*/