import java.awt.Color;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();
        

        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
        obj.setVisible(true);

    }

    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public static void insertScore(String playerName, int score) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game_scores", "root", "5069");
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO player_scores (player_name, score) VALUES ('" + playerName + "', " + score + ")";
            stmt.executeUpdate(sql);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}