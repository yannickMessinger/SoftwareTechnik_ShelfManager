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
    private TextField stuetzenbreiteTextField;
    private Button submit;
    private Button backToLagerView;
    private Button saveRegal;


    //Warnings----
    private Label hoeheWarning;
    private Label breiteWarning;
    private Label sBreiteWarning;
    private Label einlegeboedenWarning;


    public RegalConfigView() {

        Label viewName = new Label("EIN NEUES REGAL ERSTELLEN");
        viewName.setId("title");

        //Warnings----
        this.hoeheWarning = new Label("");
        this.breiteWarning = new Label("");
        this.sBreiteWarning = new Label("");
        this.einlegeboedenWarning = new Label("");

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

        //Stuetzenbreite------------
        Label stuetzenbreiteLabel = new Label("Stuetzenbreite:");
        this.stuetzenbreiteTextField = new TextField();
        HBox sBreiteInputBox = new HBox(stuetzenbreiteTextField, new Label("cm"));
        VBox sBreiteBox = new VBox(stuetzenbreiteLabel, sBreiteInputBox, sBreiteWarning);

        //Einlegeboeden Button---------------------
        this.submit = new Button("Einlegeboeden hinzufuegen");
        VBox submitBox = new VBox(submit, einlegeboedenWarning);

        //Input------------------------------------
        inputBox = new VBox(hoeheBox, breiteBox, sBreiteBox);

        //Buttons
        this.backToLagerView = new Button();
        this.saveRegal = new Button();
        HBox bottombox = new HBox(backToLagerView, saveRegal, submitBox);

        //setzen fuer Anzeige--------
        this.setTop(viewName);
        this.setCenter(inputBox);
        this.setBottom(bottombox);


        //-------------------------------------------------------------------
        //---------------------------STYLE-----------------------------------
        //-------------------------------------------------------------------
        this.setPadding(new Insets(60, 0, 60 ,60));
        inputBox.setSpacing(20);
        inputBox.setPadding(new Insets(0, 60, 0, 0));

        //Hoehe---------------------------
        hoeheTextField.getStyleClass().add("textField");
        hoeheLabel.getStyleClass().add("titleLabel");
        //hoeheTextField.setMaxWidth(600);
        hoeheInputBox.setSpacing(10);
        hoeheInputBox.setHgrow(hoeheTextField, Priority.ALWAYS);
        hoeheBox.setSpacing(10);
        hoeheWarning.getStyleClass().add("warning");

        //Breite---------------------------
        breiteTextField.getStyleClass().add("textField");
        breiteLabel.getStyleClass().add("titleLabel");
        //breiteField.setMaxWidth(600);
        breiteInputBox.setSpacing(10);
        breiteInputBox.setHgrow(breiteTextField, Priority.ALWAYS);
        breiteBox.setSpacing(10);
        breiteWarning.getStyleClass().add("warning");

        //SBreite---------------------------
        stuetzenbreiteTextField.getStyleClass().add("textField");
        stuetzenbreiteLabel.getStyleClass().add("titleLabel");
        sBreiteInputBox.setSpacing(10);
        sBreiteInputBox.setHgrow(stuetzenbreiteTextField, Priority.ALWAYS);
        sBreiteBox.setSpacing(10);
        sBreiteWarning.getStyleClass().add("warning");

        //Buttons---------------------------
        backToLagerView.getStyleClass().addAll("back-icon", "icon-button");
        saveRegal.getStyleClass().addAll("save-icon", "icon-button");
        saveRegal.setVisible(false);
        submit.setVisible(true);
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

    public Label getsBreiteWarning() {
        return sBreiteWarning;
    }

    public Label getEinlegeboedenWarning() {
        return einlegeboedenWarning;
    }

}
