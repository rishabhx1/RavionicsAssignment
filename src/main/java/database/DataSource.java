package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    //private static final Connection connection;

    private static final String url = "jdbc:mysql://localhost/collegeDb";
    private static final String username = "root";
    private static final String password = "";

    /*static  {
        try (Connection conn = DriverManager.getConnection(
                url,
                username,
                password
        )) {
            connection = conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    url,
                    username,
                    password
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
