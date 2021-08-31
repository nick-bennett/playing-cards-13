package edu.cnm.deepdive.general.util;

import java.util.Random;

public class QuickSorter {

  private static Random rng = new Random();

  public <T extends Comparable<? super T>> void sort(T[] data) {
    sort(data, 0, data.length);
  }

  public <T extends Comparable<? super T>> void sort(T[] data, int start, int end) {
    if (end > start + 1) {
      int pivotIndex = rng.nextInt(end - start) + start;
      T pivot = data[pivotIndex];
      data[pivotIndex] = data[start];
      data[start] = pivot;
      int marker = start;
      for (int i = start + 1; i < end; i++) {
        T value = data[i];
        if (value.compareTo(pivot) <= 0) {
          marker++;
          if (i > marker) {
            data[i] = data[marker];
            data[marker] = value;
          }
        }
      }
      data[start] = data[marker];
      data[marker] = pivot;
      sort(data, start, marker);
      sort(data, marker + 1, end);
    }
  }

}
