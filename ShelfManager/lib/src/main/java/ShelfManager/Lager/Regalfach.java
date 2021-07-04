package ShelfManager.Lager;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Regalfach  {

    private Einlegeboden boden;
    private ArrayList<Paket> pakete;
    private int hoehe;
    private int xPos;
    private int yPos;


    /**
     * Konstruktor - Regalfach
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


    /**
     * Ueberprueft ob addedPaket in Regalfach hinzugefuegt werden kann
     * @param addedPaket
     * @return
     */
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

    }


    /**
     * Ueberprueft ob paket Unvertraeglichkeiten in dem Regalfach hat
     * @param paket
     * @return
     */
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
