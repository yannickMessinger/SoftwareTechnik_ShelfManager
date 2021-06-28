package ShelfManager.gui.RegalConfigView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class RegalConfigView extends BorderPane {

    private Button backToLagerView;

    public RegalConfigView() {

        Label viewName = new Label("RegalConfigView");
        this.setTop(viewName);

        backToLagerView = new Button("zurueck");
        this.setBottom(backToLagerView);

    }

    public Button getBackToLagerView() {
        return backToLagerView;
    }
}
