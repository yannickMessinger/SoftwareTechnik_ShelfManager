package ShelfManager.gui.RegalConfigView;

import ShelfManager.Lager.*;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenListView;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenListViewController;
import ShelfManager.gui.RegalComponent.RegalComponent;
import ShelfManager.gui.RegalComponent.RegalComponentController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class RegalConfigViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private RegalConfigView regalConfigView;
    private Regal regal;

    private VBox inputBox;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private TextField stuetzenhoeheTextField;
    private TextField stuetzenbreiteTextField;
    private Button submit;
    private Button backToLagerView;
    private Button saveRegal;

    public RegalConfigViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.regalConfigView = new RegalConfigView();

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

            try {
                int hoehe = Integer.parseInt(hoeheTextField.getText());
                int breite = Integer.parseInt(breiteTextField.getText());
                int stuetzenhoehe = Integer.parseInt(stuetzenhoeheTextField.getText());
                int stuetzenbreite = Integer.parseInt(stuetzenbreiteTextField.getText());
                regal = new Regal(hoehe, breite);
                regal.addStuetzenByInput(stuetzenhoehe, stuetzenbreite);
                hoeheTextField.setText("");
                breiteTextField.setText("");
                stuetzenhoeheTextField.setText("");
                stuetzenbreiteTextField.setText("");

                showRegal(regal);

            } catch(NumberFormatException n) {
                System.out.println("keine Buchstaben erlaubt!");
            }
        });

        saveRegal.addEventHandler(ActionEvent.ACTION, event -> {

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
                hauptLager.addRegal(regal);
                regalConfigView.setCenter(inputBox);
                main.switchScene(Scenes.LAGER_VIEW);
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
                /* the drag-and-drop gesture entered the target */
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != regalComponent &&
                        event.getDragboard().hasString()) {
                    regalComponent.setStyle("-fx-background-color: rgba(10, 140, 120, 1)");
                }

                event.consume();
        });

        regalComponent.setOnDragExited(event -> {
                /* mouse moved away, remove the graphical cues */
            regalComponent.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");

                event.consume();
        });

        regalComponent.setOnDragDropped(event -> {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
                    System.out.println("DROPPED on target: " + db.getString());
                    int hoehe = Integer.parseInt(db.getString().split("\\|")[1]);
                    int tragkraft = Integer.parseInt(db.getString().split("\\|")[2]);
                    int yPos = (int) event.getY();
                    Einlegeboden addedEinlegeboden = regal.addEinlegeboden(hoehe, tragkraft, yPos);
                    System.out.println(regal.getInstalledEinlegeboeden().size());
                    regalComponentController.addEinlegeboden(regal.getInstalledEinlegeboeden(), addedEinlegeboden);
                    success = true;

                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
        });

        EinlegebodenListViewController einlegebodenListViewController = new EinlegebodenListViewController(regal);
        EinlegebodenListView einlegebodenListView = (EinlegebodenListView) einlegebodenListViewController.getRootView();

//        VBox testBox = new VBox();
//        testBox.setStyle("-fx-background-color: rgba( 255, 255, 0,1)");
//        testBox.getChildren().add(new Button("Holla"));

        regalConfigView.setCenter(regalComponent);
        regalConfigView.setRight(einlegebodenListView);


    }

    public Pane getRootView() {
        return rootView;
    }

}
