package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import static main.gui.Main.data;

public abstract class ResultController {
    @FXML
    private void handleShowInfoButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("invocation info");
        alert.setHeaderText(null);

        String content =
                "programmeMode: " + data.getProgrammeMode() + "\n" +
                        "objectCode: " + data.getObjectCode() + "\n" +
                        "methodNumber: " + data.getMethodNumber() + "\n" +
                        "lowerBoundary: " + data.getLowerBoundary() + "\n" +
                        "higherBoundary: " + data.getHigherBoundary() + "\n" +
                        "precision: " + data.getPrecision() + "\n";

        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    public void exit() {
        System.exit(0);
    }
}
