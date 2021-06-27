package ShelfManager.Lager;

import java.util.ArrayList;

public class Regalfach extends Gegenstand {
    private Einlegeboden boden;
    private ArrayList<Paket> pakete;
    private int hoehe;
    private int xPos;
    private int yPos;

    /**
     * Konstruktor - Regal
     */
    public Regalfach() {
        setBoden();
        this.pakete = new ArrayList<Paket>();
        //spaeter wird Hoehe über yPos im Regal bzw. Abstand zu naechstem Boden im Regal berechnet
        this.hoehe = this.erfasseHoehe();
        this.xPos = 0;
        this.yPos = 0;
    }

    //-----GETTER----------------------------

    public Einlegeboden getBoden() {
        return boden;
    }

    public ArrayList<Paket> getPakete() {
        return pakete;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    //-----SETTER----------------------------


    public void setBoden() {
        System.out.println("Einlegeboden:");
        this.boden = new Einlegeboden();
    }

    public void setPakete(ArrayList<Paket> pakete) {
        this.pakete = pakete;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
