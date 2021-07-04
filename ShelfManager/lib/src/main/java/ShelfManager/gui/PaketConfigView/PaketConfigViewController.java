package ShelfManager.gui.PaketConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.awt.*;
import java.util.ArrayList;

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
    private Button backToLagerView;
    private Button addUnvertraeglichkeit;
    private ColorPicker unvertraeglichkeiten;
    private ListView<Paket> existingPakets;
    private ObservableList<Color> collectUnvertraeglichkeiten;
    private ListView<Color> unvertraeglichkeitenList;
    private Button removeUnvertraeglichkeit;
    private Button activateGefahrgutField;
    private Button addGefahrgut;
    private Button removeGefahrgut;
    private HBox gefahrgutbox;
    private TextField gefahrenInput;
    private ObservableList<String> collectGefahrgut;
    private ListView<String> gefahrgutList;


    //Warnings----
    private Label nameWarning;
    private Label hoeheWarning;
    private Label breiteWarning;
    private Label gewichtWarning;
    private Label tragKraftWarning;

    public PaketConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.paketConfigView = new PaketConfigView();

        ////Warnings----
        this.nameWarning = paketConfigView.getNameWarning();
        this.hoeheWarning = paketConfigView.getHoeheWarning();
        this.breiteWarning = paketConfigView.getBreiteWarning();
        this.gewichtWarning = paketConfigView.getGewichtWarning();
        this.tragKraftWarning = paketConfigView.getTragKraftWarning();

        this.nameField = paketConfigView.getNameField();
        this.hoeheField = paketConfigView.getHoeheField();
        this.breiteField = paketConfigView.getBreiteField();
        this.gewichtField = paketConfigView.getGewichtField();
        this.tragKraftField = paketConfigView.getTragKraftField();
        this.paketColor = paketConfigView.getPaketColor();
        this.addNewPaket = paketConfigView.getAddNewPaket();
        this.backToLagerView = paketConfigView.getBackToLagerView();
        this.addUnvertraeglichkeit = paketConfigView.getAddUnvertraeglichkeit();
        this.unvertraeglichkeiten = paketConfigView.getUnvertraeglichkeiten();
        this.collectUnvertraeglichkeiten = FXCollections.observableArrayList();
        this.collectGefahrgut = FXCollections.observableArrayList();
        this.unvertraeglichkeitenList = paketConfigView.getUnvertraeglichkeitenList();
        this.removeUnvertraeglichkeit = paketConfigView.getRemoveUnvertraeglichkeit();
        this.addUnvertraeglichkeit = paketConfigView.getAddUnvertraeglichkeit();
        this.removeUnvertraeglichkeit = paketConfigView.getRemoveUnvertraeglichkeit();
        this.activateGefahrgutField = paketConfigView.getActivateGefahrgutField();
        this.gefahrenInput = paketConfigView.getOptionalGefahrgut();
        this.addGefahrgut = paketConfigView.getAddGefahrgut();
        this.gefahrgutList = paketConfigView.getGefahrgutList();
        this.removeGefahrgut = paketConfigView.getRemoveGefahrgut();

        rootView = this.paketConfigView;
        initialize();
    }

    @Override
    public void initialize() {


        addNewPaket.addEventHandler(ActionEvent.ACTION, event -> {
            String paketName = "";
            int hoehePaket = 0;
            int breitePaket = 0;
            int gewichtPaket = 0;
            int tragKraft = -1;

            //uberpruefe, ob Feld leer ist oder Name schon existiert
            if(nameField.getText().equals("")) {
                nameWarning.setText("Der Paketname darf nicht leer sein");
            } else {
                if (hauptLager.getAllPakets().size() > 1) {
                    for(Paket p : hauptLager.getAllPakets()) {
                        if (p.getPaketName().equals(nameField.getText())) {
                            nameWarning.setText("Der Paketname existiert bereits");
                        } else {
                            paketName = nameField.getText();
                            System.out.println(paketName);
                            nameWarning.setText("");
                        }
                    }
                } else {
                    paketName = nameField.getText();
                    System.out.println(paketName);
                    nameWarning.setText("");
                }

            }

            //ueberpruefe Hoehe-----------
            if(hoeheField.getText().equals("")){
                hoeheWarning.setText("Das Feld darf nich leer");
            } else if (!hoeheField.getText().matches("\\d+")) {
                hoeheWarning.setText("keine Buchstaben erlaubt");
            } else if (Integer.parseInt(hoeheField.getText()) < 1 ) {
                hoeheWarning.setText("Die Hoehe darf nich <= 0 sein");
            } else {
                hoehePaket = Integer.parseInt(hoeheField.getText());
                hoeheWarning.setText("");
            }

            //ueberpruefe Breite-----------
            if(breiteField.getText().equals("")) {
                breiteWarning.setText("Das Feld darf nicht leer sein");
            } else if (!breiteField.getText().matches("\\d+")) {
                breiteWarning.setText("keine Buchstaben erlaubt");
            } else if (Integer.parseInt(breiteField.getText()) < 1) {
                breiteWarning.setText("Die Breite darf nicht <= 0 sein");
            } else {
                breitePaket = Integer.parseInt(breiteField.getText());
                breiteWarning.setText("");
            }

            //ueberpruefe Gewicht-----------
            if(gewichtField.getText().equals("")) {
                gewichtWarning.setText("Das Feld darf nicht leer sein");
            } else if (!gewichtField.getText().matches("\\d+")) {
                gewichtWarning.setText("keine Buchstaben erlaubt");
            } else if (Integer.parseInt(gewichtField.getText()) < 1) {
                gewichtWarning.setText("Das Gewicht darf nicht <= 0 sein");
            } else {
                gewichtPaket = Integer.parseInt(gewichtField.getText());
                gewichtWarning.setText("");
            }

            //ueberpruefe Tragkraft-----------
            if(tragKraftField.getText().equals("")) {
                tragKraftWarning.setText("Trage bitte zuerst eine Tragkraft ein");
            } else if (!tragKraftField.getText().matches("\\d+")) {
                tragKraftWarning.setText("keine Buchstaben erlaubt");
            } else if(Integer.parseInt(tragKraftField.getText()) < 0) {
                tragKraftWarning.setText("Die Tragkraft darf nicht negativ sein");
            } else {
                tragKraft = Integer.parseInt(tragKraftField.getText());
                tragKraftWarning.setText("");
            }


            //Paketfarbe hinzufuegen
            Color color = paketConfigView.getPaketColor().getValue();


            //Paket wird nur erzeugt, wenn alle Eingaben ok sind
            if (!paketName.equals("") && hoehePaket >= 1 && breitePaket >=1 && gewichtPaket >= 1 && tragKraft >= 0) {
                Paket paketToAdd = new Paket(paketName, hoehePaket, breitePaket, gewichtPaket, tragKraft, color);

                //Unvertraeglichkeiten hinzufuegen
                for(Color c : collectUnvertraeglichkeiten){
                    paketToAdd.getUnvertraeglichkeiten().add(c);
                }

                //Gefahrgut hinzufügen
                for(String s : collectGefahrgut){
                    paketToAdd.getGefahrgutListe().add(s);
                }


                this.collectUnvertraeglichkeiten.clear();
                this.collectGefahrgut.clear();
                paketConfigView.deactivateGefahrgutInput();
                hauptLager.addPaketToList(paketToAdd);
                hauptLager.addPaketToAllPakets(paketToAdd);

                System.out.println("neues Paket angelegt");

                nameField.setText("");
                hoeheField.setText("");
                breiteField.setText("");
                gewichtField.setText("");
                tragKraftField.setText("");
                main.switchScene(Scenes.LAGER_VIEW);
            }



        });

        backToLagerView.addEventHandler(ActionEvent.ACTION, event -> {
            paketConfigView.deactivateGefahrgutInput();
            main.switchScene(Scenes.LAGER_VIEW);
        });






        addUnvertraeglichkeit.addEventHandler(ActionEvent.ACTION, event -> {
            Color unvertraeglichkeit = paketConfigView.getUnvertraeglichkeiten().getValue();
            collectUnvertraeglichkeiten.add(unvertraeglichkeit);




        });

        collectUnvertraeglichkeiten.addListener(new ListChangeListener<Color>() {
            @Override
            public void onChanged(Change<? extends Color> c) {
                unvertraeglichkeitenList.getItems().clear();
                unvertraeglichkeitenList.getItems().addAll(collectUnvertraeglichkeiten);
            }
        });

        unvertraeglichkeitenList.setCellFactory(

                new Callback<ListView<Color>, ListCell<Color>>() {
                    @Override
                    public ListCell<Color> call(ListView<Color> v) {
                        return new UnvertraeglichkeitCell();
                    }
                });



        removeUnvertraeglichkeit.addEventHandler(ActionEvent.ACTION, event ->{

            Color  aktUnvertraeglichkeit = unvertraeglichkeitenList.getSelectionModel().getSelectedItem();
            if(aktUnvertraeglichkeit != null) {
                collectUnvertraeglichkeiten.remove(aktUnvertraeglichkeit);
            }

        });


        collectGefahrgut.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                gefahrgutList.getItems().clear();
                gefahrgutList.getItems().addAll(collectGefahrgut);
            }
        });

        gefahrgutList.setCellFactory(

                new Callback<ListView<String>, ListCell<String>>() {
                    @Override
                    public ListCell<String> call(ListView<String> v) {
                        return new GefahrgutCell();
                    }
                });


        gefahrgutList.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {
                String aktGefahrgut = aktGefahrgut = gefahrgutList.getSelectionModel().getSelectedItem();
                if (click.getClickCount() == 2) {

                    if(aktGefahrgut != null && !aktGefahrgut.equals("")) {
                        aktGefahrgut = gefahrgutList.getSelectionModel().getSelectedItem();
                        System.out.println("Gefahrgut gewählt" + gefahrgutList.getSelectionModel().getSelectedItem());
                    }
                }
            }
        });






        activateGefahrgutField.addEventHandler(ActionEvent.ACTION, event -> {
            paketConfigView.activateGefahrgutInput();
        });


        addGefahrgut.addEventHandler(ActionEvent.ACTION, event -> {
            String input = paketConfigView.getOptionalGefahrgut().getText();
            if(!input.equals("")) {
                this.collectGefahrgut.add(input);
                paketConfigView.getOptionalGefahrgut().setText("");
            }

        });

        removeGefahrgut.addEventHandler(ActionEvent.ACTION, event -> {

            String aktGefahrgut = aktGefahrgut = gefahrgutList.getSelectionModel().getSelectedItem();
            if(aktGefahrgut != null){
                aktGefahrgut = gefahrgutList.getSelectionModel().getSelectedItem();
                collectGefahrgut.remove(aktGefahrgut);

            }



        });





    }


        public Pane getRootView () {
            return rootView;
        }

    }
