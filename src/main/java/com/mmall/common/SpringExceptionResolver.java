package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: SpringExceptionResolver
 * @Author: WuZhenYu
 * @CreateDate: 2019/7/3 22:26
 */
@Slf4j
public class SpringExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        String url = request.getRequestURI().toString();
        ModelAndView mv;
        String defaultMsg = "System error";

        if(!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With") != null && request.getHeader(
                "X-Requested-With").indexOf("XMLHttpRequest") > -1))){
            JsonData result = null;
            if (ex instanceof PermissonException || ex instanceof ParamException) {
                result = JsonData.fail(ex.getMessage());
            } else {
                log.error("unknow json exception, url:" + url, ex);
                result = JsonData.fail(defaultMsg);
            }
            mv = new ModelAndView("jsonView", result.toMap());
        } else {
            log.error("unknown page exception, url:" + url, ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception", result.toMap());
        }
        return mv;
    }
}
