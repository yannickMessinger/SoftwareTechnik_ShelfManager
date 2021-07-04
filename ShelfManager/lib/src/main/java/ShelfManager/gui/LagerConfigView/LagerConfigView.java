package ShelfManager.gui.LagerConfigView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class LagerConfigView extends BorderPane {

    private TextField hoeheTextField;
    private TextField breiteTextField;

    private Label hoeheWarning;
    private Label breiteWarning;

    private Button submit;

    public LagerConfigView() {

        //Warnings----
        hoeheWarning = new Label("");
        breiteWarning = new Label("");


        Label viewName = new Label("Neues Lager");
        viewName.setId("title");
        VBox titelBox = new VBox(viewName);
        titelBox.setAlignment(Pos.TOP_CENTER);
        viewName.setPadding(new Insets(40, 0, 20, 0));
        this.setTop(titelBox);


        //height----------------
        Label hoeheLabel = new Label("Hoehe:");
        this.hoeheTextField = new TextField();
        VBox hoeheBox = new VBox(hoeheLabel, hoeheTextField,hoeheWarning);
        hoeheBox.setAlignment(Pos.CENTER);



        //Breite-----------------
        Label breiteLabel = new Label("Breite:");
        this.breiteTextField = new TextField();
        VBox breiteBox = new VBox(breiteLabel, breiteTextField,breiteWarning);
        breiteBox.setAlignment(Pos.CENTER);


        //button-----------------
        this.submit = new Button("ok");
        VBox buttonBox = new VBox(submit);
        submit.getStyleClass().add("style-button");
        submit.getClass().getResourceAsStream("save-icon");

        //fuer Anzeige setzen-------------------------
        VBox box = new VBox(hoeheBox, breiteBox, buttonBox);
        this.setCenter(box);

        //---STYLE-----------------------------------------
        box.setPadding(new Insets(100));
        box.setSpacing(20);

        //Hoehe
        hoeheLabel.getStyleClass().add("titleLabel");
        hoeheTextField.getStyleClass().add("textField");
        hoeheTextField.setPromptText("Bitte Zahl eingeben");
        hoeheTextField.setMaxWidth(500);
        hoeheWarning.getStyleClass().add("warning");

        //Breit
        breiteLabel.getStyleClass().add("titleLabel");
        breiteTextField.getStyleClass().add("textField");
        breiteTextField.setMaxWidth(500);
        breiteTextField.setPromptText("Bitte Zahl eingeben");
        breiteWarning.getStyleClass().add("warning");


        hoeheBox.setSpacing(10);
        breiteBox.setSpacing(5);
        buttonBox.setAlignment(Pos.CENTER_RIGHT);

        //height----------------

        viewName.setPadding(new Insets(20, 100, 20, 100));

        this.getStyleClass().addAll("background");
    }

    public TextField getHoeheTextField() {
        return hoeheTextField;
    }

    public TextField getBreiteTextField() {
        return breiteTextField;
    }

    public Button getSubmit() {
        return submit;
    }

    public Label getHoeheWarning() {
        return hoeheWarning;
    }

    public Label getBreiteWarning() {
        return breiteWarning;
    }
}
