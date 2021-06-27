package ShelfManager.gui.LagerConfigView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LagerConfigView extends BorderPane {

    private TextField hoeheTextField;
    private TextField breiteTextField;

    private Button submit;

    public LagerConfigView() {
        VBox box = new VBox();
        Label hoeheLabel = new Label("Hoehe:");
        this.hoeheTextField = new TextField();
        Label breiteLabel = new Label("Breite:");
        this.breiteTextField = new TextField();
        this.submit = new Button("Absenden");

        box.getChildren().addAll(hoeheLabel, hoeheTextField, breiteLabel, breiteTextField, submit);
        this.setCenter(box);
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
