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

    private Button submit;

    public LagerConfigView() {

        Label viewName = new Label("Neues Lager");
        viewName.setId("title");
        VBox titelBox = new VBox(viewName);
        titelBox.setAlignment(Pos.TOP_CENTER);
        viewName.setPadding(new Insets(40, 0, 20, 0));
        this.setTop(titelBox);


        //height----------------
        Label hoeheLabel = new Label("Hoehe:");
        hoeheLabel.getStyleClass().add("titleLabel");
        this.hoeheTextField = new TextField();
        hoeheTextField.getStyleClass().add("textField");
        hoeheTextField.setMaxWidth(400);
        hoeheTextField.setPromptText("Bitte Zahl eingeben");

        VBox hoeheBox = new VBox(hoeheLabel, hoeheTextField);
        hoeheBox.setAlignment(Pos.CENTER);

        //width-----------------
        Label breiteLabel = new Label("Breite:");
        breiteLabel.getStyleClass().add("titleLabel");
        this.breiteTextField = new TextField();
        breiteTextField.getStyleClass().add("textField");
        breiteTextField.setMaxWidth(400);
        breiteTextField.setPromptText("Bitte Zahl eingeben");
        VBox breiteBox = new VBox(breiteLabel, breiteTextField);
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
}
