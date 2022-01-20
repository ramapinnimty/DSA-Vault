public class FirstLastOccurrence {
    // If element is found at `mid`, continue to search on the left
    private static int getFirstOccurrence(int[] arr, int queryElement, int start, int end) {
        int result = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == queryElement) {
                // Change is only here
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

    // If element is found at `mid`, continue to search on the right
    private static int getLastOccurrence(int[] arr, int queryElement, int start, int end) {
        int result = -1;

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (arr[mid] == queryElement) {
                // Change is only here
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

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, 10, 10, 10, 18, 20 };
        int queryElement = 10;

        int start = 0;
        int end = arr.length - 1;
        System.out.println(getFirstOccurrence(arr, queryElement, start, end));
        System.out.println(getLastOccurrence(arr, queryElement, start, end));
    }
}