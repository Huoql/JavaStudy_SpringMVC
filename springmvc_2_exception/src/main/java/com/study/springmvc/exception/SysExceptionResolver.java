package com.study.springmvc.exception;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class SysExceptionResolver implements HandlerExceptionResolver{

    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param handler
     * @param ex
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) {
        //获取到异常对象
        SysException e= null;

        if(ex instanceof SysException) {
            e= (SysException) ex;
        }else {
            e = new SysException("系统正在维护！");
        }

        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("errmsg",e.getMessage());
        return mv;
    }
}
