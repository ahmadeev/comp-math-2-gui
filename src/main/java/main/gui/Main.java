package main.gui;

import math.groups.GroupOne;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.InputData;

import java.io.IOException;

import static java.lang.Math.abs;
import static math.utils.Utils.exit;

public class Main extends Application {
    public static InputData data = new InputData();
    public static Stage primaryStage;
    public static Stage graphStage;

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
        primaryStage = stage;
        graphStage = new Stage();
        loadScene(stage, "mode-select.fxml", "solving equations");
    }

    public static void main(String[] args) {
        //launch();
        GroupOne groupOne = new GroupOne();
        groupOne.solveSystem(groupOne);

        exit("", 0);
    }
}