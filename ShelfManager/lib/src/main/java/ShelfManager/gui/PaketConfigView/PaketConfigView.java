package ShelfManager.gui.PaketConfigView;

import ShelfManager.Lager.Paket;
import ShelfManager.gui.LagerView.LagerView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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

        Label viewName = new Label("Erstelle ein neues Paket");

        //Name---------------------------
        Label name = new Label("Name");
        nameField = new TextField();
        HBox nameInputBox = new HBox(nameField, new Label("cm"));
        VBox nameBox = new VBox(name, nameInputBox);

        //Hoehe---------------------------
        Label hoehe = new Label("Hoehe");
        hoeheField = new TextField();
        HBox hoeheInputBox = new HBox(hoeheField, new Label("cm"));
        VBox hoeheBox = new VBox(hoehe, hoeheInputBox);

        //Breite---------------------------
        Label breite = new Label("Breite");
        breiteField = new TextField();
        HBox breiteInputBox = new HBox(breiteField, new Label("cm"));
        VBox breiteBox = new VBox(breite, breiteInputBox);

        //Gewicht---------------------------
        Label gewicht = new Label("Gewicht");
        gewichtField = new TextField();
        HBox gewichtInputBox = new HBox(gewichtField, new Label("kg"));
        VBox gewichtBox = new VBox(gewicht, gewichtInputBox);

        //Tragkraft--------------------------
        Label tragKraft = new Label ("Tragkraft");
        tragKraftField = new TextField();
        HBox tragKraftInputBox = new HBox(tragKraftField, new Label("kg"));
        VBox tragKraftBox = new VBox(tragKraft, tragKraftInputBox);

        //Farbe------------------------------
        Label paketFarbe = new Label("Paketfarbe");
        paketColor = new ColorPicker();
        VBox colorBox = new VBox(paketFarbe, paketColor);

        //Unvertraeglcihkeiten---------------
        Label unvertraeglMit = new Label("Unvertr. mit:");
        unvertraeglichkeiten = new ColorPicker();
        addUnvertraeglichkeit = new Button(("Unvertraeglichkeit hinzufuegen"));
        VBox unvertraeglichkeitenBox = new VBox(unvertraeglMit, unvertraeglichkeiten, addUnvertraeglichkeit);

        //Buttons----------------------------
        addNewPaket = new Button("Paket hinzufuegen");
        Region spacer = new Region();
        getBackToLagerView = new Button("zurueck");
        HBox buttonBox = new HBox(getBackToLagerView, spacer, addNewPaket);

        VBox inputBox = new VBox(viewName, nameBox, hoeheBox, breiteBox, gewichtBox, tragKraftBox, colorBox, unvertraeglichkeitenBox, buttonBox);

        this.setCenter(inputBox);

        //---STYLE-----------------------------------------
        inputBox.setPadding(new Insets(100));
        inputBox.setSpacing(20);


        nameInputBox.setSpacing(10);
        nameInputBox.setHgrow(nameField, Priority.ALWAYS);
        nameBox.setSpacing(10);

        hoeheInputBox.setSpacing(10);
        hoeheInputBox.setHgrow(hoeheField, Priority.ALWAYS);
        hoeheBox.setSpacing(10);

        breiteInputBox.setSpacing(10);
        breiteInputBox.setHgrow(breiteField, Priority.ALWAYS);
        breiteBox.setSpacing(10);

        gewichtInputBox.setSpacing(10);
        gewichtInputBox.setHgrow(gewichtField, Priority.ALWAYS);
        gewichtBox.setSpacing(10);

        tragKraftInputBox.setSpacing(10);
        tragKraftInputBox.setHgrow(tragKraftField, Priority.ALWAYS);
        tragKraftBox.setSpacing(10);

        colorBox.setSpacing(10);

        unvertraeglichkeitenBox.setSpacing(10);

        buttonBox.setSpacing(10);
        buttonBox.setHgrow(spacer, Priority.ALWAYS);





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
