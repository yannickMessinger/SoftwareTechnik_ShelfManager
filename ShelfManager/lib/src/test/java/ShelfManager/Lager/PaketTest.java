package ShelfManager.Lager;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PaketTest {

    Paket testPacket1;
    Paket testPacket2;
    Paket testPacket3;





    @BeforeEach
    public void setUp() {
      testPacket1 =  new Paket("TestPaket1",10,10,10,10, Color.RED);
      testPacket2 =  new Paket("TestPaket2",10,10,10,10, Color.YELLOW);
      testPacket3 =  new Paket("TestPaket3",10,10,10,10, Color.GREEN);
    }



    @Test
    @DisplayName("Testet ob Paketname vom Typ String ist")
    public void setNameTest(){

        Assertions.assertTrue(testPacket1 instanceof Paket);


    }

    @Test
    @DisplayName("Testet, ob Paketliste paketsOnTop  nach Aufruf von removeFromTop entsprechend reduziert wird und richtiges Paket entfernt wurde")
    public void removePaketOnTopTest(){
        testPacket1.getPaketsOnTop().add(testPacket2);
        testPacket1.getPaketsOnTop().add(testPacket3);
        testPacket1.removeFromTop(testPacket2);
        Assertions.assertTrue(testPacket1.getPaketsOnTop().size() == 1);
        Assertions.assertTrue(testPacket1.getPaketsOnTop().contains(testPacket3));
    }




}
