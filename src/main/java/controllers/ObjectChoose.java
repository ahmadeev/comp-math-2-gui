package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static main.gui.Main.data;
import static main.gui.Main.loadScene;

public class ObjectChoose implements Initializable {
    @FXML
    public Button ocB0, ocB1, ocB2, ocB3;
    @FXML
    public Button mcB0, mcB1, mcB2;
    @FXML
    public Button sB;
    @FXML
    public TextField dTF0, dTF1, dTF2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dTF0.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                data.setLowerBoundary(Double.parseDouble(newValue));
            }
        });
        dTF1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                data.setHigherBoundary(Double.parseDouble(newValue));
            }
        });
        dTF2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                data.setPrecision(Double.parseDouble(newValue));
            }
        });
    }

    @FXML
    protected void handleObjectButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == ocB0) {
            data.setObjectCode(1);
        } else if (event.getSource() == ocB1) {
            data.setObjectCode(2);
        } else if (event.getSource() == ocB2) {
            data.setObjectCode(3);
        } else if (event.getSource() == ocB3) {
            data.setObjectCode(4);
        }
    }

    @FXML
    protected void handleMethodButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        if (event.getSource() == mcB0) {
            data.setMethodNumber(1);
        } else if (event.getSource() == ocB1) {
            data.setMethodNumber(2);
        } else if (event.getSource() == mcB2) {
            data.setMethodNumber(3);
        }
    }

    @FXML
    protected void handleSubmitButtonClick(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        loadScene(stage, "result-page.fxml", "solving equations");
    }
}