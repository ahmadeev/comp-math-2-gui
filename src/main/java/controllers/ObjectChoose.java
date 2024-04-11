package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import math.equations.EquationFour;
import math.equations.EquationOne;
import math.equations.EquationThree;
import math.equations.EquationTwo;

import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;
import static main.gui.Main.data;
import static main.gui.Main.loadScene;
import static math.utils.Utils.exit;

public class ObjectChoose implements Initializable {
    @FXML
    public Button ocB0, ocB1, ocB2, ocB3;
    @FXML
    public Label ocL0, ocL1, ocL2, ocL3;
    @FXML
    public Button mcB0, mcB1, mcB2;
    @FXML
    public Label mcL0, mcL1, mcL2;
    @FXML
    public Button sB;
    @FXML
    public TextField dTF0, dTF1, dTF2;

    @FXML
    protected void handleObjectButtonClick(ActionEvent event) {
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
        data.setLowerBoundary(validateBoundary(dTF0.getText()));
        data.setHigherBoundary(validateBoundary(dTF1.getText()));
        data.setPrecision(validatePrecision(dTF2.getText()));

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        loadScene(stage, "result-page.fxml", "solving equations");
    }

    private double validateBoundary(String text) {
        text = text.replace(",", ".");
        if (text.matches("[+-]?([0-9]*[.])?[0-9]+")) {
            return Double.parseDouble(text);
        } else {
            exit("Введенное число не соответствует паттерну!", 1);
            return 0;
        }
    }

    private double validatePrecision(String text) {
        text = text.replace(",", ".");
        if (text.matches("0[.]0*1")) {
            return Double.parseDouble(text);
        } else {
            exit("Введенное число не соответствует паттерну!", 1);
            return 0;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ocL0.setText(EquationOne.EQUATION);
        ocL1.setText(EquationTwo.EQUATION);
        ocL2.setText(EquationThree.EQUATION);
        ocL3.setText(EquationFour.EQUATION);

        mcL0.setText("Половинного деления");
        mcL1.setText("Ньютона");
        mcL2.setText("Простой итерации");
    }
}