package controllers.group;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import static java.util.Objects.isNull;
import static main.gui.Main.*;
import static math.utils.Methods.Halving.halvingData;
import static math.utils.Methods.Iteration.iterationData;
import static math.utils.Methods.Newton.newtonData;
import static math.utils.Utils.showAlert;

import javafx.stage.Stage;
import math.groups.GroupOne;
import utils.GroupData;
import utils.InputData;

public class GroupOneHandler {
    @FXML
    TextField xTF0, xTF1;

    @FXML
    private void handleSubmitButtonClick() {
        String x1 = validateNumber(xTF0.getText());
        String x2 = validateNumber(xTF1.getText());

        boolean flag = true;

        if (!isNull(x1) && !isNull(x2)) {
            groupData.getGroupData().add(Double.parseDouble(x1));
            groupData.getGroupData().add(Double.parseDouble(x2));
        } else flag = false;

        if (!flag) {
            showAlert(Alert.AlertType.ERROR, "Ошибка ввода", "Неправильно введены приближения!");
        } else {
            GroupOne groupOne = new GroupOne();
            double[] x = groupOne.solveSystem(groupOne);
            String message = "";
            for(int i = 0; i < x.length; i++) {
                message += String.format("x%d: %.4f\n", i, x[i]);
            }
            showAlert(Alert.AlertType.INFORMATION, "Решение системы", message);
        }
    }

    @FXML
    private void handleExitButton() {
        System.exit(0);
    }

    @FXML
    private void handleNewButton() {
        groupData = new GroupData();
        graphStage.close();
        graphStage = new Stage();
        loadScene(primaryStage, "mode-select.fxml", "solving equations");
    }

    private String validateNumber(String text) {
        text = text.replace(",", ".");
        if (text.matches("[+-]?([0-9]*[.])?[0-9]+")) {
            return text;
        } else {
            return null;
        }
    }
}
