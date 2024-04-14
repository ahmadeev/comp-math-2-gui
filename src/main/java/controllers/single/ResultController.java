package controllers.single;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import utils.InputData;

import static main.gui.Main.*;
import static math.utils.Methods.Halving.halvingData;
import static math.utils.Methods.Newton.newtonData;
import static math.utils.Methods.Iteration.iterationData;
import static math.utils.Utils.showAlert;

public abstract class ResultController {
    @FXML
    private void handleShowInfoButton() {
/*        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("invocation info");
        alert.setHeaderText(null);

        String content =
                "Режим работы программы: " + data.getProgrammeMode() + "\n" +
                "Выбранный объект: " + data.getObjectCode() + "\n" +
                "Номер метода: " + data.getMethodNumber() + "\n" +
                "Отрезок: [" + data.getLowerBoundary() + ", " + data.getHigherBoundary() + "]\n" +
                "Точность: " + data.getPrecision() + "\n";

        alert.setContentText(content);
        alert.showAndWait();*/

        String message = "Режим работы программы: " + data.getProgrammeMode() + "\n" +
                "Выбранный объект: " + data.getObjectCode() + "\n" +
                "Номер метода: " + data.getMethodNumber() + "\n" +
                "Отрезок: [" + data.getLowerBoundary() + ", " + data.getHigherBoundary() + "]\n" +
                "Точность: " + data.getPrecision() + "\n";
        showAlert(Alert.AlertType.INFORMATION, "invocation info", message);
    }

    @FXML
    private void handleExitButton() {
        System.exit(0);
    }

    @FXML
    private void handleNewButton() {
        data = new InputData();
        halvingData = FXCollections.observableArrayList();
        newtonData = FXCollections.observableArrayList();
        iterationData = FXCollections.observableArrayList();
        graphStage.close();
        graphStage = new Stage();
        loadScene(primaryStage, "mode-select.fxml", "solving equations");
    }
}
