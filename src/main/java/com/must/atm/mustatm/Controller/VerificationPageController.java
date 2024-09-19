package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Template.BaseRectangle;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;


/**use to create verification page
 *
 * @author 13318
 */
public class VerificationPageController {
    ScheduledService<Double> sche ;

    /**
     *
     * @param primaryStage
     * @return VerificationPagePane
     */
    public Pane createVerificationPagePane(Stage primaryStage)
    {
        AnchorPane anchorPane = new AnchorPane();
        //recognize and anti-spoofing result
        Boolean verificationResult = false;
        Boolean antiSpoofingResult = true;
        //create background
        anchorPane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");
        Controller controller = new Controller();
        // create PauseTransition
        PauseTransition pause = new PauseTransition(Duration.seconds(3));


        // create verificationWindow object
        String verificationWindowPath = "verificationWindow.png";
        Image topbar = new Image(verificationWindowPath);
        // create ImageView and set picture
        ImageView verificationWindowView = new ImageView(topbar);
        anchorPane.getChildren().add(verificationWindowView);
        // picture size
        verificationWindowView.setFitWidth(500);
        verificationWindowView.setFitHeight(500);
        verificationWindowView.setPreserveRatio(true);
        // picture location
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double picHight = (newVal.doubleValue() )*0.25;
            AnchorPane.setTopAnchor(verificationWindowView, picHight);
        });
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() )*0.25;
            AnchorPane.setLeftAnchor(verificationWindowView, leftAnchor);
        });
        //picture size
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()/2;
            verificationWindowView.setFitWidth (topAnchor);
        });
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()/2;
            verificationWindowView.setFitHeight (topAnchor);
        });


        // create Text object
        Text text1 = new Text("Face recognition ...");
        double faceRecognitionSize = 20;
        // text location
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = (newVal.doubleValue() )*0.45;
            AnchorPane.setTopAnchor(text1, topAnchor);
        });
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() )*0.36;
            AnchorPane.setLeftAnchor(text1, leftAnchor);
        });
        // set font style（font，bold，italic，size）
        text1.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, faceRecognitionSize));
        anchorPane.getChildren().add(text1);


        // create Text object
//        Text text2 = new Text("Face Anti-Spoofing ...");
//        double antiSpoofingSize = 20;
//        // text location
//        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//            double topAnchor = (newVal.doubleValue() )*0.45;
//            AnchorPane.setTopAnchor(text2, topAnchor);
//        });
//        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
//            double leftAnchor = (newVal.doubleValue() )*0.36;
//            AnchorPane.setLeftAnchor(text2, leftAnchor);
//        });
//        // set font style（font，bold，italic，size）
//        text2.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, antiSpoofingSize));
//        anchorPane.getChildren().add(text2);


        //set bar
        var bar1 = new ProgressBar(0);
        bar1.setPrefWidth(200);

        sche = new ScheduledService<Double>() {
            double i =0;
//            double number =0;
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
                        System.out.println(value);
                        bar1.setProgress(value);

                        if(value>=1){

                            sche.cancel();
                            anchorPane.getChildren().remove(bar1);

                            if(verificationResult)
                            {
                                ArrayList<Integer> recColor = new ArrayList<>(Arrays.asList(45,164,78));
                                ArrayList<Double>recPosition = new ArrayList<>(Arrays.asList(0.15,0.15,0.7,0.7));
                                BaseRectangle rec =new BaseRectangle(40.0,40.0,recColor,recPosition);
                                Rectangle rectangle = controller.createRectangle(rec);
                                controller.setRectangle(anchorPane, rectangle, rec);
                                anchorPane.getChildren().add(rectangle);
                                primaryStage.hide();
                                primaryStage.show();
                                // start pause
                                pause.play();
                                // jump when pause finished
                                pause.setOnFinished(event -> {
                                    controller.showFunctionPage(primaryStage);
                                });
                                System.out.println("OK");
                            }else{
                                ArrayList<Integer> recColor = new ArrayList<>(Arrays.asList(207,34,46));
                                ArrayList<Double>recPosition = new ArrayList<>(Arrays.asList(0.15,0.15,0.7,0.7));
                                BaseRectangle rec =new BaseRectangle(40.0,40.0,recColor,recPosition);
                                Rectangle rectangle = controller.createRectangle(rec);
                                controller.setRectangle(anchorPane, rectangle, rec);
                                anchorPane.getChildren().add(rectangle);
                                primaryStage.hide();
                                primaryStage.show();
                                // start pause
                                pause.play();
                                pause.setOnFinished(event -> {
                                    controller.showMainPage(primaryStage);
                                });
                                System.out.println("OK");
                            }
                            System.out.println("end");

                        }

                        }

                };
                return  task;
            }
        };
        sche.setDelay(Duration.millis(0));
        sche.setPeriod(Duration.millis(30));
        sche.start();
        //set position of bar
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = (newVal.doubleValue()*0.5 );
            bar1.setLayoutY(topAnchor);
        });
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() *0.35);
            bar1.setLayoutX(leftAnchor);
        });
        anchorPane.getChildren().add(bar1);
        return anchorPane;
    }
}
