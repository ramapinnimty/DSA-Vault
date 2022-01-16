public class Knapsack {
    // URL: https://www.callicoder.com/0-1-knapsack-problem/

    // I. Recursion ; Time: O(2^n) ; Space: O(1)//
    private static int knapsackRecr(int[] wt, int[] val, int W, int n) {
        // Base condition
        if (n == 0 || W == 0)
            return 0;

        // Choice diagram translation
        if (wt[n - 1] > W)
            return knapsackRecr(wt, val, W, n - 1);

        return Math.max(val[n - 1] + knapsackRecr(wt, val, W - wt[n - 1], n - 1),
                knapsackRecr(wt, val, W, n - 1));
    }

    // II. TOP-DOWN APPROACH: Recursion + Memoization ; Time: O(n*W) ; Space:
    // O(n*W)//
    private static int knapsackRecrMemo(int[] wt, int[] val, int W, int n) {
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)
            dp[n][W] = knapsackRecrMemo(wt, val, W, n - 1);

        else if (wt[n - 1] <= W)
            dp[n][W] = Math.max(val[n - 1] + knapsackRecrMemo(wt, val, W - wt[n - 1], n - 1),
                    knapsackRecrMemo(wt, val, W, n - 1));

        return dp[n][W];
    }

    private static int[][] dp;

    // Only Memoize variables that change in a recursive call
    private static int knapsackMemo(int[] wt, int[] val, int W, int n) {
        // 1 - Create the matrix
        dp = new int[n + 1][W + 1];
        // 2 - Initialize the entries in the matrix with -1
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dp[i][j] = -1;

        return knapsackRecrMemo(wt, val, W, n);
    }

    // III. BOTTOM-UP APPROACH: Iteration + Tabulation ; Time: O(n*W) ; Space:
    // O(n*W)//
    private static int knapsackTab(int[] wt, int[] val, int W, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // NOT needed, as by default, Java initializes arrays with zeros.
        // for (int i = 0; i < dp.length; i++)
        // for (int j = 0; j < dp[0].length; j++)
        // dp[i][j] = 0;

        // Change 'n' --> i & 'W' --> w or j
        for (int i = 1; i < dp.length; i++) {
            for (int w = 1; w < dp[0].length; w++) {
                if (wt[i - 1] > w)
                    dp[i][w] = dp[i - 1][w];
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]);
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] wt = new int[] { 10, 20, 30 };
        int[] val = new int[] { 60, 100, 120 };
        int W = 50;

        System.out.println(knapsackRecr(wt, val, W, wt.length));
        System.out.println(knapsackMemo(wt, val, W, wt.length));
        System.out.println(knapsackTab(wt, val, W, wt.length));
    }
}