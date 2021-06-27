package ShelfManager;

import ShelfManager.Lager.Command;
import ShelfManager.Lager.Lager;
import ShelfManager.gui.LagerConfigView.LagerConfigViewController;
import ShelfManager.gui.LagerView.LagerViewController;
import ShelfManager.gui.Scenes;
import ShelfManager.gui.ViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        scenes = new HashMap<>();
        ViewController controller;
        controller = new LagerConfigViewController(hauptLager, this);
        scenes.put(Scenes.LAGER_CONFIG_VIEW, controller.getRootView());
        controller = new LagerViewController(hauptLager, this);
        scenes.put(Scenes.LAGER_VIEW, controller.getRootView());

    }

    //------------------------JAVAFX---------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
            this.primaryStage = primaryStage;
            Pane root = new Pane();

            Scene scene = new Scene(root, 200, 400);
            this.primaryStage.setScene(scene);
            this.primaryStage.setTitle("ShelfManager");

            switchScene(Scenes.LAGER_CONFIG_VIEW);

            primaryStage.show();

    }

    public void switchScene(Scenes toScene) {
        Scene scene = primaryStage.getScene();

        if (scenes.containsKey(toScene)) {
            scene.setRoot(scenes.get(toScene));
        }
    }
}
