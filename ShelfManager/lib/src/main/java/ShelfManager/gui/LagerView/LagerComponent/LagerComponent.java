package ShelfManager.gui.LagerView.LagerComponent;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class LagerComponent extends Pane {

    public LagerComponent() {
        this.setStyle("-fx-background-color: rgba(200, 255, 150, 1)");
        this.setPadding(new Insets(20,20,20,20));
        this.setMaxWidth(Double.MAX_VALUE);
        this.setHeight(Double.MAX_VALUE);
    }
}
