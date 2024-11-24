package com.must.atm.mustatm.Controller;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 13318
 */
public class main extends Application
{
    public Stage primaryStage;
    MainPageController mainPage = new MainPageController();

    @Override
    public void start(Stage primaryStage)
    {
        // set AtlantaFX stylesheet
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());

        primaryStage.setScene(new Scene(mainPage.pane(primaryStage)));
        primaryStage.setHeight(900);
        primaryStage.setWidth(1500);
        primaryStage.show();
        primaryStage.requestFocus();

    }
}