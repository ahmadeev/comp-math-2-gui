package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.data;

public class ResultPage implements Initializable {
    @FXML
    public Label rpL0, rpL1, rpL2;
    @FXML
    public Label rpL3, rpL4, rpL5;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rpL0.setText("programmeMode: " + data.getProgrammeMode());
        rpL1.setText("objectCode: " + data.getObjectCode());
        rpL2.setText("methodNumber: " + data.getMethodNumber());
        rpL3.setText("lowerBoundary: " + data.getLowerBoundary());
        rpL4.setText("higherBoundary: " + data.getHigherBoundary());
        rpL5.setText("precision: " + data.getPrecision());
    }

}
