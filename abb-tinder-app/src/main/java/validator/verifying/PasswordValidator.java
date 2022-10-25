package validator.verifying;


import jakarta.servlet.ServletRequest;

public class PasswordValidator {
    public static boolean checkPasswordEquals(ServletRequest req) {
        String password = req.getParameter("password");
        String passwordRepeat = req.getParameter("passwordrepeat");
        if (password == null && passwordRepeat == null) {
            return true;
        } else {
            assert password != null;
            return password.equals(passwordRepeat);
        }
    }
}
