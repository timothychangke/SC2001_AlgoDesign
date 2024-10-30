package Project3;

public class Knapsack {
    public static int knapsackBottomUp(int[] weights, int[] profits, int capacity) {
        // infinte item can be used
        /*
         * Time Complexity: O(W*N) where W is the total weight(capacity) and N is the
         * total number of items.
         * Auxiliary Space: O(W) where W is the total weight.
         */
        int dp[] = new int[capacity + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i] <= j) {
                    dp[j] = Math.max(dp[j], profits[i] + dp[j - weights[i]]);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weights1 = { 4, 6, 8 };
        int[] profit1 = { 7, 6, 9 };
        int capacity1 = 14;

        System.out.println(knapsackBottomUp(weights1, profit1, capacity1));

        int[] weights2 = { 5, 6, 8 };
        int[] profit2 = { 7, 6, 9 };
        int capacity2 = 14;

        System.out.println(knapsackBottomUp(weights2, profit2, capacity2));

    }
}
