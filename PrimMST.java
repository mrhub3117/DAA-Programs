import java.util.*;

class PrimMST {
    private static final int INF = Integer.MAX_VALUE;

    static void primMST(int[][] graph, int V) {
        int[] key = new int[V]; // Stores minimum edge weight for each vertex
        boolean[] mstSet = new boolean[V]; // Tracks vertices included in MST
        int[] parent = new int[V]; // Stores MST structure

        Arrays.fill(key, INF);
        key[0] = 0; // Start from vertex 0
        parent[0] = -1; // Root of MST

        for (int count = 0; count < V - 1; count++) {
            int u = minKeyVertex(key, mstSet, V);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        printMST(parent, graph, V);
    }

    static int minKeyVertex(int[] key, boolean[] mstSet, int V) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        return minIndex;
    }

    static void printMST(int[] parent, int[][] graph, int V) {
        System.out.println("Edge \t Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t " + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        primMST(graph, graph.length);
    }
}
