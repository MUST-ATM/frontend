package com.must.atm.mustatm.Controller;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author 13318
 */
public class DepositSuccess
{
    public Pane pane(Stage primaryStage)
    {

        BorderPane basePane = new BorderPane();
        //set background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");

        //creat topPane
        HBox topPane = new HBox();
        basePane.setTop(topPane);
        //create leftPane
        AnchorPane leftPane = new AnchorPane();
        basePane.setLeft(leftPane);
        //create rightPane
        AnchorPane rightPane = new AnchorPane();
        basePane.setRight(rightPane);
        //create bottomPane
        AnchorPane bottomPane = new AnchorPane();
        basePane.setBottom(bottomPane);
        //create centerPane
        StackPane centerPane = new StackPane();
        basePane.setCenter(centerPane);


        // instantiate a topBar
        Image topBar = new Image("topBar.png");
        // set topBar
        ImageView topBarView = new ImageView(topBar);
        topBarView.setPreserveRatio(true);
        topBarView.fitWidthProperty().bind(basePane.widthProperty());
        topPane.getChildren().add(topBarView);


        //set rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.rgb(5, 80, 174));
        rectangle.setHeight(rightPane.getHeight() * 0.15);
        rectangle.setWidth(rightPane.getWidth() * 0.7);
        AnchorPane.setBottomAnchor(rectangle, 0.0);
        AnchorPane.setRightAnchor(rectangle, 0.0);
        rightPane.getChildren().add(rectangle);

        // create button

        var normalBtnOne = new Button("S CONTINUE");
        var normalBtnTwo = new Button("EXIT");

        // set button action

        FunctionPageController functionPage = new FunctionPageController();
        normalBtnOne.setOnAction(e -> primaryStage.getScene().setRoot(functionPage.pane(primaryStage)));
        MainPageController mainPage = new MainPageController();
        normalBtnTwo.setOnAction(e -> primaryStage.getScene().setRoot(mainPage.pane(primaryStage)));

        // set button
        normalBtnOne.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtnTwo.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        leftPane.getChildren().add(normalBtnOne);
        rightPane.getChildren().add(normalBtnTwo);

        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            normalBtnOne.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            normalBtnTwo.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(normalBtnOne, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(normalBtnTwo, primaryStage.getWidth() * 0.05);

        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            AnchorPane.setBottomAnchor(normalBtnOne, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(normalBtnTwo, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }
}
