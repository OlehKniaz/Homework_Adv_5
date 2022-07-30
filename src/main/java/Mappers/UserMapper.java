package Mappers;

import entities.Role;
import entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserMapper {
    public static List<User> mapToListOfUsers(ResultSet resultSet) throws SQLException {
        List<User> users = new ArrayList<>();

        while (resultSet.next()){
            User user = new User(resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
            users.add(user);
        }
        return users;
    }

    public static User mapToUser(ResultSet resultSet) throws SQLException{
        User user = null;

        while (resultSet.next()){
            user = new User();
            user.setFirstName(resultSet.getString(1));
            user.setLastName(resultSet.getString(2));
            user.setEmail(resultSet.getString(3));
            user.setPassword(resultSet.getString(4));
            user.setId(resultSet.getInt(5));
            user.setRole(Role.valueOf(resultSet.getString(6)));
        }
        return user;
    }
}
