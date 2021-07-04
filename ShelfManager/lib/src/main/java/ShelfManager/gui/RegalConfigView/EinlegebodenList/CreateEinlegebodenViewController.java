package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Regal;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CreateEinlegebodenViewController extends ViewController {

    private Regal regal;

    private CreateEinlegebodenView createEinlegebodenView;
    private TextField hoeheInput;
    private TextField tragkraftInput;
    private Button addEinlegeboden;

    private Label hoeheWarning;
    private Label tragkraftWarning;

    public CreateEinlegebodenViewController(Regal regal){
        this.regal = regal;
        this.createEinlegebodenView = new CreateEinlegebodenView();
        this.hoeheInput = createEinlegebodenView.getHoeheInput();
        this.tragkraftInput = createEinlegebodenView.getTragkraftInput();
        this.addEinlegeboden = createEinlegebodenView.getAddEinlegeboden();

        this.hoeheWarning = createEinlegebodenView.getHoeheWarning();
        this.tragkraftWarning = createEinlegebodenView.getTragkraftWarning();

        rootView = createEinlegebodenView;
        initialize();
    }

    @Override
    public void initialize() {

        addEinlegeboden.addEventHandler(ActionEvent.ACTION, event -> {
            int hoehe = 0;
            int tragkraft = 0;

            if (hoeheInput.getText().equals("")){
                hoeheWarning.setText("Dieses Feld darf nicht leer sein");
            } else if(!hoeheInput.getText().matches("\\d+")) {
                hoeheWarning.setText("Keine Buchstaben erlaubt");
            } else if (Integer.parseInt(hoeheInput.getText()) < 1) {
                hoeheWarning.setText("Die Hoehe darf nicht <= 0 sein");
            } else if (Integer.parseInt(hoeheInput.getText()) > regal.getHoehe()) {
                hoeheWarning.setText("Der Einlegeboden kann nicht hoeher als das Regal sein");
            } else {
                hoehe = Integer.parseInt(hoeheInput.getText());
                hoeheWarning.setText("");
            }

            if (tragkraftInput.getText().equals("")){
                tragkraftWarning.setText("Dieses Feld darf nicht leer sein");
            } else if(!tragkraftInput.getText().matches("\\d+")) {
                tragkraftWarning.setText("Keine Buchstaben erlaubt");
            } else if (Integer.parseInt(tragkraftInput.getText()) < 1) {
                tragkraftWarning.setText("Die Hoehe darf nicht <= 0 sein");
            } else {
                tragkraft = Integer.parseInt(tragkraftInput.getText());
                tragkraftWarning.setText("");
            }


            if (hoehe != 0 && tragkraft != 0) {
                Einlegeboden einlegeboden = new Einlegeboden(regal, hoehe, tragkraft);
                regal.getEinlegeboeden().add(einlegeboden);
                hoeheInput.setText("");
                tragkraftInput.setText("");
            }

        });

    }

    public Pane getRootView() {
        return rootView;
    }


}
