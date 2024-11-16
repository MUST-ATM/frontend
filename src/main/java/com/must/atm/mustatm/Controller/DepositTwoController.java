package com.must.atm.mustatm.Controller;


import com.must.atm.mustatm.Template.GetStyle;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 13318
 */
public class DepositTwoController
    {
        /**
         * @author 13318
         */

        public Pane pane(Stage primaryStage)
        {
            BorderPane basePane = new BorderPane();
            var waitingtime = 60;
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
            StackPane centerPane = new StackPane();
            basePane.setCenter(centerPane);

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


            //waiting window


            Rectangle whiteRect = new Rectangle();
            whiteRect.setFill(Color.rgb(255, 255, 255));
            whiteRect.setArcHeight(40.0);
            whiteRect.setArcWidth(40.0);
            whiteRect.setHeight(centerPane.getHeight() * 0.15);
            whiteRect.setWidth(centerPane.getWidth() * 0.7);




            GetStyle getStyle = new GetStyle();
            //set text
            Text text = new Text("Please Input Your Cash");
            text.setStyle("""
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-text-fill: black;
                -fx-effect: innershadow(gaussian, rgba(0, 0, 0, 0.2), 9, 0, 0, 0);
                -fx-background-color:#0550AE;
                -fx-highlight-text-fill:#FFF8C5;
                -fx-highlight-fill:#FAE17D ;
                   \s""");

            //waiting timer
            Timeline animation;
            AtomicReference<String> S = new AtomicReference<>("");
            AtomicInteger tmp = new AtomicInteger(60);
            Label label = new Label("60s");
            label.setFont(javafx.scene.text.Font.font(20));
            animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> {
                int currentValue = tmp.get();
                if (currentValue > 0)
                {
                    tmp.getAndDecrement();
                    S.set(tmp + "s");
                    label.setText(S.get());
                } else {
                    DepositThreeController DepositThree = new DepositThreeController();
                    primaryStage.getScene().setRoot(DepositThree.pane(primaryStage));
                }

            }));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
            VBox textBox = new VBox(50);
            textBox.getChildren().addAll(text,label);
            textBox.setAlignment(Pos.CENTER);
            centerPane.getChildren().addAll(whiteRect,textBox);
            VBox.setMargin(text, new Insets(-100, 0, 10, 0)); // 向上偏移靠近顶部
            VBox.setMargin(label, new Insets(10, 0, 0, 0));

            // set button
            var normalBtn = new Button("jump");
            DepositThreeController DepositThree = new DepositThreeController();
            normalBtn.setOnAction(_ -> primaryStage.getScene().setRoot(DepositThree.pane(primaryStage)));
            normalBtn.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
            normalBtn.setStyle("-fx-text-fill: #033D8B;");
            leftPane.getChildren().add(normalBtn);


            //set listener
            basePane.widthProperty().addListener((_, _, _) ->
            {
                rectangle.setWidth(primaryStage.getWidth() * 0.5);
                whiteRect.setWidth(primaryStage.getWidth() * 0.3);



            });
            basePane.heightProperty().addListener((_, _, _) ->
            {
                rectangle.setHeight(primaryStage.getHeight() * 0.1);
                whiteRect.setHeight(primaryStage.getHeight() * 0.3);

            });

            return basePane;
        }
    }

