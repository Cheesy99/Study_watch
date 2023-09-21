package com.example.demo;

import javafx.scene.chart.XYChart;

public class Bars {
    XYChart.Series<String, Double> series;
    public Bars(){
        series = new XYChart.Series<>();
        String[] times = {"05:00", "06:00", "07:00", "08:00", "09:00", "10:00",
                "11:00", "12:00", "13:00", "14:00", "15:00", "16:00",
                "17:00", "18:00", "19:00", "20:00", "21:00", "22:00",
                "23:00"};
        for(String time: times){
            series.getData().add(new XYChart.Data<>(time, 0.0));
        }
        series.getData().add(new XYChart.Data<>("00:00", 55.0)); //19

    }

    public XYChart.Series<String, Double> getSeries(){
        return series;
    }
}
