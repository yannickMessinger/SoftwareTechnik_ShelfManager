package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponentController;
import ShelfManager.gui.PaketListComponent.PaketListComponentController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class LagerView extends BorderPane {

    private Button createShelfButton;
    private Button createPacketButton;
    private Button lageruebersichtButton;
    private ListView<Paket> createdPaketsListView;
    private Pane centerPane;
    private PaketListComponentController paketListComponentController;
    private LagerComponentController lagerComponentController;

    public LagerView(Lager hauptLager) {

        Label viewName = new Label("Ihr Lager");
        paketListComponentController = new PaketListComponentController(hauptLager);
        lagerComponentController = new LagerComponentController(hauptLager);

        createPacketButton = new Button("neues Paket");
        HBox centerBox = new HBox(lagerComponentController.getRootView(), createPacketButton);

        //this.centerPane = new Pane();
        //createdPaketsListView = new ListView<>();

        createShelfButton = new Button("neues Regal");
        lageruebersichtButton = new Button("Lageruebersicht");
        HBox box = new HBox(lageruebersichtButton, createShelfButton);



        //---fuer Anzeige setzen-----
        this.setTop(viewName);
        this.setRight(paketListComponentController.getRootView());
        this.setCenter(centerBox);
        this.setBottom(box);

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
