import javax.swing.plaf.TextUI;
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

        Date date_made = new Date(115, 03, 14);
        Date date_achieved = new Date(115, 03, 21);
        Time time = new Time(1,1,3);


        DBIN dbin = new DBIN(dbURL, username, password);
        //dbin.insertEntry(date_made, time, 100);
        //dbin.insertTemplate("m1");
        dbin.insertExercise("running 200m","Run 200 meter as fast as you can.");
        dbin.insertGroup("running");
        //dbin.insertGroupExercise("running 200m", "1");
        //dbin.insertGroupBelongsTo(1, 1);
        //dbin.insertIndoor(1, 4, 12);
        //dbin.insertOutdoor(1, 5, 12);
        //dbin.insertTemplateContains(1, "running 200m");
        //dbin.insertStrengthGoal("running 200m" , date_made, date_achieved, 23, 5, 3);
        //dbin.insertEnduranceGoal("running 200m", date_made, date_achieved, time, 1000);
        //dbin.insertStrengthResults("running 200m", 1, 3, 7, "a random note", 34, 12, 3);
        //dbin.insertEnduranceResults("running 200m", 1, 3, 7, "a random note", 34, 12);
        //dbin.insertSimilarExercise("running 200m", "running 200m");

        textUI textUI = new textUI();
        textUI.app();

        /*try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
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
        }*/


    }
}
