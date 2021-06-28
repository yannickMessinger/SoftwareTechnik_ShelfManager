package ShelfManager.gui.RegalConfigView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Regal;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenListView;
import ShelfManager.gui.RegalConfigView.EinlegebodenList.EinlegebodenListViewController;
import ShelfManager.gui.RegalComponent.RegalComponent;
import ShelfManager.gui.RegalComponent.RegalComponentController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RegalConfigViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private RegalConfigView regalConfigView;

    private VBox inputBox;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private TextField stuetzenhoeheTextField;
    private TextField stuetzenbreiteTextField;
    private Button submit;
    private Button backToLagerView;

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
                Regal regal = new Regal(hoehe, breite);
                regal.addStuetzenByInput(stuetzenhoehe, stuetzenbreite);
                hauptLager.addRegal(regal);
                hoeheTextField.setText("");
                breiteTextField.setText("");
                stuetzenhoeheTextField.setText("");
                stuetzenbreiteTextField.setText("");

                showRegal(regal);

            } catch(NumberFormatException n) {
                System.out.println("keine Buchstaben erlaubt!");
            }
        });
    }

    public void showRegal(Regal regal) {

        RegalComponentController regalComponentController = new RegalComponentController(regal);
        RegalComponent regalComponent = (RegalComponent) regalComponentController.getRootView();

        EinlegebodenListViewController einlegebodenListViewController = new EinlegebodenListViewController(regal);
        EinlegebodenListView einlegebodenListView = (EinlegebodenListView) einlegebodenListViewController.getRootView();

//        VBox testBox = new VBox();
//        testBox.setStyle("-fx-background-color: rgba( 255, 255, 0,1)");
//        testBox.getChildren().add(new Button("Holla"));

        regalConfigView.setCenter(regalComponent);
        regalConfigView.setRight(einlegebodenListView);



        // erstmal nur ausprobiert
        // sicherlich sollten wir die Repräsentation eines Regals auslagern
//        Pane regalPane = new Pane();
//        Stuetze[] stuetzen = regal.getStuetzen();
//
//        Line stuetze1 = new Line(50, 50, 50, 50 + stuetzen[0].getHoehe());
//        stuetze1.setStrokeWidth(stuetzen[0].getBreite());
//
//        Line stuetze2 = new Line(50 + regal.getBreite(), 50, 50 + regal.getBreite(), 50 + stuetzen[1].getHoehe());
//        stuetze2.setStrokeWidth(stuetzen[1].getBreite());
//
//        regalPane.getChildren().addAll(stuetze1, stuetze2);
//
//        regalConfigView.setCenter(regalPane);
    }

    public Pane getRootView() {
        return rootView;
    }

}
