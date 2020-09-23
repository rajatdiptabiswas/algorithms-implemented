class MedianOfTwoSortedArrays {

    public static double medianOfTwoSortedArrays(int[] a, int[] b) {

        int lengthA = a.length;
        int lengthB = b.length;

        /**
         * Swap the arrays in case a[] is larger than b[].
         * Ensures performance is always log2(min(a.length, b.length)).
         */
        if (lengthA > lengthB) {
            return medianOfTwoSortedArrays(b, a);
        }

        int lo = 0;
        int hi = lengthA;

        while (lo <= hi) {
            /**
             * partitionA = n
             * implies a[0 ... n-1] (i.e. n elements) from a[] is being considered.
             * 
             * The number of elements to the left side of the partitions in both a[]
             * and b[] should equal the number of elements to the right side of the
             * partitions in both a[] and b[].
             * 
             * If there are odd number of elements, then the left sides have one
             * extra element compared to number of elements on the right sides.
             * 
             * The following must hence hold
             * partitionA + partitionB = (lengthA + lengthB + 1) / 2
             * 
             * The + 1 makes sure there is an extra element on the left when the
             * total number of elements is odd.
             */
            int partitionA = (lo + hi) / 2;
            int partitionB = ((lengthA + lengthB + 1) / 2) - partitionA;

            /**
             * leftAMax     = element to the left of partition in a[]
             * rightAMin    = element to the right of partition in a[]
             * leftBMax     = element to the left of partition in b[]
             * rightBMin    = element to the right of partition in b[]
             */
            int leftAMax = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];
            int rightAMin = (partitionA == lengthA) ? Integer.MAX_VALUE : a[partitionA];
            int leftBMax = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
            int rightBMin = (partitionB == lengthB) ? Integer.MAX_VALUE : b[partitionB];

            if (leftAMax <= rightBMin && leftBMax <= rightAMin) {
                /**
                 * The desired partitioning has been found.
                 * 
                 * If the total elements are odd
                 * max(leftAMax, leftBMax) gives median.
                 * 
                 * If the total elements are even
                 * average(max(leftAMax, leftBMax), min(rightAMin, rightBMin))
                 * gives median.
                 */
                if ((lengthA + lengthB) % 2 == 0) {
                    return (double)(Math.max(leftAMax, leftBMax) + Math.min(rightAMin, rightBMin)) / 2;
                } else {
                    return (double)Math.max(leftAMax, leftBMax);
                }
            } else if (leftAMax > rightBMin) {
                /**
                 * This means the partition is too far right in a[].
                 * Need to move partitionA left in a[].
                 */
                hi = partitionA - 1;
            } else if (leftBMax > rightAMin) {
                /**
                 * This means the partition is too far left in a[].
                 * Need to move partitionA right in a[].
                 */
                lo = partitionA + 1;
            }
        }

        return Double.MIN_VALUE;

    }

    public static void main(String[] args) {

        int a[] = {1, 3, 5, 7};
        int b[] = {0, 2, 4, 6, 8};

        System.out.println(medianOfTwoSortedArrays(a, b));

    }

}