package Services;

import entities.User;
import exceptions.IncorrectCredsException;
import exceptions.UserAlreadyExistException;
import models.UserCredentials;

import java.sql.SQLException;
import java.util.*;

public interface UserService {
    List<User> getAll();
    void registration(User user) throws UserAlreadyExistException, SQLException;
    User login(UserCredentials credentials) throws IncorrectCredsException;
}
