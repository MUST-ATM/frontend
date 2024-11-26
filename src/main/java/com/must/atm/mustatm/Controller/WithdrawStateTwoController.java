package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Service.AccountServiceImpl;
import com.must.atm.mustatm.Service.ActionService;
import com.must.atm.mustatm.Service.ActionServiceImpl;
import com.must.atm.mustatm.Service.Type.cardType;
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

import static com.must.atm.mustatm.Template.GetStyle.*;

/**
 * A class which can generate the second withdraw page
 * @author bywang,jingye
 */
public class WithdrawStateTwoController
{

    public Pane pane(Stage primaryStage, UserBase user, cardType currency)
    {
        BorderPane basePane = new BorderPane();
        ActionService actionService = new ActionServiceImpl();
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

        // add button
        rightPane.getChildren().add(btnConfirm);
        // use ButtonStyle set button's style
        btnConfirm.setStyle(getButtonStyle());
        //set text field
        AccountServiceImpl accountService = new AccountServiceImpl();
        var balance = accountService.getBalance(user.getUserId(), currency);
        var balanceText = new TextField(balance +" "+ currency.toString());
        balanceText.setEditable(false);
        middlePane.getChildren().add(balanceText);
        balanceText.setStyle(getTextFieldStyleTwo());

        var withDraw = new TextField("");
        withDraw.setEditable(true);
        middlePane.getChildren().add(withDraw);
        withDraw.setStyle(getTextFieldStyleTwo());
        WithdrawStateThreeController withdrawThree = new WithdrawStateThreeController();
        btnConfirm.setOnAction(_ ->
        {
            primaryStage.getScene().setRoot(withdrawThree.pane(primaryStage, user,currency,Double.parseDouble(withDraw.getText())));
        });

        //set text
        Text text = new Text("Balance:");
        text.setStyle(getTextStyle());
        middlePane.getChildren().add(text);
        //set text
        Text textInputBar = new Text("Withdraw:");
        textInputBar.setStyle(getTextStyle());
        middlePane.getChildren().add(textInputBar);

        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            balanceRectangle.setWidth(primaryStage.getWidth() * 0.5);
            withDrawRectangle.setWidth(primaryStage.getWidth() * 0.5);
            btnConfirm.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            balanceText.setPrefWidth(primaryStage.getWidth() * 0.4);
            withDraw.setPrefWidth(primaryStage.getWidth() * 0.4);
            AnchorPane.setRightAnchor(btnConfirm, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(balanceRectangle, primaryStage.getWidth() * 0.10);
            AnchorPane.setLeftAnchor(withDrawRectangle, primaryStage.getWidth() * 0.10);
            AnchorPane.setLeftAnchor(balanceText, primaryStage.getWidth() * 0.25);
            AnchorPane.setLeftAnchor(withDraw, primaryStage.getWidth() * 0.25);
            AnchorPane.setLeftAnchor(text, primaryStage.getWidth() * 0.12);
            AnchorPane.setLeftAnchor(textInputBar, primaryStage.getWidth() * 0.11);
        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            balanceRectangle.setHeight(primaryStage.getHeight() * 0.15);
            withDrawRectangle.setHeight(primaryStage.getHeight() * 0.15);
            balanceText.setPrefHeight(primaryStage.getHeight() * 0.15);
            withDraw.setPrefHeight(primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(btnConfirm, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(balanceRectangle, primaryStage.getHeight() * 0.40);
            AnchorPane.setBottomAnchor(withDrawRectangle, primaryStage.getHeight() * 0.20);
            AnchorPane.setBottomAnchor(balanceText, primaryStage.getHeight() * 0.40);
            AnchorPane.setBottomAnchor(withDraw, primaryStage.getHeight() * 0.20);
            AnchorPane.setBottomAnchor(text, primaryStage.getHeight() * 0.45);
            AnchorPane.setBottomAnchor(textInputBar, primaryStage.getHeight() * 0.25);

        });

        return basePane;
    }
}
