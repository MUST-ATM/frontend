
package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Template.BaseRectangle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * MainPageController is a class which can generate main page
 * @author 13318
 */
public class MainPageController {
    /** createMainPagePane
     *
     * @param primaryStage listen window
     * @return MainPagePane
     */
    public  Pane createMainPagePane(Stage primaryStage)
    {
        BorderPane basePane = new BorderPane();
        //set background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");
        //instantiate a controller
        Controller controller = new Controller();


        //creat topPane
        HBox topPane = new HBox();

        // instantiate a topBar
        Image topBar = new Image("topBar.png");
        // set topBar
        ImageView topBarView = new ImageView(topBar);
        topBarView.setPreserveRatio(true);
        topBarView.fitWidthProperty().bind(basePane.widthProperty());
        topPane.getChildren().add(topBarView);
        basePane.setTop(topPane);





        //create rightPane
        AnchorPane rightPane = new AnchorPane();

        rightPane.setStyle("-fx-background-color:#008000 ;");
        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Color.rgb(5,80,174));

        rightPane.getChildren().add(rectangle);
//        rectangle.setHeight(rightPane.getHeight()/6.0);
//        rectangle.setWidth(rightPane.getWidth()/3.0);
//        rightPane.setTopAnchor(rectangle, rightPane.getHeight() / 6.0);
//        rightPane.setBottomAnchor(rectangle, 0.0);
//        rightPane.setLeftAnchor(rectangle, rightPane.getWidth() / 3.0);
//        rightPane.setRightAnchor(rectangle, 0.0);

        // instantiate an image which is the picture of MUST
        Image must = new Image("pictureOfMust.png");
        // set the image
        ImageView mustView = new ImageView(must);
        rightPane.getChildren().add(mustView);
//        // set the default size of image
//        mustView.setFitWidth(100);
//        mustView.setFitHeight(100);
//        mustView.setPreserveRatio(true);
        //set the position of the image
//        basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
//            double topAnchor = newVal.doubleValue() * 0.1;
//            AnchorPane.setTopAnchor(mustView, topAnchor);
//        });
//
//        //set the size of image
//        basePane.widthProperty().addListener((obs, oldVal, newVal) -> {
//            double topAnchor = newVal.doubleValue()*0.45;
//            mustView.setFitWidth (topAnchor);
//        });

//        mustView.setFitWidth(rightPane.getWidth()/3.0);
//        mustView.setFitHeight(rightPane.getHeight()/4.0);

//        rightPane.setRightAnchor(mustView, 50.0);
//        rightPane.setTopAnchor(mustView, 20.0);
//        rightPane.setLeftAnchor(mustView, 50.0);
//        rightPane.setBottomAnchor(mustView,200.0);


//
//        basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
//            double topAnchor = newVal.doubleValue()*0.45;
//            mustView.setFitHeight (topAnchor);
//        });

        rightPane.setBottomAnchor(rectangle, 0.0);
        rightPane.setRightAnchor(rectangle, 0.0);
//        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//
//                rightPane.setPrefHeight(basePane.getHeight());
//
//            rightPane.setTopAnchor(mustView, rightPane.getHeight()*0.1);
//            rightPane.setBottomAnchor(mustView,rightPane.getHeight()*0.4);
//
//                rectangle.setHeight(rightPane.getHeight()*0.15);
//                mustView.setFitHeight(rightPane.getHeight()*0.5);
//            }
//        });
//
//
//        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//
//                rightPane.setPrefWidth(basePane.getWidth()*0.7);
//
//                rightPane.setRightAnchor(mustView, rightPane.getWidth()*0.2);
//                rightPane.setLeftAnchor(mustView, rightPane.getWidth()*0.1);
//
//                rectangle.setWidth(rightPane.getWidth()*0.8);
//                mustView.setFitWidth(rightPane.getWidth()*0.7);
//            }
//        });

        basePane.setRight(rightPane);

        //create buttonPane
        HBox bottomPane = new HBox();

        bottomPane.setStyle("-fx-background-color:linear-gradient(to bottom,#FFFF00,#FFFF00) ;");

        //add a buttonbar
        //input the data of bar in the list
//        ArrayList<Integer>recColor = new ArrayList<>(Arrays.asList(5,80,174));
//        ArrayList<Double>recPosition = new ArrayList<>(Arrays.asList(0.9,0.6,0.15,4.0));
//        //instantiate a BaseRectangle which can encapsulate the data
//        BaseRectangle rec =new BaseRectangle(0.0,0.0,recColor,recPosition);
//        Rectangle rectangle = controller.createRectangle(rec);
//        controller.setRectangle(basePane,rectangle,rec);
//        basePane.getChildren().add(rectangle);
        //basePane.setBottom(bottomPane);



        //create leftPane
        AnchorPane leftPane = new AnchorPane();
        leftPane.setMinHeight(110);
        leftPane.setStyle("-fx-background-color:linear-gradient(to bottom,#0000FF,#0000FF) ;");


        // create button
        var normalBtn = new Button("SERVICE");
        // set button action
        normalBtn.setOnAction(e ->controller.showVerScene(primaryStage));
        // set button
        normalBtn.setPrefSize(300, 60);
        normalBtn.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtn.setStyle("-fx-text-fill: #033D8B;");
//        leftPane.setBottomAnchor(normalBtn, 50.0);
//        leftPane.setLeftAnchor(normalBtn, 50.0);
        leftPane.getChildren().add(normalBtn);
        basePane.setLeft(leftPane);
        basePane.setAlignment(rightPane, Pos.BOTTOM_RIGHT);

        primaryStage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                rightPane.setPrefHeight(basePane.getHeight());
                leftPane.setPrefHeight(basePane.getHeight());

                rightPane.setTopAnchor(mustView, rightPane.getHeight()*0.1);
                rightPane.setBottomAnchor(mustView,rightPane.getHeight()*0.35);
                leftPane.setBottomAnchor(normalBtn, leftPane.getHeight()*0.15);

                rectangle.setHeight(rightPane.getHeight()*0.15);
                mustView.setFitHeight(rightPane.getHeight()*0.55);
            }
        });


        primaryStage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                rightPane.setPrefWidth(basePane.getWidth()*0.7);
                leftPane.setPrefWidth(basePane.getWidth()*0.25);

                rightPane.setRightAnchor(mustView, rightPane.getWidth()*0.2);
                rightPane.setLeftAnchor(mustView, rightPane.getWidth()*0.1);
                leftPane.setLeftAnchor(normalBtn, leftPane.getWidth()*0.10);

                rectangle.setWidth(rightPane.getWidth()*0.7);
                mustView.setFitWidth(rightPane.getWidth()*0.7);

            }
        });

        return basePane;
    }

}
