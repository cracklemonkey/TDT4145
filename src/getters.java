/**
 * Created by DannyBoy on 08.03.2016.
 */
public class getters {

    /*String sql = "SELECT * FROM gruppeovelse";
    Statement statement = conn.createStatement();
    ResultSet result = statement.executeQuery(sql);

    int count = 0;

    while (result.next()){
        String ovelse = result.getString("Ovelse_navn");
        int gruppe = result.getInt("Gruppe_id");

        System.out.println(ovelse + gruppe);
    } */

    public void getOvelse(){
        String sql = "SELECT * FROM gruppeovelse";
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);



    }
}
