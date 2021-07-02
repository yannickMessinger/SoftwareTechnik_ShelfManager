package ShelfManager.gui.PaketListComponent;

import ShelfManager.Lager.Paket;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class PaketCell extends ListCell<Paket> {

    HBox root;
    VBox rectangleBox;
    Label paketnameLabel;
    Rectangle paketColorRectangle;


    public PaketCell() {
        root = new HBox();
        rectangleBox = new VBox();
        paketColorRectangle = new Rectangle(50,50);
        rectangleBox.getChildren().add(paketColorRectangle);

        paketnameLabel = new Label();
        root.getChildren().addAll(rectangleBox,paketnameLabel);
        this.setGraphic(root);
    }

    @Override
    protected void updateItem(Paket item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {
            paketnameLabel.setText(item.getPaketName());
            paketColorRectangle.setFill(item.getFarbe());

            this.setGraphic(root);
        } else {
            this.setGraphic(null);
        }
    }
}
