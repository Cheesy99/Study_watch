package com.example.demo;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class Bars {

    private final BarChart<String, Double> barChart;
    private final XYChart.Series<String, Double> series;

    Bars(BarChart<String, Double> barChart) {
        this.barChart = barChart;
        series = new XYChart.Series<>();
        // Creating the series
        String[] timeArray = {"05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
                "17:00", "18:00", "19:00", "20:00", "21:00", "22:00",
                "23:00"};
        // Making each bars int the for loop
        for (String time : timeArray)
            series.getData().add(new XYChart.Data<>(time , 0.0));
        series.getData().add(new XYChart.Data<>("00:00", 55.0));
    }

    //This is used to more bar height up
    public void updateBarHeights(Double minutesStudied, int hour) {
        XYChart.Series<String, Double> series = barChart.getData().get(0);
        series.getData().get(hour - 5)
                .setYValue(series.getData().get(hour - 5).getYValue() + minutesStudied);
    }

    public XYChart.Series<String, Double> returnSeries() {
        return series;
    }

}
