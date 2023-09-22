public class NumberofConnectedComponentsinanUnidirectedGraph_323 {
    int[] parent;
    private void union(int a, int b) {
        parent[find(a)] = find(b);

    }
    private int find(int x) {
        if (parent[x] == x) return parent[x];
        parent[x] = find(parent[x]);
        return parent[x];

    }
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int res = n;
        for (int[] edge: edges) {
            if (find(edge[0]) != find(edge[1])) {
                res--;
                union(edge[0], edge[1]);
            }
        }
        return res;

    }
}
