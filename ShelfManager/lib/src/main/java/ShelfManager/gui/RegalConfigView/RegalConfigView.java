package ShelfManager.gui.RegalConfigView;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class RegalConfigView extends BorderPane {

    private VBox inputBox;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private TextField stuetzenhoeheTextField;
    private TextField stuetzenbreiteTextField;
    private Button submit;
    private Button backToLagerView;
    private Button saveRegal;


    //Warnings----
    private Label hoeheWarning;
    private Label breiteWarning;
    private Label sHoeheWarning;
    private Label sBreiteWarning;



    public RegalConfigView() {

        Label viewName = new Label("Ein neues Regal erstellen");

        //Warnings----
        this.hoeheWarning = new Label("");
        this.breiteWarning = new Label("");
        this.sHoeheWarning = new Label("");
        this.sBreiteWarning = new Label("");

        //Hoehe------------
        Label hoeheLabel = new Label("Regalhoehe:");
        this.hoeheTextField = new TextField();
        HBox hoeheInputBox = new HBox(hoeheTextField, new Label("cm"));
        VBox hoeheBox = new VBox(hoeheLabel, hoeheInputBox, hoeheWarning);

        //Breite-----------
        Label breiteLabel = new Label("Regalbreite:");
        this.breiteTextField = new TextField();
        HBox breiteInputBox = new HBox(breiteTextField, new Label("cm"));
        VBox breiteBox = new VBox(breiteLabel, breiteInputBox, breiteWarning);

        //Stuetzenhoehe-------------
        Label stuetzenhoeheLabel = new Label("Stuetzenhoehe:");
        this.stuetzenhoeheTextField = new TextField();
        HBox sHoeheInputBox = new HBox(stuetzenhoeheTextField, new Label("cm"));
        VBox sHoeheBox = new VBox(stuetzenhoeheLabel, sHoeheInputBox, sHoeheWarning);

        //Stuetzenbreite------------
        Label stuetzenbreiteLabel = new Label("Stuetzenbreite:");
        this.stuetzenbreiteTextField = new TextField();
        HBox sBreiteInputBox = new HBox(stuetzenbreiteTextField, new Label("cm"));
        VBox sBreiteBox = new VBox(stuetzenbreiteLabel, sBreiteInputBox, sBreiteWarning);

        //Einlegeboeden Button---------------------
        this.submit = new Button("Einlegeboeden hinzufuegen");

        //Input------------------------------------
        inputBox = new VBox(hoeheBox, breiteBox, sHoeheBox, sBreiteBox);

        //Buttons
        this.backToLagerView = new Button("zurueck");
        this.saveRegal = new Button("speichern");
        HBox bottombox = new HBox(backToLagerView, saveRegal);

        //setzen fuer Anzeige--------
        this.setTop(viewName);
        this.setCenter(inputBox);
        this.setBottom(bottombox);


        //-------------------------------------------------------------------
        //---------------------------STYLE-----------------------------------
        //-------------------------------------------------------------------
        inputBox.setPadding(new Insets(60));
        inputBox.setSpacing(20);

        //Hoehe---------------------------
        hoeheTextField.getStyleClass().add("textField");
        hoeheLabel.getStyleClass().add("titleLabel");
        //hoeheTextField.setMaxWidth(600);
        hoeheInputBox.setSpacing(10);
        hoeheInputBox.setHgrow(hoeheTextField, Priority.ALWAYS);
        hoeheBox.setSpacing(10);
        hoeheWarning.getStyleClass().add("warning");

    }


    public VBox getInputBox() {
        return inputBox;
    }

    public TextField getHoeheTextField() {
        return hoeheTextField;
    }

    public TextField getBreiteTextField() {
        return breiteTextField;
    }

    public TextField getStuetzenhoeheTextField() {
        return stuetzenhoeheTextField;
    }

    public TextField getStuetzenbreiteTextField() {
        return stuetzenbreiteTextField;
    }

    public Button getSubmit() {
        return submit;
    }

    public Button getBackToLagerView() {
        return backToLagerView;
    }

    public Button getSaveRegal() {
        return saveRegal;
    }

    //Warnings Getter----

    public Label getHoeheWarning() {
        return hoeheWarning;
    }

    public Label getBreiteWarning() {
        return breiteWarning;
    }

    public Label getsHoeheWarning() {
        return sHoeheWarning;
    }

    public Label getsBreiteWarning() {
        return sBreiteWarning;
    }
}
