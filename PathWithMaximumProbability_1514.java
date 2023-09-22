import java.util.*;
public class PathWithMaximumProbability_1514 {
    class State {
        int node;
        double prob;
        State(int _node, double _prob) {
            node = _node;
            prob = _prob;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        //1. form graph
        Map<Integer, List<double[]>> graph = new HashMap<>();
        int len = edges.length;
        for (int i =0; i < len; i++) {
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(new double[] {edges[i][1], succProb[i]});
            graph.putIfAbsent(edges[i][1], new ArrayList<>());
            graph.get(edges[i][1]).add(new double[] {edges[i][0], succProb[i]});
        }

        double[] probs = new double[n];
        Queue<State> q = new PriorityQueue<>((a,b)-> (((Double)b.prob).compareTo((Double)a.prob)));
        q.add(new State(start, 1.0));
        while (!q.isEmpty()) {
            State state = q.remove();
            int parent = state.node;
            double prob = state.prob;

            if (parent == end) return prob;

            for (double[] child : graph.getOrDefault(parent, new ArrayList<>())) {
                if(probs[(int) child[0]] >= prob*child[1]) continue;

                q.add(new State((int) child[0], prob*child[1]));
                probs[(int) child[0]] = prob*child[1];
            }


        }
        return 0;

    }
}
