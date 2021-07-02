package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;



public class PaketListComponentController extends ViewController {

    private PaketListComponent paketListComponent;
    private ListView<Paket> createdPaketsListView;
    private Lager hauptLager;

    public PaketListComponentController(Lager hauptLager) {
        paketListComponent = new PaketListComponent();
        this.hauptLager = hauptLager;
        this.createdPaketsListView = paketListComponent.getCreatedPaketsListView();
        rootView = this.paketListComponent;
        initialize();

    }



    @Override
    public void initialize() {

        createdPaketsListView.setCellFactory(new Callback<ListView<Paket>, ListCell<Paket>>() {
            @Override
            public ListCell<Paket> call(ListView<Paket> param) {
                return new PaketCell();
            }
        });

        ObservableList<Paket> uiModel = createdPaketsListView.getItems();
        ObservableList<Paket> pakete = hauptLager.getObservablePaketList();
        uiModel.addAll(pakete);

        pakete.addListener((ListChangeListener<Paket>) change -> {
            System.out.println(change);
            uiModel.clear();
            uiModel.addAll(pakete);
            createdPaketsListView.refresh();
        });



        createdPaketsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent click) {
                Paket aktPaket;
                if (click.getClickCount() == 2) {

                    aktPaket = createdPaketsListView.getSelectionModel().getSelectedItem();
                    hauptLager.setAktPaket(aktPaket);
                    System.out.println("Paket gewählt" + createdPaketsListView.getSelectionModel().getSelectedItem());
                }
            }
        });

    }

    public Pane getRootView () {
        return rootView;
    }

}


