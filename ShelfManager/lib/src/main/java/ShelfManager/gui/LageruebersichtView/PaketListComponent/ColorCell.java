package ShelfManager.gui.LageruebersichtView.PaketListComponent;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;

public class ColorCell extends ListCell<Color> {


    @Override
    protected void updateItem(Color item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || empty) {
            setGraphic(null);
        } else {
            int r = (int)(item.getRed()*255);
            int g = (int)(item.getGreen()*255);
            int b = (int)(item.getBlue()*255);

            setText("rgb("+r+","+g+","+b+")");
            setStyle("-fx-control-inner-background: rgb("+r+","+g+","+b+");");

        }
    }
}
