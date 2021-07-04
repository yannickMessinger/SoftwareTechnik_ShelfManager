package ShelfManager;

import ShelfManager.Lager.Command;
import ShelfManager.Lager.Lager;
import ShelfManager.gui.LagerConfigView.LagerConfigViewController;
import ShelfManager.gui.LagerView.LagerViewController;
import ShelfManager.gui.LageruebersichtView.LageruebersichtViewController;
import ShelfManager.gui.PaketConfigView.PaketConfigViewController;
import ShelfManager.gui.RegalConfigView.RegalConfigViewController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import ShelfManager.persistenz.JSONHandler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class ShelfManagerApplication extends Application {

    private Map<Scenes, Pane> scenes;
    private Stage primaryStage;
    private Lager hauptLager;

    public static void main(String[] args) { launch(args); }

    @Override
    public void init() {
        hauptLager = new Lager();
        //hauptLager = JSONHandler.loadLager();
        scenes = new HashMap<>();
        ViewController controller;

        controller = new LagerConfigViewController(hauptLager, this);
        scenes.put(Scenes.LAGER_CONFIG_VIEW, controller.getRootView());

        controller = new LagerViewController(hauptLager, this);
        scenes.put(Scenes.LAGER_VIEW, controller.getRootView());

        controller = new RegalConfigViewController(hauptLager, this);
        scenes.put(Scenes.REGAL_CONFIG_VIEW, controller.getRootView());

        controller = new PaketConfigViewController(hauptLager, this);
        scenes.put(Scenes.PAKET_CONFIG_VIEW, controller.getRootView());

        controller = new LageruebersichtViewController(hauptLager, this);
        scenes.put(Scenes.LAGERUEBERISCHT_VIEW, controller.getRootView());

    }

    //------------------------JAVAFX---------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
            this.primaryStage = primaryStage;
            Pane root = new Pane();

            Scene scene = new Scene(root, 1200, 800);
            scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

            this.primaryStage.setScene(scene);
            this.primaryStage.setTitle("ShelfManager");
            this.primaryStage.setMaximized(true);

        switchScene(Scenes.LAGER_CONFIG_VIEW);

            primaryStage.show();

            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    //JSONHandler.safeLager(hauptLager);
                    Platform.exit();
                    System.exit(0);
                }
            });

    }

    public void switchScene(Scenes toScene) {
        Scene scene = primaryStage.getScene();

        if (scenes.containsKey(toScene)) {
            scene.setRoot(scenes.get(toScene));
        }
    }
}
