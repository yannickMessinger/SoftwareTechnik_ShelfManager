package ShelfManager.gui.LagerConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LagerConfigViewController extends ViewController {

    private LagerConfigView lagerConfigView;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private Button submit;
    private Lager hauptLager;
    private ShelfManagerApplication main;
    private final int METERTOCENTIMETER = 100;

    private Label hoeheWarning;
    private Label breiteWarning;

    public LagerConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.main = main;
        this.hauptLager = hauptLager;
        this.lagerConfigView = new LagerConfigView();
        this.hoeheTextField = lagerConfigView.getHoeheTextField();
        this.breiteTextField = lagerConfigView.getBreiteTextField();
        this.submit = lagerConfigView.getSubmit();

        this.hoeheWarning = lagerConfigView.getHoeheWarning();
        this.breiteWarning = lagerConfigView.getBreiteWarning();

        rootView = this.lagerConfigView;
        initialize();
    }

    @Override
    public void initialize() {
        submit.addEventHandler(ActionEvent.ACTION, event -> {
            int hoehe = 0;
            int breite = 0;

            //ueberpruefe Feld und Hoehe
            if(hoeheTextField.getText().equals("")){
                hoeheWarning.setText("Feld darf nicht Leer sein");
            } else if (!hoeheTextField.getText().matches("\\d+")) {
                hoeheWarning.setText("keine Buchstaben erlaubt");
            } else if (Integer.parseInt(hoeheTextField.getText()) < 1 ) {
                hoeheWarning.setText("Die Hoehe darf nich <= 0 sein");
            } else {
                hoehe = Integer.parseInt(hoeheTextField.getText()) * METERTOCENTIMETER;
                hoeheWarning.setText("");
            }

            //ueberpruefe Feld und Breite
            if(breiteTextField.getText().equals("")) {
                breiteWarning.setText("Feld darf nicht Leer sein");
            } else if (!breiteTextField.getText().matches("\\d+")) {
                breiteWarning.setText("keine Buchstaben erlaubt");
            } else if (Integer.parseInt(breiteTextField.getText()) < 1) {
                breiteWarning.setText("Die Breite darf nicht <= 0 sein");
            } else {
                breite = Integer.parseInt(breiteTextField.getText()) * METERTOCENTIMETER;
                breiteWarning.setText("");
            }

            if (hoehe != 0 && breite !=0){
                hauptLager.setHoehe(hoehe);
                hauptLager.setBreite(breite);
                System.out.println("Lagerparameter gesetzt. Höhe: " + hoehe + " Breite: " + breite);
                hoeheTextField.setText("");
                breiteTextField.setText("");
                main.switchScene(Scenes.LAGER_VIEW);
            }


        });
    }

    public Button getSubmit() {
        return submit;
    }

    public Pane getRootView() {
        return rootView;
    }

}
