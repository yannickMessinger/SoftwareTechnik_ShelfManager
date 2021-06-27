package ShelfManager.Lager;

import java.awt.*;
import java.util.ArrayList;

public class Paket {
    private String name;
    private int hoehe;
    private int breite;
    private int gewicht;
    private Color farbe;
    private int tragkraft;
    private int xPos;
    private int yPos;
    private ArrayList<Color> unvertraeglichkeiten;


    //-----GETTER----------------------------

    public String getName() {
        return name;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getGewicht() {
        return gewicht;
    }

    public Color getFarbe() {
        return farbe;
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

    public ArrayList<Color> getUnvertraeglichkeiten() {
        return unvertraeglichkeiten;
    }

    //-----SETTER----------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
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

    public void setUnvertraeglichkeiten(ArrayList<Color> unvertraeglichkeiten) {
        this.unvertraeglichkeiten = unvertraeglichkeiten;
    }
}
