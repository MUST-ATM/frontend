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
 * A class which can generate the first check account page
 */
public class CheckAccountOneController {
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
        var btnOtherAccount = new Button("CNY/USD ACCOUNT");
        var btnMopAccount = new Button("MOP ACCOUNT");
        var btnHkdAccount = new Button("HKD ACCOUNT");
        var btnReturn = new Button("RETURN");

        // set button action
        FunctionPageController functionPage = new FunctionPageController();
        btnReturn.setOnAction(e -> primaryStage.getScene().setRoot(functionPage.pane(primaryStage)));
        CheckAccountTwoController checkAccountTwo = new CheckAccountTwoController();
        btnOtherAccount.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage)));
        btnMopAccount.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage)));
        btnHkdAccount.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage)));
        // set button
        // add button to panes
        leftPane.getChildren().addAll(btnOtherAccount, btnMopAccount, btnHkdAccount);
        rightPane.getChildren().add(btnReturn);
        // use ButtonStyle set button's style
        GetStyle getStyle = new GetStyle();
        btnOtherAccount.setStyle(getStyle.getButtonStyle());
        btnMopAccount.setStyle(getStyle.getButtonStyle());
        btnHkdAccount.setStyle(getStyle.getButtonStyle());
        btnReturn.setStyle(getStyle.getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            btnOtherAccount.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnMopAccount.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnHkdAccount.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnReturn.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            leftPane.setLeftAnchor(btnOtherAccount, primaryStage.getWidth() * 0.05);
            leftPane.setLeftAnchor(btnMopAccount, primaryStage.getWidth() * 0.05);
            leftPane.setLeftAnchor(btnHkdAccount, primaryStage.getWidth() * 0.05);
            rightPane.setRightAnchor(btnReturn, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            leftPane.setBottomAnchor(btnOtherAccount, primaryStage.getHeight() * 0.55);
            leftPane.setBottomAnchor(btnMopAccount, primaryStage.getHeight() * 0.35);
            leftPane.setBottomAnchor(btnHkdAccount, primaryStage.getHeight() * 0.15);
            rightPane.setBottomAnchor(btnReturn, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }
}
