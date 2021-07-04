package ShelfManager.gui.LagerView;
import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponent;
import ShelfManager.gui.LagerView.LagerComponent.LagerComponentController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;


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



        rootView = this.lagerView;
        initialize();


    }

    @Override
    public void initialize() {
        createShelfButton.addEventHandler(ActionEvent.ACTION, event -> main.switchScene(Scenes.REGAL_CONFIG_VIEW));
        createPacketbutton.addEventHandler(ActionEvent.ACTION, event -> main.switchScene(Scenes.PAKET_CONFIG_VIEW));
        lageruebersichtButton.addEventHandler(ActionEvent.ACTION, event -> main.switchScene(Scenes.LAGERUEBERISCHT_VIEW));

    }



    public Pane getRootView() {
        return rootView;
    }

}
