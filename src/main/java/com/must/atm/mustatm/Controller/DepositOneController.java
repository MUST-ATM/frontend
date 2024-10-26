package com.must.atm.mustatm.Controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DepositOneController {


    /**
     * @author DOVAKIIN
     */


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
            rectangle.setFill(Color.rgb(5,80,174));
            rectangle.setHeight(rightPane.getHeight()*0.15);
            rectangle.setWidth(rightPane.getWidth()*0.7);
            AnchorPane.setBottomAnchor(rectangle, 0.0);
            AnchorPane.setRightAnchor(rectangle, 0.0);
            rightPane.getChildren().add(rectangle);

            // create button
            var normalBtnOne = new Button("CNY/USD ACCOUNT");
            var normalBtnTwo = new Button("MOP ACCOUNT");
            var normalBtnThree = new Button("HCD ACCOUNT");
            var normalBtnFour = new Button("EXIST");
            // set button action
//        VerificationPageController verificationPage = new VerificationPageController();
//        normalBtnOne.setOnAction(e ->primaryStage.getScene().setRoot(verificationPage.pane(primaryStage)));
            FunctionPageController functionPage = new FunctionPageController();
            normalBtnFour.setOnAction(e ->primaryStage.getScene().setRoot(functionPage.pane(primaryStage)));
            // set button
            normalBtnOne.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
            normalBtnTwo.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
            normalBtnThree.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
            normalBtnFour.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
//        normalBtnOne.setStyle("-fx-text-fill: #033D8B;");
            leftPane.getChildren().addAll(normalBtnOne,normalBtnTwo,normalBtnThree);
            rightPane.getChildren().add(normalBtnFour);


            //set listener
            basePane.widthProperty().addListener((obs, oldVal, newVal) -> {
                rectangle.setWidth(primaryStage.getWidth()*0.5);
                normalBtnOne.setPrefSize(primaryStage.getWidth()*0.3,primaryStage.getHeight()*0.1);
                normalBtnTwo.setPrefSize(primaryStage.getWidth()*0.3,primaryStage.getHeight()*0.1);
                normalBtnThree.setPrefSize(primaryStage.getWidth()*0.3,primaryStage.getHeight()*0.1);
                normalBtnFour.setPrefSize(primaryStage.getWidth()*0.3,primaryStage.getHeight()*0.1);
                leftPane.setLeftAnchor(normalBtnOne, primaryStage.getWidth()*0.05);
                leftPane.setLeftAnchor(normalBtnTwo, primaryStage.getWidth()*0.05);
                leftPane.setLeftAnchor( normalBtnThree, primaryStage.getWidth()*0.05);
                rightPane.setRightAnchor(normalBtnFour, primaryStage.getWidth()*0.05);


            });
            basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
                rectangle.setHeight(primaryStage.getHeight()*0.1);
                leftPane.setBottomAnchor(normalBtnOne, primaryStage.getHeight()*0.55);
                leftPane.setBottomAnchor(normalBtnTwo, primaryStage.getHeight()*0.35);
                leftPane.setBottomAnchor(normalBtnThree, primaryStage.getHeight()*0.15);
                rightPane.setBottomAnchor(normalBtnFour, primaryStage.getHeight()*0.15);

            });

            return basePane;
        }






}
