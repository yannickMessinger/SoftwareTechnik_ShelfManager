package ShelfManager.Lager;

public class Stuetze {
    private int hoehe;
    private int breite;
    private int xPos;
    private int yPos;

    public Stuetze(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
    }

    /**
     * Konstruktor fuer JSONHandler Parsing-Methods
     * @param hoehe
     * @param breite
     * @param xPos
     * @param yPos
     */
    public Stuetze(int hoehe, int breite, int xPos, int yPos) {
        this.hoehe = hoehe;
        this.breite = breite;
        this.xPos = xPos;
        this.yPos = yPos;
    }

//-----GETTER----------------------------

    public int getHoehe() {
        return hoehe;
    }

    public int getBreite() {
        return breite;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    //-----SETTER----------------------------

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

}
