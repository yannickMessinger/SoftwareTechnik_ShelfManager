package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CreateEinlegebodenView extends VBox {

    private TextField hoeheInput;
    private TextField tragkraftInput;
    private Button addEinlegeboden;

    private Label hoeheWarning;
    private Label tragkraftWarning;


    public CreateEinlegebodenView(){

        Label hoeheLabel = new Label("Hoehe:");
        hoeheLabel.getStyleClass().add("titleLabel");
        hoeheInput = new TextField();
        hoeheWarning = new Label("");
        hoeheWarning.getStyleClass().add("warning");
        hoeheInput.getStyleClass().add("textField");


        Label tragkraftLabel = new Label("Tragkraft:");
        tragkraftLabel.getStyleClass().add("titleLabel");
        tragkraftInput = new TextField();
        tragkraftWarning = new Label("");
        tragkraftWarning.getStyleClass().add("warning");
        tragkraftInput.getStyleClass().add("textField");


        addEinlegeboden = new Button("+");
        addEinlegeboden.getStyleClass().add("style-button");



        //---setzen-----------------------------
        this.getChildren().addAll(hoeheLabel, hoeheInput, hoeheWarning, tragkraftLabel, tragkraftInput, tragkraftWarning, addEinlegeboden);
        this.setSpacing(10);
        this.setPadding(new Insets(20));
        this.getStyleClass().addAll("background");
    }

    public TextField getHoeheInput() {
        return hoeheInput;
    }

    public TextField getTragkraftInput() {
        return tragkraftInput;
    }

    public Button getAddEinlegeboden() {
        return addEinlegeboden;
    }

    public Label getHoeheWarning() {
        return hoeheWarning;
    }

    public Label getTragkraftWarning() {
        return tragkraftWarning;
    }
}
