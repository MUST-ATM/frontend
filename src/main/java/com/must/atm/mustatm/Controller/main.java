package com.must.atm.
        mustatm.Controller;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

    void showFunctionPage(Stage primaryStage){


        var functionPage = new FunctionPageController();
        var functionScene = new Scene(functionPage.createFunctionPagePane(primaryStage));
        primaryStage.setScene(functionScene);
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

    public Rectangle setRectangle(AnchorPane anchorPane,Rectangle rectangle,Double timesY,Double timesX,Double timesHeight,Double timesWidth){
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double rectangleY = newVal.doubleValue()*timesY;
            double height = newVal.doubleValue()*timesHeight;
            rectangle.setY(rectangleY);
            rectangle.setHeight(height);
        });
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double rectangleX = newVal.doubleValue()*timesX ;
            double width=newVal.doubleValue()*timesWidth;
            rectangle.setX(rectangleX);
            rectangle.setWidth(width);
        });
        return rectangle;
    }

    public Rectangle createRectangle(double arcWidth, double arcHeight, int colorR, int colorG,int colorB) {
        Rectangle rectangle = new Rectangle();
        rectangle.setArcWidth(arcWidth);
        rectangle.setArcHeight(arcHeight);
        rectangle.setFill(Color.rgb(colorR,colorG,colorB));
        return rectangle;
    }
}