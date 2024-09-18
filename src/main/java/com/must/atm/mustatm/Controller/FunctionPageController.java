package com.must.atm.mustatm.Controller;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author DOVAKIIN
 */
public class FunctionPageController {

    public Pane createFunctionPagePane(Stage primaryStage)
    {
        AnchorPane anchorPane = new AnchorPane();
        //创建背景
        anchorPane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");
        // 创建topbar对象
        String topbarPath = "topbar.png";
        Image topbar = new Image(topbarPath);
        // 创建ImageView并设置图片
        ImageView topbarView = new ImageView(topbar);
        anchorPane.getChildren().add(topbarView);
        // 设置title大小
//        topbarView.setFitWidth(1000);
//        topbarView.setFitHeight(1000);
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












        return anchorPane;
    }





}
