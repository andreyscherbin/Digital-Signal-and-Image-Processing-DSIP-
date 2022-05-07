package com.flex.lab1_tsoosi;

import java.util.ArrayList;

public class Fourier {

  public static ArrayList<Complex> discreteFourier(ArrayList<Complex> a, int N, int dir,
      Counter mul, Counter add) {
    ArrayList<Complex> result = new ArrayList<>();
    for (int k = 0; k < N; k++) {
      Complex temp = new Complex(0.0, 0.0);
      for (int n = 0; n < N; n++) {
        double argument = 2 * Math.PI * k * n / N;
        temp = temp.plus(a.get(n).times(new Complex(Math.cos(argument),
            dir * Math.sin(argument))));
        mul.mulDFT();
        add.incDFT();
      }
      if (dir == 1) {
        temp = temp.divides(N);
      }
      result.add(temp);
    }
    return result;
  }

  public static void fastFourier(ArrayList<Complex> a, int N, int dir, Counter mul,
      Counter add) {
    if (a.size() == 1) {
      return;
    }

    Complex Wn = new Complex(Math.cos(2 * Math.PI / N), dir * Math.sin(2 * Math.PI / N));
    Complex W = new Complex(1.0, 0.0);
    ArrayList<Complex> odd = new ArrayList<>();
    ArrayList<Complex> even = new ArrayList<>();

    for (int k = 0; k < N / 2; k++) {
      even.add(k, a.get(k).plus(a.get(N / 2 + k)));
      odd.add(k, a.get(k).minus(a.get(N / 2 + k)).times(W));
      W = W.times(Wn);
      add.incFFT();
      add.incFFT();
      mul.mulFFT();
      mul.mulFFT();
    }

    fastFourier(even, even.size(), dir, mul, add);
    fastFourier(odd, odd.size(), dir, mul, add);

    for (int k = 0; k < N / 2; k++) {
      a.add(2 * k, even.get(k));
      a.add(2 * k + 1, odd.get(k));
    }
  }
}
