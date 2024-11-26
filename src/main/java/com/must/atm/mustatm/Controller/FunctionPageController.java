package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Base.UserBase;
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

/**create function page
 * @author DOVAKIIN
 */
public class FunctionPageController
{

    public Pane pane(Stage primaryStage, UserBase user)
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
        var btnDeposit = new Button("DEPOSIT");
        var btnWithdraw = new Button("WITHDRAW");
        var btnCheck = new Button("CHECK ACCOUNT");
        var btnExist = new Button("EXIST");

        // set button action
        MainPageController mainPage = new MainPageController();
        btnExist.setOnAction(_ -> primaryStage.getScene().setRoot(mainPage.pane(primaryStage)));
        DepositStateOneController depositPage = new DepositStateOneController();
        btnDeposit.setOnAction(_ -> primaryStage.getScene().setRoot(depositPage.pane(primaryStage,user)));
        WithdrawStateOneController withdrawPage = new WithdrawStateOneController();
        btnWithdraw.setOnAction(_ -> primaryStage.getScene().setRoot(withdrawPage.pane(primaryStage,user)));
        CheckAccountStateOneController checkAccountPage = new CheckAccountStateOneController();
        btnCheck.setOnAction(_ -> primaryStage.getScene().setRoot(checkAccountPage.pane(primaryStage,user)));
        // set button
        // add button to panes
        leftPane.getChildren().addAll(btnDeposit, btnWithdraw, btnCheck);
        rightPane.getChildren().add(btnExist);
        // use ButtonStyle set button's style
        btnDeposit.setStyle(getButtonStyle());
        btnWithdraw.setStyle(getButtonStyle());
        btnCheck.setStyle(getButtonStyle());
        btnExist.setStyle(getButtonStyle());

        //set listener
        basePane.widthProperty().addListener((_, _, _) ->
        {
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            btnDeposit.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnWithdraw.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnCheck.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            btnExist.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);
            AnchorPane.setLeftAnchor(btnDeposit, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(btnWithdraw, primaryStage.getWidth() * 0.05);
            AnchorPane.setLeftAnchor(btnCheck, primaryStage.getWidth() * 0.05);
            AnchorPane.setRightAnchor(btnExist, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((_, _, _) ->
        {
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            AnchorPane.setBottomAnchor(btnDeposit, primaryStage.getHeight() * 0.55);
            AnchorPane.setBottomAnchor(btnWithdraw, primaryStage.getHeight() * 0.35);
            AnchorPane.setBottomAnchor(btnCheck, primaryStage.getHeight() * 0.15);
            AnchorPane.setBottomAnchor(btnExist, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }


}
