package com.must.atm.
        mustatm.Controller;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class main extends Application {


    public Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        // set AtlantaFX stylesheet
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        var mainPage = new MainPageController();

        var mainScene = new Scene(mainPage.createMainPagePane(primaryStage));

//        var verificationPage = new VerificationPageController();
//        var verificationScene = new Scene(verificationPage.createVerificationPagePane());


        primaryStage.setScene(mainScene);
        primaryStage.setTitle(System.getProperty("app.name"));
        primaryStage.setOnCloseRequest(t -> Platform.exit());
        primaryStage.setMaxWidth(1800);
        primaryStage.setMaxHeight(900);



        Platform.runLater(() -> {
            primaryStage.show();
            primaryStage.requestFocus();
        });
    }



//    public static void changeScene(Scene scene) {
//        primaryStage.setScene(scene);
//    }


//here
//    public static Stage createStage(){
//        Stage primaryStage =new Stage();
//        return primaryStage;
//    }

    void showVerScene(Stage primaryStage){


        var verificationPage = new VerificationPageController();
        var verificationScene = new Scene(verificationPage.createVerificationPagePane(primaryStage));
        primaryStage.setScene(verificationScene);
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