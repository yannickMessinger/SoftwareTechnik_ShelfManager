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


    public CreateEinlegebodenView(){

        Label hoeheLabel = new Label("Hoehe:");
        hoeheLabel.getStyleClass().add("titleLabel");
        hoeheInput = new TextField();
        hoeheInput.getStyleClass().add("textField");


        Label tragkraftLabel = new Label("Tragkraft:");
        tragkraftLabel.getStyleClass().add("titleLabel");
        tragkraftInput = new TextField();
        tragkraftInput.getStyleClass().add("textField");


        addEinlegeboden = new Button("+");
        addEinlegeboden.getStyleClass().add("style-button");



        //---setzen-----------------------------
        this.getChildren().addAll(hoeheLabel, hoeheInput, tragkraftLabel, tragkraftInput, addEinlegeboden);
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
}
