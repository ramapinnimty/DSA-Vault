// Learning resource: 
// Program that illustrates multiple recursion calls
// [V.V.IMP] Once `getNFibNum(n - 1)` fully executes, only then `getNFibNum(n - 2)` will execute.
// Time: O(2^n) i.e, exponential ; Space: O(n) since at any time the stack holds <=n function calls.
public class Fibonacci {
    public static int getNFibNum(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return getNFibNum(n - 1) + getNFibNum(n - 2);
    }

    public static void main(String[] args) {
        int n = 7;

        System.out.println("The " + n + "th Fibonacci number is: " + getNFibNum(n));
    }
}