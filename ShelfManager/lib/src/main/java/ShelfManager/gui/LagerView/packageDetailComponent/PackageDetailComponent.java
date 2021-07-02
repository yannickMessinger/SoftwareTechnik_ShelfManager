package ShelfManager.gui.LagerView.packageDetailComponent;

import ShelfManager.Lager.Paket;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PackageDetailComponent extends Pane {


    private Rectangle currentPackage;
    Label currentPackageName;
    Label currentPackageHoehe;
    Label currentPackageBreite;
    Label currentPackageGewicht;
    Label currentPackageTragkraft;
    //Liste bzw. Anzeigemöglichkeit für Unverträglichkeiten hinzufügen

    public PackageDetailComponent(){

        currentPackage = new Rectangle(100,100, Color.color(0,0,0,0));
        HBox rectangleBox = new HBox(currentPackage);

        currentPackageName = new Label("Name");
        currentPackageHoehe = new Label("Hoehe");
        currentPackageBreite = new Label("Breite");
        currentPackageGewicht = new Label("Gewicht");
        currentPackageTragkraft = new Label("Tragkraft");

        VBox detailLabels = new VBox(currentPackageName, currentPackageHoehe, currentPackageBreite, currentPackageGewicht,currentPackageTragkraft);
        VBox currentPackageInfo = new VBox(rectangleBox, detailLabels);



        this.getChildren().add(currentPackageInfo);


    }

    //------------------------GETTER

    public Rectangle getCurrentPackage() {
        return currentPackage;
    }

    public Label getCurrentPackageName() {
        return currentPackageName;
    }

    public Label getCurrentPackageHoehe() {
        return currentPackageHoehe;
    }

    public Label getCurrentPackageBreite() {
        return currentPackageBreite;
    }

    public Label getCurrentPackageGewicht() {
        return currentPackageGewicht;
    }


    public Label getCurrentPackageTragkraft() {
        return currentPackageTragkraft;
    }


    //-----------------------SETTER



    public void setCurrentPackage(Rectangle currentPackage) {
        this.currentPackage = currentPackage;
    }



    public void setCurrentPackageName(Label currentPackageName) {
        this.currentPackageName = currentPackageName;
    }



    public void setCurrentPackageHoehe(Label currentPackageHoehe) {
        this.currentPackageHoehe = currentPackageHoehe;
    }



    public void setCurrentPackageBreite(Label currentPackageBreite) {
        this.currentPackageBreite = currentPackageBreite;
    }



    public void setCurrentPackageGewicht(Label currentPackageGewicht) {
        this.currentPackageGewicht = currentPackageGewicht;
    }



    public void setCurrentPackageTragkraft(Label currentPackageTragkraft) {
        this.currentPackageTragkraft = currentPackageTragkraft;
    }
}