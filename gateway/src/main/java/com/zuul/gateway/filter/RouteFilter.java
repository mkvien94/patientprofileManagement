package com.zuul.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class RouteFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return "route";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
       System.out.println("Inside Route Filter");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        List<String> cookies = Collections.list(request.getHeaders("cookie"));
        HttpSession session = request.getSession(true);
        if (session != null && cookies.stream().noneMatch(c -> c.startsWith("SESSION="))) {
            context.addZuulRequestHeader("cookie", "SESSION=" + session.getId());
        }
        if(session!=null)
            System.out.println("ZuulPreFilter session proxy: {}"+ session.getId());

        return null;
    }
}
