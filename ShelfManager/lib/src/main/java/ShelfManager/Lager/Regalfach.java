package ShelfManager.Lager;

import java.util.ArrayList;

public class Regalfach {
    private Einlegeboeden boden;
    private ArrayList<Paket> pakete;
    private int hoehe;
    private int xPos;
    private int yPos;

    //-----GETTER----------------------------

    public Einlegeboeden getBoden() {
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


    public void setBoden(Einlegeboeden boden) {
        this.boden = boden;
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
