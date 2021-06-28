package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class PaketListComponent extends Pane {

    private Label listenName;
    private ListView<Paket> createdPaketsListView;


    public PaketListComponent() {

        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.listenName = new Label("PAKETE");
        createdPaketsListView = new ListView<>();



        this.getChildren().addAll(createdPaketsListView);
    }

    public ListView<Paket> getCreatedPaketsListView() {
        return createdPaketsListView;
    }
}