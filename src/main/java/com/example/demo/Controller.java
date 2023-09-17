package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * The `HelloController` class is a JavaFX controller for managing a timer application.
 * It handles the user interface components and timer logic.
 * @author Tobias Chisi
 */

public class Controller implements Initializable {

    @FXML
    private Text currentTime;
    @FXML
    private Button startButton;
    private Timer timer = new Timer();
    private Timeline timeline;
    @FXML
    private BarChart<String, Integer> barChart;

    @FXML
    private NumberAxis yAxis;

    //private BarChartController barChartController;

    /**
     * Event handler for the "Start" button click.
     * Starts the timer and updates the UI.
     */


    @FXML
    protected void onStartButtonClick() {
      //  barChartController = new BarChartController(barChart);
       // barChartController.initialize();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Customize the Y-axis (NumberAxis)
        barChart.setTitle("Daily Study Hours");
        barChart.setLegendVisible(false);
        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("05:00", 4));
        series.getData().add(new XYChart.Data<>("06:00", 10));
        series.getData().add(new XYChart.Data<>("07:00", 15));
        series.getData().add(new XYChart.Data<>("08:00", 10));
        series.getData().add(new XYChart.Data<>("09:00", 10));
        series.getData().add(new XYChart.Data<>("10:00", 10));
        series.getData().add(new XYChart.Data<>("11:00", 10));
        series.getData().add(new XYChart.Data<>("12:00", 10));
        series.getData().add(new XYChart.Data<>("13:00", 60));
        series.getData().add(new XYChart.Data<>("14:00", 10));
        series.getData().add(new XYChart.Data<>("15:00", 11));
        series.getData().add(new XYChart.Data<>("16:00", 12));
        series.getData().add(new XYChart.Data<>("17:00", 13));
        series.getData().add(new XYChart.Data<>("18:00", 14));
        series.getData().add(new XYChart.Data<>("19:00", 10));
        series.getData().add(new XYChart.Data<>("20:00", 10));
        series.getData().add(new XYChart.Data<>("21:00", 10));
        series.getData().add(new XYChart.Data<>("22:00", 10));
        series.getData().add(new XYChart.Data<>("23:00", 10));
        series.getData().add(new XYChart.Data<>("00:00", 10));
        barChart.getData().add(series);

        yAxis = new NumberAxis(0, 60, 10); // Lower bound: 0, Upper bound: 60, Tick unit: 10

        // Set the custom Y-axis to the bar chart
        barChart.setVerticalGridLinesVisible(false); // Hide vertical grid lines (optional)
        barChart.setVerticalZeroLineVisible(false); // Hide the zero line (optional)
       // Adjust the gap between tick labels and axis






    }
}
