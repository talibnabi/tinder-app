package com.company.filters;

import com.company.cookies.Cookies;
import com.company.finding.NonLikedUserFindManager;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;


public class NonLikedFilter implements Filter {
    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)  {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            if (NonLikedUserFindManager.getUser(Cookies.getIdFromCookies(req)).size() > 0) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                rs.sendRedirect("/list/");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
