package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Template.GetStyle;
import javafx.scene.control.Button;
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
        AnchorPane.setBottomAnchor(rectangle, 0.0);
        AnchorPane.setRightAnchor(rectangle, 0.0);
        rightPane.getChildren().add(rectangle);

        // create button
        var btnDeposit = new Button("DEPOSIT");
        var btnWithdraw = new Button("WITHDRAW");
        var btnCheck = new Button("CHECK ACCOUNT");
        var btnExist = new Button("EXIST");

        // set button action
        MainPageController mainPage = new MainPageController();
        btnExist.setOnAction(e -> primaryStage.getScene().setRoot(mainPage.pane(primaryStage)));
        DepositStateOneController depositPage = new DepositStateOneController();
        btnDeposit.setOnAction(e -> primaryStage.getScene().setRoot(depositPage.pane(primaryStage)));
        WithdrawStateOneController withdrawPage = new WithdrawStateOneController();
        btnWithdraw.setOnAction(e -> primaryStage.getScene().setRoot(withdrawPage.pane(primaryStage)));
        CheckAccountStateOneController checkAccountPage = new CheckAccountStateOneController();
        btnCheck.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountPage.pane(primaryStage)));
        // set button
        // add button to panes
        leftPane.getChildren().addAll(btnDeposit, btnWithdraw, btnCheck);
        rightPane.getChildren().add(btnExist);
        // use ButtonStyle set button's style
        GetStyle getStyle = new GetStyle();
        btnDeposit.setStyle(getStyle.getButtonStyle());
        btnWithdraw.setStyle(getStyle.getButtonStyle());
        btnCheck.setStyle(getStyle.getButtonStyle());
        btnExist.setStyle(getStyle.getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            btnDeposit.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnWithdraw.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnCheck.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnExist.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            leftPane.setLeftAnchor(btnDeposit, primaryStage.getWidth() * 0.05);
            leftPane.setLeftAnchor(btnWithdraw, primaryStage.getWidth() * 0.05);
            leftPane.setLeftAnchor(btnCheck, primaryStage.getWidth() * 0.05);
            rightPane.setRightAnchor(btnExist, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            leftPane.setBottomAnchor(btnDeposit, primaryStage.getHeight() * 0.55);
            leftPane.setBottomAnchor(btnWithdraw, primaryStage.getHeight() * 0.35);
            leftPane.setBottomAnchor(btnCheck, primaryStage.getHeight() * 0.15);
            rightPane.setBottomAnchor(btnExist, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }


}
