package ShelfManager.Lager;

import ShelfManager.Lager.Exceptions.LagerVollException;
import ShelfManager.Lager.Exceptions.PaketZuGrossException;
import ShelfManager.Lager.Exceptions.RegalfachTraglastExceededException;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RegalfachTest {
    Regal testRegal;
    Regalfach testRegalfach;
    Einlegeboden testEinlegeboden;

    @BeforeEach
    public void setUp() {
        testRegal = new Regal(200, 100);
        testEinlegeboden = new Einlegeboden(testRegal, 5, 100, 200, 10, 10);
        testRegalfach = new Regalfach(testEinlegeboden, new ArrayList<Paket>(), 100, 50, 50);
        testRegal.installEinlegeboden(testEinlegeboden);
    }

    @Test
    @DisplayName("Konstruktor Regalfach() gibt Objekt vom Typ Regalfach zurueck")
    public void testeRegalfachObjekt() {
        Assertions.assertTrue(testRegalfach instanceof Regalfach);
    }


    @Test
    @DisplayName("tryToAddPaket() fuegt Paket hinzu, wenn noch keine Pakete im Regalfach sind")
    public void testePaketHinzufuegenRegalfachLeer() {
        Paket testPaket = new Paket("testPaket", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Assertions.assertTrue(testRegalfach.tryToAddPaket(testPaket));
    }

    @Test
    @DisplayName("tryToAddPaket() gibt false zurueck, wenn das Paket zu hoch ist")
    public void testePaketZuHoch() {
        Paket testPaket = new Paket("testPaket", 110, 50, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Assertions.assertFalse(testRegalfach.tryToAddPaket(testPaket));
    }

    @Test
    @DisplayName("tryToAddPaket() gibt false zurueck, wenn das Paket zu breit ist")
    public void testePaketZuBreit() {
        Paket testPaket = new Paket("testPaket", 20, 110, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Assertions.assertFalse(testRegalfach.tryToAddPaket(testPaket));
    }

    @Test
    @DisplayName("tryToAddPaket() gibt false zurueck, wenn es bei bestehenden Paketen Unvertraeglichkeiten gibt")
    public void testeBestehendePaketeUnvertraeglichMitNeuemPaket() {
        //TODO: Position bereucksichtigen wegen Stapel etc...
        Paket testPaket1 = new Paket("testPaket", 5, 50, 100, Color.RED, 20, 10, 5, new ArrayList<Color>());
        testPaket1.getUnvertraeglichkeiten().add(Color.BLUE);
        testRegalfach.getPakete().add(testPaket1);
        Paket testPaket2 = new Paket("testPaket", 5, 50, 100, Color.BLUE, 20, 10, 10, new ArrayList<Color>());
        Assertions.assertFalse(testRegalfach.checkUnvertraeglichkeiten(testPaket2));
    }

    @Test
    @DisplayName("tryToAddPaket() gibt false zurueck, wenn es beim neuen Paket Unvertraeglichkeiten gibt")
    public void testeNeuesPaketUnvertraeglichMitBestehendenPaketen() {
        //TODO: Position bereucksichtigen wegen Stapel etc...
        Paket testPaket1 = new Paket("testPaket", 5, 50, 100, Color.RED, 20, 10, 5, new ArrayList<Color>());
        testRegalfach.getPakete().add(testPaket1);
        Paket testPaket2 = new Paket("testPaket", 5, 50, 100, Color.BLUE, 20, 10, 10, new ArrayList<Color>());
        testPaket2.getUnvertraeglichkeiten().add(Color.RED);

        Assertions.assertFalse(testRegalfach.checkUnvertraeglichkeiten(testPaket2));
    }



    //Exceptions----------------------
    @Test
    @DisplayName("tryToAddPaket() wirft RefalfachVollException, wenn die Traglast des Regalfachs ueberschritten wurde")
    public void testeRegalfachVoll() {
        Assertions.assertThrows(RegalfachTraglastExceededException.class, () ->{
            for(int i = 0; i < 3; i++) {
                Paket testPaket = new Paket("testPaket"+i, 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
                testRegalfach.tryToAddPaket(testPaket);
            }
        });
    }

    @Test
    @DisplayName("tryToAddPaket() wirft PaketZuGrossException, wenn das Paket nicht in das Regalfach passt")
    public void testePaketZuGross() {
        Assertions.assertThrows(PaketZuGrossException.class, () ->{
            Paket testPaket = new Paket("testPaket", 200, 100, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
            testRegalfach.tryToAddPaket(testPaket);
        });
    }



}
