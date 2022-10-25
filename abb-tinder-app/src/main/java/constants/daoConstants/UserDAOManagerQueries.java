package constants.daoConstants;

public class UserDAOManagerQueries {
    public static final String insertUserQuery = "insert into users ( name, surname,email, picture_url, age, password) values (?,?,?,?,?,?)";
    public static final String getUserByIDQuery = "select * from users where id =";
    public static final String getAllUserQuery = "select * from users";
    public static final String findIdByEmailQuery = "select * from users";
}
