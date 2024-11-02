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
        var normalBtnOne = new Button("CNY/USD ACCOUNT");
        var normalBtnTwo = new Button("MOP ACCOUNT");
        var normalBtnThree = new Button("HCD ACCOUNT");
        var normalBtnFour = new Button("RETURN");

        // set button action
        FunctionPageController functionPage = new FunctionPageController();
        normalBtnFour.setOnAction(e -> primaryStage.getScene().setRoot(functionPage.pane(primaryStage)));
        CheckAccountTwoController checkAccountTwo = new CheckAccountTwoController();
        normalBtnOne.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage)));
        normalBtnTwo.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage)));
        normalBtnThree.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage)));
        // set button
        // add button to panes
        leftPane.getChildren().addAll(normalBtnOne, normalBtnTwo, normalBtnThree);
        rightPane.getChildren().add(normalBtnFour);
        // use ButtonStyle set button's style
        GetStyle getStyle = new GetStyle();
        normalBtnOne.setStyle(getStyle.getButtonStyle());
        normalBtnTwo.setStyle(getStyle.getButtonStyle());
        normalBtnThree.setStyle(getStyle.getButtonStyle());
        normalBtnFour.setStyle(getStyle.getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            normalBtnOne.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            normalBtnTwo.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            normalBtnThree.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            normalBtnFour.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            leftPane.setLeftAnchor(normalBtnOne, primaryStage.getWidth() * 0.05);
            leftPane.setLeftAnchor(normalBtnTwo, primaryStage.getWidth() * 0.05);
            leftPane.setLeftAnchor(normalBtnThree, primaryStage.getWidth() * 0.05);
            rightPane.setRightAnchor(normalBtnFour, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            leftPane.setBottomAnchor(normalBtnOne, primaryStage.getHeight() * 0.55);
            leftPane.setBottomAnchor(normalBtnTwo, primaryStage.getHeight() * 0.35);
            leftPane.setBottomAnchor(normalBtnThree, primaryStage.getHeight() * 0.15);
            rightPane.setBottomAnchor(normalBtnFour, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }
}
