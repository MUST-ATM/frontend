package com.must.atm.mustatm.Controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author DOVAKIIN
 */
public class FunctionPageController
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
        var normalBtnOne = new Button("DEPOSIT");
        var normalBtnTwo = new Button("WITHDRAW");
        var normalBtnThree = new Button("CHECK ACCOUNT");
        var normalBtnFour = new Button("EXIST");
        // set button action
        MainPageController mainPage = new MainPageController();
        normalBtnFour.setOnAction(_ -> primaryStage.getScene().setRoot(mainPage.pane(primaryStage)));
        DepositOneController depositPage = new DepositOneController();
        normalBtnOne.setOnAction(_ -> primaryStage.getScene().setRoot(depositPage.pane(primaryStage)));
        // set button
        normalBtnOne.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtnTwo.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtnThree.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtnFour.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        normalBtnOne.setStyle("-fx-text-fill: #033D8B;");
        leftPane.getChildren().addAll(normalBtnOne, normalBtnTwo, normalBtnThree);
        rightPane.getChildren().add(normalBtnFour);


        //set listener
        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            normalBtnOne.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            normalBtnTwo.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            normalBtnThree.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            normalBtnFour.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(normalBtnOne, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(normalBtnTwo, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(normalBtnThree, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(normalBtnFour, primaryStage.getWidth() * 0.05);


        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            AnchorPane.setBottomAnchor(normalBtnOne, primaryStage.getHeight() * 0.55);
            AnchorPane.setBottomAnchor(normalBtnTwo, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(normalBtnThree, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(normalBtnFour, primaryStage.getHeight() * 0.15);

        });

        return basePane;
    }


}
