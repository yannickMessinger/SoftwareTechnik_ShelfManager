package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class LagerViewController extends ViewController {
    private ShelfManagerApplication main;
    private Lager hauptLager;
    private LagerView lagerView;

    private Button createShelfButton;
    private Button createPacketbutton;
    private Button lageruebersichtButton;

    public LagerViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.main = main;
        this.hauptLager = hauptLager;
        this.lagerView = new LagerView();
        this.createShelfButton = lagerView.getCreateShelfButton();
        this.createPacketbutton = lagerView.getCreatePacketButton();
        this.lageruebersichtButton = lagerView.getLageruebersichtButton();

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

    public Pane getRootView() {
        return rootView;
    }

}
