
package com.must.atm.mustatm.Controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author 13318
 */
public class MainPageController {


    public  Pane createMainPagePane(Stage primaryStage)
    {
        AnchorPane anchorPane = new AnchorPane();

        //创建背景
        anchorPane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");



        main main = new main();

        // 创建must对象
        String mustPath = "pictureOfMust.png";
        Image must = new Image(mustPath);

        // 创建ImageView并设置图片
        ImageView mustView = new ImageView(must);
        anchorPane.getChildren().add(mustView);

        // 设置must大小
        mustView.setFitWidth(1000);
        mustView.setFitHeight(1000);
        mustView.setPreserveRatio(true);

         // 设置must位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue() * 0.35;
            AnchorPane.setTopAnchor(mustView, topAnchor);
        });

        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue()) * 0.45;
            AnchorPane.setLeftAnchor(mustView, leftAnchor);
        });

        //计算must大小
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            mustView.setFitWidth (topAnchor);
        });
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            mustView.setFitHeight (topAnchor);
        });


        //buttonbar

        Rectangle rectangle = main.createRectangle(0,0,5,80,174);
        main.setRectangle(anchorPane,rectangle,0.9,0.6,0.15,4.0);
        anchorPane.getChildren().add(rectangle);



        // 创建topbar对象
        String topbarPath = "topbar.png";
        Image topbar = new Image(topbarPath);

        // 创建ImageView并设置图片
        ImageView topbarView = new ImageView(topbar);
        anchorPane.getChildren().add(topbarView);

        // 设置title大小
        topbarView.setFitWidth(1000);
        topbarView.setFitHeight(1000);
        topbarView.setPreserveRatio(true);

        // 计算title位置
        AnchorPane.setTopAnchor(topbarView, 0.0);
        AnchorPane.setLeftAnchor(topbarView, 0.0);

        //计算title大小
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue();
            topbarView.setFitWidth (topAnchor);
        });
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue();
            topbarView.setFitHeight (topAnchor);
        });



        // 创建Label，设置宽高
//        Label content = new Label("Content");
//        content.prefWidthProperty().bind(anchorPane.widthProperty().multiply(1));
//        content.prefHeightProperty().bind(anchorPane.heightProperty().multiply(1));
//        anchorPane.getChildren().add(content);

        // 创建按钮
        var normalBtn = new Button("SERVICE");
        normalBtn.setMnemonicParsing(true);


        // 创建按钮action

        normalBtn.setOnAction(e ->main.showVerScene(primaryStage));


        // 设置按钮的大小
        normalBtn.setPrefSize(300, 60);

        // 设置按钮内字体样式颜色
        normalBtn.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtn.setStyle("-fx-text-fill: #033D8B;");


        // 计算按钮的位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = (newVal.doubleValue() - normalBtn.getHeight())* 0.9;
            AnchorPane.setTopAnchor(normalBtn, topAnchor);
        });

        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue() - normalBtn.getWidth()) / 20;
            AnchorPane.setLeftAnchor(normalBtn, leftAnchor);
        });
        anchorPane.getChildren().add(normalBtn);


        return anchorPane;
    }

}
