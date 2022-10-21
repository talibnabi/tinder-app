package util;

import java.sql.Connection;

import static db.ConnectionToDB.getConnection;

public class DBConnection {
    public static final Connection connection = getConnection();
}
