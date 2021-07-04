package ShelfManager.gui.LageruebersichtView.PaketListComponent;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Callback;


public class PaketListComponentController extends ViewController {

    private PaketListComponent paketListComponent;
    private ListView<Paket> createdPaketsListView;
    private Lager hauptLager;
    private Button showFilterPakets;
    private Button showAll;
    private ComboBox colorFilter;



    public PaketListComponentController(Lager hauptLager) {
        paketListComponent = new PaketListComponent();
        this.hauptLager = hauptLager;
        this.createdPaketsListView = paketListComponent.getCreatedPaketsListView();
        this.showFilterPakets = paketListComponent.getFilter();
        this.showAll = paketListComponent.getShowAll();
        this.colorFilter = paketListComponent.getColorFilter();

        rootView = this.paketListComponent;
        initialize();

    }



    @Override
    public void initialize() {



        ObservableList<Paket> uiModel = createdPaketsListView.getItems();
        ObservableList<Paket> pakete = hauptLager.getAllPakets();
        uiModel.addAll(pakete);

        ObservableList<Color> paketfarben = FXCollections.observableArrayList();

        colorFilter.setCellFactory((Callback<ListView<Color>, ListCell<Color>>) param -> new ColorCell());

        createdPaketsListView.setCellFactory(param -> {
            PaketCell cell = new PaketCell();
            return cell;
        });

        pakete.addListener((ListChangeListener<Paket>) change -> {
            System.out.println(change);
            uiModel.clear();
            uiModel.addAll(pakete);
            createdPaketsListView.refresh();
            paketfarben.clear();
            for(Paket p: pakete) {
                paketfarben.add(p.getFarbe());
            }
            colorFilter.setItems(paketfarben);
            if (paketfarben.size() > 0) {
                colorFilter.getSelectionModel().selectFirst();
            }
        });

        showFilterPakets.addEventHandler(ActionEvent.ACTION, event -> {
            System.out.println("Filter aktiviert");
            Color color = (Color) colorFilter.getSelectionModel().getSelectedItem();
            hauptLager.filterAllPaketsByColor(color);
            uiModel.clear();
            uiModel.addAll(hauptLager.getObervableFilteredList());
            createdPaketsListView.refresh();
            hauptLager.resetFilterList();
        });



        showAll.addEventHandler(ActionEvent.ACTION, event -> {
            uiModel.clear();
            uiModel.addAll(pakete);
            createdPaketsListView.refresh();
        });

        createdPaketsListView.setOnMouseClicked(click -> {
            Paket aktPaket;
            if (click.getClickCount() == 2) {

                aktPaket = createdPaketsListView.getSelectionModel().getSelectedItem();
                hauptLager.setAktPaket(aktPaket);
                System.out.println("Paket gewählt" + createdPaketsListView.getSelectionModel().getSelectedItem());
            }
        });

    }



    public Pane getRootView () {
        return rootView;
    }

}


