package filters;

import filters.helpers.AuthFilterHelper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value = {"/cabinet.jsp", "/createProduct.jsp", "/buckets.jsp"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        AuthFilterHelper.handleAuthUser(servletRequest, servletResponse, filterChain);
    }
}
