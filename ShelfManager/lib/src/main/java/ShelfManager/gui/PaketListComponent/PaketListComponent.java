package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PaketListComponent extends Pane {

    private Label listenName;
    private ListView<Paket> createdPaketsListView;
    private ColorPicker filterColor;
    private Button filter;
    private Button showAll;
    private Button removePacket;


    public PaketListComponent() {


        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.listenName = new Label("PAKETE");
        createdPaketsListView = new ListView<>();
        filterColor = new ColorPicker();
        Label filterLabel = new Label(("Filterfarbe auswaehlen:"));
        filter = new Button("Pakete filtern");
        showAll = new Button("Alle Pakete anzeigen");
        removePacket = new Button("Paket loeschen");
        VBox box = new VBox(createdPaketsListView,filterLabel,filterColor, filter, showAll, removePacket);


        this.getChildren().addAll(box);
    }

    public ListView<Paket> getCreatedPaketsListView() {
        return createdPaketsListView;
    }

    public ColorPicker getFilterColor() {
        return filterColor;
    }

    public Button getFilter() {
        return filter;
    }

    public Button getShowAll() {
        return showAll;
    }

    public Button getRemovePacket(){
        return removePacket;
    }
}