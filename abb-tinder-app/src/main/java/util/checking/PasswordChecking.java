package util.checking;


import jakarta.servlet.ServletRequest;

public class PasswordChecking {
    public static boolean checkPasswordEquals(ServletRequest req) {
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");

        if (password == null && repassword == null) return true;
        assert password != null;
        return password.equals(repassword);
    }
}
