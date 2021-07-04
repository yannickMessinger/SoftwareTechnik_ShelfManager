package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenCell;
import ShelfManager.gui.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;
import javafx.util.Callback;



public class PaketListComponentController extends ViewController {

    private PaketListComponent paketListComponent;
    private ListView<Paket> createdPaketsListView;
    //private ColorPicker filterColor;
    private Lager hauptLager;
    private Button showFilterPakets;
    private Button showAll;
    private ComboBox colorFilter;



    public PaketListComponentController(Lager hauptLager) {
        paketListComponent = new PaketListComponent();
        this.hauptLager = hauptLager;
        this.createdPaketsListView = paketListComponent.getCreatedPaketsListView();
        //this.filterColor = paketListComponent.getFilterColor();
        this.showFilterPakets = paketListComponent.getFilter();
        this.showAll = paketListComponent.getShowAll();
        this.colorFilter = paketListComponent.getColorFilter();

        rootView = this.paketListComponent;
        initialize();

    }



    @Override
    public void initialize() {

        ObservableList<Paket> uiModel = createdPaketsListView.getItems();
        ObservableList<Paket> pakete = hauptLager.getObservablePaketList();
        uiModel.addAll(pakete);

        ObservableList<Color> paketfarben = FXCollections.observableArrayList();
        colorFilter.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
            @Override
            public ListCell<Color> call(ListView<Color> param) {
                return new ColorCell();
            }
        });



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

                        Rectangle rectangle = new Rectangle(cell.getItem().getBreite(), cell.getItem().getHoehe(), cell.getItem().getFarbe());
                        SnapshotParameters snapshotParameters = new SnapshotParameters();
                        snapshotParameters.setTransform(Transform.scale(2,2));
//                        db.setDragView(rectangle.snapshot(snapshotParameters, null), event.getX(), event.getY());
                        db.setDragView(rectangle.snapshot(snapshotParameters, null), 0, 0);
                    }
                });

                cell.setOnDragDone(event -> {
                    if (event.getTransferMode() == TransferMode.MOVE) {
                        pakete.remove(cell.getItem());
                    }
                    event.consume();
                });


                return cell;
            }
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
            hauptLager.filterPaketsByColor(color);
            uiModel.clear();
            uiModel.addAll(hauptLager.getObervableFilteredList());
            createdPaketsListView.refresh();
            hauptLager.resetFilterList();
        });

//        showFilterPakets.addEventHandler(ActionEvent.ACTION, event -> {
//            System.out.println("Filter aktiviert");
//            Color color = paketListComponent.getFilterColor().getValue();
//            hauptLager.filterPaketsByColor(color);
//            uiModel.clear();
//            uiModel.addAll(hauptLager.getObervableFilteredList());
//            createdPaketsListView.refresh();
//            hauptLager.resetFilterList();
//        });


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


