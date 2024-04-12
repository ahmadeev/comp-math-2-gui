package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import math.utils.MathPOJONewton;
import math.utils.Methods;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.data;

public class ResultPageNewton implements Initializable {
    @FXML
    TableView<MathPOJONewton> dataTable;
    @FXML
    private TableColumn<MathPOJONewton, Integer> counter;
    @FXML
    private TableColumn<MathPOJONewton, Double> prevX;
    @FXML
    private TableColumn<MathPOJONewton, Double> prevXValue;
    @FXML
    private TableColumn<MathPOJONewton, Double> prevXDerValue;
    @FXML
    private TableColumn<MathPOJONewton, Double> x;
    @FXML
    private TableColumn<MathPOJONewton, Double> step;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //  важный
        counter.setCellValueFactory(new PropertyValueFactory<MathPOJONewton, Integer>("counter"));
        prevX.setCellValueFactory(new PropertyValueFactory<MathPOJONewton, Double>("prevX"));
        prevXValue.setCellValueFactory(new PropertyValueFactory<MathPOJONewton, Double>("prevXValue"));
        prevXDerValue.setCellValueFactory(new PropertyValueFactory<MathPOJONewton, Double>("prevXDerValue"));
        x.setCellValueFactory(new PropertyValueFactory<MathPOJONewton, Double>("x"));
        step.setCellValueFactory(new PropertyValueFactory<MathPOJONewton, Double>("step"));

        dataTable.setItems(Methods.Newton.newtonData);
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
