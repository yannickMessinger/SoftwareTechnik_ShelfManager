package ShelfManager;

import ShelfManager.Lager.Command;
import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Regal;
import ShelfManager.Lager.Regalfach;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Regal testRegal;

    public static void main(String[] args) {
        ShelfManagerApplication.main(args);


        Command command = null;
        boolean validCommand = false;
        Lager lager = null;

        while (true) {
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
                                                System.out.println("neues Lager erstellt");
                            break;
                        case ADD_SHELF:         System.out.println("Regal hinzufügen");
                                                testRegal = new Regal();
                            break;
                        case ADD_COMPARTMENT:   System.out.println("Regalfach hinzufügen");
                                                Regalfach testFach = new Regalfach(testRegal);
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

        }


    }
}
