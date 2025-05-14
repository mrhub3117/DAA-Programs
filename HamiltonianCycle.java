import java.util.*;

class HamiltonianCycle {
    int V; 
    int[][] graph;
    List<List<Integer>> cycles = new ArrayList<>();

    HamiltonianCycle(int[][] g) {
        this.V = g.length;
        this.graph = g;
    }

    void findHamiltonianCycles() {
        int[] path = new int[V];
        Arrays.fill(path, -1);
        path[0] = 0; 
        backtrack(path, 1);
        
        if (cycles.isEmpty()) System.out.println("No Hamiltonian Cycles found.");
        else {
            System.out.println("Hamiltonian Cycles:");
            for (List<Integer> cycle : cycles) System.out.println(cycle);
        }
    }

    void backtrack(int[] path, int pos) {
        if (pos == V) {
            if (graph[path[pos - 1]][path[0]] == 1) {
                List<Integer> cycle = new ArrayList<>();
                for (int node : path) cycle.add(node);
                cycle.add(path[0]); // Closing the cycle
                cycles.add(cycle);
            }
            return;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, path, pos)) {
                path[pos] = v;
                backtrack(path, pos + 1);
                path[pos] = -1; 
            }
        }
    }

    boolean isSafe(int v, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0) return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 1, 0, 1, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 1},
            {1, 1, 1, 0, 1},
            {1, 0, 1, 1, 0}
        };

        HamiltonianCycle hc = new HamiltonianCycle(graph);
        hc.findHamiltonianCycles();
    }
}
