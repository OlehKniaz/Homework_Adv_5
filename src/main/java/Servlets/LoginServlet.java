package Servlets;

import DAO.Impl.BucketDaoImpl;
import DAO.Impl.UserDaoImpl;
import Services.Impl.UserServiceImpl;
import Services.UserService;
import com.google.gson.Gson;
import entities.User;
import exceptions.IncorrectCredsException;
import models.UserCredentials;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService;

    public LoginServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl(), new BucketDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        UserCredentials credentials = gson.fromJson(reader,UserCredentials.class);

        try {
            User user = userService.login(credentials);
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("role", user.getRole());
            resp.sendRedirect("cabinet.jsp");
        } catch (IncorrectCredsException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
