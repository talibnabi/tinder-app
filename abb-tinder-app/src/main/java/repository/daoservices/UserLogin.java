package repository.daoservices;

import model.User;
import repository.dao.UserLoginDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static db.ConnectionToDB.getConnection;

public class UserLogin implements UserLoginDAO {
    private static final UserLogin userLogin = new UserLogin();

    private UserLogin() {
    }

    public static UserLogin getInstance() {
        return userLogin;
    }

    private static final Connection con = getConnection();

    @Override
    public User login(String username, String password) {
        User c = null;
        final String query = "select * from user where username=? and password=?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new User(rs.getString(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Something went wrong during login", ex);
        }
        return c;
    }
}
