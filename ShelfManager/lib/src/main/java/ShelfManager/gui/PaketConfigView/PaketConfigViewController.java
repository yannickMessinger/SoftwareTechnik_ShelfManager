package ShelfManager.gui.PaketConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.scene.layout.Pane;

public class PaketConfigViewController extends ViewController {

    private Lager hauptlager;
    private ShelfManagerApplication main;
    private PaketConfigView paketConfigView;

    public PaketConfigViewController(Lager hauptlager, ShelfManagerApplication main) {
        this.hauptlager = hauptlager;
        this.main = main;
        this.paketConfigView = new PaketConfigView();

        rootView = this.paketConfigView;
        initialize();
    }

    @Override
    public void initialize() {

    }

    public Pane getRootView() {
        return rootView;
    }

}
