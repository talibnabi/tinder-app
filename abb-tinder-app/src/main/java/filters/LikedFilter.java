package filters;

import cookies.Cookies;
import finding.concretes.NonLikedUserFindManager;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LikedFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rs = (HttpServletResponse) servletResponse;
        if (req.getMethod().equalsIgnoreCase("GET")) {
            if (NonLikedUserFindManager.getNonLikedUser(Cookies.getIdFromCookies(req)).size() < 1) {
                rs.sendRedirect("/list/");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
