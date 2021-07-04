package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponentController;
import ShelfManager.gui.LagerView.packageDetailComponent.PackageDetailComponentController;
import ShelfManager.gui.PaketListComponent.PaketListComponentController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;

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

        Label viewName = new Label("IHR LAGER");

        paketListComponentController = new PaketListComponentController(hauptLager);
        packageDetailComponentController = new PackageDetailComponentController(hauptLager);
        lagerComponentController = new LagerComponentController(hauptLager);
        Tooltip tt = new Tooltip();

        createPacketButton = new Button();
        VBox packetButtonBox = new VBox(createPacketButton);
        HBox centerBox = new HBox(lagerComponentController.getRootView(), packetButtonBox);
        //Mouse pop-up hover
        createPacketButton.setTooltip(new Tooltip("neues Paket anlegen"));

        //RightBox
        VBox rightComponents = new VBox(paketListComponentController.getRootView(),packageDetailComponentController.getRootView());

        //ButtonBox
        createShelfButton = new Button();
        createShelfButton.setTooltip(new Tooltip("neues Regal anlegen"));
        lageruebersichtButton = new Button();
        HBox buttonBox = new HBox(lageruebersichtButton, createShelfButton);
        lageruebersichtButton.setTooltip(new Tooltip("Lagerbestand-Liste speichern"));


        //---fuer Anzeige setzen-----
        this.setTop(viewName);
        this.setBottom(buttonBox);
        this.setCenter(centerBox);
        this.setRight(rightComponents);

        //---STYLE----------------------------
        this.getStyleClass().addAll("background");
        this.setPadding(new Insets(60, 0, 60 ,60));
        viewName.setId("title");

        centerBox.setSpacing(20);
        centerBox.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(centerBox, Priority.ALWAYS);
        packetButtonBox.setAlignment(Pos.CENTER);
        packetButtonBox.setPadding(new Insets(20, 50, 20, 20));

        rightComponents.setSpacing(10);

        //---Button
        createShelfButton.getStyleClass().addAll("shelf-icon", "icon-button");
        lageruebersichtButton.getStyleClass().addAll("overview-icon", "icon-button");
        createPacketButton.getStyleClass().addAll("package-icon", "icon-button");
        buttonBox.setAlignment(Pos.CENTER);


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

