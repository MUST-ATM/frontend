package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Template.BasePane;
import com.must.atm.mustatm.Template.NoticePane;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

import static com.must.atm.mustatm.Template.GetStyle.*;
import static com.must.atm.mustatm.Template.NoticePane.textPane;

/**
 * A class which can generate the withdraw-success page
 * @author  Jingye,bywang
 */
public class WithdrawSuccessController
{
    public Pane pane(Stage primaryStage, UserBase user)
    {
        BasePane basePane = new BasePane(primaryStage);
        NoticePane noticePane = new NoticePane(primaryStage);
        var middlePane = basePane.getMiddlePane();
        var rightPane = basePane.getRightPane();
        var leftPane = basePane.getLeftPane();
        noticePane.succeed();
        var texts = new ArrayList<String>();
        texts.add("WITHDRAWAL");
        texts.add("SUCCESSFUL");
        var succeed = noticePane.succeed(textPane(texts));
        middlePane.getChildren().add(succeed);


        // create button
        var btnContinue = new Button("CONTINUE");
        var btnExist = new Button("EXIST");
        // set button action
        WithdrawStateOneController withdrawStateOneController = new WithdrawStateOneController();
        MainPageController mainPageController = new MainPageController();
        btnContinue.setOnAction(_ -> primaryStage.getScene().setRoot(withdrawStateOneController.pane(primaryStage,user)));
        btnExist.setOnAction(_ -> primaryStage.getScene().setRoot(mainPageController.pane(primaryStage)));
        // set button
        // add button to panes
        rightPane.getChildren().add(btnContinue);
        leftPane.getChildren().add(btnExist);
        // use ButtonStyle set button's style
        btnContinue.setStyle(getButtonStyle());
        btnExist.setStyle(getButtonStyle());

        //set listener
        basePane.getBasePane().widthProperty().addListener((_, _, _) ->
        {
            AnchorPane.setLeftAnchor(succeed, primaryStage.getWidth() * 0.05);

            btnContinue.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            btnExist.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(btnExist, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(btnContinue, primaryStage.getWidth() * 0.05);
        });
        basePane.getBasePane().heightProperty().addListener((_, _, _) ->
                AnchorPane.setBottomAnchor(succeed, primaryStage.getHeight() * 0.38));

        return basePane.getBasePane();
    }

}
