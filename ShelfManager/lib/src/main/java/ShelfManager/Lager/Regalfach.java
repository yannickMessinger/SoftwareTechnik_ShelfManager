package ShelfManager.Lager;

import javafx.scene.paint.Color;

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
    public Regalfach(Regal regal) {
        setBoden(regal);
        this.pakete = new ArrayList<Paket>();
        //spaeter wird Hoehe über yPos im Regal bzw. Abstand zu naechstem Boden im Regal berechnet
        this.hoehe = this.erfasseHoehe();
        this.xPos = 0;
        this.yPos = 0;
    }

    /**
     * Konstruktor fuer JSONHandler Parsing-Methods
     * @param boden
     * @param pakete
     * @param hoehe
     * @param xPos
     * @param yPos
     */
    public Regalfach(Einlegeboden boden, ArrayList<Paket> pakete, int hoehe, int xPos, int yPos) {
        this.boden = boden;
        this.pakete = pakete;
        this.hoehe = hoehe;
        this.xPos = xPos;
        this.yPos = yPos;
    }


    public boolean tryToAddPaket(Paket addedPaket) {

        if (!checkUnvertraeglichkeiten(addedPaket)) {
            return false;
        }


        //Paket hoeher oder breiter als Regalfach
        if (addedPaket.getHoehe() > this.getHoehe() || addedPaket.getBreite() > this.getBoden().getBreite()) {
            return false;
        }

        //wenn aus Regal raussteht
        if (addedPaket.getxPos() + addedPaket.getBreite() > this.xPos + this.getBoden().getBreite()) {
            return false;
        }

        //wenn leer, dann hinzufuegen
        if (this.pakete.isEmpty()) {
            addedPaket.setyPos(this.getBoden().getyPos() - this.getBoden().getHoehe()/2 - addedPaket.getHoehe());
            return true;
        }

        //wenn bereits Pakete
        //Ueberlappung
        for (Paket p : this.getPakete()) {
            if (p.checkOverlapping(addedPaket)) {
                System.out.println("OVERLAP");
                return false;
            }
        }

        //aufeinander Stapeln
        boolean yTransform = true;
        while (yTransform) {
            for (Paket p : this.getPakete()) {
                if (p.checkOverlapping(addedPaket)) {
                    addedPaket.setyPos(p.getyPos() - addedPaket.getHoehe());
                    yTransform = false;
                    if (p.overlappingEdges(addedPaket)) {
                        System.out.println("steht ueber");
                        return false;
                    }
                    break;
                } else {
                    addedPaket.setyPos(addedPaket.getyPos()+1);
                }
            }
            if (addedPaket.getyPos() >= this.getBoden().getyPos()) {
                addedPaket.setyPos(this.getBoden().getyPos() - this.getBoden().getHoehe()/2 - addedPaket.getHoehe());
                yTransform = false;
            }
        }

        return true;

        //Option:
    }

    public boolean checkUnvertraeglichkeiten(Paket paket) {
        for (Paket p : this.getPakete()) {
            for (Color c : paket.getUnvertraeglichkeiten()) {
                if (c == p.getFarbe()) {
                    return false;
                }
            }
        }
        return true;
    }

//    public int calculateYPos(Paket paket) {
//
//        for (Paket p : this.getPakete()) {
//
//        }
//    }

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


    public void setBoden(Regal regal) {
        System.out.println("Einlegeboden:");
        //this.boden = new Einlegeboden(regal);
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
