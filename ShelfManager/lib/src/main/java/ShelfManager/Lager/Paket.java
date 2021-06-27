package ShelfManager.Lager;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Paket extends Gegenstand{
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private String name;
    private int hoehe;
    private int breite;
    private int gewicht;
    private Color farbe;
    private int tragkraft;
    private int xPos;
    private int yPos;
    private ArrayList<Color> unvertraeglichkeiten;


    /**
     * Konstruktor - Paket
     */
    public Paket() {
        setName();
        this.hoehe = this.erfasseHoehe();
        this.breite = this.erfasseBreite();
        setGewicht();
        this.farbe = new Color(255,255,255);
        setTragkraft();
        this.xPos = 0;
        this.yPos = 0;
        this.unvertraeglichkeiten = new ArrayList<>();
    }




    //-----GETTER----------------------------

    public String getName() {
        return name;
    }

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getGewicht() {
        return gewicht;
    }

    public Color getFarbe() {
        return farbe;
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

    public ArrayList<Color> getUnvertraeglichkeiten() {
        return unvertraeglichkeiten;
    }

    //-----SETTER----------------------------

    /**
     * Erfasst den Namen eines Pakets
     * und gibt diesen zurueck
     * @return name
     */
    public void setName() {
        name = "";
        try {
            while (name.equals("")) {
                //TO DO: Ueberpruefung, ob Name schon existiert
                System.out.println("Gib einen Namen ein:");
                name = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    /**
     * Erfasst Gewicht eines Pakets
     * und gibt dieses zurueck
     * @return gewicht
     */
    public void setGewicht() {
        gewicht = 0;
        try {
            while (gewicht <= 0) {
                System.out.println("Trage das Gewicht ein:");
                gewicht = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.gewicht = gewicht;
    }

    public void setFarbe(Color farbe) {
        this.farbe = farbe;
    }

    public void setTragkraft() {
        tragkraft = 0;
        try {
            while (tragkraft < 0) {
                System.out.println("Trage das Gewicht ein:");
                tragkraft = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.tragkraft = tragkraft;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setUnvertraeglichkeiten(ArrayList<Color> unvertraeglichkeiten) {
        this.unvertraeglichkeiten = unvertraeglichkeiten;
    }
}
