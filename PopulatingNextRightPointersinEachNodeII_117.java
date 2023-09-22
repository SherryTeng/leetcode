import java.util.LinkedList;

import java.util.*;
public class PopulatingNextRightPointersinEachNodeII_117 {
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

    public Node connect(Node root) {

        //constant space:
        Node dummyHead  = new Node(0); // this head will always point to the first element in the current layer we are searching
        Node pre = dummyHead; // this 'pre' will be the "current node" that builds every single layer
        Node real_root = root; // just for return statement

        while(root != null){
            if(root.left != null){
                pre.next = root.left;
                pre = pre.next;
            }
            if(root.right != null){
                pre.next = root.right;
                pre = pre.next;
            }
            root = root.next;
            if(root == null){ // reach the end of current layer
                pre = dummyHead; // shift pre back to the beginning, get ready to point to the first element in next layer
                root = dummyHead.next; //root comes down one level below to the first available non null node
                dummyHead.next = null;//reset dummyhead back to default null
            }
        }
        return real_root;




//        //Method 1: 自己想出来的方法， 但是空间复杂度比较高 不是constant space
//        if (root == null) return null;
//        Queue<Node> q = new LinkedList<>();
//        q.add(root);
//        while (!q.isEmpty()) {
//            int size = q.size();
//            Queue<Node> level = new LinkedList<>();
//            for (int i = 0; i < size; i++) {
//                Node curr = q.poll();
//                level.add(curr);
//
//                if (curr.left != null) {
//                    q.add(curr.left);
//                }
//
//                if (curr.right != null) {
//                    q.add(curr.right);
//                }
//            }
//            Node levelNode = level.poll();
//            while (size>1) {
//                levelNode.next = level.poll();
//                levelNode = levelNode.next;
//                size--;
//            }
//        }
//        return root;
//    }




        }




}
