package com.company.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.company.handler.UserPasswordVerifyHandler.checkPasswordEquals;
import static com.company.handler.UserVerifyHandler.isUniqueUser;

public class UserRegisterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;

        if (req.getMethod().equalsIgnoreCase("GET")) {
            chain.doFilter(request, response);
        } else {
            if (isUniqueUser(request) && checkPasswordEquals(request)) {
                try {
                    chain.doFilter(request, response);
                } catch (IOException e) {
                    throw new RuntimeException("Something went wrong during user register filtering", e);
                }
            } else {
                if (response != null) {
                    rs.reset();
                }
            }
        }
    }
}
