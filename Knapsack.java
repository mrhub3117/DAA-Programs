3.Knapsack Problem a)Dynamic Programming method
public class KnapsackDP {
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int W = 50;
        int n = val.length;

        System.out.println("Maximum value in Knapsack = " + knapsack(W, wt, val, n));
    }
}

b)Greedy Method:
import java.util.Arrays;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class KnapsackGreedy {
    public static double knapsack(int W, Item[] items) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        int currentWeight = 0;
        double totalValue = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= W) {
                totalValue += item.value;
                currentWeight += item.weight;
            } else {
                int remainingWeight = W - currentWeight;
                totalValue += item.value * ((double) remainingWeight / item.weight);
                break;  // Since we can't take more items
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int W = 50;

        System.out.println("Maximum value in Knapsack (Greedy) = " + knapsack(W, items));
    }
}
