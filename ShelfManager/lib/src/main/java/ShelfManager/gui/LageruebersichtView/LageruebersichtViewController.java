package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Lager;
import ShelfManager.Lager.Paket;
import ShelfManager.ShelfManagerApplication;
import ShelfManager.gui.PaketListComponent.PaketCell;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
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

/*import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;*/

public class LageruebersichtViewController extends ViewController {

    private Lager hauptLager;
    private ShelfManagerApplication main;
    private LageruebersichtView lageruebersichtView;
    private Stage stage;

    private ComboBox filterBox;
    private Button backToLagerView;
    private ListView<Paket> paketlistView;
    private Button speicheren;
    private FileChooser fileChooser;

    public LageruebersichtViewController(Lager hauptLager, ShelfManagerApplication main) {
        this.hauptLager = hauptLager;
        this.main = main;
        this.lageruebersichtView = new LageruebersichtView(hauptLager);

        this.fileChooser = new FileChooser();
        this.filterBox = lageruebersichtView.getFilterBox();
        this.backToLagerView = lageruebersichtView.getBackToLagerView();
        this.paketlistView = lageruebersichtView.getPaketlistView();
        this.speicheren=lageruebersichtView.getSpeicheren();



        rootView = lageruebersichtView;
        initialize();
    }

    @Override
    public void initialize() {
        backToLagerView.addEventHandler(ActionEvent.ACTION, event -> {
            main.switchScene(Scenes.LAGER_VIEW);
        });

        paketlistView.setCellFactory(new Callback<ListView<Paket>, ListCell<Paket>>() {
            @Override
            public ListCell<Paket> call(ListView<Paket> param) {
                return new PaketCell();
            }
        });

        /*ObservableList<Paket> uiModel = paketlistView.getItems();
        ObservableList<Paket> pakete = hauptLager.getAllPakets();
        uiModel.addAll(pakete);

        pakete.addListener((ListChangeListener<Paket>) change -> {
            System.out.println(change);
            uiModel.clear();
            uiModel.addAll(pakete);
            paketlistView.refresh();
        });*/


        filterBox.setOnAction((Event ev) -> {

        });

        //Lagerübersicht speicheren 


        // mit hilfe Filechooser
         speicheren.setOnAction(event -> {
           System.out.println("tessst");
            configureFileChooser(fileChooser);
             File file = fileChooser.showSaveDialog(stage);
            fileChooser.setTitle("save");
            fileChooser.setInitialFileName("mySave");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("pdf","*.pdf"));


            //Durch print als pdf speicheren
/*           speicheren.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {

                 PrinterJob save = PrinterJob.createPrinterJob();
                 if(save != null){
                    save.showPrintDialog(stage);
                    save.printPage(paketlistView);
                    save.endJob();
                 }
             }


            // using PDFBox libreries erstellt einen Snapshot (erstellt dann eine PDF-Datei und fügt das Bild in die PDF-Datei ein)
            speicheren.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    WritableImage nodeshot = bar.snapshot(new SnapshotParameters(), null);
                    File file = new File("chart.png");

                    try {
                        ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", file);
                    } catch (IOException e) {

                    }

                    PDDocument doc    = new PDDocument();
                    PDPage page = new PDPage();
                    PDImageXObject pdimage;
                    PDPageContentStream content;
                    try {
                        pdimage = PDImageXObject.createFromFile("chart.png",doc);
                        content = new PDPageContentStream(doc, page);
                        content.drawImage(pdimage, 100, 100);
                        content.close();
                        doc.addPage(page);
                        doc.save("pdf_file.pdf");
                        doc.close();
                        file.delete();
                    } catch (IOException ex) {
                        Logger.getLogger(NodeToPdf.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }*/
        });

    }
    private static void configureFileChooser(final FileChooser fileChooser) {

        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    }

    public Pane getRootView() {

        return rootView;
    }

}
