def knapsack_bp(weights, profits, capacity):
    dp = [0] * (capacity + 1)
    for i in range(len(weights)):
        for j in range(1, capacity + 1):
            if weights[i] <= j:
                dp[j] = max(dp[j], profits[i] + dp[j - weights[i]])
    return dp[capacity]


if __name__ == "__main__":
    weights1, weights2 = [4, 6, 8], [5, 6, 8]
    profits1, profits2 = [7, 6, 9], [7, 6, 9]
    print("The maximum profit of knapsack in a) is " +
          str(knapsack_bp(weights1, profits1, 14)))
    print("The maximum profit of knapsack in b) is " +
          str(knapsack_bp(weights2, profits2, 14)))
