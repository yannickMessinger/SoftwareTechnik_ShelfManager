package ShelfManager.gui.RegalComponent;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Regal;
import ShelfManager.Lager.Stuetze;
import ShelfManager.gui.ViewController;
import javafx.collections.ObservableList;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Line;

public class RegalComponentController extends ViewController {

    private RegalComponent regalComponent;
    private Line stuetzeLeft;
    private Line stuetzeRight;

    private Regal regal;
    private Stuetze regalStuetzeLeft;
    private Stuetze regalStuetzeRight;

    public RegalComponentController(Regal regal) {

        this.regal = regal;
        this.regalStuetzeLeft = regal.getStuetzen()[0];
        this.regalStuetzeRight = regal.getStuetzen()[1];

        this.regalComponent = new RegalComponent();
        this.stuetzeLeft = regalComponent.getStuetzeLeft();
        this.stuetzeRight = regalComponent.getStuetzeRight();

        rootView = regalComponent;
        initialize();

    }

    @Override
    public void initialize() {

        regalComponent.setMaxWidth(regal.getBreite());
        regalComponent.setMaxHeight(regal.getHoehe());

        stuetzeLeft.setStartX(0);
        stuetzeLeft.setStartY(0);
        stuetzeLeft.setEndX(0);
        stuetzeLeft.setEndY(regalStuetzeLeft.getHoehe());
        stuetzeLeft.setStrokeWidth(regalStuetzeLeft.getBreite());

        stuetzeRight.setStartX(regal.getBreite());
        stuetzeRight.setStartY(0);
        stuetzeRight.setEndX(regal.getBreite());
        stuetzeRight.setEndY(regalStuetzeRight.getHoehe());
        stuetzeRight.setStrokeWidth(regalStuetzeRight.getBreite());


    }

    public void addEinlegeboden(ObservableList<Einlegeboden> installedEinlegeboeden, Einlegeboden einlegeboden) {
        Line bodenline = new Line();
        bodenline.setStartX(0);
        bodenline.setStartY(einlegeboden.getyPos());
        bodenline.setEndX(regal.getBreite());
        bodenline.setEndY(einlegeboden.getyPos());
        bodenline.setStrokeWidth(einlegeboden.getHoehe());

        regalComponent.getChildren().add(bodenline);

        bodenline.setOnDragDetected(event -> {
            installedEinlegeboeden.remove(einlegeboden);
            Dragboard db = bodenline.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent cc = new ClipboardContent();
            cc.putString("|" + einlegeboden.getHoehe() + "|" + einlegeboden.getTragkraft());
            db.setContent(cc);
            regalComponent.getChildren().remove(bodenline);
        });

        bodenline.setOnDragOver(event -> {
            Dragboard db = event.getDragboard();
            if (db.hasString()) {
                event.acceptTransferModes(TransferMode.MOVE);
            }
        });

    }


}
