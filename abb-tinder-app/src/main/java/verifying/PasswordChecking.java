package verifying;


import jakarta.servlet.ServletRequest;

public class PasswordChecking {
    public static boolean checkPasswordEquals(ServletRequest req) {
        String password = req.getParameter("password");
        String repassword = req.getParameter("passwordrepeat");

        if (password == null && repassword == null) return true;
        assert password != null;
        return password.equals(repassword);
    }
}
