public class CheckIfPalindrome {
    private static void reverse(char[] charArr, int idx, int n) {
        if (idx >= n / 2)
            return;

        char temp = charArr[idx];
        charArr[idx] = charArr[n - idx - 1];
        charArr[n - idx - 1] = temp;
        reverse(charArr, idx + 1, n);
    }

    public static boolean isPalindrome(String str) {
        char[] charArr = str.toCharArray();
        reverse(charArr, 0, charArr.length);
        String resStr = "";
        for (char ch : charArr)
            resStr += ch;

        return str.equals(resStr);
    }

    public static void main(String[] args) {
        String str = "madam";
        System.out.println("Is the given string a palindrome? : " + isPalindrome(str));
    }
}