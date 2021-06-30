package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.PaketListComponent.PaketListComponentController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.ArrayList;

public class LageruebersichtView extends BorderPane {

    private ComboBox filterBox;
    private Button backToLagerView;
    private Button speicheren;
    private ListView<Paket> paketlistView;
    private PaketListComponentController paketListComponentController;   //


    public LageruebersichtView(Lager hauptLager) {

        Label viewName = new Label("LageruebersichtView");
        Label filterName = new Label("Filter");

        paketListComponentController = new PaketListComponentController(hauptLager);
        paketlistView = new ListView<>();
        this.backToLagerView = new Button("zurueck");
        this.speicheren= new Button("speichern");
        this.filterBox = new ComboBox();


        VBox centerBox = new VBox();
        HBox  filter = new HBox();


        // TODO: Farben aus Logik verwenden
        this.filterBox.getItems().addAll(
            "Alle",
                new Rectangle(10, 10, Color.RED),
                new Rectangle(10, 10, Color.GREEN),
                new Rectangle(10, 10, Color.BLUE));


        filter.getChildren().addAll(filterName,filterBox);
        filter.setSpacing(10);

        centerBox.getChildren().addAll( filter,paketListComponentController.getRootView(),speicheren);
        centerBox.setSpacing(10);
        centerBox.setAlignment(Pos.TOP_CENTER);
        centerBox.setPadding(new Insets(6, 0, 0, 0));

        this.setTop(viewName);
        this.setCenter(centerBox);
        this.setBottom(backToLagerView);
        this.setPadding(new Insets(6));

    }

    public ComboBox getFilterBox() {
        return filterBox;
    }

    public Button getBackToLagerView() {
        return backToLagerView;
    }

    public Button getSpeicheren() {
        return speicheren;
    }

    public ListView<Paket> getPaketlistView() {
        return paketlistView;
    }
}
