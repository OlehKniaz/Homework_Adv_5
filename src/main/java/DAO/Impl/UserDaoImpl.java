package DAO.Impl;

import DAO.UserDao;
import JDBC.MySQLConnector;
import Mappers.UserMapper;
import entities.User;

import java.sql.*;
import java.util.*;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {

    private  Connection connection;

    public UserDaoImpl() {
        this.connection = new MySQLConnector().getConnection();
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
        return UserMapper.mapToListOfUsers(resultSet);
    }

    @Override
    public void insert(User object) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO user(first_name, last_name, email, password, role) VALUE (?, ?, ?, ?, ?)");
        statement.setString(1, object.getFirstName());
        statement.setString(2, object.getLastName());
        statement.setString(3, object.getEmail());
        statement.setString(4, object.getPassword());
        statement.setString(5, object.getRole().name());
        statement.execute();
    }

    @Override
    public Optional<User> getById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<User> getByEmail(String email) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT first_name, last_name, email, password, id, role  FROM web_project.user WHERE email = ?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        return Optional.ofNullable(UserMapper.mapToUser(resultSet));
    }

}
