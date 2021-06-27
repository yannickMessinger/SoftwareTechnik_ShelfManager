package ShelfManager.gui.PaketConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaketConfigViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private PaketConfigView paketConfigView;
    private TextField nameField;
    private TextField hoeheField;
    private TextField breiteField;
    private TextField gewichtField;
    private TextField tragKraftField;
    private ColorPicker paketColor;
    private Button addNewPaket;

    public PaketConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.paketConfigView = new PaketConfigView();

        this.nameField = paketConfigView.getNameField();
        this.hoeheField = paketConfigView.getHoeheField();
        this.breiteField = paketConfigView.getBreiteField();
        this.gewichtField = paketConfigView.getGewichtField();
        this.tragKraftField = paketConfigView.getTragKraftField();
        this.paketColor = paketConfigView.getPaketColor();

        this.addNewPaket = paketConfigView.getAddNewPaket();



        rootView = this.paketConfigView;
        initialize();
    }

    @Override
    public void initialize() {
        addNewPaket.addEventHandler(ActionEvent.ACTION, event -> {

            String paketName = nameField.getText();
            int hoehePaket = Integer.parseInt(hoeheField.getText());
            int breitePaket = Integer.parseInt(breiteField.getText());
            int gewichtPaket = Integer.parseInt(gewichtField.getText());
            int tragKraft = Integer.parseInt(tragKraftField.getText());
            //Paketfarbe hinzufuegen
            //Unvertraeglichkeiten hinzufuegen
            Paket paketToAdd = new Paket();
            paketToAdd.setName(paketName);
            paketToAdd.setHoehe(hoehePaket);
            paketToAdd.setBreite(breitePaket);
            paketToAdd.setGewicht(gewichtPaket);
            paketToAdd.setTragkraft(tragKraft);

            hauptLager.getPaketListe().add(paketToAdd);
            System.out.println("neues Paket angelegt");


            nameField.setText("");
            hoeheField.setText("");
            breiteField.setText("");
            gewichtField.setText("");

        });

    }

        public Pane getRootView () {
            return rootView;
        }

    }
