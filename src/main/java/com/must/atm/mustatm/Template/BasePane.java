package com.must.atm.mustatm.Template;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * BaseRectangle is the class for storing data of Rectangles
 *
 * @author jingye
 */
public class BasePane
{
    private final BorderPane basePane;
    private final AnchorPane middlePane;
    private final AnchorPane rightPane;
    private final AnchorPane leftPane;
    public BasePane(Stage primaryStage)
    {
        var basePane = new BorderPane();

        var coverPane = new StackPane();

        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#AFB8C1,#8C959F) ;");

        //creat topPane
        HBox topPane = new HBox();
        basePane.setTop(topPane);
        //create middlePane
        AnchorPane middlePane = new AnchorPane();
        basePane.setCenter(middlePane);
        //create rightPane
        AnchorPane rightPane = new AnchorPane();
        basePane.setRight(rightPane);
        //create bottomPane
        AnchorPane bottomPane = new AnchorPane();
        basePane.setBottom(bottomPane);
        AnchorPane leftPane = new AnchorPane();
        basePane.setLeft(leftPane);

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
//        rectangle.setHeight(rightPane.getHeight() * 0.15);
//        rectangle.setWidth(rightPane.getWidth() * 0.7);
        AnchorPane.setBottomAnchor(rectangle, 0.0);
        AnchorPane.setRightAnchor(rectangle, 0.0);
        bottomPane.getChildren().add(rectangle);

        this.basePane = basePane;
        this.middlePane = middlePane;
        this.leftPane = leftPane;
        this.rightPane = rightPane;
        basePane.widthProperty().addListener((_,_,_)->
                rectangle.setWidth(primaryStage.getWidth() * 0.5));
        basePane.heightProperty().addListener((_,_,_)->
                rectangle.setHeight(primaryStage.getHeight() * 0.1));
    }

    public BorderPane getBasePane()
    {
        return basePane;
    }

//    public StackPane getCoverPane()
//    {
//        return coverPane()
//    }

    public AnchorPane getMiddlePane()
    {
        return middlePane;
    }

    public AnchorPane getRightPane()
    {
        return rightPane;
    }

    public AnchorPane getLeftPane()
    {
        return leftPane;
    }
}
