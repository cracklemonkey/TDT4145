import java.sql.*;

/**
 * Created by thomas on 08/03/16.
 */

public class main {



    public static void main(String[] args) {
        System.out.println("Hello World!"); // Display the string.


        String dbURL = "jdbc:mysql://localhost:3306/TDT4145";
        String username = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected");


                String sql = "SELECT * FROM gruppeovelse";
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                int count = 0;

                while (result.next()){
                    String ovelse = result.getString("Ovelse_navn");
                    int gruppe = result.getInt("Gruppe_id");
                    
                    System.out.println(ovelse + gruppe);
                }



            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}
