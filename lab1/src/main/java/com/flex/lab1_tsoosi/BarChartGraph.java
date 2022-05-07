package com.flex.lab1_tsoosi;

import java.util.Map;
import java.util.TreeMap;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BarChartGraph extends Graph {

  public BarChartGraph(Map<Double, Double> coordinates, String title, String xAxisUnit,
      String yAxisUnit) {

    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    graph = new BarChart<>(xAxis, yAxis);
    graph.setTitle(title);
    xAxis.setLabel(xAxisUnit);
    yAxis.setLabel(yAxisUnit);
    XYChart.Series series = new XYChart.Series();
    Map<Double, Double> treeMap = new TreeMap<>();
    treeMap.putAll(coordinates);
    treeMap.forEach((k, v) -> series.getData().add(new XYChart.Data(k.toString(), v)));
    graph.getData().addAll(series);
  }
}
