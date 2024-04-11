package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import utils.InputData;
import math.utils.Methods;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.data;
import math.equations.*;

import static math.utils.Utils.exit;

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

        int programmeMode = data.getProgrammeMode();
        int objectCode = data.getObjectCode();
        int methodNumber = data.getMethodNumber();

        if (programmeMode == 1) {
            Equations equation = null;
            switch(objectCode) {
                case 1: {
                    equation = new EquationOne();
                    break;
                }
                case 2: {
                    equation = new EquationTwo();
                    break;
                }
                case 3: {
                    equation = new EquationThree();
                    break;
                }
                case 4: {
                    equation = new EquationFour();
                    break;
                }
                default: {
                    exit("Выбранного уравнения не существует!",1);
                }
            }

            double lowerBoundary = 0;
            double higherBoundary = 0;
            double precision = 0;

            lowerBoundary = data.getLowerBoundary();
            higherBoundary = data.getHigherBoundary();
            precision = data.getPrecision();

            if (lowerBoundary == 0 && higherBoundary == 0 || precision == 0) exit("",1);

            switch(methodNumber) {
                case 1: {
                    Methods.Halving.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                case 2: {
                    Methods.Newton.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                case 3: {
                    Methods.Iteration.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    break;
                }
                default: {
                    exit("Выбранного метода решения нелинейного уравнения не существует!",1);
                }
            }
        } else if (programmeMode == 2) {
            //  poka nichego
        } else {
            exit("Выбранного сценария работы программы не существует!",1);
        }
    }

}
