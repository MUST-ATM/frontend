package com.must.atm.mustatm.Controller;


import com.must.atm.mustatm.Base.UserBase;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.must.atm.mustatm.Template.GetStyle.*;

/**A class which can generate the deposit fail page
 * @author 13318
 */
public class DepositFailController
{
    public Pane pane(Stage primaryStage, UserBase user){
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
        topBarView.fitWidthProperty().bind(basePane.widthProperty());
        topBarView.setPreserveRatio(true);
        topPane.getChildren().add(topBarView);

        //set rectangle
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(rightPane.getHeight() * 0.15);
        rectangle.setWidth(rightPane.getWidth() * 0.7);
        rectangle.setFill(Color.rgb(5, 80, 174));
        AnchorPane.setBottomAnchor(rectangle, 0.0);
        AnchorPane.setRightAnchor(rectangle, 0.0);
        bottomPane.getChildren().add(rectangle);

        Rectangle rectangleMid = new Rectangle();
        rectangleMid.setFill(Color.rgb(207, 34, 46));
        middlePane.getChildren().add(rectangleMid);

        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        Text text = new Text("DEPOSIT");
        text.setStyle(getTextStyle());
        text.setStyle(getTextStyleBig());
        middlePane.getChildren().add(text);
        Text textTwo = new Text("FAIL");
        textTwo.setStyle(getTextStyleBig());
        middlePane.getChildren().add(textTwo);


        // create button
        var btnContinue = new Button("CONTINUE");
        var btnExist = new Button("EXIST");
        // set button action
        DepositStateOneController DepositOne = new DepositStateOneController();
        MainPageController mainPageController = new MainPageController();
        btnContinue.setOnAction(_ -> primaryStage.getScene().setRoot(DepositOne.pane(primaryStage,user)));
        btnExist.setOnAction(_ -> primaryStage.getScene().setRoot(mainPageController.pane(primaryStage)));

        // add button
        rightPane.getChildren().add(btnContinue);
        leftPane.getChildren().add(btnExist);
        // use ButtonStyle set button's style
        btnContinue.setStyle(getButtonStyle());
        btnExist.setStyle(getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);

            AnchorPane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.02);
            AnchorPane.setLeftAnchor(text, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(textTwo, primaryStage.getWidth() * 0.05);

            btnContinue.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            btnExist.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setRightAnchor(btnContinue, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(btnExist, primaryStage.getWidth() * 0.05);

        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            AnchorPane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(text, primaryStage.getHeight() * 0.45);
            AnchorPane.setBottomAnchor(textTwo, primaryStage.getHeight() * 0.38);


            AnchorPane.setBottomAnchor(btnExist, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(btnContinue, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }

}
