package ShelfManager;

import ShelfManager.Lager.Command;
import ShelfManager.Lager.Lager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShelfManagerApplication extends Application {
    //private Map<Scenes, Pane> scenes;
    private Stage primaryStage;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static void main(String[] args) {
        Command command = null;
        boolean validCommand = false;
        Lager lager = null;

        System.out.println("Was möchten Sie tun?");
        try {
            String input = reader.readLine();
            System.out.println(input);


            for(Command c: Command.values()) {
                if (c.toString().equals(input)){
                    validCommand = true;
                    command = Command.valueOf(input);
                    break;
                }
            }

            if (validCommand){
                switch (command){
                    case ADD_WAREHOUSE:     System.out.println("Lager hinzufügen");
                                            lager = new Lager();
                        break;
                    case ADD_SHELF:         System.out.println("Regal hinzufügen");

                        break;
                    case ADD_COMPARTMENT:   System.out.println("Regalfach hinzufügen");
                        break;
                    case ADD_PACKAGE:       System.out.println("Paket hinzufügen");
                        break;
                    case CONFIGURE_PACKAGE: System.out.println("Paket konfigurieren");
                        break;
                    default:
                        System.out.println("Kommando nicht gefunden");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----------------------------------------------
        //launch(args);
    }
    //--------------------------------------------------------------------------------------------
//    public static Lager addWarehouse(){
//        int hoehe = 0;
//        int breite = 0;
//
//        try {
//            while (hoehe <= 0) {
//                System.out.println("Hoehe:");
//                hoehe = Integer.parseInt(reader.readLine());
//            }
//            while (hoehe <= 0) {
//                System.out.println("Breite:");
//                breite = Integer.parseInt(reader.readLine());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return new Lager(hoehe, breite);
//    }
    //--------------------------------------------------------------------------------------------


    //------------------------JAVAFX---------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
            Pane root = new Pane();

            Scene scene = new Scene(root, 1600, 900);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ShelfManager");
            primaryStage.show();

    }
}
