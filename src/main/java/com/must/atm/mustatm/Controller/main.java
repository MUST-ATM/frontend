package com.must.atm.mustatm.Controller;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 13318
 */
public class main extends Application
{
    public Stage primaryStage;
    //    Controller controller = new Controller();


    @Override
    public void start(Stage primaryStage) throws IOException
    {
        // set AtlantaFX stylesheet
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        primaryStage.setTitle("MUST ATM");
        primaryStage.setScene(new Scene(new MainPageController().pane(primaryStage)));
        primaryStage.setHeight(900);
        primaryStage.setWidth(1500);
        primaryStage.show();
        primaryStage.requestFocus();
    }
}