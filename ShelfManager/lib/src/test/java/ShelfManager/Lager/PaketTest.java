package ShelfManager.Lager;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class PaketTest {

    Paket testPacket;
    ArrayList<Color> unvertraeglichkeiten = new ArrayList<>();

    public PaketTest(){
        this.testPacket = new Paket("TestPaket",10,10,10, Color.ORANGE,10,50,50,unvertraeglichkeiten);
    }


    @Test
    @DisplayName("Testet ob Paketname vom Typ String ist")
    public void setNameTest(){

        Assertions.assertTrue(new Paket("TestPaket",10,10,10, Color.ORANGE,10,50,50,unvertraeglichkeiten) instanceof Paket);


    }




}
