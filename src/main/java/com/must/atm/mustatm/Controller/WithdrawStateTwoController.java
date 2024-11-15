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
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * A class which can generate the second withdraw page
 */
public class WithdrawStateTwoController {

    public Pane pane(Stage primaryStage)
    {
        BorderPane basePane = new BorderPane();
        //set background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");

        //creat topPane
        HBox topPane = new HBox();
        basePane.setTop(topPane);
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

        GetStyle getStyle = new GetStyle();

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

        var btnConfirm = new Button("CONFIRM");
        // set button
        // add button to panes
        rightPane.getChildren().add(btnConfirm);
        // use ButtonStyle set button's style
        btnConfirm.setStyle(getStyle.getButtonStyle());
        //set text field
        var balance = new TextField(getInput());
        balance.setEditable(false);
        middlePane.getChildren().add(balance);
        balance.setStyle(getStyle.getTextFieldStyleTwo());

        var withDraw = new TextField("");
        withDraw.setEditable(true);
        middlePane.getChildren().add(withDraw);
        withDraw.setStyle(getStyle.getTextFieldStyleTwo());
        WithdrawStateThreeController withdrawThree = new WithdrawStateThreeController();
        btnConfirm.setOnAction(e -> {primaryStage.getScene().setRoot(withdrawThree.pane(primaryStage));
            getOutput(withDraw.getText());
        });





        //set text
        Text text = new Text("Balance:");
        text.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(text);
        //set text
        Text textInputBar = new Text("Withdraw:");
        textInputBar.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(textInputBar);



        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            balanceRectangle.setWidth(primaryStage.getWidth() * 0.5);
            withDrawRectangle.setWidth(primaryStage.getWidth() * 0.5);
            btnConfirm.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            balance.setPrefWidth(primaryStage.getWidth() * 0.4);
            withDraw.setPrefWidth(primaryStage.getWidth() * 0.4);
            rightPane.setRightAnchor(btnConfirm, primaryStage.getWidth() * 0.05);
            middlePane.setLeftAnchor(balanceRectangle, primaryStage.getWidth() * 0.10);
            middlePane.setLeftAnchor(withDrawRectangle, primaryStage.getWidth() * 0.10);
            middlePane.setLeftAnchor(balance, primaryStage.getWidth() * 0.25);
            middlePane.setLeftAnchor(withDraw, primaryStage.getWidth() * 0.25);
            middlePane.setLeftAnchor(text, primaryStage.getWidth() * 0.12);
            middlePane.setLeftAnchor(textInputBar, primaryStage.getWidth() * 0.11);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            balanceRectangle.setHeight(primaryStage.getHeight() * 0.15);
            withDrawRectangle.setHeight(primaryStage.getHeight() * 0.15);
            balance.setPrefHeight(primaryStage.getHeight() * 0.15);
            withDraw.setPrefHeight(primaryStage.getHeight() * 0.15);
            rightPane.setBottomAnchor(btnConfirm, primaryStage.getHeight() * 0.35);
            middlePane.setBottomAnchor(balanceRectangle, primaryStage.getHeight() * 0.40);
            middlePane.setBottomAnchor(withDrawRectangle, primaryStage.getHeight() * 0.20);
            middlePane.setBottomAnchor(balance, primaryStage.getHeight() * 0.40);
            middlePane.setBottomAnchor(withDraw, primaryStage.getHeight() * 0.20);
            middlePane.setBottomAnchor(text, primaryStage.getHeight() * 0.45);
            middlePane.setBottomAnchor(textInputBar, primaryStage.getHeight() * 0.25);

        });



        return basePane;
    }

    // provide input value
    private String getInput(){
        String balance ="114514 MOP";

        return balance;
    }
    //the number of withdraw output via this method
    private void getOutput(String withDraw){
        System.out.println(withDraw);

    }

}
