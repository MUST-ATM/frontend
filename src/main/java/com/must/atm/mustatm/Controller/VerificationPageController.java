package com.must.atm.mustatm.Controller;

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


/**
 *
 * @author 13318
 */
public class VerificationPageController {
    ScheduledService<Double> sche ;

    /**
     *
     * @param primaryStage
     * @return
     */
    public Pane createVerificationPagePane(Stage primaryStage)
    {
        AnchorPane anchorPane = new AnchorPane();

        //识别结果变量
        Boolean verficationResult = false;

        //创建背景
        anchorPane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");

        main main = new main();




        // create PauseTransition
        PauseTransition pause = new PauseTransition(Duration.seconds(3));


        // 创建verificationWindow对象
        String verificationWindowPath = "verificationWindow.png";
        Image topbar = new Image(verificationWindowPath);




        // 创建ImageView并设置图片
        ImageView verificationWindowView = new ImageView(topbar);
        anchorPane.getChildren().add(verificationWindowView);

        // 设置图片大小
        verificationWindowView.setFitWidth(500);
        verificationWindowView.setFitHeight(500);
        verificationWindowView.setPreserveRatio(true);

        // 计算图片位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double picHight = (newVal.doubleValue() )*0.25;
            AnchorPane.setTopAnchor(verificationWindowView, picHight);
        });

        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() )*0.25;
            AnchorPane.setLeftAnchor(verificationWindowView, leftAnchor);
        });

        //计算图片大小
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()/2;
            verificationWindowView.setFitWidth (topAnchor);
        });
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()/2;
            verificationWindowView.setFitHeight (topAnchor);
        });


        // 创建 Text 对象
        Text text = new Text("Face recognition ...");

        double faceRecognitionSize = 20;

        //计算字体大小
//        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
//            double faceRecognitionSize = newVal.doubleValue()/2;
//        });
//        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//            double faceRecognitionSize = newVal.doubleValue()/2;
//        });


        // 计算字体位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = (newVal.doubleValue() )*0.25;
            AnchorPane.setTopAnchor(text, topAnchor);
        });

        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() )*0.25;
            AnchorPane.setLeftAnchor(text, leftAnchor);
        });

        // 设置字体样式（字体，字体加粗，字体斜体，字体大小）
        text.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.ITALIC, faceRecognitionSize));

        anchorPane.getChildren().add(text);



        //创建bar
        var bar1 = new ProgressBar(0);
        bar1.setPrefWidth(200);


        sche = new ScheduledService<Double>() {

            double i =0;
            double number =0;
            @Override
            protected Task<Double> createTask() {
                Task <Double> task = new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return  i=i+0.1;

                    }

                    /**
                     *
                     * @param value the new value
                     */
                    @Override
                    protected void updateValue(Double value) {
                        System.out.println(value);
                        bar1.setProgress(value);

                        if(value>=1&&number<2){
                            bar1.setProgress(0);
                            number = number+1;

                            i=0;

                            sche.restart();
                            System.out.println("end");

                        }
                        if(number>=2){

                            sche.cancel();
                            anchorPane.getChildren().remove(bar1);
                            if(verficationResult)
                            {
                                Rectangle rectangle = main.createRectangle(40, 40, 45, 164, 78);
                                main.setRectangle(anchorPane, rectangle, 0.15, 0.15, 0.7, 0.7);
//                                anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//                                    double y = newVal.doubleValue()*0.15;
//                                    double height = newVal.doubleValue()*0.7;
//                                    rectangle.setY(y);
//                                    rectangle.setHeight(height);
//                                });
//                                anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
//                                    double x = newVal.doubleValue()*0.15 ;
//                                    double width=newVal.doubleValue()*0.7;
//                                    rectangle.setX(x);
//                                    rectangle.setWidth(width);
//                                });
                                anchorPane.getChildren().add(rectangle);
                                primaryStage.hide();
                                primaryStage.show();
                            }else{
                                Rectangle rectangle = main.createRectangle(40, 40, 207, 34, 46);
                                main.setRectangle(anchorPane, rectangle, 0.15, 0.15, 0.7, 0.7);
//                                anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
//                                    double y = newVal.doubleValue()*0.15;
//                                    double height = newVal.doubleValue()*0.7;
//                                    rectangle.setY(y);
//                                    rectangle.setHeight(height);
//                                });
//                                anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
//                                    double x = newVal.doubleValue()*0.15 ;
//                                    double width=newVal.doubleValue()*0.7;
//                                    rectangle.setX(x);
//                                    rectangle.setWidth(width);
//                                });
                                anchorPane.getChildren().add(rectangle);
                                primaryStage.hide();
                                primaryStage.show();
                            }


                                // start pause
                                pause.play();
                                // jump when pause finished
                                pause.setOnFinished(event -> {
                                    main.showFunctionPage(primaryStage);
                                });

                                System.out.println("OK");


                        }
                    }
                };
                return  task;
            }
        };
        sche.setDelay(Duration.millis(0));
        sche.setPeriod(Duration.millis(100));
        sche.start();




        //bar位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = (newVal.doubleValue()*0.5 );
            bar1.setLayoutY(topAnchor);
//            bar1.setPrefWidth(topAnchor);
        });

        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() *0.35);
            bar1.setLayoutX(leftAnchor);
        });
        anchorPane.getChildren().add(bar1);



        return anchorPane;
    }



}
