package ShelfManager.Lager;

public class Einlegeboden {

    private Regal regal;
    private int hoehe;
    private int breite;
    private int tragkraft;
    private int xPos;
    private int yPos;


    public Einlegeboden(Regal regal, int hoehe, int tragkraft) {
        this.regal = regal;
        this.hoehe = hoehe;
        this.breite = regal.getBreite();
        this.tragkraft = tragkraft;
        this.xPos = 0;
        this.yPos = 0;

    }

    /**
     * Konstruktor - Einlegeboden
     * @param regal
     * @param hoehe
     * @param breite
     * @param tragkraft
     * @param xPos
     * @param yPos
     */
    public Einlegeboden(Regal regal, int hoehe, int breite, int tragkraft, int xPos, int yPos) {
        this.regal = regal;
        this.hoehe = hoehe;
        this.breite = breite;
        this.tragkraft = tragkraft;
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

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public void setTragkraft(int tragkraft) {this.tragkraft = tragkraft;}

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
