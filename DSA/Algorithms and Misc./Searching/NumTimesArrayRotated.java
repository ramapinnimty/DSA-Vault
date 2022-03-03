public class NumTimesArrayRotated {
    // Intuition: Find the index of the minimum element.
    private static int getMinIndex(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            // If mid = 0 (first element), then we get arr[-1].
            // To avoid this, use `(mid + N - 1) % N`.
            int prev = (mid + n - 1) % n;
            // If mid = N - 1 (last element), then we get arr[8].
            // To avoid this, use `(mid + 1) % N`.
            int next = (mid + 1) % n;

            if ((arr[mid] <= arr[prev]) && (arr[mid] <= arr[next]))
                return mid;

            // Else, we have to move in the direction of the unsorted array.
            // We can simply compare (arr[start] & arr[mid]) and (arr[mid] & arr[end]).
            // i.e, if arr[start] < arr[mid] --> sorted ; then go in the direction of mid ->
            // end.
            // and if arr[mid] < arr[end] --> sorted ; then go in the direction of start ->
            // mid.
            if (arr[prev] < arr[mid])
                end = (mid + n - 1) % n;
            else if (arr[next] < arr[mid])
                start = (mid + 1) % n;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 11, 12, 15, 18, 2, 5, 6, 8 };

        System.out.println(getMinIndex(arr));
    }
}