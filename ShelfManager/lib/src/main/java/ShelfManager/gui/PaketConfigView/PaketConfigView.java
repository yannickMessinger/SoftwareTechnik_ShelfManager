package ShelfManager.gui.PaketConfigView;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PaketConfigView extends BorderPane {

    private TextField nameField;
    private TextField hoeheField;
    private TextField breiteField;
    private TextField gewichtField;
    private TextField tragKraftField;
    private ColorPicker paketColor;
    private Button addNewPaket;



    public PaketConfigView() {
        VBox inputBox = new VBox();

        Label viewName = new Label("PaketConfigView");


        Label name = new Label("Name");
        nameField = new TextField();

        Label hoehe = new Label("Hoehe");
        hoeheField = new TextField();

        Label breite = new Label("Breite");
        breiteField = new TextField();

        Label gewicht = new Label("Gewicht");
        gewichtField = new TextField();

        Label tragKraft = new Label ("Tragkraft");
        tragKraftField = new TextField();
        //Color picker
        Label paketFarbe = new Label("Paketfarbe");
        paketColor = new ColorPicker();


        addNewPaket = new Button("Paket hinzufügen");

        inputBox.getChildren().addAll(viewName,name, nameField,hoehe, hoeheField, breite,breiteField,gewicht, gewichtField,paketFarbe,paketColor, tragKraft, tragKraftField, addNewPaket);

        this.setTop(inputBox);




    }

    public TextField getNameField() {
        return nameField;
    }

    public TextField getTragKraftField() {
        return tragKraftField;
    }

    public TextField getHoeheField() {
        return hoeheField;
    }

    public TextField getBreiteField() {
        return breiteField;
    }

    public TextField getGewichtField() {
        return gewichtField;
    }

    public ColorPicker getPaketColor() {
        return paketColor;
    }

    public Button getAddNewPaket() {
        return addNewPaket;
    }
}