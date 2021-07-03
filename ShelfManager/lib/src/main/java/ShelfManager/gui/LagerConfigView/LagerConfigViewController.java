package ShelfManager.gui.LagerConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
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

    public LagerConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.main = main;
        this.hauptLager = hauptLager;
        this.lagerConfigView = new LagerConfigView();
        this.hoeheTextField = lagerConfigView.getHoeheTextField();
        this.breiteTextField = lagerConfigView.getBreiteTextField();
        this.submit = lagerConfigView.getSubmit();



        rootView = this.lagerConfigView;
        initialize();
    }

    @Override
    public void initialize() {
        submit.addEventHandler(ActionEvent.ACTION, event -> {

            try {
                int hoehe = Integer.parseInt(hoeheTextField.getText()) * METERTOCENTIMETER;
                int breite = Integer.parseInt(breiteTextField.getText()) * METERTOCENTIMETER;
                hauptLager.setHoehe(hoehe);
                hauptLager.setBreite(breite);
                System.out.println("Lagerparameter gesetzt. Höhe: " + hoehe + " Breite: " + breite);
                hoeheTextField.setText("");
                breiteTextField.setText("");

                main.switchScene(Scenes.LAGER_VIEW);


            }catch(NumberFormatException n){
                System.out.println("keine Buchstaben erlaubt!");
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
