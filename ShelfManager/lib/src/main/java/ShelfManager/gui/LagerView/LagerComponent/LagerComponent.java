package ShelfManager.gui.LagerView.LagerComponent;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Line;

public class LagerComponent extends HBox {

    public LagerComponent() {
        this.setPadding(new Insets(20,20,20,20));
        HBox.setHgrow(this, Priority.ALWAYS);
    }
}
