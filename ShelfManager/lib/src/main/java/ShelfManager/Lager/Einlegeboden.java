package ShelfManager.Lager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.*;

public class Einlegeboden extends Gegenstand {

    private Regal regal;
    private int hoehe;
    private int breite;
    private int tragkraft;
    private int xPos;
    private int yPos;
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public Einlegeboden(Regal regal) {
        this.regal = regal;
        this.hoehe = this.erfasseHoehe();
        this.breite = regal.getBreite();
        this.tragkraft = setTragkraft();
        this.xPos = 0;
        this.yPos = 0;

    }


    //-----GETTER----------------------------

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

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    /**
     * Gibt die Tragekraft des Einlegebodens an.
     * @return
     */
    public int setTragkraft() {

        try {
            System.out.println("Tragkraft des Bodens eingeben: ");
            tragkraft = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tragkraft;

    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
