import java.util.*;
import java.io.*;


class KthSmallestOfTwoSortedArrays {

    // O(log k) = O(log (m+n)) solution.
    public static int kthSmallest(int k, int[] array1, int length1, int[] array2, int length2) {

        if (!(1 <= k && k <= length1 + length2)) {
            throw new IllegalArgumentException();
        }

        /**
         * Can reduce edge cases by assuming array1 to be smaller than array2.
         */
        if (length1 > length2) {
            return kthSmallest(k, array2, length2, array1, length1);
        }

        /**
         * If the number of elements taken from either of the array is zero,
         * return the kth element directly from the other array.
         */
        if (length1 == 0) {
            return array2[k-1];
        }

        /**
         * Base case
         */
        if (k == 1) {
            return Math.min(array1[0], array2[0]);
        }

        int i = Math.min(length1, k/2);
        int j = Math.min(length2, k/2);

        /**
         * Check k/2th element from each array.
         * 
         * The smaller of two will definitely be in the array and so can be
         * removed to create the new subproblem.
         * 
         * For example, if k = 6 => k/2 = 3
         * Check index 2 of both arrays
         * [2, 4, 6, 8]
         * [1, 3, 5, 7, 9]
         * 
         * Since array2[2] < array1[2],
         * Index [0 .. 2] of array2 must be in the left partition.
         * Can get rid of it.
         * 
         * The next subproblem becomes
         * [2, 4, 6, 8]
         * [7, 9]
         */
        if (array1[i-1] > array2[j-1]) {
            int[] newArray2 = Arrays.copyOfRange(array2, j, length2);
            return kthSmallest(k-j, array1, length1, newArray2, length2-j);
        } else {
            int[] newArray1 = Arrays.copyOfRange(array1, i, length1);
            return kthSmallest(k-i, newArray1, length1-i, array2, length2);
        }

    }

    // O(log min(n, m)) solution.
    public static int kthSmallest(int k, int[] array1, int[] array2) {

        int length1 = array1.length;
        int length2 = array2.length;

        if (length1 > length2) {
            kthSmallest(k, array2, array1);
        }

        if (!(1 <= k && k <= length1 + length2)) {
            throw new IllegalArgumentException();
        }

        int lo = 0;
        int hi = length1;

        while (lo <= hi) {

            /**
             * Ranges for the partitions are as follows.
             * partition1   -> [0, length1]
             * partition2   -> [0, length2 - 1]
             * 
             * Partition representation.
             * partition    ->  0   1   2   3   4   5
             * array        ->  | a | b | c | d | e |
             * array index  ->    0   1   2   3   4
             */
            int partition1 = (lo + hi) / 2;
            int partition2 = k - 1 - partition1;

            /**
             * If partition2 is less than 0, it implies that the left partition 
             * of array1[] has more than the required number of elements.
             * 
             * Hence partition1 needs to move left.
             */
            if (partition2 < 0) {
                hi = partition1 - 1;
                continue;
            }

            /**
             * If partition2 is greater than length2, it implies that the left 
             * partition of array1[] has fewer than the required number of
             * elements.
             * 
             * Hence partition1 needs to move right.
             */
            if (partition2 > length2) {
                lo = partition1 + 1;
                continue;
            }

            int array1LeftMax = (partition1 == 0) ? Integer.MIN_VALUE : array1[partition1 - 1];
            int array1RightMin = (partition1 == length1) ? Integer.MAX_VALUE : array1[partition1];

            int array2LeftMax = (partition2 == 0) ? Integer.MIN_VALUE : array2[partition2 - 1];
            int array2RightMin = (partition2 == length2) ? Integer.MAX_VALUE : array2[partition2];

            /**
             * Desired partitioning has been found with k-1 on the left partition.
             * 
             * The minimum of the elements next to partition1 in array1[] and
             * partition2 in array2[] gives the kth smallest element in the union
             * of the two sorted arrays.
             */
            if (array1LeftMax <= array2RightMin && array2LeftMax <= array1RightMin) {
                return Math.min(array1RightMin, array2RightMin);
            }
            /**
             * Implies partition is too far right in array1[].
             * Need to move partition1 to the left.
             */
            else if (array1LeftMax > array2RightMin) {
                hi = partition1 - 1;
            }
            /**
             * Implies partition is too far left in array1[].
             * Need to move partition1 to the right.
             */
            else {
                lo = partition1 + 1;
            }

        }

        throw new IllegalArgumentException();

    }
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(reader.readLine());

        // System.out.println(kthSmallest(k, arr1, arr2));
        System.out.println(kthSmallest(k, arr1, arr1.length, arr2, arr2.length));

    }

}