package filters.helpers;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilterHelper {

    public static void handleAuthUser(ServletRequest servletRequest, ServletResponse servletResponse,
                                       FilterChain filterChain) throws ServletException, IOException {

        HttpServletResponse responce = (HttpServletResponse) servletResponse;

        SessionParams sessionParams = getSessionParams(servletRequest);

        if(sessionParams.firstName != null && sessionParams.id != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            responce.sendRedirect("login.jsp");
        }
    }

    public static void handleNotAuthUser(ServletRequest servletRequest, ServletResponse servletResponse,
                                      FilterChain filterChain) throws ServletException, IOException {

        HttpServletResponse responce = (HttpServletResponse) servletResponse;

        SessionParams sessionParams = getSessionParams(servletRequest);

        if(sessionParams.firstName == null || sessionParams.id == null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            responce.sendRedirect("index.jsp");
        }
    }

    private static SessionParams getSessionParams(ServletRequest servletRequest){
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        Object firstName = session.getAttribute("firstName");
        Object id = session.getAttribute("id");
        return new SessionParams(firstName, id);
    }

    static class SessionParams{
        public Object firstName;
        public Object id;

        public SessionParams(Object firstName, Object id) {
            this.firstName = firstName;
            this.id = id;
        }
    }
}
