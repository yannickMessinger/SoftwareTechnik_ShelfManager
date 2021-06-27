package ShelfManager.gui.RegalConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.scene.layout.Pane;

public class RegalConfigViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private RegalConfigView regalConfigView;

    public RegalConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.regalConfigView = new RegalConfigView();


        rootView = this.regalConfigView;
        initialize();

    }

    @Override
    public void initialize() {

    }

    public Pane getRootView() {
        return rootView;
    }

}
