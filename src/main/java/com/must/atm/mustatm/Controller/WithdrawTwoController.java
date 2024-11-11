package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Template.GetStyle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 * A class which can generate the second withdraw page
 */
public class WithdrawTwoController {

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
        AnchorPane middlePane = new AnchorPane();
        basePane.setCenter(middlePane);
        //create bottomPane
        AnchorPane bottomPane = new AnchorPane();
        basePane.setBottom(bottomPane);

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
        bottomPane.getChildren().add(rectangle);

        Rectangle balanceRectangle = new Rectangle();
        balanceRectangle.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(balanceRectangle);

        Rectangle withDrawRectangle = new Rectangle();
        withDrawRectangle.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(withDrawRectangle);



        var normalBtnOne = new Button("CONFIRM");
        // set button
        // add button to panes
        rightPane.getChildren().add(normalBtnOne);
        // use ButtonStyle set button's style
        GetStyle getStyle = new GetStyle();
        normalBtnOne.setStyle(getStyle.getButtonStyle());


        var balance = new TextField(getInput());
        balance.setEditable(false);
        balance.setStyle(getStyle.getTextFieldStyle());
        middlePane.getChildren().add(balance);
        balance.setStyle(getStyle.getTextFieldStyle());

        var withDraw = new TextField("");
        withDraw.setEditable(true);
        withDraw.setStyle(getStyle.getTextFieldStyle());
        middlePane.getChildren().add(withDraw);
        withDraw.setStyle(getStyle.getTextFieldStyle());


        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            normalBtnOne.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            balance.setPrefWidth(primaryStage.getWidth() * 0.4);
            withDraw.setPrefWidth(primaryStage.getWidth() * 0.4);
            leftPane.setRightAnchor(normalBtnOne, primaryStage.getWidth() * 0.05);
            middlePane.setLeftAnchor(balance, primaryStage.getWidth() * 0.20);
            middlePane.setLeftAnchor(withDraw, primaryStage.getWidth() * 0.20);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            balance.setPrefHeight(primaryStage.getHeight() * 0.15);
            withDraw.setPrefHeight(primaryStage.getHeight() * 0.15);
            leftPane.setBottomAnchor(normalBtnOne, primaryStage.getHeight() * 0.35);
            middlePane.setBottomAnchor(balance, primaryStage.getHeight() * 0.40);
            middlePane.setBottomAnchor(withDraw, primaryStage.getHeight() * 0.20);

        });



        return basePane;
    }

    // provide input value
    private String getInput(){
        String balance ="114514 MOP";

        return balance;
    }

}
