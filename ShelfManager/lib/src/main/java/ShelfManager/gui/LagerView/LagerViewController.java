package ShelfManager.gui.LagerView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.scene.layout.Pane;

public class LagerViewController extends ViewController {
        private ShelfManagerApplication main;
        private Lager hauptLager;
        private LagerView lagerView;


    public LagerViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.main = main;
        this.hauptLager = hauptLager;
        this.lagerView = new LagerView();

        rootView = this.lagerView;
        initialize();


    }

    @Override
    public void initialize() {

    }

    public Pane getRootView() {
        return rootView;
    }

}
