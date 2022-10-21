package repository.concretes;

import model.User;
import repository.abstracts.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.DBUtil.connection;

public class UserDAOManager implements UserDAO {

    @Override
    public void insertUser(User user) {
        final String query = "insert into users ( name, surname,email, picture_url, age, password) values (?,?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPictureURL());
            ps.setInt(5, user.getAge());
            ps.setInt(6, user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByID(int userID) throws SQLException {
        final String query = "select * from users where id =" + userID;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        String email = "";
        String name = "";
        String surname = "";
        String pictureURL = "";
        int age = 0;
        int password = 0;
        while (resultSet.next()) {
            name = resultSet.getString("name");
            surname = resultSet.getString("surname");
            email = resultSet.getString("email");
            pictureURL = resultSet.getString("picture_url");
            age = resultSet.getInt("age");
            password = resultSet.getInt("password");

        }
        return new User(name, surname, email, pictureURL, age, password);
    }

    @Override
    public List<User> getAllUser() throws SQLException {
        final String query = "select * from users";
        PreparedStatement stmt = connection.prepareStatement(query);
        ResultSet resultSet = stmt.executeQuery();
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            userList.add(new User(
                    resultSet.getString("name"),
                    resultSet.getString("surname"),
                    resultSet.getString("email"),
                    resultSet.getString("picture_url"),
                    resultSet.getInt("age"),
                    resultSet.getInt("password")
            ));
        }
        return userList;
    }

    @Override
    public int findIdByName(String name) {
        PreparedStatement ps;
        try {
            final String query = "select * from users";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            String nameX;
            int id;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                nameX = resultSet.getString("email");
                if (nameX.equalsIgnoreCase(name)) {
                    return id;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Something went wrong during find id by name", e);
        }
        return -1;
    }
}
