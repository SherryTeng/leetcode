import java.util.*;
public class CriticalConnectionsinaNetwork_1192 {
//    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//
//        List<List<Integer>> res = new ArrayList<>();
//
//        //1.build graph
//        List<Integer>[] g = new List[n];
//        for (int i=0; i< n; i++) {
//            g[i] = new ArrayList<>();
//        }
//
//        for (int i =0; i < connections.size(); i++) {
//            g[connections.get(i).get(0)].add(connections.get(i).get(1));
//            g[connections.get(i).get(1)].add(connections.get(i).get(0));
//        }
//
//        int[] timer = new int[1];
//        boolean[] visited = new boolean[n];
//        int[] timeStampAtThatNode = new int[n];
//        dfs(g, -1, 0, timer, visited, res, timeStampAtThatNode);
//        return res;
//    }
//    private void dfs(List<Integer>[] g, int parent, int node, int[] timer, boolean[] visited, List<List<Integer>> res, int[] timeStampAtThatNode) {
//        visited[node] = true;
//        timeStampAtThatNode[node] = timer[0]++;
//        int currTimeStamp = timeStampAtThatNode[node];
//
//        for (int nei:g[node]) {
//            if (nei==parent) continue;
//            if (!visited[nei]) dfs(g, node, nei, timer, visited, res, timeStampAtThatNode);
//            timeStampAtThatNode[node] = Math.min(timeStampAtThatNode[node],timeStampAtThatNode[nei]);
//            if (currTimeStamp< timeStampAtThatNode[nei]) res.add(Arrays.asList(node,nei));
//        }
//    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> res = new ArrayList<>();

        //1.build graph
        List<Integer>[] graph = new List[n];
        for (int i=0; i< n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i =0; i < connections.size(); i++) {
            graph[connections.get(i).get(0)].add(connections.get(i).get(1));
            graph[connections.get(i).get(1)].add(connections.get(i).get(0));
        }


        //2. dfs to detect cycle
        int[] timeStamps = new int[n];
        dfs(graph, 0, 0, 1, timeStamps, res);
        return res;
    }
    private static int dfs(List<Integer>[] graph, int curr, int parent,  int currTimeStamp, int[] timeStamps, List<List<Integer>> res) {
        timeStamps[curr] = currTimeStamp;

        for (int nei:graph[curr]) {
            if (nei==parent) continue;
            if (timeStamps[nei] > 0) {
                timeStamps[curr] = Math.min(timeStamps[curr],timeStamps[nei]);
            } else {
                timeStamps[curr] = Math.min(timeStamps[curr],dfs(graph, nei, curr, currTimeStamp+1, timeStamps, res));
            }
            if (currTimeStamp< timeStamps[nei]) res.add(Arrays.asList(curr,nei));
        }
        return timeStamps[curr];
    }

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> c1 = new ArrayList<>();
        c1.add(0);
        c1.add(1);
        List<Integer> c2 = new ArrayList<>();
        c2.add(1);
        c2.add(2);
        List<Integer> c3 = new ArrayList<>();
        c3.add(2);
        c3.add(0);
        List<Integer> c4 = new ArrayList<>();
        c4.add(1);
        c4.add(3);

        connections.add(c1);
        connections.add(c2);
        connections.add(c3);
        connections.add(c4);

        criticalConnections(4, connections);

    }





}
