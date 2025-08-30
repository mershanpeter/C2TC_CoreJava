package jdbc;

import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:postgresql://localhost:5432/employeedbc71"; // Change database name
        String user = "postgres";  // Change to your PostgreSQL username
        String password = "shymapeter";  // Change to your PostgreSQL password

        // JDBC variables
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load PostgreSQL JDBC Driver
            Class.forName("org.postgresql.Driver");

            // Establish Connection
            conn = DriverManager.getConnection(url, user, password);

            // Create Statement
            stmt = conn.createStatement();

            // ----------- SELECT Example -----------
            String query = "SELECT * FROM employee";
            rs = stmt.executeQuery(query);

            System.out.println("Employee Details:");
            System.out.println("-------------------------------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                System.out.println("ID: " + id + ", Name: " + name + ", City: " + city);
            }

            // ----------- DELETE Example -----------
            String deleteQuery = "DELETE FROM employee WHERE id IN (1,2,3)";
            int rowsAffected = stmt.executeUpdate(deleteQuery);
            System.out.println(rowsAffected + " rows deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}