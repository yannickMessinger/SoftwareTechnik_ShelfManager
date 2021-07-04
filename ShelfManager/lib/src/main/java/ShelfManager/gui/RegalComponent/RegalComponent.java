package ShelfManager.gui.RegalComponent;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class RegalComponent extends Pane {

    private Line stuetzeLeft;
    private Line stuetzeRight;

    public RegalComponent() {

        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.stuetzeLeft = new Line();
        this.stuetzeRight = new Line();

        this.getChildren().addAll(stuetzeLeft, stuetzeRight);

    }

    public Line getStuetzeLeft() {
        return stuetzeLeft;
    }

    public Line getStuetzeRight() {
        return stuetzeRight;
    }
}
