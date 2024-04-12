package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import math.utils.MathPOJOHalving;
import math.utils.Methods;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.data;

public class ResultPageHalving implements Initializable {

    @FXML
    TableView<MathPOJOHalving> dataTable;
    @FXML
    private TableColumn<MathPOJOHalving, Integer> counter;
    @FXML
    private TableColumn<MathPOJOHalving, Double> a;
    @FXML
    private TableColumn<MathPOJOHalving, Double> b;
    @FXML
    private TableColumn<MathPOJOHalving, Double> x;
    @FXML
    private TableColumn<MathPOJOHalving, Double> aValue;
    @FXML
    private TableColumn<MathPOJOHalving, Double> bValue;
    @FXML
    private TableColumn<MathPOJOHalving, Double> step;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //  важный
        counter.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Integer>("counter"));
        a.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Double>("a"));
        b.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Double>("b"));
        x.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Double>("x"));
        aValue.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Double>("aValue"));
        bValue.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Double>("bValue"));
        step.setCellValueFactory(new PropertyValueFactory<MathPOJOHalving, Double>("step"));

        dataTable.setItems(Methods.Halving.halvingData);
        System.out.println("meow");
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
