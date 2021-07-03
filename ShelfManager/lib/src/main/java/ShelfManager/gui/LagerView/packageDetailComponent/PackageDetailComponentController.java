package ShelfManager.gui.LagerView.packageDetailComponent;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PackageDetailComponentController extends ViewController {

    private PackageDetailComponent packageDetailComponent;
    private Lager hauptLager;
    private Rectangle currentPackage;
    private Label currentPackageName;
    private Label currentPackageHoehe;
    private Label currentPackageBreite;
    private Label currentPackageGewicht;
    private Label currentPackageTragkraft;
    private ListView<Color>  unvertraeglichkeiten;


    public PackageDetailComponentController(Lager hauptLager){
        this.packageDetailComponent = new PackageDetailComponent();
        this.hauptLager = hauptLager;
        this.rootView =  packageDetailComponent;



        this.currentPackage = packageDetailComponent.getCurrentPackage();
        this.currentPackageName = packageDetailComponent.getCurrentPackageName();
        this.currentPackageHoehe = packageDetailComponent.getCurrentPackageHoehe();
        this.currentPackageBreite = packageDetailComponent.getCurrentPackageBreite();
        this.currentPackageGewicht = packageDetailComponent.getCurrentPackageGewicht();
        this.currentPackageTragkraft = packageDetailComponent.getCurrentPackageTragkraft();
        this.unvertraeglichkeiten = packageDetailComponent.getUnvertraeglichkeiten();

        initialize();
    }







    @Override
    public void initialize() {

        hauptLager.aktPaketProperty().addListener((observable, oldValue, newValue) -> {

            currentPackage.setFill(newValue.getFarbe());
            currentPackageName.setText("Paketname: " + newValue.getPaketName());
            currentPackageHoehe.setText("Pakethoehe: " + String.valueOf(newValue.getHoehe()));
            currentPackageBreite.setText("Paketbreite: " + String.valueOf(newValue.getBreite()));
            currentPackageGewicht.setText("Paketgewicht: " + String.valueOf(newValue.getGewicht()));
            currentPackageTragkraft.setText("Pakettragkraft: " + String.valueOf(newValue.getTragkraft()));
            //unvertraeglichkeiten.setItems((ObservableList<Color>) newValue.getUnvertraeglichkeiten());


        });

        hauptLager.getPaketWasDeletedProperty().addListener((observable, oldValue, newValue) -> {
            currentPackage.setFill(Color.color(0,0,0,0));
            currentPackageName.setText("Paketname: " );
            currentPackageHoehe.setText("Pakethoehe: " );
            currentPackageBreite.setText("Paketbreite: "  );
            currentPackageGewicht.setText("Paketgewicht: " );
            currentPackageTragkraft.setText("Pakettragkraft: ");
            hauptLager.setPaketWasDeleted(false);

        });



    }

    public Pane getRootView () {
        return rootView;
    }

}

