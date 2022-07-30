package Services.Impl;

import DAO.BucketDao;
import DAO.UserDao;
import Services.UserService;
import entities.User;
import exceptions.IncorrectCredsException;
import exceptions.UserAlreadyExistException;
import models.UserCredentials;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BucketDao bucketDao;

    public UserServiceImpl(UserDao userDao , BucketDao bucketDao) {
        this.userDao = userDao;
        this.bucketDao = bucketDao;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            users = userDao.getAll();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return users;
    }

//    @Override
//    public void insert(User user) throws UserAlreadyExistException {
//        try {
//            Optional<User> byEmail = userDao.getByEmail(user.getEmail());
//            if(byEmail.isPresent()){
//                throw new UserAlreadyExistException(user.getEmail());
//            }
//            userDao.insert(user);
//        } catch (SQLException exception) {
//            exception.printStackTrace();
//        }
//    }



    @Override
    public User login(UserCredentials credentials) throws IncorrectCredsException{
        try {
            Optional<User> byEmail = userDao.getByEmail(credentials.email);
            if(byEmail.isPresent()){
                User user = byEmail.get();

                if(user.getPassword().equals(credentials.password)){
                    return user;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        throw new IncorrectCredsException();
    }

    @Override
    public void registration(User user) throws UserAlreadyExistException, SQLException {
        Optional<User> byEmail = userDao.getByEmail(user.getEmail());
        if(byEmail.isPresent()){
            throw new UserAlreadyExistException(user.getEmail());
        }
        userDao.insert(user);
        Optional<User> first = userDao.getByEmail(user.getEmail());

        first.ifPresent(u -> {
            try {
                bucketDao.create(u.getId());
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });
    }
}
