package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static main.gui.Main.data;
import static main.gui.Main.loadScene;

public class ModeSelect {
    @FXML
    public Button msB0, msB1;

/*    public static int programmeMode = 0;

    public int getProgrammeMode() {
        return programmeMode;
    }*/

    @FXML
    protected void handleButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == msB0) {
//            programmeMode = 1;
            data.setProgrammeMode(1);
            loadScene(stage, "object-choose.fxml", "solving equations");
        } else if (event.getSource() == msB1) {
//            programmeMode = 2;
            data.setProgrammeMode(2);
            loadScene(stage, "group-choose.fxml", "solving equations");
        }
    }
}