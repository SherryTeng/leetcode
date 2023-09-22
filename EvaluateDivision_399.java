import java.util.*;

public class EvaluateDivision_399 {

    //1. DFS
    private Map<String, HashMap<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //1. construct graph
        for (int i = 0; i < equations.size(); i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double k = values[i];

            //graph.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
            if (graph.get(x)==null) {
                HashMap<String, Double> xToy = new HashMap<>();
                xToy.put(y,k);
                graph.put(x, xToy);
            } else {
                graph.get(x).put(y,k);
            }

            //graph.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0 / k);

            if (graph.get(y)==null) {
                HashMap<String, Double> yTox = new HashMap<>();
                yTox.put(x,1/k);
                graph.put(y, yTox);
            } else {
                graph.get(y).put(x,1/k);
            }

        }

        double[] res = new double[queries.size()];

        //2. DFS
        for (int i = 0; i < queries.size(); i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            if (!graph.containsKey(x) || !graph.containsKey(y)) {
                res[i] = -1;
            }else {
                res[i] = dfs(x, y, new HashSet<>());
            }
        }

        return res;
    }

    //get result of x/y
    private double dfs (String x, String y, Set<String> visited ) {
        if (x.equals(y)) return 1;
        visited.add(x);
        for (String n : graph.get(x).keySet()) {
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = dfs(n, y, visited);
            if (d >0) return d*graph.get(x).get(n);
        }

        return -1;
    }


//    //2. Union-Find
//    //https://zxi.mytechroad.com/blog/graph/leetcode-399-evaluate-division/
//
//    class Node {
//        public String parent;
//        public double ratio;
//        public Node(String parent, double ratio) {
//            this.parent = parent;
//            this.ratio = ratio;
//        }
//    }
//
//    class UnionFindSet {
//        private Map<String, Node> parents = new HashMap<>();
//
//        public Node find(String s) {
//            if (!parents.containsKey(s)) return null;
//            Node n = parents.get(s);
//            if (!n.parent.equals(s)) {
//                Node p = find(n.parent);
//                n.parent = p.parent;
//                n.ratio *= p.ratio;
//            }
//            return n;
//        }
//
//        public void union(String A, String B, double ratio) {
//            boolean hasA = parents.containsKey(A);
//            boolean hasB = parents.containsKey(B);
//            if (!hasA && !hasB) {
//                parents.put(A, new Node(B, ratio));
//                parents.put(B, new Node(B, 1.0));
//            } else if (!hasA) {
//                parents.put(A, new Node(B, ratio));
//            } else if (!hasB) {
//                parents.put(B, new Node(A, 1.0 / ratio));
//            } else {
//                Node rA = find(A);
//                Node rB = find(B);
//                parents.put(rA.parent,
//                        new Node(rB.parent, ratio / rA.ratio * rB.ratio));
//            }
//        }
//    }
//
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)  {
//        UnionFindSet u = new UnionFindSet();
//
//        for (int i = 0; i < equations.size(); ++i)
//            u.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
//
//        double[] ans = new double[queries.size()];
//
//        for (int i = 0; i < queries.size(); ++i) {
//            Node rx = u.find(queries.get(i).get(0));
//            Node ry = u.find(queries.get(i).get(1));
//            if (rx == null || ry == null || !rx.parent.equals(ry.parent))
//                ans[i] = -1.0;
//            else
//                ans[i] = rx.ratio / ry.ratio;
//        }
//        return ans;
//    }
}
