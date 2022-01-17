public class BinarySearch {
    // URL: https://www.programiz.com/java-programming/examples/binary-search

    // I. Using recursion ; Time: O(log n) ; Space: O(log n) recursion call stack
    // space //
    private static int binarySearchRecr(int[] arr, int num, int start, int end) {
        if (start > end)
            return -1;

        int mid = (start + end) / 2;

        if (arr[mid] < num)
            return binarySearchRecr(arr, num, mid + 1, end);
        else if (arr[mid] > num)
            return binarySearchRecr(arr, num, start, mid - 1);

        return mid;
    }

    // II. Using iteration ; Time: O(log n) ; Space: O(1) //
    private static int binarySearchIter(int[] arr, int num, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == num)
                return mid;

            if (arr[mid] < num)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int queryElement = 5;

        int start = 0;
        int end = arr.length - 1;
        System.out.println(binarySearchRecr(arr, queryElement, start, end));
        System.out.println(binarySearchIter(arr, queryElement, start, end));
    }
}
