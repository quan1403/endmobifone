package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//import static model.Login.account;
//import static model.Login.session;

@WebFilter(urlPatterns = {"/account/*", "/customer?action=show"})
public class FilterLogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpSession session = request1.getSession(false);
        String loginURI = request1.getContextPath() + "/login";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request1.getRequestURI().equals(loginURI);

        if (loggedIn || loginRequest) {
            chain.doFilter(request1, response1);
        } else {
        }
        RequestDispatcher dd = request1.getRequestDispatcher(loginURI);

        dd.forward(request1, response1);
        }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
