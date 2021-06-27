package ShelfManager.Lager;

import java.util.ArrayList;

public class Regal extends Gegenstand{
    private ArrayList<Regalfach> regalfaecher;
    private Stuetze[] stuetzen;
    private int hoehe;
    private int breite;
    private int tragkraft;
    private int xPos;
    private int yPos;


    /**
     * Konstruktor - Regal
     */
    public Regal() {
        this.regalfaecher = new ArrayList<Regalfach>();
        this.stuetzen = addSupport();
        this.hoehe = this.stuetzen[0].getHoehe();
        this.breite = this.erfasseBreite();
        this.tragkraft = calculateLoadCapacity();
        this.xPos = 0;
        this.yPos = 0;
    }

    /**
     * Berechnet aus der Liste aller Regalfaecher im Regal
     * die Gesamttragkraft des ganzen Regals
     * @return capacity
     */
    public int calculateLoadCapacity() {
        int capacity = 0;
        for(Regalfach r: regalfaecher) {
            capacity = capacity + r.getBoden().getTragkraft();
        }
        return capacity;
    }

    /**
     * Liest die Stuetzen fuer ein Regal ein und gibt diese zurueck
     * @return Stuetzen des Regals
     */
    public Stuetze[] addSupport() {
        Stuetze stuetze1 = new Stuetze();
        System.out.println("Stuetze 1 hinzugefügt");
        Stuetze stuetze2 = new Stuetze();
        System.out.println("Stuetze 2 hinzugefügt");
        return new Stuetze[]{stuetze1, stuetze2};
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
