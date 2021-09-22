package com.company;

import java.util.Arrays;

public class Main {
    /* Laura K. Gross
     * Bridgewater State University
     * August, 2021
     * An implementation of Merge-Sort from CLRS
     */
    public static void main(String[] args) {
        // Consider some sample data sets.
        double[] data1 = {26, 33, 66, 91, 79};
        double[] data2 = {91.3, 79.4, 66.2, 33.5};
        double[] data3 = {6, 5, 4, 3, 2, 1};
        double[] data4 = {5, 2, 4, 7, 1, 3, 2, 6};
        // Make a copy of the array of interest.
        double[] data = data4.clone();
        // Rearrange the elements of the array copy into sorted order.
        mergeSort(data, 0, data.length-1);
        // Print the sorted array.
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(double[] A, int p, int r) {
        int q;
        if (p < r){
            q = (p+r)/2; // Do an integer divide to get the floor.
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(double[] A, int p, int q, int r) {
        int n1 = q - p + 1; // Number of elements from p to q inclusive
        int n2 = r - q; // Number of elements from q+1 to r inclusive
        double[] L = new double[n1+1]; // Make room for n1 numbers in L and a sentinel.
        double[] R = new double[n2+1]; // Make room for n2 numbers in R and a sentinel.
        // Copy the first half of the array A into array L.
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        // Copy the second half of the array A into array R.
        for (int i = 0; i < n2; i++) {
            R[i] = A[q + 1 + i];
        }
        // Set sentinel values in L and R to the largest Integer.
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;
        // Prepare to start by comparing the initial elements of L and R.
        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++){ // For all n elements,
            // If the leading element in L <= the leading element from R,
            if (L[i] <= R[j]) {
                // then put the leading element from L into A (by overwriting)
                A[k] = L[i];
                // Advance to consider the next element as the leading element in L.
                i = i + 1;
            }
            // If the leading element in L is not less than or equal to the leading element from R,
            else {
                // then put the leading element from R into A (by overwriting)
                A[k] = R[j];
                // Advance to consider the next element as the leading element in R.
                j = j + 1;
            }
        }
    }
}