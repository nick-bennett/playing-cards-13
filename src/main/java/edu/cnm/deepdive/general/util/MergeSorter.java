package edu.cnm.deepdive.general.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSorter {

  private final Class<? extends Comparable<?>> cls;

  public MergeSorter(Class<? extends Comparable<?>> cls) {
    this.cls = cls;
  }

  public <T extends Comparable<? super T>> void sort(T[] data) {
    sort(data, 0, data.length);
  }

  public <T extends Comparable<? super T>> void sort(T[] data, int start, int end) {
    if (end > start + 1) {


      int midpoint = (start + end) / 2;
      sort(data, start, midpoint); // Sort "left" side of array range.
      sort(data, midpoint, end);  // Sort "right" side of array range.
      //noinspection unchecked
      T[] output = (T[]) Array.newInstance(cls, end - start);
      int leftIndex = start;
      int rightIndex = midpoint;
      int outputIndex = 0;
      //Merge process
      while (leftIndex < midpoint && rightIndex < end) {
        T leftValue = data[leftIndex];
        T rightValue = data[rightIndex];
        if (leftValue.compareTo(rightValue) <= 0) {
          output[outputIndex++] = leftValue;
          leftIndex++;
        } else {
          output[outputIndex++] = rightValue;
          rightIndex++;
        }
      }
      if (leftIndex < midpoint) {
        System.arraycopy(data, leftIndex, output, outputIndex, midpoint - leftIndex);
      } else {
        System.arraycopy(data, rightIndex, output, outputIndex, end - rightIndex);
      }
      System.arraycopy(output, 0, data, start, output.length);
    }
  }

}
