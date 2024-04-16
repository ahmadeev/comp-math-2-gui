package controllers;

import controllers.group.GroupOneHandler;
import controllers.group.GroupTwoHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import math.equations.Equations;
import math.groups.GroupOne;
import math.groups.GroupOutput;
import math.groups.GroupTwo;
import math.groups.Groups;
import utils.GroupData;

import java.net.URL;
import java.util.ResourceBundle;

import static controllers.single.ResultPage.getEquationByNumber;
import static java.lang.Math.abs;
import static java.util.Objects.isNull;
import static main.gui.Main.data;
import static main.gui.Main.groupData;
import static math.utils.Utils.exit;

public class Blank implements Initializable {
    @FXML
    LineChart<Number, Number>  graph;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (data.getProgrammeMode() == 1) {
            double a = data.getLowerBoundary();
            double b = data.getHigherBoundary();
            double step = data.getPrecision();

            Equations equation = getEquationByNumber(data.getObjectCode());

            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            //series.setName("Функция");

            while (b > a) {
                if (isNull(equation)) {
                    exit("", 1);
                    break;
                }
                series.getData().add(new XYChart.Data<>(a, equation.getEquationValue(a)));
                a += step;
            }
            graph.setCreateSymbols(false);
            graph.getData().add(series);
        } else if (data.getProgrammeMode() == 2) {
            double a = 0;
            double b = 0;
            double step = 0.01;
            GroupOutput groupOutput = null;
            Groups group = null;

            if (groupData.getObjectNumber() == 1) {
                groupOutput = GroupOneHandler.getGroupOutput();
                group = new GroupOne();
            } else if (groupData.getObjectNumber() == 2) {
                groupOutput = GroupTwoHandler.getGroupOutput();
                group = new GroupTwo();
            } else {
                exit("", 1);
            }

            if (!isNull(groupOutput)) {
                a = groupOutput.getX()[0] - 0.5;
                b = groupOutput.getX()[0] + 0.5;
                //b = groupOutput.getX()[1] + 0.5;
            }

            math.groups.Equations[] equations = group.getEquations();

            math.groups.Equations equationOne = equations[0];
            math.groups.Equations equationTwo = equations[1];

            XYChart.Series<Number, Number> seriesOne = new XYChart.Series<>();
            XYChart.Series<Number, Number> seriesTwo = new XYChart.Series<>();

            if (a == 0 && b == 0) exit("", 1);

            if (isNull(equationOne) || isNull(equationTwo)) {
                exit("", 1);
            } else {
                while (b > a) {
                    seriesOne.getData().add(new XYChart.Data<>(a, equationOne.getEquationValueForPlot(a)));
                    seriesTwo.getData().add(new XYChart.Data<>(a, equationTwo.getEquationValueForPlot(a)));
                    a += step;
                }
            }

            graph.setCreateSymbols(false);
            graph.getData().add(seriesOne);
            graph.getData().add(seriesTwo);

        } else {
            exit("", 1);
        }

    }
}
