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
    private TextField optionalGefahrgut;
    private ColorPicker paketColor;
    private ColorPicker unvertraeglichkeiten;
    private Button addNewPaket;
    private Button getBackToLagerView;
    private Button addUnvertraeglichkeit;
    private Button removeUnvertraeglichkeit;
    private Button activateGefahrgutField;
    private Button addGefahrgut;
    private Button removeGefahrgut;
    private HBox gefahrgutBox;
    private ListView<Color> unvertraeglichkeitenList;
    private ListView<String>gefahrgutList;

    //Warnings----
    private Label nameWarning;
    private Label hoeheWarning;
    private Label breiteWarning;
    private Label gewichtWarning;
    private Label tragKraftWarning;




    public PaketConfigView() {

        Label viewName = new Label("ERSTELLE EIN NEUES PAKET");


        //Warnings----
        nameWarning = new Label("");
        hoeheWarning = new Label("");
        breiteWarning = new Label("");
        gewichtWarning = new Label("");
        tragKraftWarning = new Label("");


        //Name---------------------------
        Label name = new Label("Name");
        nameField = new TextField();
        nameField.setPromptText("Bitte Name eingeben");
        HBox nameInputBox = new HBox(nameField);
        VBox nameBox = new VBox(name, nameInputBox, nameWarning);

        //Hoehe---------------------------
        Label hoehe = new Label("Hoehe");
        hoeheField = new TextField();
        hoeheField.setPromptText("Bitte Zahl eingeben");
        HBox hoeheInputBox = new HBox(hoeheField, new Label("cm"));
        VBox hoeheBox = new VBox(hoehe, hoeheInputBox, hoeheWarning);

        //Breite---------------------------
        Label breite = new Label("Breite");
        breiteField = new TextField();
        breiteField.setPromptText("Bitte Zahl eingeben");
        HBox breiteInputBox = new HBox(breiteField, new Label("cm"));
        VBox breiteBox = new VBox(breite, breiteInputBox, breiteWarning);

        //Gewicht---------------------------
        Label gewicht = new Label("Gewicht");
        gewichtField = new TextField();
        gewichtField.setPromptText("Bitte Zahl eingeben");
        HBox gewichtInputBox = new HBox(gewichtField, new Label("kg"));
        VBox gewichtBox = new VBox(gewicht, gewichtInputBox, gewichtWarning);

        //Tragkraft--------------------------
        Label tragKraft = new Label("Tragkraft");
        tragKraftField = new TextField();
        tragKraftField.setPromptText("Bitte Zahl eingeben");
        HBox tragKraftInputBox = new HBox(tragKraftField, new Label("kg"));
        VBox tragKraftBox = new VBox(tragKraft, tragKraftInputBox, tragKraftWarning);


        //Unvertraeglichkeiten---------------
        Label unvertraeglMit = new Label("Unvertr. mit:");
        addUnvertraeglichkeit = new Button(("Unvertraeglichkeit hinzufuegen"));
        removeUnvertraeglichkeit = new Button("Unvertraeg. loeschen");
        unvertraeglichkeiten = new ColorPicker();
        HBox unvertraeglichkeitenBox = new HBox(unvertraeglichkeiten, addUnvertraeglichkeit, removeUnvertraeglichkeit);
        HBox unvertraeglichkeitenBoxAll = new HBox(unvertraeglMit, unvertraeglichkeitenBox);


        Label aktUnvertraeglichkeiten = new Label("akuelle " + "\n" + "Unvertrgl.    :  ");
        //Rectangle unverT1, unverT2, unverT3, unverT4, unverT5;
        HBox showAktUnvertraeglichkeiten = new HBox(aktUnvertraeglichkeiten, unvertraeglichkeitenList = new ListView<Color>(), gefahrgutList = new ListView<String>());
        showAktUnvertraeglichkeiten.setSpacing(5);
        gefahrgutList.getStyleClass().add("list-cell");
        unvertraeglichkeitenList.getStyleClass().add("list-cell");
        unvertraeglichkeitenBox.setPadding(new Insets(60, 0, 0, 0));
        VBox ButtomRecht = new VBox(unvertraeglichkeitenBoxAll, showAktUnvertraeglichkeiten);
        ButtomRecht.setSpacing(20);


        //Farbe------------------------------
        Label paketFarbe = new Label("Paketfarbe");
        paketColor = new ColorPicker();
        HBox paketColorBox = new HBox(paketColor);
        HBox colorBox = new HBox(paketFarbe, paketColorBox);

        //optionales Gefahrgutfenster---------------
        Label gefahrGutLabel = new Label("Gefahrgut: ");
        activateGefahrgutField = new Button("Gefahrgutfeld einblenden");
        optionalGefahrgut = new TextField();
        optionalGefahrgut.setVisible(false);
        HBox activateGefahrgutButtonBox = new HBox(gefahrGutLabel, activateGefahrgutField, optionalGefahrgut);
        activateGefahrgutButtonBox.setSpacing(10);
        addGefahrgut = new Button("addGefahr");
        removeGefahrgut = new Button("remGefahr");
        HBox GefahrgutButtonBox = new HBox(addGefahrgut, removeGefahrgut);
        VBox GefahrgutBox = new VBox(activateGefahrgutButtonBox, GefahrgutButtonBox);
        VBox ButtomLinks = new VBox(colorBox, GefahrgutBox);


        //Buttom output
        HBox ButtomBox = new HBox(ButtomRecht, ButtomLinks);
        ButtomBox.setSpacing(50);


        //Buttons----------------------------
        addNewPaket = new Button();
        addNewPaket.setTooltip(new Tooltip("Neue Paket Hinzufuegen"));
        Region spacer = new Region();
        getBackToLagerView = new Button();
        getBackToLagerView.setTooltip(new Tooltip("Zurueck"));
        HBox buttonBox = new HBox(getBackToLagerView, spacer, addNewPaket);


        //OutuptAll
        VBox inputBox = new VBox(viewName, nameBox, hoeheBox, breiteBox, gewichtBox, tragKraftBox, ButtomBox, buttonBox);
        this.setCenter(inputBox);


        //-------------------------------------------------------------------
        //---------------------------STYLE-----------------------------------
        //-------------------------------------------------------------------

        inputBox.setPadding(new Insets(5, 20, 20, 20));


        //Name---------------------------
        viewName.getStyleClass().add("title");

        //Name---------------------------
        nameField.getStyleClass().add("textField");
        name.getStyleClass().add("titleLabel");
        nameInputBox.setSpacing(10);
        nameInputBox.setMaxWidth(1135);
        nameInputBox.setHgrow(nameField, Priority.ALWAYS);
        nameBox.setSpacing(10);
        nameWarning.getStyleClass().add("warning");

        //Hoehe---------------------------
        hoeheField.getStyleClass().add("textField");
        hoehe.getStyleClass().add("titleLabel");

        hoeheInputBox.setSpacing(10);
        hoeheInputBox.setHgrow(hoeheField, Priority.ALWAYS);
        hoeheBox.setSpacing(10);
        hoeheWarning.getStyleClass().add("warning");

        //Breite---------------------------
        breiteField.getStyleClass().add("textField");
        breite.getStyleClass().add("titleLabel");

        breiteInputBox.setSpacing(10);
        breiteInputBox.setHgrow(breiteField, Priority.ALWAYS);
        breiteBox.setSpacing(10);
        breiteWarning.getStyleClass().add("warning");

        //Gewicht---------------------------
        gewicht.getStyleClass().add("titleLabel");
        gewichtField.getStyleClass().add("textField");

        gewichtInputBox.setSpacing(10);
        gewichtInputBox.setHgrow(gewichtField, Priority.ALWAYS);
        gewichtBox.setSpacing(10);
        gewichtWarning.getStyleClass().add("warning");

        //Tragkraft---------------------------
        tragKraftField.getStyleClass().add("textField");
        tragKraft.getStyleClass().add("titleLabel");
        tragKraftInputBox.setSpacing(10);
        tragKraftInputBox.setHgrow(tragKraftField, Priority.ALWAYS);
        tragKraftBox.setSpacing(10);
        tragKraftWarning.getStyleClass().add("warning");

        //Farbe---------------------------
        paketFarbe.getStyleClass().add("titleLabel");
        colorBox.setSpacing(10);
        paketColor.getStyleClass().add("style-button-simple");
        paketColorBox.setPadding(new Insets(0, 0, 5, 10));

        //Unverträglichkeiten---------------
        addUnvertraeglichkeit.setId("style-button-simple");
        unvertraeglichkeitenBox.setPadding(new Insets(0, 0, 0, 20));
        unvertraeglMit.getStyleClass().add("titleLabel");
        aktUnvertraeglichkeiten.getStyleClass().add("titleLabel");
        unvertraeglichkeitenBox.setSpacing(10);
        unvertraeglichkeiten.getStyleClass().add("style-button-simple");
        removeUnvertraeglichkeit.setId("style-button-simple");

        //Buttons---------------------------
        addNewPaket.getStyleClass().addAll("add-icon", "icon-button");
        getBackToLagerView.getStyleClass().addAll("back-icon", "icon-button");
        buttonBox.setSpacing(10);
        buttonBox.setHgrow(spacer, Priority.ALWAYS);


        //optionales Gefahrgutfenster---------------
        gefahrGutLabel.getStyleClass().add("titleLabel");
        activateGefahrgutField.setId("style-button-simple");
        optionalGefahrgut.getStyleClass().add("textField");
        addGefahrgut.setId("style-button-simple");
        removeGefahrgut.setId("style-button-simple");
        GefahrgutButtonBox.setSpacing(10);
        GefahrgutButtonBox.setPadding(new Insets(0, 0, 5, 90));
        optionalGefahrgut.setPromptText("Gefahrgut hinzuf.");
        GefahrgutBox.setSpacing(20);
        ButtomLinks.setSpacing(20);


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

    public Button getRemoveUnvertraeglichkeit(){return removeUnvertraeglichkeit;}

    public ListView<Color> getUnvertraeglichkeitenList() {
        return unvertraeglichkeitenList;
    }

    public TextField getOptionalGefahrgut() {
        return optionalGefahrgut;
    }

    public Button getActivateGefahrgutField() {
        return activateGefahrgutField;
    }

    public Button getAddGefahrgut() {
        return addGefahrgut;
    }

    public ListView<String> getGefahrgutList() {
        return gefahrgutList;
    }

    public Button getRemoveGefahrgut() {
        return removeGefahrgut;
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

    //Getter for Warnings----

    public Label getNameWarning() {
        return nameWarning;
    }

    public Label getHoeheWarning() {
        return hoeheWarning;
    }

    public Label getBreiteWarning() {
        return breiteWarning;
    }

    public Label getGewichtWarning() {
        return gewichtWarning;
    }

    public Label getTragKraftWarning() {
        return tragKraftWarning;
    }

    public void activateGefahrgutInput(){
        this.addGefahrgut.setVisible(true);
        this.removeGefahrgut.setVisible(true);
        this.optionalGefahrgut.setVisible(true);
    }

    public void deactivateGefahrgutInput(){
        this.addGefahrgut.setVisible(false);
        this.removeGefahrgut.setVisible(false);
        this.optionalGefahrgut.setVisible(false);

    }
}
