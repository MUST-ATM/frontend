package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Service.AccountServiceImpl;
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
/**
 * A class which can generate the second check account page
 *
 *
 */

public class CheckAccountStateTwoController {
    public Pane pane(Stage primaryStage)
    {
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
        rectangleMid.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(rectangleMid);

        GetStyle getStyle = new GetStyle();
        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        Text text = new Text("Your Account Is:");
        text.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(text);

        //here need an input value
        AccountServiceImpl accountService = new AccountServiceImpl();
        var account = new TextField();
        account.setEditable(false);
        account.setStyle(getStyle.getTextFieldStyle());
        middlePane.getChildren().add(account);


        // create button
        var btnReturn = new Button("RETURN");
        // set button action
        CheckAccountStateOneController checkAccountPage = new CheckAccountStateOneController();
        btnReturn.setOnAction(e -> primaryStage.getScene().setRoot(checkAccountPage.pane(primaryStage)));
        /*
         set button
         add button to panes
         */
        rightPane.getChildren().add(btnReturn);

        // use ButtonStyle set button's style
        btnReturn.setStyle(getStyle.getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);
            account.setPrefWidth(primaryStage.getWidth() * 0.40);
            AnchorPane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.25);
            AnchorPane.setLeftAnchor(text, primaryStage.getWidth() * 0.26);
            AnchorPane.setLeftAnchor(account, primaryStage.getWidth() * 0.26);
            btnReturn.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            AnchorPane.setRightAnchor(btnReturn, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            AnchorPane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(text, primaryStage.getHeight() * 0.48);
            AnchorPane.setBottomAnchor(account, primaryStage.getHeight() * 0.40);
            AnchorPane.setBottomAnchor(btnReturn, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }

    // provide input value
    private String getInput()
    {
        return "114514 MOP";
    }
}
