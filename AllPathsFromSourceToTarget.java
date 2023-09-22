import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs (graph, res, path, 0);
        return res;

    }

    private void dfs (int[][] graph, List<List<Integer>> paths, List<Integer> path, int curr) {
        if (curr == graph.length-1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int i: graph[curr]) {
            path.add(i);
            dfs(graph, paths, path, i);
            path.remove(path.size()-1);
        }

    }
}
