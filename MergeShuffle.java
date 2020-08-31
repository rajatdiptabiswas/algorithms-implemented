import java.util.*;
import java.io.*;
import java.lang.*;
import java.text.*;
import java.math.*;


class MergeShuffle {

    private static Object[] aux;

    private static void merge(Object[] arr, Object[] aux, int lo, int mid, int hi) {

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
            } else if (Math.random() < 0.5) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }

    }

    private static void shuffle(Object[] arr, Object[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;

        shuffle(arr, aux, lo, mid);
        shuffle(arr, aux, mid+1, hi);
        merge(arr, aux, lo, mid, hi);

    }

    public static void shuffle(Object[] arr) {

        aux = new Object[arr.length];
        shuffle(arr, aux, 0, arr.length-1);

    }

    public static void main(String[] args) {

        Integer[] intArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Character[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        System.out.println(Arrays.toString(charArray));
        shuffle(charArray);
        System.out.println(Arrays.toString(charArray));

    }

}