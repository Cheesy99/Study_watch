package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalTime;
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
    private BarChart<String, Double> barChart;


    //private BarChartController barChartController;

    /**
     * Event handler for the "Start" button click.
     * Starts the timer and updates the UI.
     */

    //TODO: should go into a separate class it should extend the button class
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

    //TODO: should go into a separate class it should extend the button class

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

    //TODO: should go into a separate class it should extend the button class
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
            LocalTime startTime = LocalTime.of(5, 0); // 05:00
            LocalTime endTime = LocalTime.of(23, 0); // 23:00
            LocalTime currentTime = LocalTime.now();
            if(currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                updateBarHeights(0.016666666666666666666666666666666666666, currentTime.getHour());
            }
        }));
    }
        //TODO: This method should go into bars class
    private void updateBarHeights(Double minutesStudied, int hour) {
        XYChart.Series<String, Double> series = barChart.getData().get(0);
        series.getData().get(hour - 5)
                .setYValue(series.getData().get(hour - 5).getYValue() + minutesStudied);
    }

    //TODO:  Make a separate class for the bars this method should be in it and shortened if possible
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Setting up the bar chart with the axes and starter data
        barChart.setTitle("Daily Study Hours");
        barChart.setLegendVisible(false);
        //Optimization ideas: String[] times = {"05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
        XYChart.Series<String, Double> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>("05:00", 0.0)); //0
        series.getData().add(new XYChart.Data<>("06:00", 0.0)); //1
        series.getData().add(new XYChart.Data<>("07:00", 0.0)); //2
        series.getData().add(new XYChart.Data<>("08:00", 0.0)); //3
        series.getData().add(new XYChart.Data<>("09:00", 0.0)); //4
        series.getData().add(new XYChart.Data<>("10:00", 0.0)); //5
        series.getData().add(new XYChart.Data<>("11:00", 0.0)); //6
        series.getData().add(new XYChart.Data<>("12:00", 0.0)); //7
        series.getData().add(new XYChart.Data<>("13:00", 0.0)); //8
        series.getData().add(new XYChart.Data<>("14:00", 0.0)); //9
        series.getData().add(new XYChart.Data<>("15:00", 0.0)); //10
        series.getData().add(new XYChart.Data<>("16:00", 0.0)); //11
        series.getData().add(new XYChart.Data<>("17:00", 0.0)); //12
        series.getData().add(new XYChart.Data<>("18:00", 0.0)); //13
        series.getData().add(new XYChart.Data<>("19:00", 0.0)); //14
        series.getData().add(new XYChart.Data<>("20:00", 0.0)); //15
        series.getData().add(new XYChart.Data<>("21:00", 0.0)); //16
        series.getData().add(new XYChart.Data<>("22:00", 0.0)); //17
        series.getData().add(new XYChart.Data<>("23:00", 0.0)); //18
        series.getData().add(new XYChart.Data<>("00:00", 55.0)); //19
        barChart.getData().add(series);

        // Set the custom Y-axis to the bar chart
        // Styling Bar Chart
        XYChart.Series<String, Double> style = barChart.getData().get(0); // These are the bars
        barChart.setAnimated(false); // Disable animations (optional)
        barChart.setVerticalGridLinesVisible(false); // Hide vertical grid lines (optional)
        style.getData().get(0).getNode().setStyle("-fx-bar-fill: #c7d95b"); // Red
        style.getData().get(1).getNode().setStyle("-fx-bar-fill: #c9e707");
        style.getData().get(2).getNode().setStyle("-fx-bar-fill: #94e04c");
        style.getData().get(3).getNode().setStyle("-fx-bar-fill: #94fd2f");
        style.getData().get(4).getNode().setStyle("-fx-bar-fill: #61dc40");
        style.getData().get(5).getNode().setStyle("-fx-bar-fill: #27e34d");
        style.getData().get(6).getNode().setStyle("-fx-bar-fill: #27e3b1");
        style.getData().get(7).getNode().setStyle("-fx-bar-fill: #27dde3");
        style.getData().get(8).getNode().setStyle("-fx-bar-fill: #2795e3");
        style.getData().get(9).getNode().setStyle("-fx-bar-fill: #2746e3");
        style.getData().get(10).getNode().setStyle("-fx-bar-fill: #8d56e1");
        style.getData().get(11).getNode().setStyle("-fx-bar-fill: #670df1");
        style.getData().get(12).getNode().setStyle("-fx-bar-fill: #b00df1");
        style.getData().get(13).getNode().setStyle("-fx-bar-fill: #f10dd3");
        style.getData().get(14).getNode().setStyle("-fx-bar-fill: #f10d74");
        style.getData().get(15).getNode().setStyle("-fx-bar-fill: #f10d4a");
        style.getData().get(16).getNode().setStyle("-fx-bar-fill: #ec0606");
        style.getData().get(17).getNode().setStyle("-fx-bar-fill: #da4c2d");
        style.getData().get(18).getNode().setStyle("-fx-bar-fill: #da8f2d");
        // made the last bar transparent as I could find out how to keep the scale of the graph constant
        style.getData().get(19).getNode().setStyle("-fx-bar-fill: rgba(0, 0, 255, 0.0)");


        System.out.println(LocalTime.now().getHour());

    }
  }
