package ShelfManager.gui.LagerView.packageDetailComponent;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.ViewController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PackageDetailComponentController extends ViewController {

    private PackageDetailComponent packageDetailComponent;
    private Lager hauptLager;
    Rectangle currentPackage;
    Label currentPackageName;
    Label currentPackageHoehe;
    Label currentPackageBreite;
    Label currentPackageGewicht;
    Label currentPackageTragkraft;

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

            System.out.println("neues Paket " + newValue.getPaketName() + " wurde ausgewählt");

        });

    }

    public Pane getRootView () {
        return rootView;
    }

}

