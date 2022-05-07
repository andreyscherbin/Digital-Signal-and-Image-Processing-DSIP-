package com.flex.lab1_tsoosi;

import javafx.scene.Group;

public class Drawing extends Group {

  public Drawing() {
    Graph originalFunction = new LineChartGraph(FourierFunction.getOriginalGraph(), "y=sin(x)+cos(4x)", "Radians", "Amplitude");

    Graph graph1 = new BarChartGraph(
        FourierFunction.getDiscreteFourierGraph(FourierFunction.getOriginalGraphForDFT()), "DFT (Spectrum)", "Frequency (Hz)", "Magnitude");
    graph1.getGraph().setTranslateX(510);

    Graph graph2 = new BarChartGraph(FourierFunction.getPhaseCharacteristics(1),
        "Phase Characteristics(DFT)","Frequency (Hz)","Phase (radians)");
    graph2.getGraph().setTranslateX(1010);

    Graph graph3 = new LineChartGraph(FourierFunction.getReverseFourier(1), "Reverse transform (DFT)", "Radians", "Amplitude");
    graph3.getGraph().setTranslateX(1510);

    Graph graph4 = new BarChartGraph(
        FourierFunction.getFastFourierGraph(FourierFunction.getOriginalGraph()), "FFT (Spectrum)", "Frequency (Hz)", "Magnitude");
    graph4.getGraph().setTranslateX(510);
    graph4.getGraph().setTranslateY(400);

    Graph graph5 = new BarChartGraph(FourierFunction.getPhaseCharacteristics(0), "Phase Characteristics(FFT)", "Frequency (Hz)", "Phase (radians");
    graph5.getGraph().setTranslateX(1010);
    graph5.getGraph().setTranslateY(400);

    Graph graph6 = new LineChartGraph(FourierFunction.getReverseFourier(0), "Reverse transform (FFT)", "Radians", "Amplitude");
    graph6.getGraph().setTranslateX(1510);
    graph6.getGraph().setTranslateY(400);

    getChildren().addAll(
        originalFunction.getGraph(),
        graph1.getGraph(),
        graph2.getGraph(),
        graph3.getGraph(),
        graph4.getGraph(),
        graph5.getGraph(),
        graph6.getGraph()
    );

    System.out.println("Number of operations DFT: " + Counter.counterDFT);
    System.out.println("Number of operations FFT: " + Counter.counterFFT);
  }
}
