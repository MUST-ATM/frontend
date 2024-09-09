package com.must.atm.mustatm.Controller;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // set AtlantaFX stylesheet
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        var mainPage = new MainPageController();
        var scene = new Scene(mainPage.createPane(), 1050, 550);

        primaryStage.setScene(scene);
        primaryStage.setTitle(System.getProperty("app.name"));
        primaryStage.setOnCloseRequest(t -> Platform.exit());
        primaryStage.setMaxWidth(1800);
        primaryStage.setMaxHeight(900);

        Platform.runLater(() -> {
            primaryStage.show();
            primaryStage.requestFocus();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}