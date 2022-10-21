package repository.dao;

import jakarta.servlet.http.HttpServletRequest;
import model.User;

public interface UserLogoutDAO extends DAO<User>{
    void logout(HttpServletRequest request);
}
