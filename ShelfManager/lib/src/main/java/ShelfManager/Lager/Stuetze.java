package ShelfManager.Lager;

public class Stuetze extends Gegenstand {
    private int hoehe;
    private int breite;
    private int xPos;
    private int yPos;

    public Stuetze() {
        this.hoehe = erfasseHoehe();
        this.breite = erfasseBreite();
    }

    public Stuetze(int hoehe, int breite) {
        this.hoehe = hoehe;
        this.breite = breite;
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

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}
