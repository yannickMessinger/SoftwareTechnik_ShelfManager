package ShelfManager.gui.RegalConfigView.EinlegebodenList;

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
        hoeheInput = new TextField();
        Label tragkraftLabel = new Label("Tragkraft:");
        tragkraftInput = new TextField();

        addEinlegeboden = new Button("+");


        //---setzen-----------------------------
        this.getChildren().addAll(hoeheLabel, hoeheInput, tragkraftLabel, tragkraftInput, addEinlegeboden);

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
