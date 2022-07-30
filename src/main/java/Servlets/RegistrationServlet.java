package Servlets;

import DAO.Impl.BucketDaoImpl;
import DAO.Impl.UserDaoImpl;
import Services.Impl.UserServiceImpl;
import Services.UserService;
import com.google.gson.Gson;
import entities.User;
import exceptions.UserAlreadyExistException;

import java.io.BufferedReader;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService;

    public RegistrationServlet() {
        this.userService = new UserServiceImpl(new UserDaoImpl(), new BucketDaoImpl());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        Gson gson = new Gson();
        User user = gson.fromJson(reader,User.class);

        System.out.println(user);
        try {
            userService.registration(user);
            resp.sendRedirect("login.jsp");
        } catch (UserAlreadyExistException | SQLException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_CONFLICT);
        }
    }
}
