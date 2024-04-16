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
import math.groups.GroupOutput;
import math.groups.GroupTwo;
import utils.GroupData;
import utils.InputData;

import java.util.ArrayDeque;
import java.util.Arrays;

public class GroupOneHandler {
    private static double[] x = null;
    private static double[] dx = null;
    private static int counter = 0;
    private static String message = "";
    private static String xMessage = "";
    private static GroupOutput groupOutput;

    @FXML
    TextField xTF0, xTF1;

    public static GroupOutput getGroupOutput() {
        return groupOutput;
    }

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
            groupOutput = groupOne.solveSystem(groupOne, groupData.getGroupData().get(0), groupData.getGroupData().get(1));
            x = groupOutput.getX();
            dx = groupOutput.getDx();
            counter = groupOutput.getCounter();
            message = "Число итераций: " + counter +
                    "\nОжидаемые корни: " + groupOne.getRoots() +
                    "\nВычисленные корни: " + Arrays.toString(x) +
                    "\nПогрешность: " + Arrays.toString(dx);
            /*for(int i = 0; i < x.length; i++) {
                    xMessage += String.format("x%d: %.4f\n", i, x[i]);
                }*/
            loadScene(graphStage, "blank.fxml", "graph");
            showAlert(Alert.AlertType.INFORMATION, "Решение системы", message);
            groupData = new GroupData();
        }
    }

    @FXML
    private void handleExitButton() {
        System.exit(0);
    }

    @FXML
    private void handleNewButton() {
        groupData = new GroupData();
        x = null;
        xMessage = "";
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
