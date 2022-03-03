/*
    Problem: Sum of the first N numbers.
    Approaches: (i) Parameterized way (ii) Functional way
*/
public class NumbersSum {
    // Approach-1: Parameter way --> essentially, you'll accumulate the sum through
    // a parameter and return it ultimately.
    public static int getSumPar(int cntr, int sum, int N) {
        if (cntr > N)
            return sum;

        return getSumPar(cntr + 1, sum + cntr, N);
    }

    // Approach-2: Functional way --> You want the function to actually calculate
    // the sum (sub-problem way).
    public static int getSumFun(int N) {
        if (N == 0)
            return 0;

        return N + getSumFun(N - 1);
    }

    public static void main(String[] args) {
        int N = 10;

        System.out.println(getSumPar(1, 0, N));
        System.out.println(getSumFun(N));
    }
}