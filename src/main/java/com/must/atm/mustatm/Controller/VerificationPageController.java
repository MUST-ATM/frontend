package com.must.atm.mustatm.Controller;

import atlantafx.base.controls.ModalPane;
import com.must.atm.mustatm.Base.StatusBase;
import com.must.atm.mustatm.Base.UserBase;
import com.must.atm.mustatm.Service.CameraServiceImpl;
import com.must.atm.mustatm.Service.VerificationServiceImpl;
import com.must.atm.mustatm.Template.NoticePane;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static com.must.atm.mustatm.Template.GetStyle.getTextStyle;
import static com.must.atm.mustatm.Template.NoticePane.textPane;

/**
 * use to create verification page
 * @author 13318,bywang
 */
public class VerificationPageController
{
    private VBox progressBox = new VBox();

    /**
     * show fail page
     * @param basePane the base stack pane
     * @param primaryStage primaryStage
     */
    private static void showFail(StackPane basePane, Stage primaryStage)
    {

        ModalPane aboutModalPane = new ModalPane();
        NoticePane noticePane = new NoticePane(primaryStage);
        aboutModalPane.setId("aboutModal");
        basePane.getChildren().add(aboutModalPane);
        //set fail text box
        var texts = new ArrayList<String>();
        texts.add("RECOGNITION");
        texts.add("FAILED");
        var failed = noticePane.failed(textPane(texts));
        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        PauseTransition noTime = new PauseTransition(Duration.seconds(0.1));

        // start pause
        noTime.play();
        noTime.setOnFinished(_ ->
        {
            pause.play();
            aboutModalPane.setPersistent(true);
            aboutModalPane.show(failed);

            System.out.println("aboutDialogOpen");
        });
        pause.setOnFinished(_ ->
        {
            aboutModalPane.hide(true);
            aboutModalPane.setPersistent(false);
            MainPageController mainPage = new MainPageController();
            primaryStage.getScene().setRoot(mainPage.pane(primaryStage));
        });
    }

    /**
     * use to create verification page
     * @param primaryStage listen window
     * @return VerificationPagePane
     */
    public Pane pane(Stage primaryStage)
    {
        var basePane = new StackPane();
        var progressBar = new ProgressBar(0);
        this.progressBox = new VBox();
        //create background
        basePane.setStyle("-fx-background-color:linear-gradient(to bottom,#0550AE,#0969DA,#B6E3FF,#6E7781) ;");
        //set bar
        progressBar.setPrefWidth(200);

        // create Text object1
        Text text1 = new Text("Face recognition ...");
        // set font style（font，bold，italic，size）
        text1.setStyle(getTextStyle());

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

        servicing(primaryStage, basePane, progressBar);
        return basePane;
    }

    /**
     * Background Thread to execute the verification progress and switch scene function
     * @param primaryStage stage (window)
     * @param basePane     the StackPane that construct the Pane
     * @param progressBar  progressBar
     */
    public void servicing(Stage primaryStage, StackPane basePane, ProgressBar progressBar)
    {
        TimerService service = new TimerService();
        AtomicInteger count = new AtomicInteger(0);
        service.setCount(count.get());
        service.setPeriod(Duration.seconds(1));
        StatusBase status = new StatusBase();
        UserBase user = new UserBase(0, "");
        service.setOnSucceeded(new EventHandler<>()
        {
            /**
             * get the pause transition
             * @param aboutModalPane modalPane
             * @param succeed succeed
             * @return pause
             */
            private static PauseTransition getPauseTransition(ModalPane aboutModalPane, StackPane succeed)
            {
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                PauseTransition noTime = new PauseTransition(Duration.seconds(0.02));

                // start pause
                noTime.play();
                noTime.setOnFinished(_ ->
                {
                    pause.play();
                    aboutModalPane.setPersistent(true);
                    aboutModalPane.show(succeed);

                    System.out.println("aboutDialogOpenBtn");
                });
                return pause;
            }

            /**
             * handle the event, count the progress and switch scene
             * @param t timer event
             */
            @Override
            public void handle(WorkerStateEvent t)
            {

                progressBar.setProgress(progressBar.getProgress()+(int) t.getSource().getValue() / 100.0);
                CameraServiceImpl cameraService = new CameraServiceImpl();
                //cameraService.capture();
                if (progressBar.getProgress() < 0.5)
                {
                    try
                    {
                        VerificationServiceImpl verificationService = new VerificationServiceImpl();
                        var username = verificationService.faceRecognition("src/main/resources/pictureOfMust.png");
                        if (username != null)
                        {
                            user.setFaceId(username);
                            status.setFaceRecognition(true);
                            //set the count, don't forget the count control the progress
                            progressBar.setProgress(0.5);
                            progressBox.getChildren().removeFirst();
                            // create Text object2
                            Text text2 = new Text("Face Anti-Spoofing ...");
                            // set font style（font，bold，italic，size）
                            text2.setStyle(getTextStyle());
                            progressBox.getChildren().addFirst(text2);
                        }
                    } catch (IOException e)
                    {
                        showFail(basePane,primaryStage);
                        throw new RuntimeException(e);
                    }
                } else if (progressBar.getProgress() >= 0.5)
                {
                    if (!status.getFaceRecognition())
                    {
                        showFail(basePane, primaryStage);
                        progressBox.getChildren().remove(progressBar);
                        service.cancel();
                    } else
                    {
                        try
                        {
                            VerificationServiceImpl verificationService = new VerificationServiceImpl();
                            status.setFaceAntiSpoofing(verificationService.faceAntiSpoofing("src/main/resources/pictureOfMust.png"));
                            if (status.getFaceAntiSpoofing())
                            {
                                progressBar.setProgress(1);
                                service.cancel();
                                progressBox.getChildren().removeAll();
                                ModalPane aboutModalPane = new ModalPane();
                                NoticePane noticePane = new NoticePane(primaryStage);
                                //set success text box
                                var texts = new ArrayList<String>();
                                texts.add("RECOGNITION");
                                texts.add("SUCCESS");
                                var succeed = noticePane.succeed(textPane(texts));

                                basePane.getChildren().addAll(aboutModalPane, succeed);
                                //success wait time
                                PauseTransition pause = getPauseTransition(aboutModalPane, succeed);
                                pause.setOnFinished(_ ->
                                {
                                    aboutModalPane.hide(true);
                                    aboutModalPane.setPersistent(false);
                                    FunctionPageController functionPage = new FunctionPageController();
                                    primaryStage.getScene().setRoot(functionPage.pane(primaryStage, user));
                                });
                            } else
                            {
                                showFail(basePane, primaryStage);
                                service.cancel();
                            }

                        } catch (Exception e)
                        {
                            showFail(basePane,primaryStage);
                            throw new RuntimeException(e);
                        }
                    }
                } else if (progressBar.getProgress() >= 1)
                {
                    showFail(basePane, primaryStage);
                }
            }
        });
        service.setDelay(Duration.millis(0));
        service.setPeriod(Duration.millis(30));
        service.start();
    }

    /**
     * TimerService
     */
    private static class TimerService extends ScheduledService<Integer>
    {
        private final IntegerProperty count = new SimpleIntegerProperty();

        public final Integer getCount()
        {
            return count.get();
        }

        public final void setCount(Integer value)
        {
            count.set(value);
        }

        @Override
        protected Task<Integer> createTask()
        {
            return new Task<>()
            {
                @Override
                protected Integer call()
                {
                    //Adds 1 to the count
                    count.set(getCount() + 1);
                    return getCount();
                }
            };
        }
    }
}