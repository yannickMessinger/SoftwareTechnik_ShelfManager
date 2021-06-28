package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.util.ArrayList;

public class LageruebersichtViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private LageruebersichtView lageruebersichtView;

    private ComboBox filterBox;
    private Button backToLagerView;
    private ListView<Paket> paketlistView;

    public LageruebersichtViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.lageruebersichtView = new LageruebersichtView(hauptLager);

        this.filterBox = lageruebersichtView.getFilterBox();
        this.backToLagerView = lageruebersichtView.getBackToLagerView();
        this.paketlistView = lageruebersichtView.getPaketlistView();

        rootView = lageruebersichtView;
        initialize();
    }

    @Override
    public void initialize() {
        backToLagerView.addEventHandler(ActionEvent.ACTION, event -> {
            main.switchScene(Scenes.LAGER_VIEW);
        });

        /*paketlistView.setCellFactory(new Callback<ListView<Paket>, ListCell<Paket>>() {
            @Override
            public ListCell<Paket> call(ListView<Paket> param) {
                return new PaketCell();
            }
        });

        ObservableList<Paket> uiModel = paketlistView.getItems();
        ObservableList<Paket> pakete = hauptLager.getAllPakets();
        uiModel.addAll(pakete);

        pakete.addListener((ListChangeListener<Paket>) change -> {
            System.out.println(change);
            uiModel.clear();
            uiModel.addAll(pakete);
            paketlistView.refresh();
        });*/


    }

    public Pane getRootView() {
        return rootView;
    }

}
