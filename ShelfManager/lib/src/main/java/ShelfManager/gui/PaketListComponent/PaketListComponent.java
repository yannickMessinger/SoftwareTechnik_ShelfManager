package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

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
        //filterColor = new ColorPicker();

        //Filter mit Combobox
        colorFilter = new ComboBox();


        //FilterButton
        filter = new Button("Pakete filtern");
        showAll = new Button("Alle Pakete anzeigen");
        HBox FilterButton = new HBox(filter,showAll);
        FilterButton.setSpacing(8);


        //Loeschen
        removePacket = new Button("Paket loeschen");

        VBox box = new VBox(listenName,createdPaketsListView,filterLabel, FilterButton, colorFilter, removePacket);
        this.getChildren().addAll(box);


        //---------------------------STYLE-----------------------------------

        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.setPadding(new Insets(0,5,5,5));

        //Name
        listenName.setId("titleLabel");

        //Filter
        filterLabel.setId("titleLabel");


        //FilterButton
        filter.setId("style-button-simple");
        showAll.setId("style-button-simple");
        FilterButton.setPadding(new Insets(5,0,5,0));

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