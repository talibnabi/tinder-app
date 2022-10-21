package verifying;

import jakarta.servlet.ServletRequest;
import service.concretes.UserServiceManager;

public class UserChecking {
    public static boolean isUniqueUser(ServletRequest req) {
        String email = req.getParameter("email");
        UserServiceManager service = new UserServiceManager();
        return service.getAllUser().stream().noneMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }
}
