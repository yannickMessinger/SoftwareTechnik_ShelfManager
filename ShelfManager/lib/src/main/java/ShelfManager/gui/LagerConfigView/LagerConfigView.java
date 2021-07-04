package ShelfManager.gui.LagerConfigView;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
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
        VBox titelBox = new VBox(viewName);


        //height----------------
        Label hoeheLabel = new Label("Hoehe:");
        this.hoeheTextField = new TextField();
        HBox hoeheInputBox = new HBox(hoeheTextField, new Label("m"));
        VBox hoeheBox = new VBox(hoeheLabel, hoeheInputBox, hoeheWarning);


        //Breite-----------------
        Label breiteLabel = new Label("Breite:");
        this.breiteTextField = new TextField();
        HBox breiteInputBox = new HBox(breiteTextField, new Label("m"));
        VBox breiteBox = new VBox(breiteLabel, breiteInputBox, breiteWarning);

        //button-----------------
        this.submit = new Button("ok");
        VBox buttonBox = new VBox(submit);
        submit.getStyleClass().add("style-button");
        submit.getClass().getResourceAsStream("save-icon");

        //fuer Anzeige setzen-------------------------
        this.setTop(titelBox);
        VBox box = new VBox(hoeheBox, breiteBox, buttonBox);
        this.setCenter(box);


        //------------------------------------------------
        //---------------------STYLE----------------------
        titelBox.setAlignment(Pos.TOP_CENTER);
        viewName.setPadding(new Insets(20, 100, 20, 100));
        box.setPadding(new Insets(100));
        box.setSpacing(20);

        viewName.setId("title");

        //Hoehe
        hoeheLabel.getStyleClass().add("titleLabel");
        hoeheInputBox.setSpacing(10);
        hoeheInputBox.setMaxWidth(500);
        breiteInputBox.setHgrow(hoeheTextField, Priority.ALWAYS);
        hoeheTextField.getStyleClass().add("textField");
        hoeheTextField.setPromptText("Bitte Zahl eingeben");
        hoeheWarning.getStyleClass().add("warning");
        hoeheBox.setSpacing(10);
        hoeheBox.setAlignment(Pos.CENTER);

        //Breite
        breiteLabel.getStyleClass().add("titleLabel");
        breiteInputBox.setSpacing(10);
        breiteInputBox.setMaxWidth(500);
        breiteInputBox.setHgrow(breiteTextField, Priority.ALWAYS);
        breiteTextField.getStyleClass().add("textField");
        breiteTextField.setPromptText("Bitte Zahl eingeben");
        breiteWarning.getStyleClass().add("warning");
        breiteBox.setSpacing(5);
        breiteBox.setAlignment(Pos.CENTER);

        //Button
        buttonBox.setAlignment(Pos.CENTER_RIGHT);


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
