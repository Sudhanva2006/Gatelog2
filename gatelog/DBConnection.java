// File: gatelog/DBConnection.java
package gatelog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:mysql://localhost:3306/gatelog_db?allowPublicKeyRetrieval=true";
            String user = "root";
            String password = "aiengineer@28";
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
}