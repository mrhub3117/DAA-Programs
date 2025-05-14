import java.util.*;

class FloydWarshall {
    final static int INF = 9999;

    static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        
        for (int i = 0; i < V; i++)
            System.arraycopy(graph[i], 0, dist[i], 0, V);

        
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist, V);
    }

    static void printSolution(int[][] dist, int V) {
        System.out.println("Shortest distance matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++)
                System.out.print((dist[i][j] == INF ? "INF" : dist[i][j]) + "\t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
            {INF, INF, 2, 0}
        };

        floydWarshall(graph, graph.length);
    }
}
