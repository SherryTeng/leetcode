import java.util.HashSet;

public class LowestCommonAncestorofaBinaryTreeIII_1650 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    //use two pointers
    public Node lowestCommonAncestor(Node p, Node q) {
        Node p1 =p, p2=q;
        while (p1!=p2) {
            if (p1==null) {
                p1=q;
            }else{
                p1=p1.parent;
            }
            if (p2==null) {
                p2=p;
            }else{
                p2=p2.parent;
            }
        }
        return p1;

    }

//    // extra space
//    public Node lowestCommonAncestor(Node p, Node q) {
//
//        if (p == null || q == null) return null;
//
//        HashSet<Node> ancestors = new HashSet<>();
//        while (p != null) {
//            ancestors.add(p);
//            p = p.parent;
//        }
//
//        while (!ancestors.contains(q)){
//            q= q.parent;
//        }
//
//
//        return q;
//    }
}
