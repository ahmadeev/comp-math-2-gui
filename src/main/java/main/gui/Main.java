package main.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.InputData;

import java.io.IOException;

public class Main extends Application {
    public static InputData data = new InputData();
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
        loadScene(stage, "mode-select.fxml", "solving equations");
        //loadScene(stage, "object-choose.fxml", "meow!");
    }

    public static void main(String[] args) {
        launch();
    }
}