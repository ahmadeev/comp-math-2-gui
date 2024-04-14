package main.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import math.equations.*;
import math.equations.Equations;
import utils.InputData;

import java.io.IOException;

public class Main extends Application {
    public static InputData data = new InputData();
    public static Stage primaryStage;
    public static void loadScene(Stage stage, String resource, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(resource));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Сцена отображена!");
    }

    @Override
    public void start(Stage stage) throws IOException {
/*        primaryStage = stage;
        loadScene(stage, "mode-select.fxml", "solving equations");*/

        Stage graphStage = new Stage();

        double HEIGHT = 600;
        double WIDTH = 600;

        Equations equation = new EquationOne();

        Group graphGroup = new Group();

/*        getAxis(graphGroup, WIDTH, HEIGHT, -1.76, -2, -1);
        getPlot(graphGroup, equation, WIDTH, HEIGHT, -1.76, -2, -1);*/

        getAxis(graphGroup, WIDTH, HEIGHT, 5, -15, 10);
        getPlot(graphGroup, equation, WIDTH, HEIGHT, -8, -10, -6);

        Scene graphScene = new Scene(graphGroup, HEIGHT, WIDTH);
        graphStage.setScene(graphScene);
        graphStage.show();
    }

    public double func(double x) {
        return (Math.sin(x));
    }

    public void getAxis(Group group, double width, double height, double root, double a, double b) {
        double offset = width / 2 - getXToPixels(root, width, height, a, b);
        group.getChildren().addAll(
                new Line(0, height / 2, width, height / 2),
                new Line(width / 2  + offset, 0, width / 2  + offset, height)
        );
    }

    /*public void getPlot(Group group, double width, double height, double a, double b) {
        for (double i = 0; i < width; i++) {
            group.getChildren().add(
                    new Line(
                            i,
                            getYToPixels(func(getXFromPixels(i, width, height, a, b)), width, height, a, b),
                            i + 1,
                            getYToPixels(func(getXFromPixels(i+1, width, height, a, b)), width, height, a, b)
                    )
            );
        }
    }*/

    public void getPlot(Group group, Equations equation, double width, double height, double root, double a, double b) {
        for (double i = 0; i < width; i++) {
            group.getChildren().add(
                    new Line(
                            i,
                            getYToPixels(equation.getEquationValue(getXFromPixels(i, width, height, a, b)), width, height, a, b),
                            i + 1,
                            getYToPixels(equation.getEquationValue(getXFromPixels(i+1, width, height, a, b)), width, height, a, b)
                    )
            );
        }
    }

/*    public double getXToPixels(double x, double width, double height, double a, double b) {
        return (width / (b - a) * (x + (b - a) / 2));
    }*/

    public double getYToPixels(double y, double width, double height, double a, double b) {
        return (width / (b - a) * (-y + (b - a) / 2));
    }

    public double getXFromPixels(double x, double width, double height, double a, double b) {
        return (x / (width / (b - a)) - (b - a) / 2);
    }

    public double getYFromPixels(double x, double width, double height, double a, double b) {
        return -(x / (width / (b - a)) - (b - a) / 2);
    }

    public double getXToPixels(double x, double width, double height, double a, double b) {
        return (width / (b - a) * (x - a));
    }

/*    public double getYToPixels(double y, double width, double height, double a, double b) {
        return (width / (b - a) * (-y - a));
    }

    public double getXFromPixels(double x, double width, double height, double a, double b) {
        return (x / (width / (b - a)) + a);
    }

    public double getYFromPixels(double x, double width, double height, double a, double b) {
        return -(x / (width / (b - a)) + a);
    }*/

    public static void main(String[] args) {
        launch();
    }
}