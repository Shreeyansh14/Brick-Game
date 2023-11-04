import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/game_scores";
    private static final String USER = "root";
    private static final String PASSWORD = "Minku";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
