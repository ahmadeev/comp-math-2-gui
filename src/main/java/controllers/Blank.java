package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import math.equations.Equations;

import java.net.URL;
import java.util.ResourceBundle;

import static controllers.single.ResultPage.getEquationByNumber;
import static main.gui.Main.data;
import static math.utils.Utils.exit;

public class Blank implements Initializable {
    @FXML
    LineChart<Number, Number>  graph;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        double a = data.getLowerBoundary();
        double b = data.getHigherBoundary();
        double step = data.getPrecision();

        Equations equation = getEquationByNumber(data.getObjectCode());

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        //series.setName("Функция");

        while (b > a) {
            if (equation == null) exit("", 1);
            series.getData().add(new XYChart.Data<>(a, equation.getEquationValue(a)));
            a += step;
        }

        graph.getData().add(series);
    }
}
