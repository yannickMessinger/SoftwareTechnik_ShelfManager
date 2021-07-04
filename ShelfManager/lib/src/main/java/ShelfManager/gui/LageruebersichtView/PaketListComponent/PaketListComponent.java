package ShelfManager.gui.LageruebersichtView.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;

public class PaketListComponent extends Pane {

    private Label listenName;
    private ListView<Paket> createdPaketsListView;
    //private ColorPicker filterColor;
    private ComboBox colorFilter;
    private Button filter;
    private Button showAll;


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




        VBox box = new VBox(listenName,createdPaketsListView,filterSection);
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


    public ComboBox getColorFilter() {
        return colorFilter;
    }
}