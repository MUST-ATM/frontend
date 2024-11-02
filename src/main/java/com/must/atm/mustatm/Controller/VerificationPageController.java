package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import javafx.animation.PauseTransition;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * use to create verification page
 *
 * @author 13318
 */
public class VerificationPageController
{
    ScheduledService<Double> sche;


    /**
     * use to create verification page
     *
     * @param primaryStage listen window
     * @return VerificationPagePane
     */
    public Pane pane(Stage primaryStage)
    {
        StackPane basePane = new StackPane();

        //recognize and anti-spoofing result
        Boolean verificationResult = true;
            Boolean antiSpoofingResult = true;
        final int[] verificationStage = {1};
        final Boolean[] fail = {false};

        //create background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");

//        set bar
        var progressBar = new ProgressBar(0);
        progressBar.setPrefWidth(200);

        sche = new ScheduledService<>()
        {
            double i = 0;

            @Override
            protected Task<Double> createTask()
            {
                Task<Double> task = new Task<>()
                {
                    @Override
                    protected Double call() throws Exception
                    {
                        return i = i + 0.01;
                    }

                    /**
                     *
                     * @param value the new value
                     */
                    @Override
                    protected void updateValue(Double value)
                    {


                        System.out.println(value);
                        progressBar.setProgress(value);

                        // create Text object1
                        Text text1 = new Text("Face recognition ...");
                        double faceRecognitionSize = 20;
                        // set font style（font，bold，italic，size）
                        text1.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, faceRecognitionSize));
                        text1.setFill(Color.rgb(255, 255, 255));

                        // create Text object2
                        Text text2 = new Text("Face Anti-Spoofing ...");
                        double antiSpoofingSize = 20;
                        // set font style（font，bold，italic，size）
                        text2.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, antiSpoofingSize));
                        text2.setFill(Color.rgb(255, 255, 255));

                        //set success text box
                        VBox  successText= new VBox();
                        successText.setAlignment(Pos.CENTER);
                        // create success text
                        Text text3 = new Text("RECOGNITION");
                        // set font style（font，bold，italic，size）
                        text3.setFont(Font.font("Inter", FontWeight.BOLD, 40));
                        text3.setFill(Color.rgb(255,255,255));
                        successText.getChildren().add(text3);
                        Text text4 = new Text("SUCCESS");
                        // set font style（font，bold，italic，size）
                        text4.setFont(Font.font("Inter", FontWeight.BOLD, 40));
                        text4.setFill(Color.rgb(255,255,255));
                        successText.getChildren().add(text4);



                        //set progressbar and text box
                        VBox progressBox = new VBox();
                        progressBox.setAlignment(Pos.CENTER);
                        progressBox.setSpacing(20);

                        progressBox.getChildren().add(progressBar);
                        basePane.getChildren().add(progressBox);

                        //base black box
                        Rectangle verificationWindow = new Rectangle();
                        verificationWindow.setFill(Color.rgb(0, 0, 0));
                        verificationWindow.setHeight(basePane.getHeight() * 0.8);
                        verificationWindow.setWidth(basePane.getWidth() * 0.8);
                        verificationWindow.setArcHeight(20);
                        verificationWindow.setArcWidth(20);
                        basePane.getChildren().add(verificationWindow);
                        progressBox.toFront();

                        //if result is fail
                        if (fail[0])
                        {
                            showFail(basePane, primaryStage);
                            sche.cancel();
                            basePane.getChildren().remove(progressBar);
                        }

                        //verification stage
                        if (verificationStage[0] == 1)
                        {
                            progressBox.getChildren().addFirst(text1);
                            if (verificationResult && value <= 0.5)
                            {
                                i = 0.5;
                                progressBox.getChildren().remove(text1);
                                verificationStage[0] = 2;
                            }
                            if (value > 0.5)
                            {
                                progressBox.getChildren().remove(text1);
                                fail[0] = true;
                            }
                        }
                        //anti-spoofing stage
                        if (verificationStage[0] == 2)
                        {
                            progressBox.getChildren().addFirst(text2);
                            try
                            {

                                if (antiSpoofingResult)
                                {
                                    //if verification success
                                    i = 1.0;
                                    sche.cancel();
                                    progressBox.getChildren().remove(text2);
                                    basePane.getChildren().remove(progressBar);

                                    VBox sceneRoot = new VBox();
                                    ModalPane aboutModalPane = new ModalPane();
                                    StackPane aboutPane = new StackPane();
                                    aboutModalPane.setId("aboutModal");
                                    Dialog aboutDialog = new Dialog(0,0);
                                    aboutDialog.getChildren().add(aboutPane);
                                    aboutDialog.setStyle("-fx-background-color: rgba(255,255,255, 0.0);");

                                    Rectangle rectangle = new Rectangle();
                                    rectangle.setFill(Color.rgb(45, 164, 78));
                                    rectangle.setHeight(basePane.getHeight() * 0.3);
                                    rectangle.setWidth(basePane.getWidth() * 0.5);
                                    rectangle.setArcHeight(20);
                                    rectangle.setArcWidth(20);
                                    aboutPane.getChildren().add(rectangle);
                                    basePane.getChildren().addAll(sceneRoot, aboutModalPane);

                                    PauseTransition pause = new PauseTransition(Duration.seconds(3));
                                    PauseTransition noTime = new PauseTransition(Duration.seconds(0.02));

                                    // start pause
                                    noTime.play();
                                    noTime.setOnFinished(event ->
                                    {
                                        pause.play();
                                        aboutModalPane.setPersistent(true);
                                        aboutPane.getChildren().add(successText);
                                        aboutModalPane.show(aboutDialog);

                                        System.out.println("aboutDialogOpenBtn");
                                    });
                                    pause.setOnFinished(event ->
                                    {
                                        aboutModalPane.hide(true);
                                        aboutModalPane.setPersistent(false);
                                        FunctionPageController functionPage = new FunctionPageController();
                                        primaryStage.getScene().setRoot(functionPage.pane(primaryStage));
                                        System.out.println("OK");
                                    });
                                    System.out.println("tryend");

                                }
                                else
                                {
                                    progressBox.getChildren().remove(text2);
                                    fail[0] = true;
                                }
                            }
                            catch (NullPointerException e)
                            {
                                if (value >= 1.0)
                                {
                                    fail[0] = true;
                                }
                            }

                        }
                    }
                };
                return task;
            }
        };
        sche.setDelay(Duration.millis(0));
        sche.setPeriod(Duration.millis(30));
        sche.start();
        basePane.getChildren().add(progressBar);

        return basePane;
    }

    /**
     *
     */
    private static class Dialog extends VBox
    {
        /**
         * @param width
         * @param height
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
    private void showFail(StackPane basePane, Stage primaryStage)
    {
        //set fail text box
        VBox  failText= new VBox();
        failText.setAlignment(Pos.CENTER);
        // create fail text
        Text text5 = new Text("RECOGNITION");
        // set font style（font，bold，italic，size）
        text5.setFont(Font.font("Inter", FontWeight.BOLD, 40));
        text5.setFill(Color.rgb(255,255,255));
        failText.getChildren().add(text5);
        Text text6 = new Text("FAIL");
        // set font style（font，bold，italic，size）
        text6.setFont(Font.font("Inter", FontWeight.BOLD, 40));
        text6.setFill(Color.rgb(255,255,255));
        failText.getChildren().add(text6);

        VBox sceneRoot = new VBox();
        ModalPane aboutModalPane = new ModalPane();
        StackPane aboutPane = new StackPane();
        aboutModalPane.setId("aboutModal");
        Dialog aboutDialog = new Dialog(0,0);
        aboutDialog.getChildren().add(aboutPane);
        aboutDialog.setStyle("-fx-background-color: rgba(255,255,255, 0.0);");

        Rectangle rectangle = new Rectangle();
//        Controller controller = new Controller();
        rectangle.setFill(Color.rgb(207, 34, 46));
        rectangle.setHeight(basePane.getHeight() * 0.3);
        rectangle.setWidth(basePane.getWidth() * 0.5);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        aboutPane.getChildren().add(rectangle);
        basePane.getChildren().addAll(sceneRoot, aboutModalPane);

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.1));

        // start pause
        noTime.play();
        noTime.setOnFinished(event ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
            aboutPane.getChildren().add(failText);
            aboutModalPane.show(aboutDialog);

            System.out.println("aboutDialogOpen");
        });
        pause.setOnFinished(event ->
        {
            aboutModalPane.hide(true);
            aboutModalPane.setPersistent(false);
            MainPageController mainPage = new MainPageController();
            primaryStage.getScene().setRoot(mainPage.pane(primaryStage));
            System.out.println("OK");
        });
    }
}
