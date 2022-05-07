package com.flex.lab1_tsoosi;

import java.util.Map;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineChartGraph extends Graph {

  public LineChartGraph(Map<Double, Double> coordinates, String title, String xAxisUnit,
      String yAxisUnit) {

    NumberAxis xAxis = new NumberAxis();
    NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel(xAxisUnit);
    yAxis.setLabel(yAxisUnit);
    graph = new LineChart<>(xAxis, yAxis);
    graph.setTitle(title);
    ((LineChart)graph).setCreateSymbols(false);
    XYChart.Series series = new XYChart.Series();
    coordinates.forEach((k, v) -> series.getData().add(new XYChart.Data(k, v)));
    graph.getData().add(series);
  }
}
