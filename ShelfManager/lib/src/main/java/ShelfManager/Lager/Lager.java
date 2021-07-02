package ShelfManager.Lager;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Lager extends Gegenstand {
    private int hoehe;
    private int breite;
    //private ArrayList<Regal> regale;
    private ObservableList<Regal> observableRegalList;
    //private ArrayList<Paket> paketListe;
    private ObservableList<Paket> observablePaketList;
    private ObservableList<Paket> allPakets;
    private SimpleObjectProperty<Paket> aktPaket;

    /**
     * Konstruktor - Lager
     */
    public Lager() {
        //auskommentiert für Testzwecke wegen Threadproblematik
        //this.hoehe = erfasseHoehe();
        //this.breite = erfasseBreite();
        //this.regale = new ArrayList<Regal>();
        this.observableRegalList = FXCollections.observableArrayList();

        //this.paketListe = new ArrayList<Paket>();
        this.observablePaketList = FXCollections.observableArrayList();
        this.allPakets = FXCollections.observableArrayList();
        this.aktPaket = new SimpleObjectProperty<Paket>();
    }

    /**
     * Konstruktor fuer JSONHandler Parsing-Methods
     * @param hoehe
     * @param breite
     * @param observableRegalList
     * @param observablePaketList
     * @param allPakets
     */
    public Lager(int hoehe, int breite, ObservableList<Regal> observableRegalList, ObservableList<Paket> observablePaketList, ObservableList<Paket> allPakets) {
        this.hoehe = hoehe;
        this.breite = breite;
        this.observableRegalList = observableRegalList;
        this.observablePaketList = observablePaketList;
        this.allPakets = allPakets;
    }

    //-----METHODEN--------------------------


    /**
     * prueft vor dem Hinzufuegen eines neuen Regals,
     * ob das gewuenschte Regal in das Lager passt
     * @param regalToAdd
     */
    public void addRegal(Regal regalToAdd) {
        int verfuegbarerPlatz = breite;
        for (Regal r: observableRegalList) {
            verfuegbarerPlatz = verfuegbarerPlatz - r.getBreite();
        }

        if (regalToAdd.getHoehe() <= hoehe && regalToAdd.getBreite() <= verfuegbarerPlatz){
            observableRegalList.add(regalToAdd);
        } else {
            if (regalToAdd.getHoehe() > hoehe) {
                System.out.println("Das Regal ist zu hoch.");
            } else if (regalToAdd.getBreite() > verfuegbarerPlatz) {
                System.out.println("Das Regal ist zu breit.");
            }

        }
    }


    /**
     * fügt Paket zu paketListe hinzu
     */
    public void addPaketToList(Paket paket) {
        observablePaketList.add(paket);
    }

    /**
     * fügt Paket zu allPakets hinzu
     */
    public void addPaketToAllPakets(Paket paket) {
        allPakets.add(paket);
    }




    //-----GETTER----------------------------
    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

//    public ArrayList<Regal> getRegale() {
//        return regale;
//    }

//    public ArrayList<Paket> getPaketListe() {
//        return paketListe;
//    }


    public ObservableList<Regal> getObservableRegalList() {
        return observableRegalList;
    }

    public ObservableList<Paket> getObservablePaketList() {
        return observablePaketList;
    }

    public ObservableList<Paket> getAllPakets() {
        return allPakets;
    }

    //-----SETTER----------------------------
    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

//    public void setRegale(ArrayList<Regal> regale) {
//        this.regale = regale;
//    }


    public Paket getAktPaket() {
        return aktPaket.get();
    }

    public SimpleObjectProperty<Paket> aktPaketProperty() {
        return aktPaket;
    }

    public void setAktPaket(Paket aktPaket) {
        this.aktPaket.set(aktPaket);
    }
}
