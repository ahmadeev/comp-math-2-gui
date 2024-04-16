package controllers;

import math.groups.GroupOne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.loadScene;
import static main.gui.Main.primaryStage;

public class GroupChoose implements Initializable {
    @FXML
    Label sL1, sL2, sL3;
    @FXML
    Button sB1, sB2, sB3;

    @FXML
    private void handleObjectButtonClick(ActionEvent event) {
        var src = event.getSource();
        if (src == sB1) {
            loadScene(primaryStage, "group-one-menu.fxml", "group");
        } else if (src == sB2) {

        } else if (src == sB3) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GroupOne groupOne = new GroupOne();
        sL1.setText(groupOne.toString());
    }
}
