package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.LagerView.packageDetailComponent.PackageDetailComponentController;
import ShelfManager.gui.PaketListComponent.PaketListComponentController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LagerView extends BorderPane {

    private Button createShelfButton;
    private Button createPacketButton;
    private Button lageruebersichtButton;
    private ListView<Paket> createdPaketsListView;
    private Pane centerPane;
    private PaketListComponentController paketListComponentController;
    private PackageDetailComponentController packageDetailComponentController;

    public LagerView(Lager hauptLager) {

        Label viewName = new Label("LagerView");
        paketListComponentController = new PaketListComponentController(hauptLager);
        packageDetailComponentController = new PackageDetailComponentController(hauptLager);
        this.setTop(viewName);

        this.centerPane = new Pane();
        centerPane.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.setCenter(centerPane);

        createdPaketsListView = new ListView<>();

        VBox rightComponents = new VBox(paketListComponentController.getRootView(),packageDetailComponentController.getRootView());
        this.setRight(rightComponents);

        HBox box = new HBox();

        createShelfButton = new Button("neues Regal");
        createPacketButton = new Button("neues Paket");
        lageruebersichtButton = new Button("Lageruebersicht");

        box.getChildren().addAll(createShelfButton, createPacketButton, lageruebersichtButton);
        this.setBottom(box);

    }

    public Pane getCenterPane() {
        return centerPane;
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

    public ListView<Paket> getCreatedPaketsListView() {
        return createdPaketsListView;
    }
}
