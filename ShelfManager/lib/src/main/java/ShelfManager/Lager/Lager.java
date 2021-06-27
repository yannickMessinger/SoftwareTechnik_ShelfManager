package ShelfManager.Lager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lager extends Gegenstand {
    private int hoehe;
    private int breite;
    private ArrayList<Regal> regale;
    private ArrayList<Paket> paketListe;

    /**
     * Konstruktor - Lager
     */
    public Lager() {
        //auskommentiert für Testzwecke wegen Threadproblematik
        //this.hoehe = erfasseHoehe();
        //this.breite = erfasseBreite();
        this.regale = new ArrayList<Regal>();
        this.paketListe = new ArrayList<Paket>();
    }



    //-----METHODEN--------------------------


    /**
     * prueft vor dem Hinzufuegen eines neuen Regals,
     * ob das gewuenschte Regal in das Lager passt
     * @param regalToAdd
     */
    public void addRegal(Regal regalToAdd) {
        int verfuegbarerPlatz = breite;
        for (Regal r: regale) {
            verfuegbarerPlatz = verfuegbarerPlatz - r.getBreite();
        }

        if (regalToAdd.getHoehe() <= hoehe && regalToAdd.getBreite() <= verfuegbarerPlatz){
            regale.add(regalToAdd);
        } else {
            if (regalToAdd.getHoehe() > hoehe) {
                System.out.println("Das Regal ist zu hoch.");
            } else if (regalToAdd.getBreite() > verfuegbarerPlatz) {
                System.out.println("Das Regal ist zu breit.");
            }

        }
    }


    /**
     * Gibt alle Pakete aus dem Lager in einer ArrayList zurück
     * @return
     */
    public ArrayList<Paket> getAllPakets() {
        ArrayList<Paket> allPakets = new ArrayList<>();
        for (Regal r : regale) {
            for (Regalfach rf : r.getRegalfaecher()) {
                for (Paket p : rf.getPakete()) {
                    allPakets.add(p);
                }
            }
        }
        return allPakets;
    }












    //-----GETTER----------------------------
    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public ArrayList<Regal> getRegale() {
        return regale;
    }

    public ArrayList<Paket> getPaketListe() {
        return paketListe;
    }

    //-----SETTER----------------------------
    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public void setRegale(ArrayList<Regal> regale) {
        this.regale = regale;
    }




}
