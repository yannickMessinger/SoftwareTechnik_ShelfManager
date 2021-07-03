package ShelfManager.gui.LagerView.LagerComponent;

import ShelfManager.Lager.*;
import ShelfManager.gui.RegalComponent.RegalComponent;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Transform;

public class LagerComponentController extends ViewController {

    private Lager lager;
    private LagerComponent lagerComponent;

    public LagerComponentController(Lager lager) {
        this.lager = lager;
        this.lagerComponent = new LagerComponent();

        rootView = lagerComponent;
        initialize();
    }

    @Override
    public void initialize() {
        //TODO: erstmal ausprobiert, kann sicher in Methoden ausgelagert und wiederverwertet werden
        ObservableList<Regal> regale = lager.getObservableRegalList();
        regale.addListener(new ListChangeListener<Regal>() {
            @Override
            public void onChanged(Change<? extends Regal> c) {
                System.out.println("Changed Regale");
                lagerComponent.getChildren().clear();
                for (int i = 0; i < regale.size(); i++) {
                    Regal r = regale.get(i);
                    RegalComponent regalComponent = new RegalComponent();
                    Stuetze regalStuetzeLeft = r.getStuetzen()[0];
                    Stuetze regalStuetzeRight = r.getStuetzen()[1];

                    regalComponent.setMaxWidth(r.getBreite());
                    regalComponent.setMaxHeight(r.getHoehe());

                    Line stuetzeLeft = regalComponent.getStuetzeLeft();
                    Line stuetzeRight = regalComponent.getStuetzeRight();

                    stuetzeLeft.setStartX(0);
                    stuetzeLeft.setStartY(0);
                    stuetzeLeft.setEndX(0);
                    stuetzeLeft.setEndY(regalStuetzeLeft.getHoehe());
                    stuetzeLeft.setStrokeWidth(regalStuetzeLeft.getBreite());

                    stuetzeRight.setStartX(r.getBreite());
                    stuetzeRight.setStartY(0);
                    stuetzeRight.setEndX(r.getBreite());
                    stuetzeRight.setEndY(regalStuetzeRight.getHoehe());
                    stuetzeRight.setStrokeWidth(regalStuetzeRight.getBreite());

                    for (Einlegeboden einlegeboden : r.getInstalledEinlegeboeden()) {
                        Line bodenline = new Line();
                        bodenline.setStartX(0);
                        bodenline.setStartY(einlegeboden.getyPos());
                        bodenline.setEndX(r.getBreite());
                        bodenline.setEndY(einlegeboden.getyPos());
                        bodenline.setStrokeWidth(einlegeboden.getHoehe());


                        regalComponent.getChildren().add(bodenline);
                    }


                    int xVerschiebung = 30;
                    for (int j = 0; j < i; j++) {
                        xVerschiebung += regale.get(j).getBreite();
                        xVerschiebung += regale.get(j).getStuetzen()[0].getBreite()/2;
                        xVerschiebung += regale.get(j).getStuetzen()[1].getBreite()/2;
                    }

                    regalComponent.setTranslateX(xVerschiebung);
                    regalComponent.setTranslateY(lager.getHoehe() - r.getHoehe() - r.getStuetzen()[0].getBreite()/2);
                    regalComponent.setStyle("-fx-background-color: rgba(120, 140, 120, 0)");

                    //Pakete initialisieren
                    for (Regalfach regalfach : r.getRegalfaecher()) {
                        for (Paket addedPaket : regalfach.getPakete()) {
                            Rectangle paket = new Rectangle(addedPaket.getxPos(), addedPaket.getyPos(), addedPaket.getBreite(), addedPaket.getHoehe());
                            paket.setFill(addedPaket.getFarbe());
                            addDragAndDropFunctionToPaket(regalfach, addedPaket, paket, regalComponent);
                            regalComponent.getChildren().add(paket);
                        }
                    }

                    regalComponent.setOnDragOver(event -> {
                        if (event.getGestureSource() != regalComponent &&
                                event.getDragboard().hasString()) {
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
                        regalComponent.setStyle("-fx-background-color: rgba(120, 140, 120, 0)");

                        event.consume();
                    });

                    regalComponent.setOnDragDropped(event -> {
                        Dragboard db = event.getDragboard();
                        boolean success = false;
                        if (db.hasString()) {
                            System.out.println("DROPPED on target: " + db.getString());

                            Paket addedPaket;
                            if (event.getGestureSource().getClass().getName().equals("ShelfManager.gui.PaketListComponent.PaketCell")) {
                                addedPaket = lager.getObservablePaketList().get(Integer.parseInt(db.getString()));
                            } else {
                                addedPaket = lager.getAllPakets().get(Integer.parseInt(db.getString()));
                            }

                            int yPos = (int) event.getY();
                            int xPos = (int) event.getX();

                            //find regalfach
                            for (int j = r.getRegalfaecher().size()-1; j >= 0; j--) {
                                Regalfach rf = r.getRegalfaecher().get(j);

                                if (j == r.getRegalfaecher().size()-1) {
                                    if (rf.getBoden().getyPos() <= yPos) {
                                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                                        a.setContentText("Das Verschieben hat nicht geklappt");
                                        a.show();
                                        break;
                                    }
                                }

                                if (rf.getyPos() <= yPos) {
                                    addedPaket.setxPos(xPos);
                                    addedPaket.setyPos(yPos);
                                    if (rf.tryToAddPaket(addedPaket)) {
                                        rf.getPakete().add(addedPaket);
                                        lager.getAllPakets().add(addedPaket);
                                        Rectangle paket = new Rectangle(addedPaket.getxPos(), addedPaket.getyPos(), addedPaket.getBreite(), addedPaket.getHoehe());
                                        paket.setFill(addedPaket.getFarbe());
                                        addDragAndDropFunctionToPaket(rf, addedPaket, paket, regalComponent);
                                        regalComponent.getChildren().add(paket);
                                        success = true;
                                        event.setDropCompleted(success);
                                        event.consume();
                                    } else {
                                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                                        a.setContentText("Das Verschieben hat nicht geklappt");
                                        a.show();
                                    }

                                    break;
                                }
                            }

                        }


                    });

                    addRegalComponent(regalComponent);
                }

            }
        });
    }

    public void addRegalComponent(RegalComponent regalComponent) {
        lagerComponent.getChildren().add(regalComponent);
    }

    public void addDragAndDropFunctionToPaket(Regalfach rf, Paket addedPaket, Rectangle paket, RegalComponent regalComponent) {
        //TODO: erstmal nur ein Paket (Stapel nicht berücksichtigt)

        paket.setOnDragDetected(event -> {
            if (addedPaket!=null) {
                Dragboard db = paket.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent cc = new ClipboardContent();
                cc.putString(String.valueOf(lager.getAllPakets().indexOf(addedPaket)));
                db.setContent(cc);

                Rectangle rectangle = new Rectangle(addedPaket.getBreite(), addedPaket.getHoehe(), addedPaket.getFarbe());
                SnapshotParameters snapshotParameters = new SnapshotParameters();
                snapshotParameters.setTransform(Transform.scale(2,2));
                db.setDragView(rectangle.snapshot(snapshotParameters, null), 0, 0);
            }
        });

        paket.setOnDragDone(event -> {
            if (event.getTransferMode() == TransferMode.MOVE) {
                rf.getPakete().remove(addedPaket);
                regalComponent.getChildren().remove(paket);
            }
            event.consume();
        });
    }
}
