import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.math.*;


class MergeSort {

    private static Comparable[] aux;

    private static boolean less(Comparable a, Comparable b) {
        if (a.compareTo(b) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {

        for (int x = lo; x <= hi; x++) {
            aux[x] = arr[x];
        }

        int i = lo;
        int j = mid+1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }

    }

    private static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        sort(arr, aux, lo, mid);
        sort(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);

    }

    public static void sort(Comparable[] arr) {

        aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length-1);

    }

    public static void main(String[] args) {

        Integer[] intArray = {9, 8, 1, 3, 0, 7, 6, 4, 5, 2};
        Character[] charArray = {'d', 'e', 'c', 'a', 'b', 'f'};

        System.out.println(Arrays.toString(intArray));
        sort(intArray);
        System.out.println(Arrays.toString(intArray));

    }

}