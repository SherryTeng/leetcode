import java.util.*;
import java.util.List;
import java.util.PriorityQueue;

public class MckenseyOA_connectingComputer {

    static int findParent(int[] parent, int node) {
        if (parent[node] == -1) {
            return node;
        }
        return findParent(parent, parent[node]);
    }

    static void union(int[] parent, int node1, int node2) {
        int parent1 = findParent(parent, node1);
        int parent2 = findParent(parent, node2);
        if (parent1 != parent2) {
            parent[parent1] = parent2;
        }
    }


    static int minOperationsToConnect(int compNodes, int compEdges, int[] cFrom, int[] cTo) {

        if (compEdges  < compNodes -1) return -1;

        int[] parent = new int[compNodes + 1];
        Arrays.fill(parent, -1);

        for (int i = 0; i < compEdges; i++) {
            union(parent, cFrom[i], cTo[i]);
        }

        int components = 0;
        for (int i = 1; i <= compNodes; i++) {
            if (parent[i] == -1) {
                components++;
            }
        }

        if (components <= 1) {
            return 0;  // All computers are already connected or only one component
        } else {
            return components - 1;  // One less cable than the number of components
        }


    }


    public static void main(String[] args) {
        int num_node = 4; // Number of nodes (computers)
        int num_edge = 3; // Number of edges (cables)
        int[] c_from = {1,1,3}; // Array of source nodes for each edge
        int[] c_to = {2,3,2}; // Array of destination nodes for each edge

        int result = minOperationsToConnect(num_node, num_edge, c_from, c_to);
        System.out.println("Minimum operations: " + result);
    }

}
