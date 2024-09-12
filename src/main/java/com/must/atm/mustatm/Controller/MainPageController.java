package com.must.atm.mustatm.Controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * @author 13318
 */
public class MainPageController {

    public  Pane createPane()
    {
        AnchorPane anchorPane = new AnchorPane();
        
        // 创建图片对象
        String imagePath = "title.png";
        Image image = new Image(imagePath);


        // 创建ImageView并设置图片
        ImageView imageView = new ImageView(image);
        anchorPane.getChildren().add(imageView);

        // 设置图片大小
        imageView.setFitWidth(1000);
        imageView.setFitHeight(1000);
        imageView.setPreserveRatio(true);

        // 设置图片位置
        AnchorPane.setTopAnchor(imageView, 0.0);
        AnchorPane.setLeftAnchor(imageView, 0.0);

        // 创建Label，设置宽高
//        Label content = new Label("Content");
//        content.prefWidthProperty().bind(anchorPane.widthProperty().multiply(1));
//        content.prefHeightProperty().bind(anchorPane.heightProperty().multiply(1));
//        anchorPane.getChildren().add(content);

        // 创建按钮
        var normalBtn = new Button("SERVICE");
        normalBtn.setMnemonicParsing(true);

        // 设置按钮的大小
        normalBtn.setPrefSize(300, 60);

        // 计算按钮的位置
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue() * 0.8;
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
