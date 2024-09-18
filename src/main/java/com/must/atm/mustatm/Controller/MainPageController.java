
package com.must.atm.mustatm.Controller;

import com.must.atm.mustatm.Template.BaseRectangle;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * MainPageController is a class which can generate main page
 * @author 13318
 */
public class MainPageController {

    public  Pane createMainPagePane(Stage primaryStage)
    {
        AnchorPane anchorPane = new AnchorPane();
        //set background
        anchorPane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");
        //instantiate a controller
        Controller controller = new Controller();
        // instantiate an image which is the picture of MUST
        String mustPath = "pictureOfMust.png";
        Image must = new Image(mustPath);
        // set the image
        ImageView mustView = new ImageView(must);
        anchorPane.getChildren().add(mustView);
        // set the default size of image
        mustView.setFitWidth(1000);
        mustView.setFitHeight(1000);
        mustView.setPreserveRatio(true);
        //set the position of the image
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue() * 0.35;
            AnchorPane.setTopAnchor(mustView, topAnchor);
        });
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double leftAnchor = (newVal.doubleValue()) * 0.45;
            AnchorPane.setLeftAnchor(mustView, leftAnchor);
        });
        //set the size of image
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            mustView.setFitWidth (topAnchor);
        });
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue()*0.45;
            mustView.setFitHeight (topAnchor);
        });
        //add a buttonbar
        //input the data of bar in the list
        ArrayList<Integer>recColor = new ArrayList<>(Arrays.asList(5,80,174));
        ArrayList<Double>recPosition = new ArrayList<>(Arrays.asList(0.9,0.6,0.15,4.0));
        //instantiate a BaseRectangle which can encapsulate the data
        BaseRectangle rec =new BaseRectangle(0.0,0.0,recColor,recPosition);
        Rectangle rectangle = controller.createRectangle(rec);
        controller.setRectangle(anchorPane,rectangle,rec);
        anchorPane.getChildren().add(rectangle);
        // instantiate a topbar
        String topbarPath = "topbar.png";
        Image topbar = new Image(topbarPath);
        // set topbar
        ImageView topbarView = new ImageView(topbar);
        anchorPane.getChildren().add(topbarView);
        //set the size of title
        topbarView.setFitWidth(1000);
        topbarView.setFitHeight(1000);
        topbarView.setPreserveRatio(true);
        // set position of title
        AnchorPane.setTopAnchor(topbarView, 0.0);
        AnchorPane.setLeftAnchor(topbarView, 0.0);
        //set size of title
        anchorPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue();
            topbarView.setFitWidth (topAnchor);
        });
        anchorPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            double topAnchor = newVal.doubleValue();
            topbarView.setFitHeight (topAnchor);
        });
        // set button
        var normalBtn = new Button("SERVICE");
        normalBtn.setMnemonicParsing(true);
        // set button action
        normalBtn.setOnAction(e ->controller.showVerScene(primaryStage));
        // set button default size
        normalBtn.setPrefSize(300, 60);
        // set text and color of button
        normalBtn.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        normalBtn.setStyle("-fx-text-fill: #033D8B;");
        // set position of button
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
