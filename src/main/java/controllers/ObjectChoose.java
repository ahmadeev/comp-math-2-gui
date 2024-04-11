package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static main.gui.Main.data;
import static main.gui.Main.loadScene;

public class ObjectChoose {
    @FXML
    public Button ocB0, ocB1, ocB2, ocB3;

/*    public int objectNumber = 0;

    public int getObjectNumber() {
        return objectNumber;
    }*/

    @FXML
    protected void handleButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == ocB0) {
//            objectNumber = 1;
            data.setObjectCode(1);
            loadScene(stage, "result-page.fxml", "solving equations");
        } else if (event.getSource() == ocB1) {
//            objectNumber = 2;
            data.setObjectCode(2);
            loadScene(stage, "result-page.fxml", "solving equations");
        } else if (event.getSource() == ocB2) {
//            objectNumber = 2;
            data.setObjectCode(3);
            loadScene(stage, "result-page.fxml", "solving equations");
        } else if (event.getSource() == ocB3) {
//            objectNumber = 2;
            data.setObjectCode(4);
            loadScene(stage, "result-page.fxml", "solving equations");
        }
    }
}