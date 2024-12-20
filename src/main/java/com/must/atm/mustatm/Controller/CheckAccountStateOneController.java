package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Service.Type.cardType;
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

import static com.must.atm.mustatm.Template.GetStyle.getButtonStyle;

/**
 * A class which can generate the first check account page
 * @author bywang,jingye
 */
public class CheckAccountStateOneController
{
    public Pane pane(Stage primaryStage,UserBase user)
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
        btnReturn.setOnAction(_ -> primaryStage.getScene().setRoot(functionPage.pane(primaryStage, user)));
        CheckAccountStateTwoController checkAccountTwo = new CheckAccountStateTwoController();
        btnOtherAccount.setOnAction(_ -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage,user, cardType.CNY)));
        btnMopAccount.setOnAction(_ -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage,user, cardType.MOP)));
        btnHkdAccount.setOnAction(_ -> primaryStage.getScene().setRoot(checkAccountTwo.pane(primaryStage,user, cardType.HKD)));

        // add button
        leftPane.getChildren().addAll(btnOtherAccount, btnMopAccount, btnHkdAccount);
        rightPane.getChildren().add(btnReturn);
        // use ButtonStyle set button's style
        btnOtherAccount.setStyle(getButtonStyle());
        btnMopAccount.setStyle(getButtonStyle());
        btnHkdAccount.setStyle(getButtonStyle());
        btnReturn.setStyle(getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            btnOtherAccount.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnMopAccount.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnHkdAccount.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnReturn.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(btnOtherAccount, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(btnMopAccount, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(btnHkdAccount, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(btnReturn, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            AnchorPane.setBottomAnchor(btnOtherAccount, primaryStage.getHeight() * 0.55);
            AnchorPane.setBottomAnchor(btnMopAccount, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(btnHkdAccount, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(btnReturn, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }
}
