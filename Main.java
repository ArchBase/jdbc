import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
    public static void main(String args[]) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/lab";
        String user = "root";
        String password = "root";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to the database");


                Statement st = connection.createStatement();
                String s = "select * from student";
                ResultSet rs = st.executeQuery(s);
                System.out.println("\n\nTable contains:\n");
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println(id + " " + name + " " + age);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
