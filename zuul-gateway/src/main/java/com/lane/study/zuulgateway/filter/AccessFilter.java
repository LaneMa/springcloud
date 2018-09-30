package com.lane.study.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

    /**
     * @see org.springframework.cloud.netflix.zuul.filters.support.FilterConstants
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if (request.getParameter("name") == null) {//请求参数里没有name这个字段 则不跳转
            ctx.setSendZuulResponse(false);  //设置不跳转
            ctx.setResponseStatusCode(HttpStatus.SC_NOT_FOUND);//设置返回码是404
        }
        return null;
    }
}
