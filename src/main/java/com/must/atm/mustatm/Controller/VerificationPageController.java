package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import com.must.atm.mustatm.Base.StatusBase;
import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Service.CameraServiceImpl;
import com.must.atm.mustatm.Service.VerificationServiceImpl;
import com.must.atm.mustatm.Template.GetStyle;
import javafx.animation.PauseTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * use to create verification page
 * @author 13318
 */
public class VerificationPageController
{
    private static final GetStyle getStyle = new GetStyle();
    private static final ProgressBar progressBar = new ProgressBar(0);
    private static final UserBase user = new UserBase(0, "");
    private static final StackPane basePane = new StackPane();
    private static final ProgressBar bar = new ProgressBar(0);
    private static final VBox progressBox = new VBox();
    private static Stage primaryStage;


    /**
     * use to create verification page
     * @param primaryStage listen window
     * @return VerificationPagePane
     */
    public Pane pane(Stage primaryStage)
    {
        init();

        TimerService service = new TimerService();
        AtomicInteger count = new AtomicInteger(0);
        service.setCount(count.get());
        service.setPeriod(Duration.seconds(1));
        service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

            @Override
            public void handle(WorkerStateEvent t) {
                count.set((int) t.getSource().getValue());
                progressBar.setProgress(count.get() / 100.0);
            }
        });
        service.setDelay(Duration.millis(0));
        service.setPeriod(Duration.millis(30));
        service.start();
        return basePane;
    }
    public void init()
    {
        //create background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");
        //set bar
        bar.setPrefWidth(200);

        // create Text object1
        Text text1 = new Text("Face recognition ...");
        // set font style（font，bold，italic，size）
        text1.setStyle(getStyle.getTextStyle());


        progressBox.getChildren().add(text1);

        //base black box
        Rectangle verificationWindow = new Rectangle();
        verificationWindow.setFill(Color.rgb(0, 0, 0));
        verificationWindow.setHeight(basePane.getHeight() * 0.8);
        verificationWindow.setWidth(basePane.getWidth() * 0.8);
        verificationWindow.setArcHeight(20);
        verificationWindow.setArcWidth(20);
        basePane.getChildren().add(verificationWindow);
        
        //set progressbar and text box

        progressBox.toFront();
        progressBox.setAlignment(Pos.CENTER);
        progressBox.setSpacing(20);
        basePane.getChildren().add(progressBar);
        progressBox.getChildren().add(progressBar);
        basePane.getChildren().add(progressBox);
        
    }

    private static class TimerService extends ScheduledService<Integer> {
        private final IntegerProperty count = new SimpleIntegerProperty();

        public final void setCount(Integer value) {
            count.set(value);
        }

        public final Integer getCount() {
            return count.get();
        }

        public final IntegerProperty countProperty() {
            return count;
        }
        @Override
        protected Task<Integer> createTask() {
            return new Task<Integer>() {
                @Override
                protected Integer call() {
                    //Adds 1 to the count
                    count.set(getCount() + 1);
                    return getCount();
                }
            };
        }
    }

/*    private static class task extends Task<VerificationPageController>
    {
        private final StatusBase status = new StatusBase();
        @Override
        protected void updateValue(Double value)
        {
            progressBar.setProgress(value);
            CameraServiceImpl cameraService = new CameraServiceImpl();
            //cameraService.capture();
            if (timer < 0.5)
            {
                
                try
                {
                    VerificationServiceImpl verificationService = new VerificationServiceImpl();
                    var username = verificationService.faceRecognition("src/main/resources/capture.jpg");
                    if (username != null)
                    {
                        user.setFaceId(username);
                        status.setFaceRecognition(true);
                        progressBox.getChildren().removeFirst();
                        // create Text object2
                        Text text2 = new Text("Face Anti-Spoofing ...");
                        // set font style（font，bold，italic，size）
                        text2.setStyle(getStyle.getTextStyle());

                        progressBox.getChildren().addFirst(text2);
                        if (status.getFaceAntiSpoofing())
                        {
                            progressBox.getChildren().removeAll();
                        }
                        timer = 0.5;
                    } else
                    {
                        status.setFaceRecognition(false);
                    }
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
            } else if (timer >= 0.5)
            {
                if (!status.getFaceRecognition())
                {
                    showFail();
                    basePane.getChildren().remove(progressBar);
                    this.cancel();
                } else
                {
                    try
                    {
                        timer = 1.0;
                        VerificationServiceImpl verificationService = new VerificationServiceImpl();
                        status.setFaceAntiSpoofing(verificationService.faceAntiSpoofing("src/main/resources/capture.jpg"));
                        if (status.getFaceAntiSpoofing())
                        {
                            timer = 1.0;
                            this.cancel();
                            progressBox.getChildren().removeAll();
                            basePane.getChildren().remove(progressBar);
                            VBox sceneRoot = new VBox();
                            ModalPane aboutModalPane = new ModalPane();
                            StackPane aboutPane = new StackPane();
                            aboutModalPane.setId("aboutModal");
                            Dialog aboutDialog = new Dialog(0, 0);
                            aboutDialog.getChildren().add(aboutPane);
                            aboutDialog.setStyle("-fx-background-color: rgba(255,255,255, 0.0);");

                            Rectangle rectangle = new Rectangle();
                            rectangle.setFill(Color.rgb(45, 164, 78));
                            rectangle.setHeight(basePane.getHeight() * 0.3);
                            rectangle.setWidth(basePane.getWidth() * 0.5);
                            rectangle.setArcHeight(20);
                            rectangle.setArcWidth(20);
                            aboutPane.getChildren().add(rectangle);
                            basePane.getChildren().addAll(sceneRoot, aboutModalPane);
                            //success wait time
                            PauseTransition pause = getPauseTransition(aboutModalPane, aboutPane, aboutDialog);
                            pause.setOnFinished(_ ->
                            {
                                aboutModalPane.hide(true);
                                aboutModalPane.setPersistent(false);
                                FunctionPageController functionPage = new FunctionPageController();
                                primaryStage.getScene().setRoot(functionPage.pane(primaryStage, user));
                                System.out.println("OK");
                            });
                        }

                    } catch (Exception e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }*/

    private static PauseTransition getPauseTransition(ModalPane aboutModalPane, StackPane aboutPane, Dialog aboutDialog)
    {
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.02));

        // start pause
        noTime.play();
        noTime.setOnFinished(_ ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
            aboutPane.getChildren().add(successText());
            aboutModalPane.show(aboutDialog);

            System.out.println("aboutDialogOpenBtn");
        });
        return pause;
    }

    private static VBox successText()
    {
        //set success text box
        VBox successText = new VBox();
        successText.setAlignment(Pos.CENTER);
        // create success text
        Text text3 = new Text("RECOGNITION");
        // set font style（font，bold，italic，size）
        text3.setStyle(getStyle.getTextStyleBig());
        successText.getChildren().add(text3);
        Text text4 = new Text("SUCCESS");
        // set font style（font，bold，italic，size）
        text4.setStyle(getStyle.getTextStyleBig());
        successText.getChildren().add(text4);
        return successText;
    }
    /**
     *
     */
    static class Dialog extends VBox
    {
        /**
         * @param width  Dialog width
         * @param height Dialog height
         */
        public Dialog(int width, int height)
        {
            super();

            setSpacing(10);
            setAlignment(Pos.CENTER);
            setMinSize(width, height);
            setMaxSize(width, height);
            setStyle("-fx-background-color: -color-bg-default;");
        }
    }

    private static void showFail()
    {
        //set fail text box
        VBox failText = new VBox();
        failText.setAlignment(Pos.CENTER);
        // create fail text
        Text text5 = new Text("RECOGNITION");
        // set font style（font，bold，italic，size）
        text5.setFont(Font.font("Inter", FontWeight.BOLD, 40));
        text5.setFill(Color.rgb(255, 255, 255));
        failText.getChildren().add(text5);
        Text text6 = new Text("FAIL");
        // set font style（font，bold，italic，size）
        text6.setFont(Font.font("Inter", FontWeight.BOLD, 40));
        text6.setFill(Color.rgb(255, 255, 255));
        failText.getChildren().add(text6);

        VBox sceneRoot = new VBox();
        ModalPane aboutModalPane = new ModalPane();
        StackPane aboutPane = new StackPane();
        aboutModalPane.setId("aboutModal");
        Dialog aboutDialog = new Dialog(0, 0);
        aboutDialog.getChildren().add(aboutPane);
        aboutDialog.setStyle("-fx-background-color: rgba(255,255,255, 0.0);");

        Rectangle rectangle = new Rectangle();
//        Controller controller = new Controller();
        rectangle.setFill(Color.rgb(207, 34, 46));
        rectangle.setHeight(VerificationPageController.basePane.getHeight() * 0.3);
        rectangle.setWidth(VerificationPageController.basePane.getWidth() * 0.5);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        aboutPane.getChildren().add(rectangle);
        VerificationPageController.basePane.getChildren().addAll(sceneRoot, aboutModalPane);

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.1));

        // start pause
        noTime.play();
        noTime.setOnFinished(_ ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
            aboutPane.getChildren().add(failText);
            aboutModalPane.show(aboutDialog);

            System.out.println("aboutDialogOpen");
        });
        pause.setOnFinished(_ ->
        {
            aboutModalPane.hide(true);
            aboutModalPane.setPersistent(false);
            MainPageController mainPage = new MainPageController();
            primaryStage.getScene().setRoot(mainPage.pane(primaryStage));
            System.out.println("OK");
        });
    }
}

