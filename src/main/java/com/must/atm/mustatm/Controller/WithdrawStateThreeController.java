package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Template.BasePane;
import com.must.atm.mustatm.Template.NoticePane;
import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

import static com.must.atm.mustatm.Template.GetStyle.*;
import static com.must.atm.mustatm.Template.NoticePane.textPane;

/**
 * A class which ca ngenerate the third withdraw page
 */
public class WithdrawStateThreeController
{
    public Pane pane(Stage primaryStage, UserBase user)
    {

        StackPane underBasePane = new StackPane();
        BasePane basePane = new BasePane(primaryStage);
        underBasePane.getChildren().add(basePane.getBasePane());
        //set background
        var middlePane = basePane.getMiddlePane();
        Rectangle rectangleMid = new Rectangle();
        rectangleMid.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(rectangleMid);

        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        var balanceText = textPane("Your Withdraw Is:");
        middlePane.getChildren().add(balanceText);

        //set text filed
        //need input from service
        //here need an input
        String Withdraw = getInput();
        var withdraw = new TextField(Withdraw);
        withdraw.setEditable(false);
        withdraw.setStyle(getTextFieldStyle());
        middlePane.getChildren().add(withdraw);
        var newBalanceText = textPane("Balance will be:");
        middlePane.getChildren().add(newBalanceText);

        String Balance = getInputTwo();
        var balance = new TextField(Balance);
        balance.setEditable(false);
        balance.setStyle(getTextFieldStyle());
        middlePane.getChildren().add(balance);


        // create button
        var btnReturn = new Button("RETURN");
        var btnConfirm = new Button("CONFIRM");
        // set button action
        WithdrawStateOneController withdrawOne = new WithdrawStateOneController();
        WithdrawSuccessController withdrawSuccess = new WithdrawSuccessController();
        btnReturn.setOnAction(_ -> primaryStage.getScene().setRoot(withdrawOne.pane(primaryStage,user)));
        btnConfirm.setOnAction(_ -> primaryStage.getScene().setRoot(withdrawSuccess.pane(primaryStage,user)));
        // set button
        // add button to panes
        ModalPane aboutModalPane = new ModalPane();
        var rightPane = basePane.getRightPane();
        var leftPane = basePane.getLeftPane();
        rightPane.getChildren().add(btnReturn);
        leftPane.getChildren().add(btnConfirm);
        // use ButtonStyle set button's style
        btnReturn.setStyle(getButtonStyle());
        btnConfirm.setStyle(getButtonStyle());

        NoticePane noticePane = new NoticePane(primaryStage);
        var failedText = new ArrayList<String>();
        failedText.add("WITHDRAWAL FAILED");

        if (getInputWarningInuputWrong())
        {
            underBasePane.getChildren().addAll(aboutModalPane);
            failedText.add("Please input an number in correct format");
            callDialog(aboutModalPane, noticePane.failed(textPane(failedText)), primaryStage, user);
        } else if (getInputWarningDepositionWrong())
        {
            underBasePane.getChildren().addAll(aboutModalPane);
            failedText.add("Do not have enough deposit");
            callDialog(aboutModalPane, noticePane.failed(textPane(failedText)), primaryStage, user);
        }


        //set listener
        underBasePane.widthProperty().addListener((_, _, _) ->
        {
            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);
            withdraw.setPrefWidth(primaryStage.getWidth() * 0.40);
            balance.setPrefWidth(primaryStage.getWidth() * 0.40);
            AnchorPane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.02);
            AnchorPane.setLeftAnchor(balanceText, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(newBalanceText, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(withdraw, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(balance, primaryStage.getWidth() * 0.03);
            btnReturn.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            btnConfirm.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(btnConfirm, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(btnReturn, primaryStage.getWidth() * 0.05);
        });
        underBasePane.heightProperty().addListener((_, _, _) ->
        {
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            AnchorPane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(balanceText, primaryStage.getHeight() * 0.48);
            AnchorPane.setBottomAnchor(newBalanceText, primaryStage.getHeight() * 0.31);
            AnchorPane.setBottomAnchor(withdraw, primaryStage.getHeight() * 0.40);
            AnchorPane.setBottomAnchor(balance, primaryStage.getHeight() * 0.23);
            AnchorPane.setBottomAnchor(btnConfirm, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(btnReturn, primaryStage.getHeight() * 0.35);
        });

        return underBasePane;
    }
    private void callDialog(ModalPane aboutModalPane, StackPane failed, Stage primaryStage, UserBase user)
    {
        //success wait time
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.02));
//        Text FailText = new Text("Please input an number in correct format");
        // start pause
        aboutModalPane.toFront();
        noTime.play();
        noTime.setOnFinished(_ ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
//            aboutPane.getChildren().add(FailText);
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
    private String getInput()
    {

        return "114514 MOP";
    }

    private String getInputTwo()
    {

        return "114000 MOP";
    }

    private Boolean getInputWarningInuputWrong()
    {
        return false;
    }

    private Boolean getInputWarningDepositionWrong()
    {
        return false;
    }


}
