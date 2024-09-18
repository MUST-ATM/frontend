package com.must.atm.mustatm.Controller;
import com.must.atm.mustatm.Template.BaseRectangle;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Controller class contain the methods which can generate and show pages
 * and methods about generate some element in UI
 */
public class Controller {
    //Generate and show verification page
    public void showVerScene(Stage primaryStage){
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
    //Generate and show function page
    public void showFunctionPage(Stage primaryStage){
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
    //Generate and show main page
    public void showMainPage(Stage primaryStage){
        var mainPage = new MainPageController();
        var mainScene = new Scene(mainPage.createMainPagePane(primaryStage));
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
    //set Rectangle's X,Y and height, width
    public void setRectangle(AnchorPane anchorPane, Rectangle rectangle, BaseRectangle rec){
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double rectangleY = newVal.doubleValue()*rec.getTimesY();
            double height = newVal.doubleValue()*rec.getTimesHeight();
            rectangle.setY(rectangleY);
            rectangle.setHeight(height);
        });
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double rectangleX = newVal.doubleValue()* rec.getTimesX();
            double width=newVal.doubleValue()*rec.getTimesWidth();
            rectangle.setX(rectangleX);
            rectangle.setWidth(width);
        });
    }
    //create a Rectangle
    public Rectangle createRectangle(BaseRectangle rec) {
        Rectangle rectangle = new Rectangle();
        rectangle.setArcWidth(rec.getArcWidth());
        rectangle.setArcHeight(rec.getArcHeight());
        rectangle.setFill(Color.rgb(rec.getColor().get(0),rec.getColor().get(1),rec.getColor().get(2)));
        return rectangle;
    }
}

