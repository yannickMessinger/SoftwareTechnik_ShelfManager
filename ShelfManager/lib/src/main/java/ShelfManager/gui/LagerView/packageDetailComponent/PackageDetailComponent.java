package ShelfManager.gui.LagerView.packageDetailComponent;

import ShelfManager.Lager.Paket;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PackageDetailComponent extends VBox {


    private Rectangle currentPackage;
    private Label currentPackageName;
    private Label currentPackageHoehe;
    private Label currentPackageBreite;
    private Label currentPackageGewicht;
    private Label currentPackageTragkraft;
    private Label currentUnvertraeglichkeiten;
    private Label name;
    private ListView<Color>  unvertraeglichkeiten;
    private Label currentGefahrgut;
    private ListView<String> gefahrgutList;


    //Liste bzw. Anzeigemöglichkeit für Unverträglichkeiten hinzufügen

    public PackageDetailComponent(){

        currentPackage = new Rectangle(20,20, Color.color(0,0,0,0));
        HBox rectangleBox = new HBox(currentPackage);


        //Label
        name = new Label("Paket Details"); //

        //Details-------------------------
        currentPackageName = new Label("Name");
        currentPackageHoehe = new Label("Hoehe");
        currentPackageBreite = new Label("Breite");
        currentPackageGewicht = new Label("Gewicht");
        currentPackageTragkraft = new Label("Tragkraft");

        VBox detailLabels = new VBox(currentPackageName, currentPackageHoehe, currentPackageBreite, currentPackageGewicht,currentPackageTragkraft);


        //Unvertraeglichkeiten------------------
        currentUnvertraeglichkeiten = new Label("Unvertraeglichkeiten:");
        this.unvertraeglichkeiten = new ListView<Color>();
        VBox listBox = new VBox(currentUnvertraeglichkeiten, unvertraeglichkeiten);


        //Gefahrgut----------------------------
        currentGefahrgut = new Label("Gefahrgut: ");
        this.gefahrgutList = new ListView<String>();
        VBox listGefahrBox = new VBox(currentGefahrgut, gefahrgutList );


        //fuer Anzeige setzen-------------------------------
        this.getChildren().addAll(rectangleBox, detailLabels, listBox, listGefahrBox);


        //--------------------------------------------------
        //------------------------Style---------------------
        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        //Label
        name.getStyleClass().add("titleLabel");

        //Details-------------------------
        detailLabels.setSpacing(10);
        currentPackageName.getStyleClass().add("light-font");
        currentPackageHoehe.getStyleClass().add("light-font");
        currentPackageBreite.getStyleClass().add("light-font");
        currentPackageGewicht.getStyleClass().add("light-font");
        currentPackageTragkraft.getStyleClass().add("light-font");

        //Unvertraeglichkeiten------------------
        currentUnvertraeglichkeiten.getStyleClass().add("light-font");
        unvertraeglichkeiten.setMaxHeight(50);
        listBox.setSpacing(5);

        //Gefahrgut------------------
        currentGefahrgut.getStyleClass().add("light-font");
        gefahrgutList.setMaxHeight(50);
        listGefahrBox.setSpacing(5);



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

    public ListView<String> getGefahrgutList(){return gefahrgutList;}
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

