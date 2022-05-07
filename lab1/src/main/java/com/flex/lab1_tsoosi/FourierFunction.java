package com.flex.lab1_tsoosi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourierFunction {

  private static ArrayList<Complex> listDFT;
  private static ArrayList<Complex> listFFT;
  private static int N = 16;
  private static int coefficient = 128;

  public static HashMap<Double, Double> getOriginalGraph() {
    HashMap<Double, Double> graphHash = new HashMap<>();
    for (int i = 0; i < coefficient; i++) {
      graphHash.put(2 * i * Math.PI / coefficient,
          Math.sin(2 * i * Math.PI / coefficient) + Math.cos(4 * (2 * i * Math.PI / coefficient)));
    }
    return graphHash;
  }

  public static HashMap<Double, Double> getOriginalGraphForDFT() {
    HashMap<Double, Double> graphHash = new HashMap<>();
    for (int i = 0; i < N; i++) {
      graphHash.put(2 * i * Math.PI / N,
          Math.sin(2 * i * Math.PI / N) + Math.cos(4 * (2 * i * Math.PI / N)));
    }
    return graphHash;
  }

  public static Map<Double, Double> getCosOriginalGraph() {
    Map<Double, Double> graphHash = new HashMap<>();
    for (int i = 0; i < N; i++) {
      graphHash.put(2 * i * Math.PI / N, Math.cos(4 * 2 * i * Math.PI / N));
    }
    return graphHash;
  }

  public static Map<Double, Double> getSinOriginalGraph() {
    Map<Double, Double> graphHash = new HashMap<>();
    for (int i = 0; i < N; i++) {
      graphHash.put(2 * i * Math.PI / N, Math.sin(2 * i * Math.PI / N));
    }
    return graphHash;
  }

  public static HashMap<Double, Double> getDiscreteFourierGraph(HashMap<Double, Double> source) {
    ArrayList<Complex> temp = new ArrayList<>();
    HashMap<Double, Double> result = new HashMap<>();
    ArrayList<Complex> fouirierList = null;
    Counter mul = new Counter();
    Counter add = new Counter();
    for (int i = 0; i < N; i++) {
      temp.add(new Complex(source.get(2 * i * Math.PI / N), 0.0));
    }
    fouirierList = Fourier.discreteFourier(temp, N, -1, mul, add);
    listDFT = fouirierList;
    for (int i = 0; i < N; i++) {
      result.put((double) i, fouirierList.get(i).abs());
    }
    return result;
  }

  public static HashMap<Double, Double> getFastFourierGraph(HashMap<Double, Double> source) {
    ArrayList<Complex> temp = new ArrayList<>();
    HashMap<Double, Double> result = new HashMap<>();
    ArrayList<Complex> fouirierList = null;
    Counter mul = new Counter();
    Counter add = new Counter();
    for (int i = 0; i < N; i++) {
      temp.add(new Complex(source.get(2 * i * Math.PI / N), 0.0));
    }
    Fourier.fastFourier(temp, N, -1, mul, add);
    listFFT = temp;
    for (int i = 0; i < N; i++) {
      result.put((double) i, listFFT.get(i).abs());
    }
    return result;
  }

  public static HashMap<Double, Double> getReverseFourier(int fourierType) {
    HashMap<Double, Double> result = new HashMap<>();
    ArrayList<Complex> fourierList;
    Counter mul = new Counter();
    Counter add = new Counter();
    if (fourierType == 0) {
      Fourier.fastFourier(listFFT, N, 1, mul, add);
      fourierList = listFFT;
    } else {
      fourierList = Fourier.discreteFourier(listDFT, N, 1, mul, add);
    }
    for (int i = 0; i < N; i++) {
      result.put(2 * i * Math.PI / N, fourierList.get(i).getRe());
    }
    return result;
  }

  public static HashMap<Double, Double> getPhaseCharacteristics(int fourierType) {
    HashMap<Double, Double> result = new HashMap<>();
    if (fourierType == 0) {
      for (int i = 0; i < N; i++) {
        result.put((double) i, listFFT.get(i).phase());
      }
    } else {
      for (int i = 0; i < N; i++) {
        result.put((double) i, listDFT.get(i).phase());
      }
    }
    return result;
  }
}
