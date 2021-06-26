package ShelfManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ShelfManagerApplication extends Application {
    //private Map<Scenes, Pane> scenes;
    private Stage primaryStage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
            Pane root = new Pane();

            Scene scene = new Scene(root, 300, 200);
            primaryStage.setScene(scene);
            primaryStage.setTitle("ShelfManager");
            primaryStage.show();

    }
}
