package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Service.AccountServiceImpl;
import com.must.atm.mustatm.Service.ActionServiceImpl;
import com.must.atm.mustatm.Service.Type.cardType;
import com.must.atm.mustatm.Template.NoticePane;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import static com.must.atm.mustatm.Template.GetStyle.*;
import static com.must.atm.mustatm.Template.NoticePane.textPane;

/**
 * A class which ca generate the third withdraw page
 * @author jingye
 */
public class WithdrawStateThreeController
{
    public Pane pane(Stage primaryStage, UserBase user, cardType currency,double withdrawBalance)
    {

        StackPane underBasePane = new StackPane();
        BorderPane basePane = new BorderPane();
        underBasePane.getChildren().add(basePane);
        //set background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");

        //creat topPane
        HBox topPane = new HBox();
        basePane.setTop(topPane);
        //create middlePane
        AnchorPane middlePane = new AnchorPane();
        basePane.setCenter(middlePane);
        //create rightPane
        AnchorPane rightPane = new AnchorPane();
        basePane.setRight(rightPane);
        //create bottomPane
        AnchorPane bottomPane = new AnchorPane();
        basePane.setBottom(bottomPane);
        AnchorPane leftPane = new AnchorPane();
        basePane.setLeft(leftPane);

        // instantiate a topBar
        Image topBar = new Image("topBar.png");
        // set topBar
        ImageView topBarView = new ImageView(topBar);
        topBarView.setPreserveRatio(true);
        topBarView.fitWidthProperty().bind(underBasePane.widthProperty());
        topPane.getChildren().add(topBarView);

        //set rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.rgb(5, 80, 174));
        rectangle.setHeight(rightPane.getHeight() * 0.15);
        rectangle.setWidth(rightPane.getWidth() * 0.7);
        AnchorPane.setBottomAnchor(rectangle, 0.0);
        AnchorPane.setRightAnchor(rectangle, 0.0);
        bottomPane.getChildren().add(rectangle);

        Rectangle rectangleMid = new Rectangle();
        rectangleMid.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(rectangleMid);

        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        var withdrawText = textPane("Your Withdraw Is:");
        middlePane.getChildren().add(withdrawText);

        // create button
        var btnReturn = new Button("RETURN");
        var btnConfirm = new Button("CONFIRM");
        // set button action
        WithdrawStateOneController withdrawOne = new WithdrawStateOneController();
        WithdrawSuccessController withdrawSuccess = new WithdrawSuccessController();
        btnReturn.setOnAction(_ -> primaryStage.getScene().setRoot(withdrawOne.pane(primaryStage,user)));

        ModalPane aboutModalPane = new ModalPane();

        rightPane.getChildren().add(btnReturn);
        leftPane.getChildren().add(btnConfirm);
        // use ButtonStyle set button's style
        btnReturn.setStyle(getButtonStyle());
        btnConfirm.setStyle(getButtonStyle());

        NoticePane noticePane = new NoticePane(primaryStage);
        var failedText = new ArrayList<String>();
        failedText.add("WITHDRAWAL FAILED");


        AccountServiceImpl accountService = new AccountServiceImpl();
        var currentBalance = accountService.getBalance(user.getUserId(),currency);
        var currentBalancePreviewText = new TextField(withdrawBalance + " " + currency.toString());
        currentBalancePreviewText.setEditable(false);
        currentBalancePreviewText.setStyle(getTextFieldStyle());
        middlePane.getChildren().add(currentBalancePreviewText);

        if(withdrawBalance > currentBalance)
        {
            underBasePane.getChildren().addAll(aboutModalPane);
            failedText.add("Do not have enough deposit");
            callDialog(aboutModalPane, noticePane.failed(textPane(failedText)), primaryStage, user);
        }
        ActionServiceImpl actionService = new ActionServiceImpl();
        btnConfirm.setOnAction(_ ->
                {
                    actionService.withdraw(user.getUserId(), currency,withdrawBalance);
                    primaryStage.getScene().setRoot(withdrawSuccess.pane(primaryStage,user));
                });
        var newBalanceText = textPane("Balance will be:");
        middlePane.getChildren().add(newBalanceText);
        var newBalance = currentBalance-withdrawBalance;
        var newBalancePreviewText = new TextField(newBalance+" " + currency);
        newBalancePreviewText.setEditable(false);
        newBalancePreviewText.setStyle(getTextFieldStyle());
        middlePane.getChildren().add(newBalancePreviewText);


        //set listener
        underBasePane.widthProperty().addListener((_, _, _) ->
        {

            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);
            currentBalancePreviewText.setPrefWidth(primaryStage.getWidth() * 0.40);
            newBalancePreviewText.setPrefWidth(primaryStage.getWidth() * 0.40);
            AnchorPane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.02);
            AnchorPane.setLeftAnchor(newBalancePreviewText, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(newBalanceText, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(withdrawText, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(currentBalancePreviewText, primaryStage.getWidth() * 0.03);
            btnReturn.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            btnConfirm.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(btnReturn, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(btnConfirm, primaryStage.getWidth() * 0.05);
        });
        underBasePane.heightProperty().addListener((_, _, _) ->
        {
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            AnchorPane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(withdrawText, primaryStage.getHeight() * 0.48);
            AnchorPane.setBottomAnchor(newBalanceText, primaryStage.getHeight() * 0.31);
            AnchorPane.setBottomAnchor(currentBalancePreviewText, primaryStage.getHeight() * 0.40);
            AnchorPane.setBottomAnchor(newBalancePreviewText, primaryStage.getHeight() * 0.23);
            AnchorPane.setBottomAnchor(btnReturn, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(btnConfirm, primaryStage.getHeight() * 0.35);
        });

        return underBasePane;
    }
    private void callDialog(ModalPane aboutModalPane, StackPane failed, Stage primaryStage, UserBase user)
    {
        //success wait time
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.02));
        // start pause
        aboutModalPane.toFront();
        noTime.play();
        noTime.setOnFinished(_ ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
            aboutModalPane.show(failed);

            System.out.println("aboutDialogOpenBtn");
        });
        pause.setOnFinished(_ ->
        {
            aboutModalPane.hide(false);
            aboutModalPane.setPersistent(true);
            WithdrawStateOneController withdrawStateOne = new WithdrawStateOneController();
            primaryStage.getScene().setRoot(withdrawStateOne.pane(primaryStage,user));
            System.out.println("OK");
        });
    }


}
