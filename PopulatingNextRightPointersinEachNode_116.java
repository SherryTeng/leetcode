import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode_116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    //自己想出的方法超时，更为简洁的方法是直接用Queue的.peek()方法， 而不用另外建立一个ArrayList
//    public Node connect(Node root) {
//        if (root == null) return null;
//        Queue<ArrayList<Node>> q = new LinkedList<>();
//        ArrayList<Node> start = new ArrayList<>();
//        start.add(root);
//        q.add(start);
//        while (!q.isEmpty()) {
//            ArrayList<Node> level = q.remove();
//            int size = level.size();
//            ArrayList<Node> nextLevel = new ArrayList<>();
//            for (int i = 0; i < size; i++) {
//                if (i == size -1 ) {
//                    level.get(size-1).next = null;
//                }else {
//                    level.get(i).next = level.get(i+1);
//                }
//
//                if (level.get(i).left != null) {
//                    nextLevel.add(level.get(i).left);
//
//                }
//                if (level.get(i).right != null){
//                    nextLevel.add(level.get(i).right);
//                }
//            }
//            q.add(nextLevel);
//        }
//        return root;
//
//    }

//    public Node connect(Node root) {
//        if (root == null) return null;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()){
//            int size = q.size();
//
//            for (int i = 0; i < size; i++) {
//                Node curr = q.remove();
//                if (i < size -1) {
//                    curr.next = q.peek();
//                }
//                if (curr.left != null) q.add(curr.left);
//                if (curr.right != null) q.add(curr.right);
//            }
//        }
//        return root;
//
//    }

    //DFS
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;


    }

}
