package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.Lager.Regal;
import ShelfManager.Lager.Stuetze;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponent;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponentController;
import ShelfManager.gui.RegalComponent.RegalComponent;
import ShelfManager.gui.RegalComponent.RegalComponentController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Callback;

import java.util.ArrayList;

public class LagerViewController extends ViewController {
    private ShelfManagerApplication main;
    private Lager hauptLager;
    private LagerView lagerView;

    private Button createShelfButton;
    private Button createPacketbutton;
    private Button lageruebersichtButton;
    private ListView<Paket> createdPaketsListView;

    private LagerComponentController lagerComponentController;
    private LagerComponent lagerComponent;

    public LagerViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.main = main;
        this.hauptLager = hauptLager;
        this.lagerView = new LagerView(hauptLager);
        this.createShelfButton = lagerView.getCreateShelfButton();
        this.createPacketbutton = lagerView.getCreatePacketButton();
        this.lageruebersichtButton = lagerView.getLageruebersichtButton();
        this.createdPaketsListView = lagerView.getCreatedPaketsListView();

        this.lagerComponentController = new LagerComponentController(hauptLager);
        this.lagerComponent = (LagerComponent) lagerComponentController.getRootView();
        lagerView.setCenter(lagerComponent);

        rootView = this.lagerView;
        initialize();


    }

    @Override
    public void initialize() {
        createShelfButton.addEventHandler(ActionEvent.ACTION, event -> {
            main.switchScene(Scenes.REGAL_CONFIG_VIEW);
        });
        createPacketbutton.addEventHandler(ActionEvent.ACTION, event -> {
            main.switchScene(Scenes.PAKET_CONFIG_VIEW);
        });
        lageruebersichtButton.addEventHandler(ActionEvent.ACTION, event -> {
            main.switchScene(Scenes.LAGERUEBERISCHT_VIEW);
        });

    }

//        createdPaketsListView.setCellFactory(new Callback<ListView<Paket>, ListCell<Paket>>() {
//            @Override
//            public ListCell<Paket> call(ListView<Paket> param) {
//                return new PaketCell();
//            }
//        });

//        ObservableList<Paket> uiModel = createdPaketsListView.getItems();
//        ObservableList<Paket> pakete = hauptLager.getObservablePaketList();
//        uiModel.addAll(pakete);
//
//        pakete.addListener((ListChangeListener<Paket>) change -> {
//            System.out.println(change);
//            uiModel.clear();
//            uiModel.addAll(pakete);
//            createdPaketsListView.refresh();
//        });

//        ObservableList<Regal> regale = hauptLager.getObservableRegalList();

//        ObservableList<Node> regaleInLager = lagerView.getCenterPane().getChildren();
//        regale.addListener(new ListChangeListener<Regal>() {
//            @Override
//            public void onChanged(Change<? extends Regal> c) {
//                for (Regal r : regale) {
//                    System.out.println("Changed");
//                    RegalComponentController regalComponentController = new RegalComponentController(r);
//                    RegalComponent regalComponent = (RegalComponent) regalComponentController.getRootView();
//                    regaleInLager.add(regalComponent);
//                }
//            }
//        });
//    }

    public Pane getRootView() {
        return rootView;
    }

}
