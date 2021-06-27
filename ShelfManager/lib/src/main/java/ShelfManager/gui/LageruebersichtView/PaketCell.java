package ShelfManager.gui.LageruebersichtView;

import ShelfManager.Lager.Paket;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class PaketCell extends ListCell<Paket> {

    HBox root;
    Label paketnameLabel;
    Label regalNrLabel;
    Label fachNrLabel;

    public PaketCell() {
        root = new HBox();

        paketnameLabel = new Label();
        regalNrLabel = new Label();
        fachNrLabel = new Label();
        root.getChildren().addAll(paketnameLabel, regalNrLabel, fachNrLabel);
        this.setGraphic(root);
    }

    @Override
    protected void updateItem(Paket item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {
            paketnameLabel.setText(item.getName());
            // TODO: regalNr & fachNr

            this.setGraphic(root);
        } else {
            this.setGraphic(null);
        }
    }
}
