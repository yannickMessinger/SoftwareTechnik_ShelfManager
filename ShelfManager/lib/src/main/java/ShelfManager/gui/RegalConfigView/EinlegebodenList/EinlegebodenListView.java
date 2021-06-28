package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Regal;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class EinlegebodenListView extends VBox {

    private ListView<Einlegeboden> einlegebodenList;
    private CreateEinlegebodenViewController createEinlegebodenViewController;

    public EinlegebodenListView(Regal regal) {
        this.einlegebodenList = new ListView<>();
        this.createEinlegebodenViewController = new CreateEinlegebodenViewController(regal);



        this.getChildren().addAll(einlegebodenList, createEinlegebodenViewController.getRootView());





    }




    //------GETTER----------------------------------------
    public ListView<Einlegeboden> getEinlegebodenList() {
        return einlegebodenList;
    }
}
