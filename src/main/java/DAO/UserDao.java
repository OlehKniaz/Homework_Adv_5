package DAO;

import entities.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<User> getAll() throws SQLException;
    void insert(User object) throws SQLException;
    Optional<User> getById(int id) throws SQLException;
    Optional<User> getByEmail(String email) throws SQLException;
}
