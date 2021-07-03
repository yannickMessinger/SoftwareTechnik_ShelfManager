package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.gui.PaketListComponent.PaketListComponent;
import ShelfManager.gui.PaketListComponent.PaketListComponentController;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.util.ArrayList;

public class LageruebersichtView<paketListComponent> extends BorderPane {


    private Button backToLagerView;
    private Button speicheren;
    private ListView<Paket> paketlistView;
    private PaketListComponentController paketListComponentController;


    public LageruebersichtView(Lager hauptLager) {
        paketListComponentController = new PaketListComponentController(hauptLager);
        paketlistView = new ListView<>();


        //Titel
        Label viewName = new Label("LageruebersichtView");


        //FilterName
        Label ViewInfo = new Label("Lagerbestand als PDF-Datei speicheren ");


        //Button
        backToLagerView = new Button();
        Region spacer = new Region();
        speicheren = new Button();
        HBox buttonBox = new HBox(backToLagerView, spacer, speicheren);

        //PaketListe View
        VBox paketListBox = new VBox();
        paketListBox.getChildren().addAll(paketListComponentController.getRootView());


        //Position
        VBox inputBox = new VBox(viewName, ViewInfo, paketListBox);
        this.setCenter(inputBox);
        this.setBottom(buttonBox);


        //-------------------------------------------------------------------
        //---------------------------STYLE-----------------------------------
        //-------------------------------------------------------------------

        this.setPadding(new Insets(20));
        this.getStyleClass().addAll("background");
        inputBox.setPadding(new Insets(10, 20, 0, 20));
        inputBox.setSpacing(20);

        //viewName
        viewName.setId("title");



        ViewInfo.getStyleClass().add("titleLabel");


        //Buttons---------------------------
        speicheren.getStyleClass().addAll("overview-icon", "icon-button");
        backToLagerView.getStyleClass().addAll("back-icon", "icon-button");
        buttonBox.setSpacing(10);
        buttonBox.setHgrow(spacer, Priority.ALWAYS);
        buttonBox.setPadding(new Insets(20));


    }


    public Button getBackToLagerView() {
        return backToLagerView;
    }

    public Button getSpeicheren() {
        return speicheren;
    }

    public ListView<Paket> getPaketlistView() { return paketlistView; }


}
