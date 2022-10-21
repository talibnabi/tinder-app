package validator.verifying;


import jakarta.servlet.ServletRequest;

public class PasswordValidator {
    public static boolean checkPasswordEquals(ServletRequest req) {
        String password = req.getParameter("password");
        String repassword = req.getParameter("passwordrepeat");
        if (password == null && repassword == null) {
            return true;
        } else {
            assert password != null;
            return password.equals(repassword);
        }
    }
}
