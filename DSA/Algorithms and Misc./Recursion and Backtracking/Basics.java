/*
    Learnings: -
        1. Refrain from using unary operators for backtracking (var++|++var & var--|--var) as they tend to produce confusing results.
*/

public class Basics {
    // Problem-1: Print name `N` times using recursion.
    // Time: O(n) ; Space: O(n) --> Stack space
    public static void printName(int cntr, int N) {
        if (cntr > N)
            return;
        System.out.println("Rama");
        printName(++cntr, N);
    }

    // Problem-2: Print linearly from 1 to N using recursion.
    // Time: O(n) ; Space: O(n) --> Stack space
    public static void printIntInc(int cntr, int N) {
        if (cntr > N)
            return;
        System.out.println(cntr);
        printIntInc(++cntr, N);
    }

    // Problem-3: Print linearly from N to 1 using recursion.
    // Time: O(n) ; Space: O(n) --> Stack space
    public static void printIntDec(int cntr) {
        if (cntr < 1)
            return;
        System.out.println(cntr);
        printIntDec(--cntr);
    }

    // [IMP] Problem-4: Print linearly from 1 to N using backtracking.
    // Time: O(n) ; Space: O(n) --> Stack space
    public static void printIntIncRecr(int cntr) {
        if (cntr < 1)
            return;
        printIntIncRecr(cntr - 1);
        System.out.println(cntr);
    }

    // [IMP] Problem-5: Print linearly from N to 1 using backtracking.
    // Time: O(n) ; Space: O(n) --> Stack space
    public static void printIntDecRecr(int cntr, int N) {
        if (cntr > N)
            return;
        printIntDecRecr(cntr + 1, N);
        System.out.println(cntr);
    }

    public static void main(String[] args) {
        int cntr = 1;
        int N = 5;

        Basics.printName(cntr, N);
        Basics.printIntInc(cntr, N);
        Basics.printIntDec(N);
        Basics.printIntIncRecr(N);
        Basics.printIntDecRecr(cntr, N);
    }
}
