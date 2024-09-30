package com.must.atm.mustatm.Controller;

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
        rightPane.setBottomAnchor(rectangle, 0.0);
        rightPane.setRightAnchor(rectangle, 0.0);
        rightPane.getChildren().add(rectangle);

        // instantiate an image which is the picture of MUST
        Image must = new Image("pictureOfMust.png");
        // set the image
        ImageView mustView = new ImageView(must);
        mustView.setPreserveRatio(true);
        rightPane.getChildren().add(mustView);

        // create button
        var normalBtn = new Button("SERVICE");
        // set button action
        normalBtn.setOnAction(e ->controller.showVerScene(primaryStage));
        // set button
        normalBtn.setPrefSize(300, 60);
        normalBtn.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtn.setStyle("-fx-text-fill: #033D8B;");
        leftPane.getChildren().add(normalBtn);

        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            rectangle.setWidth(basePane.getWidth()*0.5);
            normalBtn.setPrefSize(basePane.getWidth()*0.3,60);
            leftPane.setLeftAnchor(normalBtn, leftPane.getWidth()*0.10);
            mustView.setFitWidth (topAnchor);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            rectangle.setHeight(basePane.getHeight()*0.1);
            leftPane.setBottomAnchor(normalBtn, leftPane.getHeight()*0.15);
            AnchorPane.setTopAnchor(mustView, topAnchor*0.1);
        });
        
        return basePane;
    }

}
