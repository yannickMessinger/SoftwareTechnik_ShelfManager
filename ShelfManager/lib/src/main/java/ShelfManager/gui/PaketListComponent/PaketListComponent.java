package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class PaketListComponent extends Pane {

    private Label listenName;
    private ListView<Paket> createdPaketsListView;
    //private ColorPicker filterColor;
    private ComboBox colorFilter;
    private Button filter;
    private Button showAll;
    private Button removePacket;


    public PaketListComponent() {

        //Name
        this.listenName = new Label("PAKETE");

        //List
        createdPaketsListView = new ListView<>();

        //Filter
        Label filterLabel = new Label(("Filterfarbe auswaehlen:"));
        colorFilter = new ComboBox();
        filter = new Button("Pakete filtern");
        showAll = new Button("Alle Pakete anzeigen");
        Region spacer = new Region();
        HBox filterButtonBox = new HBox(filter, spacer,  showAll);
        VBox filterSection = new VBox(filterLabel, colorFilter, filterButtonBox);

        //Loeschen
        removePacket = new Button("Paket loeschen");

        VBox box = new VBox(listenName,createdPaketsListView,filterSection, removePacket);
        this.getChildren().addAll(box);


        //---------------------------STYLE-----------------------------------

        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        box.setPadding(new Insets(10));
        box.setSpacing(10);

        //Name
        listenName.setId("titleLabel");

        //List
        createdPaketsListView.setMaxHeight(100);

        //Filter
        filterLabel.setId("titleLabel");
        filterSection.setSpacing(10);

        //FilterButton
        filter.setId("style-button-simple");
        showAll.setId("style-button-simple");
        HBox.setHgrow(spacer, Priority.ALWAYS);

        //Loeschen
        removePacket.setId("style-button-simple");
        removePacket.setStyle("-fx-background-color: #F43131;");

    }

    public ListView<Paket> getCreatedPaketsListView() {
        return createdPaketsListView;
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

    public ComboBox getColorFilter() {
        return colorFilter;
    }
}