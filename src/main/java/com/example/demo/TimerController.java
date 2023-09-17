package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
 * The `HelloController` class is a JavaFX controller for managing a timer application.
 * It handles the user interface components and timer logic.
 * @author Tobias Chisi
 */

public class TimerController {

    @FXML
    private Text currentTime;
    @FXML
    private Button startButton;
    private Timer timer = new Timer();
    private Timeline timeline;

    /**
     * Event handler for the "Start" button click.
     * Starts the timer and updates the UI.
     */

    @FXML
    protected void onStartButtonClick() {
        if (!timer.isRunning) {
            timeline = createTimeline();
            timeline.setCycleCount(Timeline.INDEFINITE);
            currentTime.setText(timer.getCurrentTime());
            timeline.play();
            timer.isRunning = true;
            startButton.setDisable(true); // Disable the start button while the timer is running
        } else
            throw new IllegalStateException("Implementation error at onStartButtonClick()");
    }


    @FXML
    protected void onResetButtonClick() {
        timer.reset();
        currentTime.setText(timer.getCurrentTime());
        timeline.stop();
        startButton.setDisable(false);
        timer.isRunning = false;
    }
    /**
     * Event handler for the "Stop" button click.
     * Stops the timer and enables the "Start" button.
     */

    @FXML
    protected void onStopButtonClick() {
        timeline.stop();
        startButton.setDisable(false);
        timer.isRunning = false;
    }

    /**
     * Creates and configures a Timeline for updating the current time display.
     *
     * @return A configured Timeline for updating the time display.
     */
    private Timeline createTimeline() {
        return new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            timer.runSeconds();
            currentTime.setText(timer.getCurrentTime());
        }));
    }

}
