package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import com.must.atm.mustatm.Template.GetStyle;
import javafx.animation.PauseTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * A class which ca ngenerate the third withdraw page
 */
public class WithdrawThreeController {
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
        rectangleMid.setFill(Color.rgb(5, 80, 174));
        middlePane.getChildren().add(rectangleMid);

        GetStyle getStyle = new GetStyle();
        rectangleMid.setStyle("-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.5), 30, 0, 7, 7);");
        //set text
        Text text = new Text("Your Withdraw Is:");
        text.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(text);
        Text textTwo = new Text("Balance will be:");
        textTwo.setStyle(getStyle.getTextStyle());
        text.setStyle(getStyle.getTextStyle());
        middlePane.getChildren().add(textTwo);

        //set text filed
        //need unput from service
        //here need an input
        String Withdraw =getInput();
        var withdraw = new TextField(Withdraw);
        withdraw.setEditable(false);
        withdraw.setStyle(getStyle.getTextFieldStyle());
        middlePane.getChildren().add(withdraw);

        String Balance = getInputTwo();
        var balance = new TextField(Balance);
        balance.setEditable(false);
        balance.setStyle(getStyle.getTextFieldStyle());
        middlePane.getChildren().add(balance);

        // create button
        var btnReturn = new Button("RETURN");
        var btnConfirm = new Button("CONFIRM");
        // set button action
        WithdrawOneController withdrawOneController = new WithdrawOneController();
        WithdrawSuccessController withdrawSuccessController = new WithdrawSuccessController();
        btnReturn.setOnAction(e -> primaryStage.getScene().setRoot(withdrawOneController.pane(primaryStage)));
        btnConfirm.setOnAction(e -> primaryStage.getScene().setRoot(withdrawSuccessController.pane(primaryStage)));
        // set button
        // add button to panes
        rightPane.getChildren().add(btnReturn);
        leftPane.getChildren().add(btnConfirm);
        // use ButtonStyle set button's style
        btnReturn.setStyle(getStyle.getButtonStyle());
        btnConfirm.setStyle(getStyle.getButtonStyle());


        //create dialog
        VBox sceneRoot = new VBox();
        ModalPane aboutModalPane = new ModalPane();
        StackPane aboutPane = new StackPane();
        aboutModalPane.setId("aboutModal");
        Dialog aboutDialog = new Dialog(0,0);
        aboutDialog.getChildren().add(aboutPane);
        aboutDialog.setStyle("-fx-background-color: rgba(255,255,255, 0.0);");
        Rectangle rectangleTwo = new Rectangle();
        rectangleTwo.setFill(Color.rgb(207, 34, 46));
        rectangleTwo.setArcHeight(20);
        rectangleTwo.setArcWidth(20);
        aboutPane.getChildren().add(rectangleTwo);
        VBox textBox = new VBox();
        Text TopText = new Text("WITHDRAWAL FAILED");
        textBox.setSpacing(30);
        textBox.setAlignment(Pos.CENTER);
        TopText.setStyle(getStyle.getTextStyleBig());
        textBox.getChildren().add(TopText);
        aboutPane.getChildren().add(textBox);

        if(getInputWarningInuputWrong()){
            underBasePane.getChildren().addAll(sceneRoot, aboutModalPane);
            Text FailText = new Text("Please input an number in correct format");
            FailText.setStyle(getStyle.getTextStyle());
            textBox.getChildren().add(FailText);
            callDialog( aboutModalPane, aboutDialog, aboutPane, primaryStage, withdrawOneController);
        }else
            if(getInputWarningDepositionWrong()){
                underBasePane.getChildren().addAll(sceneRoot, aboutModalPane);
                Text FailText = new Text("Do not have enough deposit");
                FailText.setStyle(getStyle.getTextStyle());
                textBox.getChildren().add(FailText);
                callDialog( aboutModalPane, aboutDialog, aboutPane, primaryStage, withdrawOneController);
        }






        //set listener
        basePane.widthProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangleTwo.setWidth(primaryStage.getWidth() * 0.5);
            rectangle.setWidth(primaryStage.getWidth() * 0.5);
            rectangleMid.setWidth(primaryStage.getWidth() * 0.45);
            withdraw.setPrefWidth(primaryStage.getWidth() * 0.40);
            balance.setPrefWidth(primaryStage.getWidth() * 0.40);
            middlePane.setLeftAnchor(rectangleMid, primaryStage.getWidth() * 0.02);
            middlePane.setLeftAnchor(text, primaryStage.getWidth() * 0.03);
            middlePane.setLeftAnchor(textTwo, primaryStage.getWidth() * 0.03);
            middlePane.setLeftAnchor(withdraw, primaryStage.getWidth() * 0.03);
            middlePane.setLeftAnchor(balance, primaryStage.getWidth() * 0.03);
            btnReturn.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            btnConfirm.setPrefSize(primaryStage.getWidth() * 0.2, primaryStage.getHeight() * 0.1);
            leftPane.setLeftAnchor(btnConfirm, primaryStage.getWidth() * 0.05);
            rightPane.setRightAnchor(btnReturn, primaryStage.getWidth() * 0.05);
        });
        basePane.heightProperty().addListener((obs, oldVal, newVal) ->
        {
            rectangleTwo.setHeight(primaryStage.getHeight() * 0.4);
            rectangle.setHeight(primaryStage.getHeight() * 0.1);
            rectangleMid.setHeight(primaryStage.getHeight() * 0.4);
            middlePane.setBottomAnchor(rectangleMid, primaryStage.getHeight() * 0.15);
            middlePane.setBottomAnchor(text, primaryStage.getHeight() * 0.48);
            middlePane.setBottomAnchor(textTwo, primaryStage.getHeight() * 0.31);
            middlePane.setBottomAnchor(withdraw, primaryStage.getHeight() * 0.40);
            middlePane.setBottomAnchor(balance, primaryStage.getHeight() * 0.23);
            leftPane.setBottomAnchor(btnConfirm, primaryStage.getHeight() * 0.35);
            rightPane.setBottomAnchor(btnReturn, primaryStage.getHeight() * 0.35);
        });

        return basePane;
    }
    private String getInput(){
        String withdraw ="114514 MOP";

        return withdraw;
    }
    private String getInputTwo(){
        String balance ="114000 MOP";

        return balance;
    }
    private Boolean getInputWarningInuputWrong(){
        return true;
    }
    private Boolean getInputWarningDepositionWrong(){
        return true;
    }
    private void callDialog(ModalPane aboutModalPane,Dialog aboutDialog,StackPane aboutPane,Stage primaryStage,WithdrawOneController withdrawOneController){
        //success wait time
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.02));
//        Text FailText = new Text("Please input an number in correct format");
        // start pause
        aboutModalPane.toFront();
        noTime.play();
        noTime.setOnFinished(_ ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
//            aboutPane.getChildren().add(FailText);
            aboutModalPane.show(aboutDialog);

            System.out.println("aboutDialogOpenBtn");
        });
        pause.setOnFinished(_ ->
        {
            aboutModalPane.hide(false);
            aboutModalPane.setPersistent(true);
            primaryStage.getScene().setRoot(withdrawOneController.pane(primaryStage));
            System.out.println("OK");
        });



    }
    private static class Dialog extends VBox
    {
        /**
         * @param width Dialog width
         * @param height Dialog height
         */
        public Dialog(int width, int height)
        {
            super();

            setSpacing(10);
            setAlignment(Pos.CENTER);
            setMinSize(width, height);
            setMaxSize(width, height);
            setStyle("-fx-background-color: -color-bg-default;");
        }
    }
}
