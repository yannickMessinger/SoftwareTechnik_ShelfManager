package ShelfManager.Lager;

import ShelfManager.Lager.Exceptions.LagerVollException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class RegalTest {

    Regal testRegal = new Regal(200, 100);

    @Test
    @DisplayName("Konstruktor Regal() gibt Objekt vom Typ Regal zurueck")
    public void testeRegalObjekt() {
        Assertions.assertTrue(testRegal instanceof Regal);
    }


}
