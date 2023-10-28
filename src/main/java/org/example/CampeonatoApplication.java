package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CampeonatoApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(CampeonatoApplication.class.getResource("campeonato-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 280);
        stage.setTitle("Campeonato Analizer 2003 - 2022.");
        stage.setScene(scene);
        stage.show();
    }
}