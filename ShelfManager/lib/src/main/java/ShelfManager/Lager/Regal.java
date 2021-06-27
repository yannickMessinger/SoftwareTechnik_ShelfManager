package ShelfManager.Lager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Regal {
    private ArrayList<Regalfach> regalfaecher;
    private Stuetze[] stuetze = new Stuetze[2];
    private int hoehe;
    private int breite;
    private int tragkraft;
    private int xPos;
    private int yPos;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public void addSupport() {
        int hoehe = 0;
        int breite = 0;
        try {
            while (hoehe <= 0) {
                System.out.println("Hoehe:");
                hoehe = Integer.parseInt(reader.readLine());
            }
            while (hoehe <= 0) {
                System.out.println("Breite:");
                breite = Integer.parseInt(reader.readLine());
            }

            //Stuetze stuetze1 = new Stuetze(hoehe, breite);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    //-----GETTER----------------------------
    public ArrayList<Regalfach> getRegalfaecher() {
        return regalfaecher;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getTragkraft() {
        return tragkraft;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    //-----SETTER----------------------------

    public void setRegalfaecher(ArrayList<Regalfach> regalfaecher) {
        this.regalfaecher = regalfaecher;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public void setTragkraft(int tragkraft) {
        this.tragkraft = tragkraft;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
