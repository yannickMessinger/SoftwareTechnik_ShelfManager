package ShelfManager.gui.RegalConfigView.EinlegebodenList;

import ShelfManager.Lager.Einlegeboden;
import ShelfManager.Lager.Paket;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class EinlegebodenCell extends ListCell<Einlegeboden> {
    private VBox root;

    private Label hoeheLabel;
    private Label traglastLabel;

    public EinlegebodenCell() {
        root = new VBox();
        hoeheLabel = new Label("Hoehe:");
        traglastLabel = new Label("Traglast:");

        root.getChildren().addAll(hoeheLabel, traglastLabel);
        this.setGraphic(root);

    }

    @Override
    protected void updateItem(Einlegeboden item, boolean empty) {
        super.updateItem(item, empty);

        if (!empty) {
            hoeheLabel.setText("Hoehe: " + item.getHoehe());
            traglastLabel.setText("Tragkraft: " + item.getTragkraft());
            root.setPadding(new Insets(10));
            root.setSpacing(5);
            this.setGraphic(root);
        } else {
            this.setGraphic(null);
        }
    }

}
