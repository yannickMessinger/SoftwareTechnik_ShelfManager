package ShelfManager.gui.RegalConfigView;

import ShelfManager.Lager.*;
import ShelfManager.Lager.Exceptions.LagerVollException;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenListView;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenListViewController;
import ShelfManager.gui.RegalComponent.RegalComponent;
import ShelfManager.gui.RegalComponent.RegalComponentController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Comparator;

public class RegalConfigViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private RegalConfigView regalConfigView;
    private Regal regal;
    private final int METERTOCENTIMETER = 100;

    private VBox inputBox;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private TextField stuetzenhoeheTextField;
    private TextField stuetzenbreiteTextField;
    private Button submit;
    private Button backToLagerView;
    private Button saveRegal;

    //Warnings----
    private Label hoeheWarning;
    private Label breiteWarning;
    private Label sHoeheWarning;
    private Label sBreiteWarning;
    private Label einlegeboedenWarning;


    public RegalConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.regalConfigView = new RegalConfigView();

        //Warnings----
        hoeheWarning = regalConfigView.getHoeheWarning();
        breiteWarning = regalConfigView.getBreiteWarning();
        sHoeheWarning = regalConfigView.getsHoeheWarning();
        sBreiteWarning = regalConfigView.getsBreiteWarning();
        einlegeboedenWarning = regalConfigView.getEinlegeboedenWarning();

        this.inputBox = regalConfigView.getInputBox();
        this.hoeheTextField = regalConfigView.getHoeheTextField();
        this.breiteTextField = regalConfigView.getBreiteTextField();
        this.stuetzenhoeheTextField = regalConfigView.getStuetzenhoeheTextField();
        this.stuetzenbreiteTextField = regalConfigView.getStuetzenbreiteTextField();
        this.submit = regalConfigView.getSubmit();
        this.backToLagerView = regalConfigView.getBackToLagerView();
        this.saveRegal = regalConfigView.getSaveRegal();

        rootView = this.regalConfigView;
        initialize();

    }

    @Override
    public void initialize() {
        backToLagerView.addEventHandler(ActionEvent.ACTION, event -> {
            regalConfigView.setCenter(inputBox);
            main.switchScene(Scenes.LAGER_VIEW);
        });

        submit.addEventHandler(ActionEvent.ACTION, event -> {
            int hoehe = 0;
            int breite = 0;
            int stuetzenhoehe = 0;
            int stuetzenbreite = 0;

                //Hohe---------------------------
                if (hoeheTextField.getText().equals("") || Integer.parseInt(hoeheTextField.getText()) < 1) {
                    hoeheWarning.setText("Die Regalhoehe darf nicht 0 sein");
                } else if (Integer.parseInt(hoeheTextField.getText()) > hauptLager.getHoehe()){
                    hoeheWarning.setText("Das Regal ist zu hoch für das Lager");
                } else {
                    //hoehe = Integer.parseInt(hoeheTextField.getText()) * METERTOCENTIMETER ;
                    hoehe = Integer.parseInt(hoeheTextField.getText());
                    hoeheWarning.setText("");
                }

                //Breite--------------------------
                if (breiteTextField.getText().equals("") || Integer.parseInt(breiteTextField.getText()) < 1) {
                    breiteWarning.setText("Die Regalbreite darf nicht 0 sein");
                } else if (Integer.parseInt(breiteTextField.getText()) > hauptLager.getBreite()){
                    //Hier vllt schon auf übrigen Platz im Lager testen?????
                   breiteWarning.setText("Das Regal ist zu breit für das Lager");
                } else {
                    //breite = Integer.parseInt(breiteTextField.getText()) * METERTOCENTIMETER;
                    breite = Integer.parseInt(breiteTextField.getText());
                    breiteWarning.setText("");
                }

                //SHohe---------------------------
                if (stuetzenhoeheTextField.getText().equals("") || Integer.parseInt(stuetzenhoeheTextField.getText()) < Integer.parseInt(hoeheTextField.getText())) {
                    sHoeheWarning.setText("Die Stuetze muss mindestens so hoch sein, wie das Regal");
                } else if (Integer.parseInt(stuetzenbreiteTextField.getText()) > hauptLager.getHoehe()){
                    sHoeheWarning.setText("Die Stütze ist zu hoch für das Lager");
                } else {
                    //stuetzenhoehe = Integer.parseInt(breiteTextField.getText()) * METERTOCENTIMETER;
                    stuetzenhoehe = Integer.parseInt(stuetzenhoeheTextField.getText());
                    sHoeheWarning.setText("");
                }

                //SBreite-------------------------
                if (stuetzenbreiteTextField.getText().equals("") || Integer.parseInt(stuetzenbreiteTextField.getText()) < 1) {
                    sBreiteWarning.setText("Die Stuetzenbreite darf nicht 0 sein");
                } else if (Integer.parseInt(stuetzenbreiteTextField.getText()) > Integer.parseInt(breiteTextField.getText())){
                    sBreiteWarning.setText("Die Stütze ist Breiter als das Regal, das ist Unsinn");
                } else {
                    //stuetzenbreite = Integer.parseInt(breiteTextField.getText()) * METERTOCENTIMETER;
                    stuetzenbreite = Integer.parseInt(stuetzenbreiteTextField.getText());
                    sBreiteWarning.setText("");
                }

                if (hoehe > 0 && breite > 0 && stuetzenhoehe > 0 && stuetzenbreite > 0) {
                    regal = new Regal(hoehe, breite);
                    regal.addStuetzenByInput(stuetzenhoehe, stuetzenbreite);
                    hoeheTextField.setText("");
                    breiteTextField.setText("");
                    stuetzenhoeheTextField.setText("");
                    stuetzenbreiteTextField.setText("");
                    showRegal(regal);
                }

        });

        saveRegal.addEventHandler(ActionEvent.ACTION, event -> {
            if (regal.getInstalledEinlegeboeden().isEmpty()) {
                einlegeboedenWarning.setText("Das Regal kann ohne Einlegeboeden doch nicht stehen! :(");
            } else {
                if (regal != null) {
                    // Regalfächer berechnen
                    System.out.println("regal");
                    regal.getInstalledEinlegeboeden().sort(Comparator.comparing(Einlegeboden::getyPos));

                    for (int i = 0; i< regal.getInstalledEinlegeboeden().size(); i++) {
                        Einlegeboden curEinlegeboden = regal.getInstalledEinlegeboeden().get(i);
                        ArrayList<Paket> pakete = new ArrayList<Paket>();
                        if (i==0) {
                            Regalfach newRegalfach = new Regalfach(curEinlegeboden, pakete, curEinlegeboden.getyPos(), 0, 0);
                            regal.getRegalfaecher().add(newRegalfach);
                        } else {
                            Einlegeboden prevBoden = regal.getInstalledEinlegeboeden().get(i-1);
                            Regalfach newRegalfach = new Regalfach(curEinlegeboden, pakete, curEinlegeboden.getyPos() - prevBoden.getyPos(), 0, prevBoden.getyPos());
                            regal.getRegalfaecher().add(newRegalfach);
                        }
                    }
                    try {
                        hauptLager.addRegal(regal);
                    } catch (LagerVollException e) {
                        e.printStackTrace();
                    }
                    regalConfigView.setCenter(inputBox);
                    main.switchScene(Scenes.LAGER_VIEW);
                }

            }

        });
    }

    public void showRegal(Regal regal) {

        RegalComponentController regalComponentController = new RegalComponentController(regal);
        RegalComponent regalComponent = (RegalComponent) regalComponentController.getRootView();

        // DRAG and DROP target-settings

        regalComponent.setOnDragOver(event -> {
            if (event.getGestureSource() != regalComponent &&
                    event.getDragboard().hasString()) {
                /* allow for both copying and moving, whatever user chooses */
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }

            event.consume();
        });

        regalComponent.setOnDragEntered(event -> {
                if (event.getGestureSource() != regalComponent &&
                        event.getDragboard().hasString()) {
                    regalComponent.setStyle("-fx-background-color: rgba(10, 140, 120, 1)");
                }
                event.consume();
        });

        regalComponent.setOnDragExited(event -> {
            regalComponent.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
            event.consume();
        });

        regalComponent.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    System.out.println("DROPPED on target: " + db.getString() + " from " + event.getGestureSource().getClass());
                    int yPos = (int) event.getY();

                    Einlegeboden addedEinlegeboden;

                    if (event.getGestureSource().getClass().getName().equals("ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenCell")) {
                        addedEinlegeboden = regal.getEinlegeboeden().get(Integer.parseInt(db.getString()));
                    } else {
                        addedEinlegeboden = regal.getInstalledEinlegeboeden().get(Integer.parseInt(db.getString()));
                    }

                    addedEinlegeboden.setyPos(yPos);
                    regal.installEinlegeboden(addedEinlegeboden);
                    regalComponentController.addEinlegeboden(regal.getInstalledEinlegeboeden(), addedEinlegeboden);
                    success = true;

                }

                event.setDropCompleted(success);

                event.consume();
        });

        EinlegebodenListViewController einlegebodenListViewController = new EinlegebodenListViewController(regal);
        EinlegebodenListView einlegebodenListView = (EinlegebodenListView) einlegebodenListViewController.getRootView();

        regalConfigView.setCenter(regalComponent);
        regalConfigView.setRight(einlegebodenListView);


    }

    public Pane getRootView() {
        return rootView;
    }

}
