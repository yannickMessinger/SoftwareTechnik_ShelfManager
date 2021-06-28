package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Regal;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CreateEinlegebodenViewController extends ViewController {

    private Regal regal;

    private CreateEinlegebodenView createEinlegebodenView;
    private TextField hoeheInput;
    private TextField tragkraftInput;
    private Button addEinlegeboden;

    public CreateEinlegebodenViewController(Regal regal){
        this.regal = regal;
        this.createEinlegebodenView = new CreateEinlegebodenView();
        this.hoeheInput = createEinlegebodenView.getHoeheInput();
        this.tragkraftInput = createEinlegebodenView.getTragkraftInput();
        this.addEinlegeboden = createEinlegebodenView.getAddEinlegeboden();

        rootView = createEinlegebodenView;
        initialize();
    }

    @Override
    public void initialize() {

        addEinlegeboden.addEventHandler(ActionEvent.ACTION, event -> {
            Einlegeboden einlegeboden = new Einlegeboden(regal, Integer.parseInt(hoeheInput.getText()), Integer.parseInt(tragkraftInput.getText()));
            regal.getEinlegeboeden().add(einlegeboden);

        });

    }

    public Pane getRootView() {
        return rootView;
    }


}
