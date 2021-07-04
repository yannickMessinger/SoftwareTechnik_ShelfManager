package ShelfManager.Lager;

import ShelfManager.Lager.Exceptions.LagerVollException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;


public class LagerTest {
    Lager testLager = new Lager();


    @Test
    @DisplayName("Konstruktor Lager() gibt Objekt vom Typ Lager zurueck")
    public void testeLagerObjekt() {
        Assertions.assertTrue(testLager instanceof Lager);
    }

    @Test
    @DisplayName("addRegal() wirft LagerVollException, wenn kein Regal mehr in das Lager passt")
    public void testeLagerVoll() {
        testLager.setHoehe(5);
        testLager.setHoehe(6);
        Assertions.assertThrows(LagerVollException.class, () ->{
            for(int i = 0; i < 6; i++) {
                Regal testRegal = new Regal(200, 100);
                testLager.addRegal(testRegal);
            }
        });
    }



}











