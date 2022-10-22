package filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static validator.verifying.CookieValidator.checkCookies;

public class CookiesFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rs = (HttpServletResponse) response;

        if (req.getMethod().equalsIgnoreCase("GET")) {
            if (checkCookies(request)) {
                rs.sendRedirect("/login/");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

    }
}
