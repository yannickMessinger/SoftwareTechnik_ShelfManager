package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class PaketCell extends ListCell<Paket> {

    HBox root;
    Label paketnameLabel;

    public PaketCell() {
        root = new HBox();
        paketnameLabel = new Label();
        root.getChildren().addAll(paketnameLabel);
        this.setGraphic(root);
    }

    @Override
    protected void updateItem(Paket item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {
            paketnameLabel.setText(item.getPaketName());

            this.setGraphic(root);
        } else {
            this.setGraphic(null);
        }
    }
}
