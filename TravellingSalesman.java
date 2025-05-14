import java.util.Arrays;

class TravellingSalesman {
    static final int INF = 99999;
    static int N;
    static int[][] graph;
    static int[][] dp;

    static int tsp(int pos, int mask) {
        if (mask == (1 << N) - 1) 
            return graph[pos][0]; 

        if (dp[pos][mask] != -1) 
            return dp[pos][mask];

        int minCost = INF;
        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) { 
                int newCost = graph[pos][city] + tsp(city, mask | (1 << city));
                minCost = Math.min(minCost, newCost);
            }
        }
        return dp[pos][mask] = minCost;
    }

    public static void main(String[] args) {
        graph = new int[][] {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        N = graph.length;

        dp = new int[N][1 << N]; 
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println("Minimum Cost of TSP = " + tsp(0, 1)); 
    }
}
