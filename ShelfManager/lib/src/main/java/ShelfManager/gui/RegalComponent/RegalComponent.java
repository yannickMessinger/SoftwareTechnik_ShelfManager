package ShelfManager.gui.RegalComponent;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class RegalComponent extends Pane {

    private Label regalName;
    private Line stuetzeLeft;
    private Line stuetzeRight;

    public RegalComponent() {

        this.setStyle("-fx-background-color: rgba(120, 140, 120, 1)");
        this.regalName = new Label("Regal");
        this.stuetzeLeft = new Line();
        this.stuetzeRight = new Line();

        this.getChildren().addAll(regalName, stuetzeLeft, stuetzeRight);

    }

    public Line getStuetzeLeft() {
        return stuetzeLeft;
    }

    public Line getStuetzeRight() {
        return stuetzeRight;
    }
}
