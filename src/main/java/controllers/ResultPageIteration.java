package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import math.utils.MathPOJOIteration;
import math.utils.Methods;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.data;

public class ResultPageIteration implements Initializable {
    @FXML
    TableView<MathPOJOIteration> dataTable;
    @FXML
    private TableColumn<MathPOJOIteration, Integer> counter;
    @FXML
    private TableColumn<MathPOJOIteration, Double> prevX;
    @FXML
    private TableColumn<MathPOJOIteration, Double> x;
    @FXML
    private TableColumn<MathPOJOIteration, Double> xPhi;
    @FXML
    private TableColumn<MathPOJOIteration, Double> xValue;
    @FXML
    private TableColumn<MathPOJOIteration, Double> step;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //  важный
        counter.setCellValueFactory(new PropertyValueFactory<MathPOJOIteration, Integer>("counter"));
        prevX.setCellValueFactory(new PropertyValueFactory<MathPOJOIteration, Double>("prevX"));
        x.setCellValueFactory(new PropertyValueFactory<MathPOJOIteration, Double>("x"));
        xPhi.setCellValueFactory(new PropertyValueFactory<MathPOJOIteration, Double>("xPhi"));
        xValue.setCellValueFactory(new PropertyValueFactory<MathPOJOIteration, Double>("xValue"));
        step.setCellValueFactory(new PropertyValueFactory<MathPOJOIteration, Double>("step"));

        dataTable.setItems(Methods.Iteration.iterationData);
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
