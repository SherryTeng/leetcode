public class GraphValidTree_261 {
    int[] parent;
    private void union (int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa != pb) {
            parent[pa] = pb;

        }

    }
    private int find (int x) {
        if (parent[x] == x) return parent[x];
        parent[x] = find(parent[x]);
        return parent[x];

    }
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i =0; i < n; i++) {
            parent[i]=i;
        }
        int count = n;

        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) return false;
            union(edge[0], edge[1]);
            count--;

        }

        return count == 1;

    }
}
