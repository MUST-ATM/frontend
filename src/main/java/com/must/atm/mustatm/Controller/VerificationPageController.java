package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import com.must.atm.mustatm.Template.BaseRectangle;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;


/**use to create verification page
 *
 * @author 13318
 */
public class VerificationPageController {
    ScheduledService<Double> sche ;


    private void showFail(StackPane basePane,Stage primaryStage){
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        Rectangle redRectangle = new Rectangle();
//        Controller controller = new Controller();
        redRectangle.setFill(Color.rgb(207, 34, 46));
        redRectangle.setHeight(basePane.getHeight() * 0.15);
        redRectangle.setWidth(basePane.getWidth() * 0.5);
        basePane.getChildren().add(redRectangle);

        // start pause
        pause.play();
        pause.setOnFinished(event -> {
//            controller.showMainPage(primaryStage);
            MainPageController mainPage = new MainPageController();
            primaryStage.getScene().setRoot(mainPage.pane(primaryStage));
        });
        System.out.println("OK");
    }
    /**use to create verification page
     *
     * @param primaryStage listen window
     * @return VerificationPagePane
     */
    public Pane pane(Stage primaryStage)
    {
        StackPane basePane = new StackPane  ();

        //recognize and anti-spoofing result
        Boolean verificationResult = true;
        Boolean antiSpoofingResult = true;

        VBox windowPane = new VBox();
        windowPane.setAlignment(Pos.CENTER);
        basePane.getChildren().add(windowPane);



        //create background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");
//        Controller controller = new Controller();


        //set rectangle
        Rectangle redRectangle = new Rectangle();
        redRectangle.setFill(Color.rgb(207,34,46));
        redRectangle.setHeight(basePane.getHeight()*0.15);
        redRectangle.setWidth(basePane.getWidth()*0.5);
        basePane.getChildren().add(redRectangle);

//        // create verificationWindow object
//        String verificationWindowPath = "verificationWindow.png";
//        Image topbar = new Image(verificationWindowPath);
//        // create ImageView and set picture
//        ImageView verificationWindowView = new ImageView(topbar);
//        verificationWindowView.setPreserveRatio(true);
//        StackPane.setAlignment(verificationWindowView, Pos.CENTER);
//        windowPane.getChildren().add(verificationWindowView);


        // create Text object1
//        Text text1 = new Text("Face recognition ...");
//        double faceRecognitionSize = 20;
//        // set font style（font，bold，italic，size）
//        text1.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, faceRecognitionSize));
//        basePane.getChildren().add(text1);
//
//        // create Text object1
//        Text text2 = new Text("Face Anti-Spoofing ...");
//        double antiSpoofingSize = 20;
//        // set font style（font，bold，italic，size）
//        text2.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, antiSpoofingSize));
//        basePane.getChildren().add(text2);




//        set bar
        var bar1 = new ProgressBar(0);
        bar1.setPrefWidth(200);

        sche = new ScheduledService<Double>() {
            double i = 0;
            double number =0;
            @Override
            protected Task<Double> createTask() {
                Task <Double> task = new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return  i=i+0.01;
                    }
                    /**
                     *
                     * @param value the new value
                     */
                    @Override
                    protected void updateValue(Double value) {
                        // create PauseTransition
                        PauseTransition pause = new PauseTransition(Duration.seconds(3));

                        System.out.println(value);
                        bar1.setProgress(value);

                        if(value>=0.5){
                            if(value==0.5){
                                System.out.println("==0.5");
                                pause.play();}
                            if(verificationResult) {
                                if(value>=1){

                                    sche.cancel();
                                    basePane.getChildren().remove(bar1);


                                    if (antiSpoofingResult) {
                                        //set rectangle
//                                        Rectangle rectangle = new Rectangle();
//                                        rectangle.setFill(Color.rgb(45, 164, 78));
//                                        rectangle.setHeight(basePane.getHeight() * 0.15);
//                                        rectangle.setWidth(basePane.getWidth() * 0.5);



                                        DialogPane dialog = new DialogPane();
                                        Stage stage = new Stage();
                                        Scene  scene =new Scene(dialog);
                                        stage.setScene(scene);
                                        stage.initOwner(primaryStage);
                                        stage.initModality(Modality.NONE);
                                        stage.setHeight(basePane.getHeight()*0.7);
                                        stage.setWidth(basePane.getWidth()*0.7);
                                        dialog.setPrefHeight(stage.getHeight());
                                        dialog.setPrefWidth(stage.getWidth());
                                        stage.show();
                                        dialog.setStyle("-fx-background-color:#2da44e ;");













                                        // start pause
                                        pause.play();
                                        // jump when pause finished
                                        pause.setOnFinished(event -> {
//                                            controller.showFunctionPage(primaryStage);
                                            stage.close();
                                            FunctionPageController functionPage = new FunctionPageController();
                                            primaryStage.getScene().setRoot(functionPage.pane(primaryStage));

                                        });
                                        System.out.println("OK");
                                    } else {
                                        //set rectangle
                                        showFail(basePane,primaryStage);
                                    }

                                    System.out.println("end");

                                }
                            } else {
                                //showFail(basePane,primaryStage);
                                System.out.println("jump");
                            }
                        }

                        }

                };
                return  task;
            }
        };
        sche.setDelay(Duration.millis(0));
        sche.setPeriod(Duration.millis(30));
        sche.start();
        basePane.getChildren().add(bar1);

//        set Listener
//        basePane.heightProperty().addListener((obs, oldVal, newVal) -> {
//            verificationWindowView.setFitHeight (basePane.getHeight()*0.8);
////            bar1.setLayoutY(basePane.getHeight()*0.5);
//        });
//        basePane.widthProperty().addListener((obs, oldVal, newVal) -> {
//            verificationWindowView.setFitWidth (basePane.getWidth()*0.8);
////            bar1.setLayoutX(basePane.getWidth()*0.35);
//        });

        return basePane;
    }
}
