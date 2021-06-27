package ShelfManager;

import ShelfManager.Lager.Command;
import ShelfManager.Lager.Lager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ShelfManagerApplication extends Application {
    //private Map<Scenes, Pane> scenes;
    private Stage primaryStage;


    public static void main(String[] args) {
        launch(args);
    }



    //------------------------JAVAFX---------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
            Pane root = new Pane();

            Scene scene = new Scene(root, 1600, 900);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ShelfManager");
            primaryStage.show();

    }
}
