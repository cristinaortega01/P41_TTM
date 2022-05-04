package com.example.front;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane = new GridPane();
        ChoiceBox levelselect = new ChoiceBox();
        levelselect.getItems().addAll("Level 1", "Level 2", "Level 3");
        ChoiceBox rangeselect = new ChoiceBox();
        rangeselect.getItems().addAll("Bajo", "Contralto", "Tenor", "Bajo");
        ToggleButton Select = new ToggleButton();
        
        gridPane.add(levelselect, 1, 1);
        gridPane.add(rangeselect, 2,1);
        Scene scene = new Scene(gridPane, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}