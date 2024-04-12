package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import math.utils.MathPOJOHalving;
import math.utils.Methods;

import java.net.URL;
import java.util.ResourceBundle;

public class ResultPageHalving extends ResultController implements Initializable {

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


}
