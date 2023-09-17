package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.chart.*;

public class BarChartController {

    @FXML
    private BarChart<Integer, Integer> barChart;

    protected BarChartController(BarChart barChart){
        this.barChart = barChart;
    }

    public void initialize() {

        CategoryAxis yAxis = new CategoryAxis();
        yAxis.setLabel("Timer");

        // Customize the X-axis (NumberAxis)
        NumberAxis xAxis = new NumberAxis(0, 10, 1);
        xAxis.setLabel("Hours Studied");

        // Configure the BarChart with the axes
        barChart.setTitle("Daily Study Hours");
        barChart.setLegendVisible(false);
        barChart.getYAxis().setTickLabelsVisible(false);

    }


}

