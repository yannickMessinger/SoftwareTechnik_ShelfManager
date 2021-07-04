package ShelfManager.gui.LagerView.packageDetailComponent;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.PaketConfigView.UnvertraeglichkeitCell;
import ShelfManager.gui.ViewController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

public class PackageDetailComponentController extends ViewController {

    private PackageDetailComponent packageDetailComponent;
    private Lager hauptLager;
    private Rectangle currentPackage;
    private Label currentPackageName;
    private Label currentPackageHoehe;
    private Label currentPackageBreite;
    private Label currentPackageGewicht;
    private Label currentPackageTragkraft;
    private ListView<Color> unvertraeglichkeitenFromView;
    private ObservableList<Color>  observableUnvertraeglichkeiten;
    private ListView<String> gefahrgutListFromview;
    private ObservableList<String> observableGefahrgut;


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
        this.observableUnvertraeglichkeiten = FXCollections.observableArrayList();
        this.unvertraeglichkeitenFromView = packageDetailComponent.getUnvertraeglichkeiten();
        this.observableGefahrgut = FXCollections.observableArrayList();
        this.gefahrgutListFromview = packageDetailComponent.getGefahrgutList();

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
            observableUnvertraeglichkeiten.setAll(newValue.getUnvertraeglichkeiten());
            observableGefahrgut.setAll((newValue.getGefahrgutListe()));


        });

        hauptLager.getPaketWasDeletedProperty().addListener((observable, oldValue, newValue) -> {
            currentPackage.setFill(Color.color(0,0,0,0));
            currentPackageName.setText("Paketname: " );
            currentPackageHoehe.setText("Pakethoehe: " );
            currentPackageBreite.setText("Paketbreite: "  );
            currentPackageGewicht.setText("Paketgewicht: " );
            currentPackageTragkraft.setText("Pakettragkraft: ");
            hauptLager.setPaketWasDeleted(false);
            unvertraeglichkeitenFromView.getItems().clear();
            unvertraeglichkeitenFromView.refresh();
        });

        unvertraeglichkeitenFromView.setCellFactory(

                new Callback<ListView<Color>, ListCell<Color>>() {
                    @Override
                    public ListCell<Color> call(ListView<Color> v) {
                        return new UnvertraeglichkeitCell();
                    }
                });


        observableUnvertraeglichkeiten.addListener(new ListChangeListener<Color>() {
            @Override
            public void onChanged(Change<? extends Color> c) {

                unvertraeglichkeitenFromView.getItems().clear();
                unvertraeglichkeitenFromView.getItems().addAll(observableUnvertraeglichkeiten);
                unvertraeglichkeitenFromView.refresh();
            }
        });

        gefahrgutListFromview.setCellFactory(

                new Callback<ListView<String>, ListCell<String>>() {
                    @Override
                    public ListCell<String> call(ListView<String> v) {
                        return new GefahrgutCell();
                    }
                });


      observableGefahrgut.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> s) {

                gefahrgutListFromview.getItems().clear();
                gefahrgutListFromview.getItems().addAll(observableGefahrgut);
                gefahrgutListFromview.refresh();
            }
        });



    }

    public Pane getRootView () {
        return rootView;
    }

}

