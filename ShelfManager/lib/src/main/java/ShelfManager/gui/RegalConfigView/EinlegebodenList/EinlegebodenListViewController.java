package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Paket;
import ShelfManager.Lager.Regal;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class EinlegebodenListViewController extends ViewController {

    Regal regal;

    private ListView<Einlegeboden> einlegebodenList;
    private EinlegebodenListView einlegebodenListView;


    public EinlegebodenListViewController(Regal regal) {
        this.regal = regal;
        this.einlegebodenListView = new EinlegebodenListView(regal);
        this.einlegebodenList = einlegebodenListView.getEinlegebodenList();

        rootView = einlegebodenListView;
        initialize();
    }

    @Override
    public void initialize() {

        einlegebodenList.setCellFactory(new Callback<ListView<Einlegeboden>, ListCell<Einlegeboden>>() {
            @Override
            public ListCell<Einlegeboden> call(ListView<Einlegeboden> param) {
                return new EinlegebodenCell();
            }
        });

        ObservableList<Einlegeboden> uiModel = einlegebodenList.getItems();
        ObservableList<Einlegeboden> einlegeboeden = regal.getEinlegeboeden();
        uiModel.addAll(einlegeboeden);


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
