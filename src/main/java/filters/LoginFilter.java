package filters;

import filters.helpers.AuthFilterHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = {"/login.jsp", "/registration.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        AuthFilterHelper.handleNotAuthUser(servletRequest,servletResponse,filterChain);
    }
}
