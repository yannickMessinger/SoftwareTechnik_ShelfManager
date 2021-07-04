package ShelfManager.Lager;

import ShelfManager.Lager.Exceptions.LagerVollException;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Lager {
    private int hoehe;
    private int breite;
    private ObservableList<Regal> observableRegalList;
    private ObservableList<Paket> observablePaketList;
    private ObservableList<Paket> obervableFilteredList;
    private ObservableList<Paket> allPakets;
    private ArrayList<Paket> aktStack;
    private SimpleObjectProperty<Paket> aktPaket;
    private SimpleBooleanProperty paketWasDeleted;

    /**
     * Konstruktor - Lager
     */
    public Lager() {
        this.observableRegalList = FXCollections.observableArrayList();
        this.obervableFilteredList = FXCollections.observableArrayList();
        this.observablePaketList = FXCollections.observableArrayList();
        this.allPakets = FXCollections.observableArrayList();
        this.aktStack = new ArrayList<>();
        this.aktPaket = new SimpleObjectProperty<>();
        this.paketWasDeleted = new SimpleBooleanProperty(false);

    }

    /**
     * Konstruktor - Lager
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

    public void filterPaketsByColor(Color color){

        for(Paket p : this.observablePaketList){
            if(p.getFarbe() .equals(color)){
                this.obervableFilteredList.add(p);

            }
        }

    }

    public void resetFilterList(){
        this.obervableFilteredList.clear();
    }


    public void filterAllPaketsByColor(Color color){

        for(Paket p : this.allPakets){
            if(p.getFarbe() .equals(color)){
                this.obervableFilteredList.add(p);

            }
        }
    }



    /**
     * prueft vor dem Hinzufuegen eines neuen Regals,
     * ob das gewuenschte Regal in das Lager passt
     * @param regalToAdd
     */
    public void addRegal(Regal regalToAdd) throws LagerVollException {
        int verfuegbarerPlatz = breite;
        for (Regal r: observableRegalList) {
            verfuegbarerPlatz = verfuegbarerPlatz - r.getBreite();
        }
        if( verfuegbarerPlatz <= 0) {
            throw  new LagerVollException();
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


    /**
     * Entfernt Paket aus der ObservableList
     * @param p zu löschendes Paket
     */

    public void removePaketFromList(Paket p){
        observablePaketList.remove(p);
    }

    /**
     * Entfernt Paket aus der allPakets Liste
     * @param p zu löschendes Paket
     */
    public void removePaketFromAllPakets(Paket p){
        allPakets.remove(p);
    }

    //-----GETTER----------------------------
    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public ObservableList<Regal> getObservableRegalList() {
        return observableRegalList;
    }

    public ObservableList<Paket> getObservablePaketList() {
        return observablePaketList;
    }

    public ObservableList<Paket> getAllPakets() {
        return allPakets;
    }

    public ObservableList<Paket> getObervableFilteredList(){
        return obervableFilteredList;
    }

    public ArrayList<Paket> getAktStack() {
        return aktStack;
    }

    //-----SETTER----------------------------
    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public Paket getAktPaket() {
        return aktPaket.get();
    }

    public SimpleObjectProperty<Paket> aktPaketProperty() {
        return aktPaket;
    }

    public void setAktPaket(Paket aktPaket) {
        this.aktPaket.set(aktPaket);
    }


    public boolean isPaketWasDeleted() {
        return paketWasDeleted.get();
    }

    public SimpleBooleanProperty getPaketWasDeletedProperty() {
        return paketWasDeleted;
    }

    public void setPaketWasDeleted(boolean paketWasDeleted) {
        this.paketWasDeleted.set(paketWasDeleted);
    }

    public void setAktStack(ArrayList<Paket> aktStack) {
        this.aktStack = aktStack;
    }
}
