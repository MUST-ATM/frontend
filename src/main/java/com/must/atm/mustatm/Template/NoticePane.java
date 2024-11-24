package com.must.atm.mustatm.Template;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author bywang
 */
public class NoticePane
{
    private final StackPane aboutPane;
    private final Rectangle background;
    public NoticePane(Stage primaryStage)
    {
        StackPane aboutPane = new StackPane();
        var aboutDialog = dialog();
        aboutDialog.getChildren().add(aboutPane);
        aboutDialog.setStyle("-fx-background-color: rgba(255,255,255, 0.0);");

        Rectangle background = new Rectangle();
        background.setHeight(primaryStage.getHeight() * 0.3);
        background.setWidth(primaryStage.getWidth() * 0.5);
        background.setArcHeight(20);
        background.setArcWidth(20);
        aboutPane.getChildren().add(background);
        this.background = background;
        this.aboutPane = aboutPane;
    }
    public StackPane getAboutPane()
    {
        return this.aboutPane;
    }
    public StackPane failed()
    {
        background.setFill(Color.rgb(207, 34, 46));
        return aboutPane;
    }

    public StackPane failed(VBox failText)
    {
        background.setFill(Color.rgb(207, 34, 46));
        aboutPane.getChildren().add(failText);
        return aboutPane;
    }

    public StackPane succeed()
    {
        background.setFill(Color.rgb(45, 164, 78));
        return aboutPane;
    }
    public StackPane succeed(VBox textPane)
    {
        background.setFill(Color.rgb(45, 164, 78));
        aboutPane.getChildren().add(textPane);
        return aboutPane;
    }
    public static VBox textPane(String text)
    {
        VBox successText = new VBox();
        successText.setAlignment(Pos.CENTER);
        successText.getChildren().add(
                new TextLib(text).noticeText()
        );
        return successText;
    }
    public static VBox textPane(ArrayList<String> textList)
    {
        VBox successText = new VBox();
        successText.setAlignment(Pos.CENTER);
        textList.forEach((text)->
                successText.getChildren().add(
                        new TextLib(text).noticeText()
                ));
        return successText;
    }
    /**
     *
     */
    private VBox dialog()
    {
        var vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setMinSize(0, 0);
        vbox.setMaxSize(0, 0);
        vbox.setStyle("-fx-background-color: -color-bg-default;");
        return vbox;
    }
}
