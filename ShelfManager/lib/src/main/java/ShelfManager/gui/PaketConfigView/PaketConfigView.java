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

    //Warnings----
    private Label nameWarning;
    private Label hoeheWarning;
    private Label breiteWarning;
    private Label gewichtWarning;
    private Label tragKraftWarning;




    public PaketConfigView() {

        Label viewName = new Label("Erstelle ein neues Paket");


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
        Label tragKraft = new Label ("Tragkraft");
        tragKraftField = new TextField();
        tragKraftField.setPromptText("Bitte Zahl eingeben");
        HBox tragKraftInputBox = new HBox(tragKraftField, new Label("kg"));
        VBox tragKraftBox = new VBox(tragKraft, tragKraftInputBox, tragKraftWarning);

        //Farbe------------------------------
        Label paketFarbe = new Label("Paketfarbe");
        paketColor = new ColorPicker();
        HBox paketColorBox = new HBox( paketColor);
        paketColor.getStyleClass().add("style-button-simple");
        HBox colorBox = new HBox(paketFarbe, paketColorBox);
        paketColorBox.setPadding(new Insets(0, 0, 5, 24));

        //Unvertraeglcihkeiten---------------
        Label unvertraeglMit = new Label("Unvertr. mit:");
        unvertraeglichkeiten = new ColorPicker();
        addUnvertraeglichkeit = new Button(("Unvertraeglichkeit hinzufuegen"));
        HBox unvertraeglichkeitenBox = new HBox( unvertraeglichkeiten, addUnvertraeglichkeit);
        HBox unvertraeglichkeitenBoxAll = new HBox(unvertraeglMit,unvertraeglichkeitenBox);

        //Buttons----------------------------
        addNewPaket = new Button();
        Region spacer = new Region();

        getBackToLagerView = new Button();
        HBox buttonBox = new HBox(getBackToLagerView, spacer, addNewPaket);

        VBox inputBox = new VBox(viewName, nameBox, hoeheBox, breiteBox, gewichtBox, tragKraftBox, colorBox, unvertraeglichkeitenBoxAll, buttonBox);
        this.setCenter(inputBox);


        //-------------------------------------------------------------------
        //---------------------------STYLE-----------------------------------
        //-------------------------------------------------------------------
        inputBox.setPadding(new Insets(40));
        inputBox.setSpacing(10);

        //Name---------------------------
        viewName.setId("title");

        //Name---------------------------
        nameField.getStyleClass().add("textField");
        name.getStyleClass().add("titleLabel");
        //nameField.setMaxWidth(600);
        nameInputBox.setSpacing(10);
        nameInputBox.setHgrow(nameField, Priority.ALWAYS);
        nameBox.setSpacing(10);
        nameWarning.getStyleClass().add("warning");

        //Hoehe---------------------------
        hoeheField.getStyleClass().add("textField");
        hoehe.getStyleClass().add("titleLabel");
        //hoeheField.setMaxWidth(600);
        hoeheInputBox.setSpacing(10);
        hoeheInputBox.setHgrow(hoeheField, Priority.ALWAYS);
        hoeheBox.setSpacing(10);
        hoeheWarning.getStyleClass().add("warning");

        //Breite---------------------------
        breiteField.getStyleClass().add("textField");
        breite.getStyleClass().add("titleLabel");
        //breiteField.setMaxWidth(600);
        breiteInputBox.setSpacing(10);
        breiteInputBox.setHgrow(breiteField, Priority.ALWAYS);
        breiteBox.setSpacing(10);
        breiteWarning.getStyleClass().add("warning");

        //Gewicht---------------------------
        gewicht.getStyleClass().add("titleLabel");
        gewichtField.getStyleClass().add("textField");
        //gewichtField.setMaxWidth(600);
        gewichtInputBox.setSpacing(10);
        gewichtInputBox.setHgrow(gewichtField, Priority.ALWAYS);
        gewichtBox.setSpacing(10);
        gewichtWarning.getStyleClass().add("warning");

        //Tragkraft---------------------------
        tragKraftField.getStyleClass().add("textField");
        tragKraft.getStyleClass().add("titleLabel");
        //tragKraftField.setMaxWidth(600);
        tragKraftInputBox.setSpacing(10);
        tragKraftInputBox.setHgrow(tragKraftField, Priority.ALWAYS);
        tragKraftBox.setSpacing(10);
        tragKraftWarning.getStyleClass().add("warning");

        //Farbe---------------------------
        paketFarbe.getStyleClass().add("titleLabel");
        colorBox.setSpacing(10);
        paketColorBox.setPadding(new Insets(0, 0, 5, 24));

        //Unverträglichkeiten---------------
        addUnvertraeglichkeit.setId("style-button-simple");
        unvertraeglichkeitenBox.setPadding(new Insets(0, 0, 5, 20));
        unvertraeglMit.getStyleClass().add("titleLabel");
        unvertraeglichkeitenBox.setSpacing(10);
        unvertraeglichkeiten.getStyleClass().add("style-button-simple");

        //Buttons---------------------------
        addNewPaket.getStyleClass().addAll("add-icon", "icon-button");
        getBackToLagerView.getStyleClass().addAll("back-icon", "icon-button");
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
}
