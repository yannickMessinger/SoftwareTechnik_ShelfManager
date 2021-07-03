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
        if (addedPaket.getHoehe() > hoehe || addedPaket.getBreite() > boden.getBreite()) {
            return false;
        }

        //wenn aus Regal raussteht
        if (addedPaket.getxPos() + addedPaket.getBreite() > xPos + boden.getBreite()) {
            return false;
        }

        //wenn Tragfaehigkeit ueberschritten
        int gesamtgewicht = 0;
        for (Paket p : pakete) {
            gesamtgewicht += p.getGewicht();
        }
        if (gesamtgewicht + addedPaket.getGewicht() > boden.getTragkraft()) {
            return false;
        }

        //wenn leer, dann hinzufuegen
        if (pakete.isEmpty()) {
            addedPaket.setyPos(boden.getyPos() - boden.getHoehe()/2 - addedPaket.getHoehe());
            return true;
        }

        //wenn bereits Pakete
        //Ueberlappung
        for (Paket p : pakete) {
            if (p != addedPaket) {
                if (p.checkOverlapping(addedPaket)) {
                    System.out.println("OVERLAP");
                    return false;
                }
            }
        }

        //aufeinander Stapeln
        boolean yTransform = true;
        while (yTransform) {
            for (Paket p : pakete) {
                if (p != addedPaket) {
                    if (p.checkOverlapping(addedPaket)) {
                        addedPaket.setyPos(p.getyPos() - addedPaket.getHoehe());
                        yTransform = false;
                        if (p.overlappingEdges(addedPaket)) {
                            System.out.println("steht ueber");
                            return false;
                        }
                        if (!p.addPaketOnTop(addedPaket)) {
                            return false;
                        }
                        break;
                    } else {
                        addedPaket.setyPos(addedPaket.getyPos()+1);
                    }
                } else {
                    addedPaket.setyPos(addedPaket.getyPos()+1);
                }
            }
            if (addedPaket.getyPos() >= boden.getyPos()) {
                addedPaket.setyPos(boden.getyPos() - boden.getHoehe()/2 - addedPaket.getHoehe());
                yTransform = false;
            }
        }

        return true;

        //Option:
    }

    public boolean checkUnvertraeglichkeiten(Paket paket) {

        for (Paket p : pakete) {
            for (Color color : p.getUnvertraeglichkeiten()) {
                if (color == paket.getFarbe()) {
                    return false;
                }
            }
            for (Color c : paket.getUnvertraeglichkeiten()) {
                if (c == p.getFarbe()) {
                    return false;
                }
            }
        }
        return true;
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
