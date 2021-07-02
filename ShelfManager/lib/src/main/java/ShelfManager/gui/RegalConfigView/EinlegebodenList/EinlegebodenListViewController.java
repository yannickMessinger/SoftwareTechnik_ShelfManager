package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Paket;
import ShelfManager.Lager.Regal;
import ShelfManager.gui.ViewController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class EinlegebodenListViewController extends ViewController {

    Regal regal;

    private ListView<Einlegeboden> einlegebodenList;
    private EinlegebodenListView einlegebodenListView;

    //private final ObjectProperty<ListCell<Einlegeboden>> dragSource;


    public EinlegebodenListViewController(Regal regal) {
        this.regal = regal;
        this.einlegebodenListView = new EinlegebodenListView(regal);
        this.einlegebodenList = einlegebodenListView.getEinlegebodenList();

        //this.dragSource = new SimpleObjectProperty<>();

        rootView = einlegebodenListView;
        initialize();
    }

    @Override
    public void initialize() {

        ObservableList<Einlegeboden> uiModel = einlegebodenList.getItems();
        ObservableList<Einlegeboden> einlegeboeden = regal.getEinlegeboeden();
        uiModel.addAll(einlegeboeden);


        // DRAG and DROP source-settings

        einlegebodenList.setCellFactory(new Callback<ListView<Einlegeboden>, ListCell<Einlegeboden>>() {
            @Override
            public ListCell<Einlegeboden> call(ListView<Einlegeboden> param) {
                EinlegebodenCell cell = new EinlegebodenCell();

                cell.setOnDragDetected(event -> {
                    if (! cell.isEmpty()) {
                        Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
                        ClipboardContent cc = new ClipboardContent();
                        cc.putString(String.valueOf(cell.getIndex()));
                        db.setContent(cc);
                    }
                });

                cell.setOnDragDone(event -> {
                    einlegeboeden.remove(cell.getItem());
                });

                return cell;
            }
        });


        einlegeboeden.addListener((ListChangeListener<Einlegeboden>) change -> {
            System.out.println(change + " -> Einlegeboden");
            uiModel.clear();
            uiModel.addAll(einlegeboeden);
            einlegebodenList.refresh();
        });



    }

    public Pane getRootView() {
        return rootView;
    }


}
