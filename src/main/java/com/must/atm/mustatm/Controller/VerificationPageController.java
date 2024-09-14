package com.must.atm.mustatm.Controller;

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
import javafx.stage.Stage;
import javafx.util.Duration;

public class VerificationPageController {
    ScheduledService<Double> sche ;
    public Pane createVerificationPagePane(Stage primaryStage)
    {
        AnchorPane anchorPane = new AnchorPane();

        //创建背景
        anchorPane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");





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
            double topAnchor = (newVal.doubleValue() )*0.25;
            AnchorPane.setTopAnchor(verificationWindowView, topAnchor);
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


        //创建bar
        var bar1 = new ProgressBar(0);
        bar1.setPrefWidth(200);


        sche = new ScheduledService<Double>() {
            double i =0;
            @Override
            protected Task<Double> createTask() {
                Task <Double> task = new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return  i=i+0.01;

                    }

                    @Override
                    protected void updateValue(Double value) {
                        bar1.setProgress(value);

                        if(value>=1){
                            sche.cancel();

                        }
                    }
                };
                return  task;
            }
        };
        sche.setDelay(Duration.millis(0));
        sche.setPeriod(Duration.millis(500));
        sche.start();
        //bar位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = (newVal.doubleValue()*0.5 );
            bar1.setLayoutX(topAnchor);
//            bar1.setPrefWidth(topAnchor);
        });

        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() *0.25);
            bar1.setLayoutY(leftAnchor);
        });
        anchorPane.getChildren().add(bar1);



        return anchorPane;
    }







}
