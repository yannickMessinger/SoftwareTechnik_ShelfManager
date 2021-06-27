package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Paket;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.util.ArrayList;

public class LageruebersichtView extends BorderPane {

    private ComboBox filterBox;
    private Button backToLagerView;
    private ListView<Paket> paketlistView;

    public LageruebersichtView() {

        Label viewName = new Label("LageruebersichtView");
        this.setTop(viewName);

        VBox centerBox = new VBox();

        this.filterBox = new ComboBox();
        // TODO: Farben aus Logik verwenden
        this.filterBox.getItems().addAll(
            "Alle",
                "Farbe 1",
                "Farbe 2",
                "Farbe 3"
        );

        paketlistView = new ListView<>();

        centerBox.getChildren().addAll(filterBox, paketlistView);

        this.setCenter(centerBox);

        this.backToLagerView = new Button("zurueck");
        this.setBottom(backToLagerView);

    }

    public ComboBox getFilterBox() {
        return filterBox;
    }

    public Button getBackToLagerView() {
        return backToLagerView;
    }

    public ListView<Paket> getPaketlistView() {
        return paketlistView;
    }
}
