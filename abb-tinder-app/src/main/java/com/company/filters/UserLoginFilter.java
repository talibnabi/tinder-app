package com.company.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;


import static com.company.handler.UserLoginVerifyHandler.isLoginCorrect;

public class UserLoginFilter implements Filter {

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;

        if (req.getMethod().equalsIgnoreCase("GET")) {
            chain.doFilter(request, response);
        } else {
            if (isLoginCorrect(request)) {
                chain.doFilter(request, response);
            } else {
                rs.sendRedirect("/login");
            }
        }
    }
}
