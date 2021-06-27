package ShelfManager.Lager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gegenstand {
    int hoehe = 0;
    int breite = 0;
    String name = "";
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public int erfasseHoehe() {
        try {
            while (hoehe <= 0) {
                System.out.println("Hoehe:");
                hoehe = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hoehe;
    }

    public int erfasseBreite() {
        try {
            while (breite <= 0) {
                System.out.println("Breite:");
                breite = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return breite;
    }


}
