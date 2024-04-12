package controllers;

import math.utils.Methods;

import math.equations.*;

import static main.gui.Main.*;
import static math.utils.Utils.exit;

public class ResultPage {

    public static void invokeApp() {
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
                    loadScene(primaryStage, "result-page-halving.fxml","solving equations");
                    break;
                }
                case 2: {
                    Methods.Newton.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    loadScene(primaryStage, "result-page-newton.fxml","solving equations");
                    break;
                }
                case 3: {
                    Methods.Iteration.getRoot(lowerBoundary, higherBoundary, precision, equation);
                    loadScene(primaryStage, "result-page-iteration.fxml","solving equations");
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
