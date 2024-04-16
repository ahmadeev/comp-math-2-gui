package controllers.group;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import math.groups.GroupOne;
import math.groups.GroupOutput;
import math.groups.GroupTwo;
import utils.GroupData;

import java.util.Arrays;

import static java.util.Objects.isNull;
import static main.gui.Main.*;
import static math.utils.Utils.showAlert;

public class GroupTwoHandler {
    private static double[] x = null;
    private static double[] dx = null;
    private static int counter = 0;
    private static String message = "";
    private static String xMessage = "";

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
            GroupTwo groupTwo = new GroupTwo();
            GroupOutput result = groupTwo.solveSystem(groupTwo, groupData.getGroupData().get(0), groupData.getGroupData().get(1));
            x = result.getX();
            dx = result.getDx();
            counter = result.getCounter();
            message = "Число итераций: " + counter +
                    "\nОжидаемые корни: " + groupTwo.getRoots() +
                    "\nВычисленные корни: " + Arrays.toString(x) +
                    "\nПогрешность: " + Arrays.toString(dx);
            /*for(int i = 0; i < x.length; i++) {
                    xMessage += String.format("x%d: %.4f\n", i, x[i]);
                }*/

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
