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
        Tooltip tt = new Tooltip();


        createPacketButton = new Button();
        HBox centerBox = new HBox(createPacketButton,lagerComponentController.getRootView() );
        //Mous pop-up hover
        createPacketButton.setTooltip(new Tooltip("neues Paket anlegen"));
        centerBox.setSpacing(20);


        //RightBox
        VBox rightComponents = new VBox(paketListComponentController.getRootView(),packageDetailComponentController.getRootView());
        rightComponents.setPadding(new Insets(0,5,20,5));

        //ButtonBox
        createShelfButton = new Button();
        createShelfButton.setTooltip(new Tooltip("neues Regal anlegen"));
        lageruebersichtButton = new Button();
        HBox Buttonbox = new HBox(lageruebersichtButton, createShelfButton);
        lageruebersichtButton.setTooltip(new Tooltip("Lagerbestand-Liste speichern"));
        Buttonbox.setPadding(new Insets(10,400,20,400));
        Buttonbox.setSpacing(30);



        //---fuer Anzeige setzen-----
        this.setTop(viewName);
        this.setBottom(Buttonbox);
        this.setCenter(centerBox);
        this.setRight(rightComponents);
        this.setPadding(new Insets(0,5,5,5));

        //---STYLE----------------------------

        this.getStyleClass().addAll("background");
        viewName.setId("title");

        //---Button
        createShelfButton.getStyleClass().addAll("shelf-icon", "icon-button");
        lageruebersichtButton.getStyleClass().addAll("overview-icon", "icon-button");
        createPacketButton.getStyleClass().addAll("package-icon", "icon-button");

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

