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
    @FXML
    public Button mcB0, mcB1, mcB2;
    @FXML
    public Button sB;

    @FXML
    protected void handleObjectButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == ocB0) {
            data.setObjectCode(1);
        } else if (event.getSource() == ocB1) {
            data.setObjectCode(2);
        } else if (event.getSource() == ocB2) {
            data.setObjectCode(3);
        } else if (event.getSource() == ocB3) {
            data.setObjectCode(4);
        }
    }

    @FXML
    protected void handleMethodButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == mcB0) {
            data.setMethodNumber(1);
        } else if (event.getSource() == ocB1) {
            data.setMethodNumber(2);
        } else if (event.getSource() == mcB2) {
            data.setMethodNumber(3);
        }
    }

    @FXML
    protected void handleSubmitButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        loadScene(stage, "result-page.fxml", "solving equations");
    }
}