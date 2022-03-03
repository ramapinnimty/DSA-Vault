public class ReverseArray {
    // Approach-1: Using two pointers
    public static void reverse(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        reverse(arr, left + 1, right - 1);
    }

    // Approach-2: Using a single variable
    public static void reverseUsingOneVar(int[] arr, int idx) {
        int L = arr.length;
        if (idx >= (L / 2))
            return;

        int temp = arr[idx];
        arr[idx] = arr[L - 1 - idx];
        arr[L - 1 - idx] = temp;
        reverseUsingOneVar(arr, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // reverse(arr, 0, arr.length - 1);
        reverseUsingOneVar(arr, 0);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}