package ShelfManager.gui.PaketConfigView;

import ShelfManager.Lager.Paket;
import ShelfManager.gui.LagerView.LagerView;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PaketConfigView extends BorderPane {

    private TextField nameField;
    private TextField hoeheField;
    private TextField breiteField;
    private TextField gewichtField;
    private TextField tragKraftField;
    private ColorPicker paketColor;
    private ColorPicker unvertraeglichkeiten;
    private Button addNewPaket;
    private Button getBackToLagerView;
    private Button addUnvertraeglichkeit;




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


        Label unvertraeglMit = new Label("Unvertr. mit:");
        unvertraeglichkeiten = new ColorPicker();


        addNewPaket = new Button("Paket hinzufuegen");
        addUnvertraeglichkeit = new Button(("Unvertraeglichkeit hinzufuegen"));
        getBackToLagerView = new Button("zurueck");

        inputBox.getChildren().addAll(viewName,name, nameField,hoehe, hoeheField, breite,breiteField,gewicht, gewichtField,paketFarbe, paketColor, unvertraeglMit, unvertraeglichkeiten, addUnvertraeglichkeit,  tragKraft, tragKraftField, addNewPaket, getBackToLagerView);

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

    /*public ComboBox<Color> getColor() {
        return color;
    }*/

    public Button getBackToLagerView() {
        return getBackToLagerView;
    }

    public ColorPicker getUnvertraeglichkeiten() {
        return unvertraeglichkeiten;
    }

    public Button getAddUnvertraeglichkeit() {
        return addUnvertraeglichkeit;
    }
}
