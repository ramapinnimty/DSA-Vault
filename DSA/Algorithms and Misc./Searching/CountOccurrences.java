public class CountOccurrences {
    private static int getFirstIndex(int[] arr, int queryElement, int start, int end) {
        int result = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == queryElement) {
                result = mid;
                end = mid - 1;
            } else {
                if (arr[mid] < queryElement)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return result;
    }

    private static int getLastIndex(int[] arr, int queryElement, int start, int end) {
        int result = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == queryElement) {
                result = mid;
                start = mid + 1;
            } else {
                if (arr[mid] < queryElement)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return result;
    }

    // Intuition: `count = LastOccurrenceIndex - FirstOccurrenceIndex + 1`
    private static int getCount(int[] arr, int queryElement, int start, int end) {
        int firstIndex = getFirstIndex(arr, queryElement, start, end);
        int lastIndex = getLastIndex(arr, queryElement, start, end);
        if (firstIndex == -1 && lastIndex == -1)
            return 0;

        return lastIndex - firstIndex + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, 10, 10, 10, 18, 20 };
        int queryElement = 10;

        int start = 0;
        int end = arr.length - 1;
        System.out.println(getCount(arr, queryElement, start, end));
    }
}
