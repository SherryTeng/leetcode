import java.util.PriorityQueue;

public class MinCosttoConnectAllPoints_1584 {
    int[] parent;

    private void uinon(int a, int b) {
        parent[find(a)] = parent[find(b)];

    }

    private int find(int x) {
        if (parent[x] == x) return parent[x];
        parent[x] = find(parent[x]);
        return parent[x];

    }

    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0]-points[b][0]) + Math.abs(points[a][1]-points[b][1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        for (int i = 0; i < n;i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j<n; j++) {
                q.add(new int[] {findDist(points, i, j), i, j});
            }
        }
        int res = 0;
        int count = n;
        while (count >1) {
            int[] edge = q.remove();
            if (find(edge[1]) != find(edge[2])) {
                res += edge[0];
                uinon(edge[1], edge[2]);
                count--;
            }
        }
        return res;
    }
}
