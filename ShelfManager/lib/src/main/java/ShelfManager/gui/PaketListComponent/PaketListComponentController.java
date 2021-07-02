package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenCell;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Callback;



public class PaketListComponentController extends ViewController {

    private PaketListComponent paketListComponent;
    private ListView<Paket> createdPaketsListView;
    private ColorPicker filterColor;
    private Lager hauptLager;
    private Button showFilterPakets;
    private Button showAll;


    public PaketListComponentController(Lager hauptLager) {
        paketListComponent = new PaketListComponent();
        this.hauptLager = hauptLager;
        this.createdPaketsListView = paketListComponent.getCreatedPaketsListView();
        this.filterColor = paketListComponent.getFilterColor();
        this.showFilterPakets = paketListComponent.getFilter();
        this.showAll = paketListComponent.getShowAll();

        rootView = this.paketListComponent;
        initialize();

    }



    @Override
    public void initialize() {

        ObservableList<Paket> uiModel = createdPaketsListView.getItems();
        ObservableList<Paket> pakete = hauptLager.getObservablePaketList();
        uiModel.addAll(pakete);

        createdPaketsListView.setCellFactory(new Callback<ListView<Paket>, ListCell<Paket>>() {
            @Override
            public ListCell<Paket> call(ListView<Paket> param) {
                PaketCell cell = new PaketCell();

                cell.setOnDragDetected(event -> {
                    if (! cell.isEmpty()) {
                        Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
                        ClipboardContent cc = new ClipboardContent();
                        cc.putString(String.valueOf(cell.getIndex()));
                        db.setContent(cc);
                    }
                });

                cell.setOnDragDone(event -> {
                    pakete.remove(cell.getItem());
                });


                return cell;
            }
        });



        pakete.addListener((ListChangeListener<Paket>) change -> {
            System.out.println(change);
            uiModel.clear();
            uiModel.addAll(pakete);
            createdPaketsListView.refresh();
        });


        showFilterPakets.addEventHandler(ActionEvent.ACTION, event -> {
            System.out.println("Filter aktiviert");
            Color color = paketListComponent.getFilterColor().getValue();
            hauptLager.filterPaketsByColor(color);
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


