package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import math.equations.EquationFour;
import math.equations.EquationOne;
import math.equations.EquationThree;
import math.equations.EquationTwo;

import java.net.URL;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;
import static main.gui.Main.data;

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
    public Label inputErrorLabel;
    @FXML
    public TextField dTF0, dTF1, dTF2;
    @FXML
    public Label chosenObject, chosenMethod;

    @FXML
    protected void handleObjectButtonClick(ActionEvent event) {
        if (event.getSource() == ocB0) {
            data.setObjectCode(1);
            chosenObject.setText("Выбранное уравнение: \n" + EquationOne.EQUATION + "\nКорни уравнения: \n" + EquationOne.ROOTS);
        } else if (event.getSource() == ocB1) {
            data.setObjectCode(2);
            chosenObject.setText("Выбранное уравнение: \n" + EquationTwo.EQUATION + "\nКорни уравнения: \n" + EquationTwo.ROOTS);
        } else if (event.getSource() == ocB2) {
            data.setObjectCode(3);
            chosenObject.setText("Выбранное уравнение: \n" + EquationThree.EQUATION + "\nКорни уравнения: \n" + EquationThree.ROOTS);
        } else if (event.getSource() == ocB3) {
            data.setObjectCode(4);
            chosenObject.setText("Выбранное уравнение: \n" + EquationFour.EQUATION + "\nКорни уравнения: \n" + EquationFour.ROOTS);
        }
    }

    @FXML
    protected void handleMethodButtonClick(ActionEvent event) {
        if (event.getSource() == mcB0) {
            data.setMethodNumber(1);
            chosenMethod.setText("Выбранный метод: \n" + "Половинного деления");
        } else if (event.getSource() == mcB1) {
            data.setMethodNumber(2);
            chosenMethod.setText("Выбранный метод: \n" + "Ньютона");
        } else if (event.getSource() == mcB2) {
            data.setMethodNumber(3);
            chosenMethod.setText("Выбранный метод: \n" + "Простой итерации");
        }
    }

    @FXML
    protected void handleSubmitButtonClick() {
        String lowerBoundary = validateBoundary(dTF0.getText());
        String higherBoundary = validateBoundary(dTF1.getText());
        String precision = validatePrecision(dTF2.getText());

        if (!(isNull(lowerBoundary) || isNull(higherBoundary) || isNull(precision))) {
            data.setLowerBoundary(Double.parseDouble(lowerBoundary));
            data.setHigherBoundary(Double.parseDouble(higherBoundary));
            data.setPrecision(Double.parseDouble(precision));
            ResultPage.invokeApp();
        } else {
            inputErrorLabel.setText("Неверный формат входных данных!");
        }
    }

    private String validateBoundary(String text) {
        text = text.replace(",", ".");
        if (text.matches("[+-]?([0-9]*[.])?[0-9]+")) {
            return text;
        } else {
            return null;
        }
    }

    private String validatePrecision(String text) {
        text = text.replace(",", ".");
        if (text.matches("0[.]0*1")) {
            return text;
        } else {
            return null;
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