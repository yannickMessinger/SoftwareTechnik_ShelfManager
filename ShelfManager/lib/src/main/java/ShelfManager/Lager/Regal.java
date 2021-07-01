package ShelfManager.Lager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Regal extends Gegenstand{
    private ArrayList<Regalfach> regalfaecher;

    //Einlegeboeden for EinlegbodenListView
    private ObservableList<Einlegeboden> einlegeboeden;

    //Einlegeboeden for RegalComponent
    private ObservableList<Einlegeboden> installedEinlegeboeden;

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
        this.regalfaecher = new ArrayList<>();
        this.stuetzen = addSupport();
        this.hoehe = this.stuetzen[0].getHoehe();
        this.breite = this.erfasseBreite();
        this.tragkraft = calculateLoadCapacity();
        this.xPos = 0;
        this.yPos = 0;
    }

    public Regal(int hoehe, int breite) {
        this.regalfaecher = new ArrayList<>();
        this.einlegeboeden = FXCollections.observableArrayList();
        this.installedEinlegeboeden = FXCollections.observableArrayList();
        this.hoehe = hoehe;
        this.breite = breite;
        this.tragkraft = 0;
        this.xPos = 0;
        this.yPos = 0;
    }

    /**
     * Konstruktor fuer JSONHandler Parsing-Methods
     * @param regalfaecher
     * @param einlegeboeden
     * @param stuetzen
     * @param hoehe
     * @param breite
     * @param tragkraft
     * @param xPos
     * @param yPos
     */
    public Regal(ArrayList<Regalfach> regalfaecher, ObservableList<Einlegeboden> einlegeboeden, Stuetze[] stuetzen, int hoehe, int breite, int tragkraft, int xPos, int yPos) {
        this.regalfaecher = regalfaecher;
        this.einlegeboeden = einlegeboeden;
        this.stuetzen = stuetzen;
        this.hoehe = hoehe;
        this.breite = breite;
        this.tragkraft = tragkraft;
        this.xPos = xPos;
        this.yPos = yPos;
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

    /**
     * Liest die Stuetzen fuer ein Regal ein und gibt diese zurueck
     * @param stuetzenhoehe und stuetzenbreite
     * @return Stuetzen des Regals
     */
    public void addStuetzenByInput(int stuetzenhoehe, int stuetzenbreite) {
        Stuetze stuetze1 = new Stuetze(stuetzenhoehe, stuetzenbreite);
        System.out.println("Stuetze 1 hinzugefügt");
        Stuetze stuetze2 = new Stuetze(stuetzenhoehe, stuetzenbreite);
        System.out.println("Stuetze 2 hinzugefügt");
        this.stuetzen =  new Stuetze[]{stuetze1, stuetze2};
    }

    public void addEinlegeboden(int hoehe, int tragkraft) {
        installedEinlegeboeden.add(new Einlegeboden(this, hoehe, tragkraft));
    }




    //-----GETTER----------------------------
    public ArrayList<Regalfach> getRegalfaecher() {
        return regalfaecher;
    }

    public ObservableList<Einlegeboden> getEinlegeboeden() {
        return einlegeboeden;
    }

    public ObservableList<Einlegeboden> getInstalledEinlegeboeden() {
        return installedEinlegeboeden;
    }

    public Stuetze[] getStuetzen() {
        return stuetzen;
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
