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

    public void insertExercise(String exercise_name, String exercise_description){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO ovelse (navn, beskrivelse) VALUES ('" + exercise_name + "', '" + exercise_description + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertGroup(String group_name){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO Gruppe (navn) VALUES ('" + group_name + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertGroupExercise(String exercise_name, String group_id){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO GruppeOvelse (Ovelse_navn, Gruppe_id) VALUES ('" + exercise_name + "', '" + group_id + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertGroupBelongsTo(int group_id1, int group_id2){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO GruppeTilhorighet (Gruppe_id1, Gruppe_id2) VALUES ('" + group_id1 + "', '" + group_id2 + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertIndoor(int entry_id, int air, int number_audience){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO Innendors (Treningsokt_id, luft, antallTilskuere) VALUES ('" + entry_id + "', '" + air + "', '" + number_audience + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertOutdoor(int entry_id, int temperature, int weather_type){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO Utendors (Treningsokt_id, temperatur, vaertype) VALUES ('" + entry_id + "', '" + temperature + "', '" + weather_type + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertTemplate(String name){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO Mal (navn) VALUES ('" + name + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void insertTemplateContains(int mal_id, String exercise_name){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO MalInneholder (Mal_id, Ovelse_navn) VALUES ('" + mal_id + "', '" + exercise_name + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void insertStrengthGoal(String exercise_name, Date date_made, Date date_achieved, int load, int reps, int sets){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO StyrkeMaal (Ovelse_navn, datoLaget, datoOppnadd, belastning, reps, sets) VALUES ('" + exercise_name + "', '" + date_made + "', '" + date_achieved + "', '" + load + "', '" + reps + "', '" + sets + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertEnduranceGoal(String exercise_name, Date date_made, Date date_achieved, Time time, int length){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO UtholdenhetsMaal (Ovelse_navn, datoLaget, datoOppnadd, tid, lengde) VALUES ('" + exercise_name + "', '" + date_made + "', '" + date_achieved + "', '" + time + "', '" + length + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertEntry(Date date, Time time, Time length){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO Treningsokt (dato, tidspunkt, varighet) VALUES ('" + date + "', '" + time + "', '" + length + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertStrengthResults(String exercise_name, int entry_id, int shape, int performance, String note, int load, int reps, int sets){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO StyrkeResultat (Ovelse_navn, Treningsokt_id, form, prestasjon, notat, belastning, reps, sets) VALUES ('" + exercise_name + "', '" + entry_id + "', '" + shape + "', '" + performance + "', '" + note + "', '" + load + "', '" + reps + "', '" + sets + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertEnduranceResults(String exercise_name, int entry_id, int shape, int performance, String note, Time time, int length){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO UtholdenhetsRestultat (Ovelse_navn, Treningsokt_id, form, prestasjon, notat, tid, lengde) VALUES ('" + exercise_name + "', '" + entry_id + "', '" + shape + "', '" + performance + "', '" + note + "', '" + time + "', '" + length + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertSimilarExercise(String exercise_name1, String exercise_name2){
        try (Connection conn = DriverManager.getConnection(dbURL, username, password);){
            if (conn != null) {
                System.out.println("Connected to database...");
                String sql = "INSERT INTO TilsvarendeOvelse (Ovelse_navn1, Ovelse_navn2) VALUES ('" + exercise_name1 + "', '" + exercise_name2 + "')";
                System.out.println(sql);
                Statement statement = conn.createStatement();
                statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
