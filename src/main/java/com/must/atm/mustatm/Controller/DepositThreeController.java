package com.must.atm.mustatm.Controller;


import com.must.atm.mustatm.Template.GetStyle;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author 13318
 */
public class DepositThreeController
{
    public Pane pane(Stage primaryStage)
    {

        boolean deposit = false;
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
        //create bottomPane
        AnchorPane bottomPane = new AnchorPane();
        basePane.setBottom(bottomPane);
        //create centerPane
        AnchorPane middlePane = new AnchorPane();
        basePane.setCenter(middlePane);


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

        // create button
        var btnConfirm = new Button("CONFIRM");

        // set button action
        if (deposit){
            DepositSuccessController success = new DepositSuccessController();
            btnConfirm.setOnAction(_ -> primaryStage.getScene().setRoot(success.pane(primaryStage)));

        }else {
            DepositFailController fail = new DepositFailController();
            btnConfirm.setOnAction(_ -> primaryStage.getScene().setRoot(fail.pane(primaryStage)));
        }
        // set button
        btnConfirm.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        leftPane.getChildren().add(btnConfirm);

        Rectangle rectangleMid = new Rectangle();
        rectangleMid.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(rectangleMid);

        GetStyle getStyle = new GetStyle();
        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        Text text = new Text("Your Deposit Is:");
        text.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(text);
        Text textTwo = new Text("Balance will be:");
        textTwo.setStyle(getStyle.getTextStyle());
        text.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(textTwo);


        //set listener
        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);
            AnchorPane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.02);
            AnchorPane.setLeftAnchor(text, primaryStage.getWidth() * 0.03);
            AnchorPane.setLeftAnchor(textTwo, primaryStage.getWidth() * 0.03);
            btnConfirm.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(btnConfirm, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            AnchorPane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(text, primaryStage.getHeight() * 0.48);
            AnchorPane.setBottomAnchor(textTwo, primaryStage.getHeight() * 0.31);
            AnchorPane.setBottomAnchor(btnConfirm, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }
}
