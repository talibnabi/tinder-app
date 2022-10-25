package repository.concretes;

import model.User;
import repository.abstracts.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constants.daoConstants.UserDAOManagerQueries.*;
import static util.DBOperation.connection;

public class UserDAOManager implements UserDAO {

    @Override
    public void insertUser(User user) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(insertUserQuery);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPictureURL());
            ps.setInt(5, user.getAge());
            ps.setString(6, user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByID(int userID) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(getUserByIDQuery + userID);
        ResultSet resultSet = preparedStatement.executeQuery();
        String email = "";
        String name = "";
        String surname = "";
        String pictureURL = "";
        int age = 0;
        String password = "";
        while (resultSet.next()) {
            name = resultSet.getString("name");
            surname = resultSet.getString("surname");
            email = resultSet.getString("email");
            pictureURL = resultSet.getString("picture_url");
            age = resultSet.getInt("age");
            password = resultSet.getString("password");

        }
        return new User(name, surname, email, pictureURL, age, password);
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(getAllUserQuery);
        ResultSet resultSet = stmt.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            userList.add(new User(
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("email"),
                    resultSet.getString("picture_url"),
                    resultSet.getInt("age"),
                    resultSet.getString("password")
            ));
        }
        return userList;
    }

    @Override
    public int findIdByEmail(String email) {
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(findIdByEmailQuery);
            ResultSet resultSet = ps.executeQuery();
            String emailX;
            int id;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                emailX = resultSet.getString("email");
                if (emailX.equals(email)) {
                    return id;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during find id by name", e);
        }
        return -1;
    }
}
