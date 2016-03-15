import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;


/**
 * Created by thomas on 15/03/16.
 */
public class textUI {
    String answer = "";
    String dbURL = "jdbc:mysql://localhost:3306/TDT4145";
    String username = "root";
    String password = "root";
    textUI txtUI = new textUI();
    DBIN dbin = new DBIN(dbURL, username, password);
    String exName = "";
    String exGroup = "";
    String exDesc = "";
    Time exTime;
    Integer exDist;
    Integer exKG;
    Integer exReps;
    Integer exSets;

    java.sql.Date workDate;
    Time workStartTime;
    Time workDuration;
    Integer workShape;
    Integer workPerformance;
    String workNote = "";
    Time workTime;
    Integer workDistance;
    Integer workKG;
    Integer workReps;
    Integer workSets;
    String workAir = "";
    Integer workSpectators;
    Integer workTemp;
    String workWeather = "";

    DateFormat formaterDate = new SimpleDateFormat("yyyy.mm.dd");
    Scanner reader = new Scanner(System.in);  // Reading from System.in

    //Creates sql.Time from user input
    public java.sql.Time parseTime(String str){
        try {
            DateFormat formaterDate = new SimpleDateFormat("hh:mm:ss");
            java.util.Date date = (java.util.Date) formaterDate.parse(str);
            java.sql.Time time = new java.sql.Time(date.getTime());
            return time;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Creates a sql.Date from user input
    public java.sql.Date parseDate(String str){
        try {
            DateFormat formaterDate = new SimpleDateFormat("yyyy.mm.dd");
            java.util.Date date = (java.util.Date) formaterDate.parse(str);
            java.sql.Date datesql = new java.sql.Date(date.getDate());
            return datesql;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    //Asks user for result info used in both endurance and strenght
    public void result(){
        System.out.println("excersice name: ");
        exName = reader.nextLine();

        System.out.println("workout's shape on a scale from 1-10: ");
        workShape = Integer.parseInt(reader.nextLine());

        System.out.println("workout performance on a scale from 1-10: ");
        workPerformance = Integer.parseInt(reader.nextLine());

        System.out.println("workout note: ");
        workNote = reader.nextLine();
    }

    //Asks user for info about Indoors and Outdoors
    public void inOutdoors(){
        System.out.println("Is the excersice Indoors(i) or Outdoors? (o)?: ");
        answer = reader.nextLine();

        if(answer.contentEquals("i")){
            System.out.println("how was the air?: ");
            workAir = reader.nextLine();

            System.out.println("number of spectaters: ");
            workSpectators = Integer.parseInt(reader.nextLine());
        }
        else if(answer.contentEquals("o")){
            System.out.println("temperature: ");
            workTemp = Integer.parseInt(reader.nextLine());

            System.out.println("weather: ");
            workWeather = reader.nextLine();
        }
    }

    //Main method for textUI
    public void app() {
        System.out.println("create ex (creates a new excersice)\n" +
                "reg work (register workout)\n" +
                "show exercises (show ex)\n" +
                "show workouts (show work)\n" +
                "  Type a command:");
        String command = reader.nextLine(); // Scans the next token of the input as an Sring.


        try{
            //------------------------- Create Exercise ---------------------
            if (command.contentEquals("create ex")){
                System.out.println("excersice name: ");
                exName = reader.nextLine();

                System.out.println("excersice description: ");
                exDesc = reader.nextLine();

                System.out.println("excersice group: ");
                exGroup = reader.nextLine();

                System.out.println("Is the excersice endurance (e) or strenght (s)?: ");
                answer = reader.nextLine();

                //Endurance exercise
                if(answer.contentEquals("e")){
                    System.out.println("excersice goal time: (hh:mm:ss) ");
                    exTime = txtUI.parseTime(reader.nextLine());

                    System.out.println("excersice distance in meters: ");
                    exDist = Integer.parseInt(reader.nextLine());

                    java.util.Date date = new java.util.Date();
                    java.sql.Date datesql = new java.sql.Date(date.getTime());
                    dbin.insertExercise(exName, exDesc);
                    dbin.insertGroupExercise(exName, exGroup);
                    dbin.insertEnduranceGoal(exName, datesql, datesql, exTime, exDist);
                }
                //Strenght exercise
                else if(answer.contentEquals("s")){
                    System.out.println("excersice kg: ");
                    exKG = Integer.parseInt(reader.nextLine());

                    System.out.println("excersice reps: ");
                    exReps = Integer.parseInt(reader.nextLine());

                    System.out.println("excersice sets: ");
                    exSets = Integer.parseInt(reader.nextLine());

                    java.util.Date date = new java.util.Date();
                    java.sql.Date datesql = new java.sql.Date(date.getTime());
                    dbin.insertExercise(exName, exDesc);
                    dbin.insertGroupExercise(exName, exGroup);
                    dbin.insertStrengthGoal(exName, datesql, datesql, exKG, exReps, exSets);
                }
            }
            //------------------------- Register workout ---------------------
            else if(command.contentEquals("reg work")){
                System.out.println("workout date: (yyyy.mm.dd)");

                workDate = txtUI.parseDate(reader.nextLine());

                System.out.println("workout starttime: (hh:mm:ss)");
                workStartTime = txtUI.parseTime(reader.nextLine());

                System.out.println("workout duration: (hh:mm:ss)");
                workDuration = txtUI.parseTime(reader.nextLine());

                System.out.println("Is the excersice endurance (e) or strenght (s)?: ");
                answer = reader.nextLine();

                //Endurance workout
                if(answer.contentEquals("e")){
                    System.out.println("workout time (hh:mm:ss): ");
                    workTime = txtUI.parseTime(reader.nextLine());

                    System.out.println("workout distance: ");
                    workDistance = Integer.parseInt(reader.nextLine());

                    txtUI.inOutdoors();

                    dbin.insertEntry(workDate, workStartTime, workDuration);
                    //Finn entry_id
                    dbin.insertEnduranceResults(exName, 1, workShape, workPerformance, workNote, workTime, workDistance);
                }
                //Strength workout
                else if(answer.contentEquals("s")){
                    while(answer != "no"){
                        System.out.println("excersice kg: ");
                        workKG = Integer.parseInt(reader.nextLine());

                        System.out.println("excersice reps: ");
                        workReps = Integer.parseInt(reader.nextLine());

                        System.out.println("excersice sets: ");
                        workSets = Integer.parseInt(reader.nextLine());

                        txtUI.inOutdoors();

                        dbin.insertEntry(workDate, workStartTime, workDuration);
                        dbin.insertStrengthResults(exName, 1, workShape, workPerformance, workNote, workKG, workReps, workSets);

                        System.out.println("Do you want to register another excersice in this workout?");
                        answer = reader.nextLine();
                    }
                }
            }
        }catch (Exception e){
            System.out.println("Wrong input, try again");
            txtUI.app();
        }
    }
}
