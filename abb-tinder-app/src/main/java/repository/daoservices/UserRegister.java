package repository.daoservices;

import model.User;
import repository.dao.UserRegisterDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static db.ConnectionToDB.getConnection;

public class UserRegister implements UserRegisterDAO {
    private static final UserRegister userRegister = new UserRegister();

    private UserRegister() {
    }

    public static UserRegister getInstance() {
        return userRegister;
    }
    private static final Connection con = getConnection();

    @Override
    public void register(User user) {
        final String query = "INSERT INTO users (username,password,picture_url,email) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPictureURL());
            ps.setString(4, user.getEmail());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Something went wrong during register", ex);
        }
    }
}
