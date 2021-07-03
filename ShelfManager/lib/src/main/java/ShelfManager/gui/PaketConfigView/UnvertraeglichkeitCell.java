package ShelfManager.gui.PaketConfigView;


import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class UnvertraeglichkeitCell extends ListCell<Color> {
    HBox root;
    Rectangle unvertraeglichRect;

    public UnvertraeglichkeitCell(){
        root = new HBox();
        unvertraeglichRect = new Rectangle(20,20);
        root.getChildren().add(unvertraeglichRect);
        this.setGraphic(root);
    }



    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {

            unvertraeglichRect.setFill(item);

            this.setGraphic(root);
        } else {
            this.setGraphic(null);
        }
    }
}
