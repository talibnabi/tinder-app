package validator.verifying;

import jakarta.servlet.ServletRequest;
import service.concretes.UserServiceManager;

public class UserValidator {
    public static boolean isUniqueUser(ServletRequest req) {
        String email = req.getParameter("email");
        UserServiceManager service = new UserServiceManager();
        return service.getAllUser().stream().noneMatch(user -> user.getEmail().equals(email));
    }
}
