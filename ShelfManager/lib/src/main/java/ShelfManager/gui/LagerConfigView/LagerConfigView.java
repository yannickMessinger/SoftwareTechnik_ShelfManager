package ShelfManager.gui.LagerConfigView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LagerConfigView extends BorderPane {

    private TextField hoeheTextField;
    private TextField breiteTextField;

    private Button submit;

    public LagerConfigView() {

            Label viewName = new Label("Neues Lager");
            this.setTop(viewName);


            //height----------------
            Label hoeheLabel = new Label("Hoehe:");
            this.hoeheTextField = new TextField();
            VBox hoeheBox = new VBox(hoeheLabel, hoeheTextField);

            //width-----------------
            Label breiteLabel = new Label("Breite:");
            this.breiteTextField = new TextField();
            VBox breiteBox = new VBox(breiteLabel, breiteTextField);

            //button-----------------
            this.submit = new Button("ok");
            VBox buttonBox = new VBox(submit);


            //fuer Anzeige setzen-------------------------
            VBox box = new VBox(hoeheBox, breiteBox, buttonBox);
            this.setCenter(box);

            //---STYLE-----------------------------------------
            box.setPadding(new Insets(100));
            box.setSpacing(20);

            hoeheBox.setSpacing(10);
            breiteBox.setSpacing(10);
            buttonBox.setAlignment(Pos.CENTER_RIGHT);

            viewName.setPadding(new Insets(20, 100, 20, 100));
        this.getStyleClass().addAll("background");
    }

    public TextField getHoeheTextField() {
        return hoeheTextField;
    }

    public TextField getBreiteTextField() {
        return breiteTextField;
    }

    public Button getSubmit() {
        return submit;
    }
}
