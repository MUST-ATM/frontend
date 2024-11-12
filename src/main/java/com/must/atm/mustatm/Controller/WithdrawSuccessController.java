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

public class WithdrawSuccessController {
    public Pane pane(Stage primaryStage){
        BorderPane basePane = new BorderPane();
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

        Rectangle rectangleMid = new Rectangle();
        rectangleMid.setFill(Color.rgb(45, 164, 78));
        middlePane.getChildren().add(rectangleMid);

        GetStyle getStyle = new GetStyle();
        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        Text text = new Text("WITHDRAW");
        text.setStyle(getStyle.getTextStyle());
        text.setStyle(getStyle.getTextStyleTwo());
        middlePane.getChildren().add(text);
        Text textTwo = new Text("SUCCESSFUL");
        textTwo.setStyle(getStyle.getTextStyleTwo());
        middlePane.getChildren().add(textTwo);


        // create button
        var normalBtn = new Button("CONTINUE");
        var normalBtnTwo = new Button("EXIST");
        // set button action
        WithdrawOneController withdrawOneController = new WithdrawOneController();
        MainPageController mainPageController = new MainPageController();
        normalBtn.setOnAction(e -> primaryStage.getScene().setRoot(withdrawOneController.pane(primaryStage)));
        normalBtnTwo.setOnAction(e -> primaryStage.getScene().setRoot(mainPageController.pane(primaryStage)));
        // set button
        // add button to panes
        rightPane.getChildren().add(normalBtn);
        leftPane.getChildren().add(normalBtnTwo);
        // use ButtonStyle set button's style
        normalBtn.setStyle(getStyle.getButtonStyle());
        normalBtnTwo.setStyle(getStyle.getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);

            middlePane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.02);
            middlePane.setLeftAnchor(text, primaryStage.getWidth() * 0.05);
            middlePane.setLeftAnchor(textTwo, primaryStage.getWidth() * 0.05);

            normalBtn.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            normalBtnTwo.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            leftPane.setLeftAnchor(normalBtnTwo, primaryStage.getWidth() * 0.05);
            rightPane.setRightAnchor(normalBtn, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            middlePane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            middlePane.setBottomAnchor(text, primaryStage.getHeight() * 0.45);
            middlePane.setBottomAnchor(textTwo, primaryStage.getHeight() * 0.38);


            leftPane.setBottomAnchor(normalBtnTwo, primaryStage.getHeight() * 0.35);
            rightPane.setBottomAnchor(normalBtn, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }

}
