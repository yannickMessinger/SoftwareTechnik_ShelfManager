package ShelfManager.gui.LagerView.packageDetailComponent;

import ShelfManager.Lager.Paket;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PackageDetailComponent extends Pane {


    private Rectangle currentPackage;
    private Label currentPackageName;
    private Label currentPackageHoehe;
    private Label currentPackageBreite;
    private Label currentPackageGewicht;
    private Label currentPackageTragkraft;
    private Label currentUnvertraeglichkeiten;
    private Label name;
    private ListView<Color>  unvertraeglichkeiten;

    //Liste bzw. Anzeigemöglichkeit für Unverträglichkeiten hinzufügen

    public PackageDetailComponent(){

        currentPackage = new Rectangle(30,30, Color.color(0,0,0,0));
        HBox rectangleBox = new HBox(currentPackage);
        this.unvertraeglichkeiten = new ListView<Color>();

        //Label
        name=new Label("Paket Details "); //
        currentPackageName = new Label("Name");
        currentPackageHoehe = new Label("Hoehe");
        currentPackageBreite = new Label("Breite");
        currentPackageGewicht = new Label("Gewicht");
        currentPackageTragkraft = new Label("Tragkraft");
        currentUnvertraeglichkeiten = new Label("Unvertraeglichkeiten:");

        //output Box
        VBox detailLabels = new VBox(currentPackageName, currentPackageHoehe, currentPackageBreite, currentPackageGewicht,currentPackageTragkraft);
        VBox listBox = new VBox(currentUnvertraeglichkeiten, unvertraeglichkeiten);
        listBox.setMaxHeight(30); // muss angepasst werden
        VBox currentPackageInfo = new VBox(rectangleBox, detailLabels,listBox);

        //Unverträglichkeitenliste noch in VBox packen, passt aber nicht vom Layout!
        //Titel


        this.getChildren().addAll(currentPackageInfo);
        //------------------------Style

        //Label
        name.getStyleClass().add("titleLabel");
        currentPackageName.getStyleClass().add("titleLabel");
        currentPackageHoehe.getStyleClass().add("titleLabel");
        currentPackageBreite.getStyleClass().add("titleLabel");
        currentPackageGewicht.getStyleClass().add("titleLabel");
        currentPackageTragkraft.getStyleClass().add("titleLabel");
        currentUnvertraeglichkeiten.getStyleClass().add("titleLabel");


        //output Box
        currentPackageInfo.setId("Box-Border");

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

    public ListView<Color> getUnvertraeglichkeiten(){
        return unvertraeglichkeiten;
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

