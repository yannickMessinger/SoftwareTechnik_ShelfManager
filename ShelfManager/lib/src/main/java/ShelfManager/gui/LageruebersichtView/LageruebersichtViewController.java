package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.scene.layout.Pane;

public class LageruebersichtViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private LageruebersichtView lageruebersichtView;

    public LageruebersichtViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.lageruebersichtView = new LageruebersichtView();

        rootView = lageruebersichtView;
        initialize();
    }

    @Override
    public void initialize() {

    }

    public Pane getRootView() {
        return rootView;
    }

}
