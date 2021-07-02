package ShelfManager.Lager;


import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Paket extends Gegenstand{
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String paketName;
    private int hoehe;
    private int breite;
    private int gewicht;
    private Color farbe;
    private int tragkraft;
    private int xPos;
    private int yPos;
    private ArrayList<Color> unvertraeglichkeiten;


    /**
     * Konstruktor - Paket
     */
    public Paket(String paketName, int hoehePaket, int breitePaket, int gewichtPaket, int tragKraft, Color farbe) {
        setName(paketName);
        setHoehe(hoehePaket);
        setBreite(breitePaket);
        setGewicht(gewichtPaket);
        //Farbe noch anpassen!!!
        //this.farbe = new Color(255,255,255);
        this.farbe = farbe;
        setTragkraft(tragKraft);
        this.xPos = 0;
        this.yPos = 0;
        this.unvertraeglichkeiten = new ArrayList<>();
    }

    /**
     * Konstruktor fuer JSONHandler Parsing-Methods
     * @param paketName
     * @param hoehe
     * @param breite
     * @param gewicht
     * @param farbe
     * @param tragkraft
     * @param xPos
     * @param yPos
     * @param unvertraeglichkeiten
     */
    public Paket(String paketName, int hoehe, int breite, int gewicht, Color farbe, int tragkraft, int xPos, int yPos, ArrayList<Color> unvertraeglichkeiten) {
        this.paketName = paketName;
        this.hoehe = hoehe;
        this.breite = breite;
        this.gewicht = gewicht;
        this.farbe = farbe;
        this.tragkraft = tragkraft;
        this.xPos = xPos;
        this.yPos = yPos;
        this.unvertraeglichkeiten = unvertraeglichkeiten;
    }


//-----GETTER----------------------------


    public String getPaketName() {
        return paketName;
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

    /**
     * Erfasst den Namen eines Pakets
     * und gibt diesen zurueck
     * @return name
     */
    public void setName(String name) {
        this.paketName = name;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    /**
     * Erfasst Gewicht eines Pakets
     * und gibt dieses zurueck
     * @return gewicht
     */
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
