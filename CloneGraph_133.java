import java.util.*;
public class CloneGraph_133 {

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node  == null) return null;

        Map<Node, Node> map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();

        map.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node next: curr.neighbors) {
                if (!map.containsKey(next)) {
                    map.put(next, new Node(next.val));
                    q.add(next);

                }
                map.get(curr).neighbors.add(map.get(next));
            }
        }

        return map.get(node);

    }
}
