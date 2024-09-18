package com.must.atm.
        mustatm.Controller;
import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class main extends Application {
    public Stage primaryStage;
    Controller controller = new Controller();
    @Override
    public void start(Stage primaryStage) throws IOException {
        // set AtlantaFX stylesheet
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        controller.showMainPage(primaryStage);
    }
}