package controllers;

import math.groups.GroupOne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import math.groups.GroupTwo;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.loadScene;
import static main.gui.Main.primaryStage;

public class GroupChoose implements Initializable {
    @FXML
    Label sL1, sL2;
    @FXML
    Button sB1, sB2;

    @FXML
    private void handleObjectButtonClick(ActionEvent event) {
        var src = event.getSource();
        if (src == sB1) {
            loadScene(primaryStage, "group-one-menu.fxml", "group");
        } else if (src == sB2) {
            loadScene(primaryStage, "group-two-menu.fxml", "group");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GroupOne groupOne = new GroupOne();
        GroupTwo groupTwo = new GroupTwo();
        sL1.setText(groupOne.toString());
        sL2.setText(groupTwo.toString());
    }
}
