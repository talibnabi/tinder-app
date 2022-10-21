package service.concretes;

import model.User;
import repository.abstracts.UserDAO;
import repository.concretes.UserDAOManager;
import service.abstracts.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceManager implements UserService {
    private final UserDAO userDAO = new UserDAOManager();

    @Override
    public User getUserByID(int id) {
        try {
            return userDAO.getUserByID(id);
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during get all user by id", e);
        }
    }

    @Override
    public List<User> getAllUser() {
        try {
            return userDAO.getAllUser();
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during get all users", e);
        }
    }

    @Override
    public void insertUser(String name, String surname, String email, String pictureURL, int age, String password) {
        User user = new User(name, surname, email, pictureURL, age, password);
        userDAO.insertUser(user);
    }

    @Override
    public int findUserIdByEmail(String email) {
        return userDAO.findIdByEmail(email);
    }
}
