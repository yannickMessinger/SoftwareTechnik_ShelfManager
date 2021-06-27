package ShelfManager.gui.LagerConfigView;

import ShelfManager.gui.ViewController;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LagerConfigViewController extends ViewController {

    private LagerConfigView lagerConfigView;
    private TextField hoeheTextField;
    private TextField breiteTextField;
    private Button submit;

    public LagerConfigViewController() {
        this.lagerConfigView = new LagerConfigView();
        this.hoeheTextField = lagerConfigView.getHoeheTextField();
        this.breiteTextField = lagerConfigView.getBreiteTextField();
        this.submit = lagerConfigView.getSubmit();

        rootView = this.lagerConfigView;
    }

    @Override
    public void initialize() {
        submit.addEventHandler(ActionEvent.ACTION, event -> {System.out.println("submit");});
    }

    public Pane getRootView() {
        return rootView;
    }

}
