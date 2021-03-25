package com.zuul.gateway.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zuul.gateway.service.JsonService;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class AppRequestInterceptor implements RequestInterceptor {

    private static final String X_AUTHORIZATION_USERTOKEN = "x-authorization-usertoken";

    @Autowired
    JsonService jsonService;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            try {
                requestTemplate.header(X_AUTHORIZATION_USERTOKEN,
                        jsonService.writeValueAsString(request.getSession().getAttribute("user")));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
    }
}
