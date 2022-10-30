package com.company.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;


public class ChatFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            if (req.getPathInfo().equalsIgnoreCase("/")) {
                rs.sendRedirect("/list/");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
