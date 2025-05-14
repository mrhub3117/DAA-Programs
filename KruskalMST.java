import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    public int compareTo(Edge other) { return this.weight - other.weight; }
}

class KruskalMST {
    int[] parent;
    KruskalMST(int n) { parent = new int[n]; Arrays.fill(parent, -1); }

    int find(int v) { return (parent[v] < 0) ? v : (parent[v] = find(parent[v])); }
    void union(int v1, int v2) { parent[v1] = v2; }

    List<Edge> getMST(List<Edge> edges, int nodes) {
        Collections.sort(edges);
        List<Edge> mst = new ArrayList<>();
        for (Edge edge : edges) {
            int root1 = find(edge.src), root2 = find(edge.dest);
            if (root1 != root2) {
                mst.add(edge);
                union(root1, root2);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(0, 1, 4), new Edge(1, 2, 2), new Edge(2, 3, 3));
        KruskalMST k = new KruskalMST(4);
        List<Edge> mst = k.getMST(edges, 4);
        for (Edge edge : mst) System.out.println(edge.src + " - " + edge.dest + " (" + edge.weight + ")");
    }
}
