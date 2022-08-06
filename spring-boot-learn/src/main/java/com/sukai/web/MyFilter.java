package com.sukai.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author chengsukai
 * @since 2022-07-11 12:18
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("execute filter");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
