import java.sql.*;

/**
 * Created by thomas on 08/03/16.
 */
public class DBIN {

    String dbURL = "jdbc:mysql://localhost:3306/TDT4145";
    String username = "root";
    String password = "root";

    public DBIN(String dbURL, String username, String password){
        this.dbURL = dbURL;
        this.username = username;
        this.password = password;
    }

    public void insertExercise(String name, String description){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO ovelse (navn, beskrivelse) VALUES ('" + name + "', '" + description + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
