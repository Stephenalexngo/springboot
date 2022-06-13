package com.stephen.springboot.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FooFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(FooFilter.class);
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Initializing Foo Filter");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        log.info("Logging Request  {} : {} : {}",
                req.getMethod(), req.getRequestURI(), filterConfig.getFilterName());

        chain.doFilter(request, response);

        log.info("Logging Response : {}", res.getOutputStream());
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
