package ShelfManager.Lager;

import ShelfManager.Lager.Exceptions.LagerVollException;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;


public class LagerTest {
    Lager testLager = new Lager();


    @BeforeEach
    public void setUp() {
        testLager.setHoehe(5);
        testLager.setHoehe(6);
    }


    @Test
    @DisplayName("Konstruktor Lager() gibt Objekt vom Typ Lager zurueck")
    public void testeLagerObjekt() {
        Assertions.assertTrue(testLager instanceof Lager);
    }


    @Test
    @DisplayName("filterPaketsByColor() erzeugt Liste, in der nur Pakete der dem Filter entsprechenden Farbe sind")
    public void testFilterPaketsByColor() {
        Paket testPaket1 = new Paket("testPaket1", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Paket testPaket2 = new Paket("testPaket2", 10, 10, 100, Color.GREEN, 20, 10, 10, new ArrayList<Color>());
        Paket testPaket3 = new Paket("testPaket3", 10, 10, 100, Color.BLUE, 20, 10, 10, new ArrayList<Color>());
        testLager.getObservablePaketList().addAll(testPaket1,testPaket2,testPaket3);
        testLager.filterPaketsByColor(Color.RED);
        Assertions.assertEquals(testLager.getObervableFilteredList().get(0), testPaket1);
        Assertions.assertTrue(testLager.getObervableFilteredList().size() == 1);
    }

    @Test
    @DisplayName("resetFilteredList() loescht alle Pakete aus der Observable filteredList")
    public void testResetFilteredList() {
        Paket testPaket1 = new Paket("testPaket1", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Paket testPaket2 = new Paket("testPaket2", 10, 10, 100, Color.GREEN, 20, 10, 10, new ArrayList<Color>());
        Paket testPaket3 = new Paket("testPaket3", 10, 10, 100, Color.BLUE, 20, 10, 10, new ArrayList<Color>());
        testLager.getObservablePaketList().addAll(testPaket1,testPaket2,testPaket3);
        testLager.filterPaketsByColor(Color.RED);
        Assertions.assertFalse(testLager.getObervableFilteredList().isEmpty());

        testLager.resetFilterList();
        Assertions.assertTrue(testLager.getObervableFilteredList().isEmpty());
    }

    @Test
    @DisplayName("addPaketToList() fuegt Paket zu paketListe hinzu")
    public void testAddPaketToList() {
        Paket testPaket1 = new Paket("testPaket1", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Assertions.assertFalse(testLager.getObservablePaketList().contains(testPaket1));
        testLager.addPaketToList(testPaket1);
        Assertions.assertTrue(testLager.getObservablePaketList().contains(testPaket1));
    }

    @Test
    @DisplayName("removePaketFromList() entfernt zu loeschendes Paket aus paketListe")
    public void testRemovePaketFromList() {
        Paket testPaket1 = new Paket("testPaket1", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        testLager.getObservablePaketList().add(testPaket1);
        Assertions.assertTrue(testLager.getObservablePaketList().contains(testPaket1));
        testLager.removePaketFromList(testPaket1);
        Assertions.assertFalse(testLager.getObservablePaketList().contains(testPaket1));
    }

    @Test
    @DisplayName("addPaketToAllPakets() fuegt Paket zur Liste aller Pakete")
    public void testAddPaketToAllPakets() {
        Paket testPaket1 = new Paket("testPaket1", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        Assertions.assertFalse(testLager.getAllPakets().contains(testPaket1));
        testLager.addPaketToAllPakets(testPaket1);
        Assertions.assertTrue(testLager.getAllPakets().contains(testPaket1));
    }

    @Test
    @DisplayName("removePaketFromAllPakets entfernt zu loeschendes Paket aus Liste aller Pakete")
    public void testremovePaketFromAllPakets() {
        Paket testPaket1 = new Paket("testPaket1", 10, 10, 100, Color.RED, 20, 10, 10, new ArrayList<Color>());
        testLager.getAllPakets().add(testPaket1);
        Assertions.assertTrue(testLager.getAllPakets().contains(testPaket1));
        testLager.removePaketFromAllPakets(testPaket1);
        Assertions.assertFalse(testLager.getAllPakets().contains(testPaket1));
    }



    //Exceptions-----------------------
    @Test
    @DisplayName("addRegal() wirft LagerVollException, wenn kein Regal mehr in das Lager passt")
    public void testeLagerVoll() {
        Assertions.assertThrows(LagerVollException.class, () ->{
            for(int i = 0; i < 6; i++) {
                Regal testRegal = new Regal(200, 100);
                testLager.addRegal(testRegal);
            }
        });
    }



}











