package ShelfManager.gui.LagerView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class LagerView extends BorderPane {

    Button createShelfButton;
    Button createPacketButton;
    Button lageruebersichtButton;

    public LagerView() {

        Label viewName = new Label("LagerView");
        this.setTop(viewName);

        HBox box = new HBox();

        createShelfButton = new Button("neues Regal");
        createPacketButton = new Button("neues Paket");
        lageruebersichtButton = new Button("Lageruebersicht");

        box.getChildren().addAll(createShelfButton, createPacketButton, lageruebersichtButton);
        this.setBottom(box);

    }

    public Button getCreateShelfButton() {
        return createShelfButton;
    }

    public Button getCreatePacketButton() {
        return createPacketButton;
    }

    public Button getLageruebersichtButton() {
        return lageruebersichtButton;
    }
}
