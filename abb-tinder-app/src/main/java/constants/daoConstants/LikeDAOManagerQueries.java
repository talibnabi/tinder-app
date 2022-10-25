package constants.daoConstants;

public class LikeDAOManagerQueries {
    public static String insertLikeQuery = "insert into likes (_from, _to, liked) values (?,?,?)";
    public static String getLikeByIDQuery = "select * from likes where id = ";
    public static String getAllLikeQuery = "select * from likes";
}
