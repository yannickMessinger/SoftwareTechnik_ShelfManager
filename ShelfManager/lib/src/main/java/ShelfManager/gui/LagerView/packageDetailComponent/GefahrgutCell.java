package ShelfManager.gui.LagerView.packageDetailComponent;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class GefahrgutCell extends ListCell<String> {
    HBox root;
    Label gefahrgutLabel;


    public GefahrgutCell(){
        root = new HBox();
        gefahrgutLabel = new Label("");
        root.getChildren().add(gefahrgutLabel);
        this.setGraphic(root);
    }


    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {

            gefahrgutLabel.setText(item);

            this.setGraphic(root);
        } else {
            this.setGraphic(null);
        }
    }
}
