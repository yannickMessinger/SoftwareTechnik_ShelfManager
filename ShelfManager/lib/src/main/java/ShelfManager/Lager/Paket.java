package ShelfManager.Lager;


import javafx.geometry.Point2D;
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
    private ArrayList<Paket> paketsOnTop;
    private Paket paketBelow;


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
        this.paketsOnTop = new ArrayList<>();
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
        // TODO:
        //this.paketsOnTop = paketsOnTop;
    }


    public boolean checkOverlapping(Paket paket) {
        Point2D l1 = new Point2D(this.xPos, this.yPos);
        Point2D r1 = new Point2D(this.xPos + this.breite, this.yPos + this.hoehe);
        Point2D l2 = new Point2D(paket.getxPos(), paket.getyPos());
        Point2D r2 = new Point2D(paket.getxPos() + paket.getBreite(), paket.getyPos() + paket.getHoehe());


        if (l1.getX() == r1.getX() || l1.getY() == r1.getY() || l2.getX() == r2.getX() || l2.getY() == r2.getY()) { return false; }

        // If one rectangle is on left side of other
        if (l1.getX() >= r2.getX() || l2.getX() >= r1.getX()) { return false; }

        // If one rectangle is above other
        if (l1.getY() >= r2.getY() || l2.getY() >= r1.getY()) { return false; }

        return true;
    }

    public boolean overlappingEdges(Paket paket) {
        Point2D l1 = new Point2D(this.xPos, this.yPos);
        Point2D r1 = new Point2D(this.xPos + this.breite, this.yPos);
        Point2D l2 = new Point2D(paket.getxPos(), paket.getyPos() + paket.getHoehe());
        Point2D r2 = new Point2D(paket.getxPos() + paket.getBreite(), paket.getyPos() + paket.getHoehe());

//        if (paket.getBreite() <= this.getBreite()) {
//            paket.setxPos(this.xPos);
//            return false;
//        }

        if (l2.getX() < l1.getX() || r2.getX() > r1.getX()) {
            return true;
        }

        return false;

    }

    public boolean addPaketOnTop(Paket paket) {
        int gesamtgewicht = 0;
        for (Paket p : paketsOnTop) {
            gesamtgewicht += p.getGewicht();
        }
        if (gesamtgewicht + paket.getGewicht() <= tragkraft) {
            this.paketsOnTop.add(paket);
            paket.setPaketBelow(this);
            return true;
        }
        return false;
    }

    public void removeFromTop(Paket paket) {
        paketsOnTop.remove(paket);
    }

    public ArrayList<Paket> allPaketsOnTop() {
        ArrayList<Paket> allPaketsOnTop = new ArrayList<>();

        allPaketsOnTop.add(this);
        for (Paket p : paketsOnTop) {
            ArrayList<Paket> nextLayer = p.allPaketsOnTop();
            for (Paket paket : nextLayer) {
                allPaketsOnTop.add(paket);
            }
        }

        return allPaketsOnTop;
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

    public ArrayList<Paket> getPaketsOnTop() {
        return paketsOnTop;
    }

    public Paket getPaketBelow() {
        return paketBelow;
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

    public void setPaketBelow(Paket paketBelow) {
        this.paketBelow = paketBelow;
    }
}
