

 
 package com.test.sorting;

 import java.util.Arrays;

 class SortedSquaredArray {
  public int[] sortedSquaredArray(int[] A) {
      int n = A.length;
      int[] result = new int[n];
      for (int i = 0; i < n; ++i)
          result[i] = A[i] * A[i];


      Arrays.sort(result);
      return result;
  }
}
