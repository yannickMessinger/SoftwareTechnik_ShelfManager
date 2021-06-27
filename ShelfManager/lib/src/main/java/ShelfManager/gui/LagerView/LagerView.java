package ShelfManager.gui.LagerView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class LagerView extends BorderPane {

    Button createShelfButton;
    Button createPacketButton;

    public LagerView() {

        Label viewName = new Label("LagerView");
        this.setTop(viewName);

        HBox box = new HBox();

        createShelfButton = new Button("neues Regal");
        createPacketButton = new Button("neues Packet");

        box.getChildren().addAll(createShelfButton, createPacketButton);
        this.setBottom(box);

    }

    public Button getCreateShelfButton() {
        return createShelfButton;
    }

    public Button getCreatePacketButton() {
        return createPacketButton;
    }
}
