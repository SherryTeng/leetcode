public class NumberofProvinces_547 {
    int[] parents;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        int res = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i == j) continue;
                if (isConnected[i][j] == 1) {
                    if (find(i) != find(j)) {
                        union(i, j);
                        res--;
                    }
                }
            }
        }
        return res;
    }

    private void union(int x, int y) {
        parents[find(x)] = find(y);

    }

    private int find(int x){
        if (x == parents[x]) return x;
        return find(parents[x]);

    }
}
