package ShelfManager.gui.LagerView.LagerComponent;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Regal;
import ShelfManager.Lager.Stuetze;
import ShelfManager.gui.RegalComponent.RegalComponent;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.shape.Line;

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
                    addRegalComponent(regalComponent);
                }

            }
        });
    }

    public void addRegalComponent(RegalComponent regalComponent) {
        lagerComponent.getChildren().add(regalComponent);
    }

}
