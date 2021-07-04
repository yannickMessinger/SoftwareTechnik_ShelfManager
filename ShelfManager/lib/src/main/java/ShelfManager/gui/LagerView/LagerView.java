package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponentController;
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
    private LagerComponentController lagerComponentController;

    public LagerView(Lager hauptLager) {

        Label viewName = new Label("Ihr Lager");

        paketListComponentController = new PaketListComponentController(hauptLager);
        packageDetailComponentController = new PackageDetailComponentController(hauptLager);
        lagerComponentController = new LagerComponentController(hauptLager);

        createPacketButton = new Button();
        createPacketButton.getStyleClass().addAll("package-icon", "icon-button");
        HBox centerBox = new HBox(lagerComponentController.getRootView(), createPacketButton);

        VBox rightComponents = new VBox(paketListComponentController.getRootView(),packageDetailComponentController.getRootView());

        createShelfButton = new Button();
        createShelfButton.getStyleClass().addAll("shelf-icon", "icon-button");
        lageruebersichtButton = new Button();
        lageruebersichtButton.getStyleClass().addAll("overview-icon", "icon-button");
        HBox box = new HBox(lageruebersichtButton, createShelfButton);

        //---fuer Anzeige setzen-----
        this.setTop(viewName);
        this.setBottom(box);
        this.setCenter(centerBox);
        this.setRight(rightComponents);

        //---STYLE----------------------------

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
