package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import math.utils.MathPOJO;
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
    @FXML
    public Button showInfoButton;

    @FXML
    TableView<MathPOJO> dataTable;
    @FXML
    private TableColumn<MathPOJO, Integer> counter;
    @FXML
    private TableColumn<MathPOJO, Double> a;
    @FXML
    private TableColumn<MathPOJO, Double> b;
    @FXML
    private TableColumn<MathPOJO, Double> x;
    @FXML
    private TableColumn<MathPOJO, Double> aValue;
    @FXML
    private TableColumn<MathPOJO, Double> bValue;
    @FXML
    private TableColumn<MathPOJO, Double> step;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //  важный
        counter.setCellValueFactory(new PropertyValueFactory<MathPOJO, Integer>("counter"));
        a.setCellValueFactory(new PropertyValueFactory<MathPOJO, Double>("a"));
        b.setCellValueFactory(new PropertyValueFactory<MathPOJO, Double>("b"));
        x.setCellValueFactory(new PropertyValueFactory<MathPOJO, Double>("x"));
        aValue.setCellValueFactory(new PropertyValueFactory<MathPOJO, Double>("aValue"));
        bValue.setCellValueFactory(new PropertyValueFactory<MathPOJO, Double>("bValue"));
        step.setCellValueFactory(new PropertyValueFactory<MathPOJO, Double>("step"));

        dataTable.setItems(Methods.Halving.halvingData);

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
}
