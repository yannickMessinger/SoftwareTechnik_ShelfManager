package ShelfManager.gui.RegalConfigView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class RegalConfigView extends BorderPane {

    private VBox inputBox;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private TextField stuetzenhoeheTextField;
    private TextField stuetzenbreiteTextField;
    private Button submit;
    private Button backToLagerView;

    public RegalConfigView() {

        Label viewName = new Label("RegalConfigView");
        this.setTop(viewName);

        inputBox = new VBox();
        Label hoeheLabel = new Label("Regalhoehe:");
        this.hoeheTextField = new TextField();
        Label breiteLabel = new Label("Regalbreite:");
        this.breiteTextField = new TextField();

        Label stuetzenhoeheLabel = new Label("Stuetzenhoehe:");
        this.stuetzenhoeheTextField = new TextField();
        Label stuetzenbreiteLabel = new Label("Stuetzenbreite:");
        this.stuetzenbreiteTextField = new TextField();

        this.submit = new Button("Einlegeboeden hinzufuegen");

        inputBox.getChildren().addAll(hoeheLabel, hoeheTextField, breiteLabel, breiteTextField,
                stuetzenhoeheLabel, stuetzenhoeheTextField, stuetzenbreiteLabel, stuetzenbreiteTextField, submit);
        this.setCenter(inputBox);

        backToLagerView = new Button("zurueck");
        this.setBottom(backToLagerView);

    }

    public VBox getInputBox() {
        return inputBox;
    }

    public TextField getHoeheTextField() {
        return hoeheTextField;
    }

    public TextField getBreiteTextField() {
        return breiteTextField;
    }

    public TextField getStuetzenhoeheTextField() {
        return stuetzenhoeheTextField;
    }

    public TextField getStuetzenbreiteTextField() {
        return stuetzenbreiteTextField;
    }

    public Button getSubmit() {
        return submit;
    }

    public Button getBackToLagerView() {
        return backToLagerView;
    }

}
