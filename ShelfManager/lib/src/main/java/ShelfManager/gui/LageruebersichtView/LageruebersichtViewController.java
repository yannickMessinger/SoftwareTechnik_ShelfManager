package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.PaketListComponent.PaketCell;
import ShelfManager.gui.PaketListComponent.PaketListComponent;
import ShelfManager.gui.PaketListComponent.PaketListComponentController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.print.*;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LageruebersichtViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private LageruebersichtView lageruebersichtView;
    private Stage stage;
    private Button backToLagerView;
    private ListView<Paket> paketlistView;
    private Button speicheren;
    private PaketListComponent paketListComponent;


    public LageruebersichtViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.lageruebersichtView = new LageruebersichtView(hauptLager);
        this.backToLagerView = lageruebersichtView.getBackToLagerView();
        this.paketlistView = lageruebersichtView.getPaketlistView();
        this.speicheren = lageruebersichtView.getSpeicheren();


        rootView = lageruebersichtView;
        initialize();
    }

    @Override
    public void initialize() {


        //Durch Print als pdf speicheren
        speicheren.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PrinterJob save = PrinterJob.createPrinterJob();
                if (save != null) {
                    save.printPage(lageruebersichtView);    //  als Screnschot
                    save.endJob();
                }
            }

        });

        /*speicheren.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PrinterJob job = PrinterJob.createPrinterJob();
                if (job != null) {
                    Printer printer = job.getPrinter();
                    PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
                    PrintResolution resolution = job.getJobSettings().getPrintResolution();

                    boolean success = job.printPage(pageLayout, lageruebersichtView);
                    if (success) {
                        job.endJob();
                    }
                }
            }

        });
*/
        backToLagerView.addEventHandler(ActionEvent.ACTION, event -> {
            main.switchScene(Scenes.LAGER_VIEW);
        });

    }

    public Pane getRootView() {

        return rootView;
    }

}
