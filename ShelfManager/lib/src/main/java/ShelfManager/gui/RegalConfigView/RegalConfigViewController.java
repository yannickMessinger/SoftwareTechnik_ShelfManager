package ShelfManager.gui.RegalConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.scene.layout.Pane;

public class RegalConfigViewController extends ViewController {

    private Lager hauptlager;
    private ShelfManagerApplication main;
    private RegalConfigView regalConfigView;

    public RegalConfigViewController(Lager hauptlager, ShelfManagerApplication main) {
        this.hauptlager = hauptlager;
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
