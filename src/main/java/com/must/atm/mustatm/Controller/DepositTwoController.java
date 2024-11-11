package com.must.atm.mustatm.Controller;


import javafx.animation.PauseTransition;
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
import javafx.util.Duration;

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

            //pause
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.play();
            pause.setOnFinished(event -> {
                DepositThreeController depositThree = new DepositThreeController();
                primaryStage.getScene().setRoot(depositThree.pane(primaryStage));
            });

            //progressBar
//            var basicInd = new RingProgressIndicator(0, false);
//
//            var customTextInd = new RingProgressIndicator(0.5, false);
//            customTextInd.setMinSize(75, 75);
//            customTextInd.setStringConverter(new StringConverter<>() {
//                @Override
//                public String toString(Double progress) {
//                    return (int) Math.ceil(progress * 100) + "°";
//                }
//
//                @Override
//                public Double fromString(String progress) {
//                    return 0d;
//                }
//            });
//
//            var reverseInd = new RingProgressIndicator(0.0, true);
//            reverseInd.setMinSize(150, 150);
//
//            var reverseLabel = new Label("0%");
//            reverseLabel.getStyleClass().add(Styles.TITLE_4);
//
//            var reverseBtn = new Button("start");
//            reverseBtn.getStyleClass().addAll(
//                    Styles.BUTTON_CIRCLE, Styles.FLAT
//            );
//            reverseBtn.disableProperty().bind(
//                    reverseInd.progressProperty().greaterThan(0.0)
//            );
//            reverseBtn.setOnAction(evt1 -> {
//                var task = new Task<Void>() {
//                    @Override
//                    protected Void call() throws Exception {
//                        PauseTransition pause = new PauseTransition(Duration.seconds(1));
//                        int steps = 0;
//                        for (int i = 60; i >= steps; i--) {
//                            Thread.sleep(100);
//                            updateProgress(i, steps);
//                            updateMessage(i + "%");
//                        }
//                        return null;
//                    }
//                };
//
//                // reset properties, so we can start a new task
//                task.setOnSucceeded(evt2 -> {
//                    reverseInd.progressProperty().unbind();
//                    reverseLabel.textProperty().unbind();
//                    reverseInd.setProgress(0.0);
//                    reverseLabel.setText("0%");
//                });
//
//                reverseInd.progressProperty().bind(task.progressProperty().multiply(-1).add(1));
//                reverseLabel.textProperty().bind(task.messageProperty());
//
//                new Thread(task).start();
//            });
//
//            var reverseGraphic = new VBox(10, reverseLabel, reverseBtn);
//            reverseGraphic.setAlignment(Pos.CENTER);
//            reverseInd.setGraphic(reverseGraphic);
//            centerPane.getChildren().add(reverseInd);


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
            rightPane.getChildren().add(rectangle);

            // create button
            var normalBtnOne = new Button("wait");


            // set button
            normalBtnOne.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));

            leftPane.getChildren().addAll(normalBtnOne);



            //set listener
            basePane.widthProperty().addListener((obs, oldVal, newVal) ->
            {
                rectangle.setWidth(primaryStage.getWidth() * 0.5);
                normalBtnOne.setPrefSize(primaryStage.getWidth() * 0.3, primaryStage.getHeight() * 0.1);

                AnchorPane.setLeftAnchor(normalBtnOne, primaryStage.getWidth() * 0.05);



            });
            basePane.heightProperty().addListener((obs, oldVal, newVal) ->
            {
                rectangle.setHeight(primaryStage.getHeight() * 0.1);
                AnchorPane.setBottomAnchor(normalBtnOne, primaryStage.getHeight() * 0.55);


            });

            return basePane;
        }


    }

