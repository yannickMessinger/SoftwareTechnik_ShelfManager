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
        viewName.setId("title");



        //Name---------------------------
        Label name = new Label("Name");
        name.getStyleClass().add("titleLabel");

        nameField = new TextField();
        nameField.getStyleClass().add("textField");
        nameField.setMaxWidth(600);
        nameField.setPromptText("Bitte Name eingeben");
        HBox nameInputBox = new HBox(nameField);
        VBox nameBox = new VBox(name, nameInputBox);

        //Hoehe---------------------------
        Label hoehe = new Label("Hoehe");
        hoehe.getStyleClass().add("titleLabel");

        hoeheField = new TextField();
        hoeheField.getStyleClass().add("textField");
        hoeheField.setMaxWidth(600);
        hoeheField.setPromptText("Bitte Zahl eingeben");
        HBox hoeheInputBox = new HBox(hoeheField, new Label("cm"));
        VBox hoeheBox = new VBox(hoehe, hoeheInputBox);

        //Breite---------------------------
        Label breite = new Label("Breite");
        breite.getStyleClass().add("titleLabel");

        breiteField = new TextField();
        breiteField.getStyleClass().add("textField");
        breiteField.setMaxWidth(600);
        breiteField.setPromptText("Bitte Zahl eingeben");
        HBox breiteInputBox = new HBox(breiteField, new Label("cm"));
        VBox breiteBox = new VBox(breite, breiteInputBox);

        //Gewicht---------------------------
        Label gewicht = new Label("Gewicht");
        gewicht.getStyleClass().add("titleLabel");


        gewichtField = new TextField();
        gewichtField.getStyleClass().add("textField");
        gewichtField.setMaxWidth(600);
        gewichtField.setPromptText("Bitte Zahl eingeben");
        HBox gewichtInputBox = new HBox(gewichtField, new Label("kg"));
        VBox gewichtBox = new VBox(gewicht, gewichtInputBox);

        //Tragkraft--------------------------
        Label tragKraft = new Label ("Tragkraft");
        tragKraft.getStyleClass().add("titleLabel");

        tragKraftField = new TextField();
        tragKraftField.getStyleClass().add("textField");
        tragKraftField.setMaxWidth(600);
        tragKraftField.setPromptText("Bitte Zahl eingeben");
        HBox tragKraftInputBox = new HBox(tragKraftField, new Label("kg"));
        VBox tragKraftBox = new VBox(tragKraft, tragKraftInputBox);

        //Farbe------------------------------
        Label paketFarbe = new Label("Paketfarbe");
        paketFarbe.getStyleClass().add("titleLabel");

        paketColor = new ColorPicker();
        HBox paketColorBox = new HBox( paketColor);
        paketColor.getStyleClass().add("style-button-simple");
        HBox colorBox = new HBox(paketFarbe, paketColorBox);
        paketColorBox.setPadding(new Insets(0, 0, 5, 24));


        //Unvertraeglcihkeiten---------------
        Label unvertraeglMit = new Label("Unvertr. mit:");
        unvertraeglMit.getStyleClass().add("titleLabel");


        unvertraeglichkeiten = new ColorPicker();
        unvertraeglichkeiten.getStyleClass().add("style-button-simple");
        addUnvertraeglichkeit = new Button(("Unvertraeglichkeit hinzufuegen"));
        addUnvertraeglichkeit.setId("style-button-simple");
        HBox unvertraeglichkeitenBox = new HBox( unvertraeglichkeiten, addUnvertraeglichkeit);
        HBox unvertraeglichkeitenBoxAll = new HBox(unvertraeglMit,unvertraeglichkeitenBox);
        unvertraeglichkeitenBox.setPadding(new Insets(0, 0, 5, 20));


        //Buttons----------------------------
        addNewPaket = new Button();
        addNewPaket.getStyleClass().addAll("add-icon", "icon-button");
        Region spacer = new Region();

        getBackToLagerView = new Button();
        getBackToLagerView.getStyleClass().addAll("back-icon", "icon-button");
        HBox buttonBox = new HBox(getBackToLagerView, spacer, addNewPaket);

        VBox inputBox = new VBox(viewName, nameBox, hoeheBox, breiteBox, gewichtBox, tragKraftBox, colorBox, unvertraeglichkeitenBoxAll, buttonBox);
        this.setCenter(inputBox);

        //---STYLE-----------------------------------------
        inputBox.setPadding(new Insets(60));
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


        this.getStyleClass().addAll("background");

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
