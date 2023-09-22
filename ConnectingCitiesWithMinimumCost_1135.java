import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost_1135 {
    int[] parent;
    int N;
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            parent[px] = py;
            N--;
        }
    }
    private int find(int x) {
        if(parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public int minimumCost(int n, int[][] connections) {

        parent = new int[n+1];
        N=n;

        for (int i=0; i<=n;i++) {
            parent[i]=i;
        }

        Arrays.sort(connections, (a,b)->a[2]-b[2]);

        int res= 0;
        for (int[] c: connections){
            int x = c[0], y = c[1];
            if (find(x) != find(y)) {
                res += c[2];
                union(x,y);
            }
        }

        if (N==1) {
            return res;
        }else {
            return -1;
        }

    }
}
