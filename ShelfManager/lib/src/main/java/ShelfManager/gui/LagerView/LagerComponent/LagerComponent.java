package ShelfManager.gui.LagerView.LagerComponent;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class LagerComponent extends HBox {

    public LagerComponent() {
        this.setStyle("-fx-background-color: rgba(200,50,20,1);");
        this.setPadding(new Insets(20,20,20,20));
        HBox.setHgrow(this, Priority.ALWAYS);
    }
}
