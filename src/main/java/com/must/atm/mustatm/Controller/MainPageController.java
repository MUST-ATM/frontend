
package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Template.BaseRectangle;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        rightPane.setStyle("-fx-background-color:linear-gradient(to bottom,#008000,#008000) ;");
        // instantiate an image which is the picture of MUST
        Image must = new Image("pictureOfMust.png");
        // set the image
        ImageView mustView = new ImageView(must);
        rightPane.getChildren().add(mustView);
        // set the default size of image
        mustView.setFitWidth(100);
        mustView.setFitHeight(100);
        mustView.setPreserveRatio(true);
        //set the position of the image
        basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue() * 0.1;
            AnchorPane.setTopAnchor(mustView, topAnchor);
        });

        //set the size of image
        basePane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            mustView.setFitWidth (topAnchor);
        });

        AnchorPane.setRightAnchor(mustView, 50.0);

        basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            mustView.setFitHeight (topAnchor);
        });
        basePane.setRight(rightPane);



        //create buttonPane
        HBox bottomPane = new HBox();

        bottomPane.setStyle("-fx-background-color:linear-gradient(to bottom,#FFFF00,#FFFF00) ;");

        //add a buttonbar
        //input the data of bar in the list
        ArrayList<Integer>recColor = new ArrayList<>(Arrays.asList(5,80,174));
        ArrayList<Double>recPosition = new ArrayList<>(Arrays.asList(0.9,0.6,0.15,4.0));
        //instantiate a BaseRectangle which can encapsulate the data
        BaseRectangle rec =new BaseRectangle(0.0,0.0,recColor,recPosition);
        Rectangle rectangle = controller.createRectangle(rec);
        controller.setRectangle(basePane,rectangle,rec);
        basePane.getChildren().add(rectangle);
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
        leftPane.setBottomAnchor(normalBtn, 50.0);
        leftPane.setLeftAnchor(normalBtn, 50.0);
        leftPane.getChildren().add(normalBtn);
        basePane.setLeft(leftPane);

        return basePane;
    }

}
