public class LowestCommonAncestorofaBinaryTree_236 {

      public static class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

          if(root == null || root == p || root == q) return root;
          TreeNode left = lowestCommonAncestor(root.left, p,q);
          TreeNode right = lowestCommonAncestor(root.right, p,q);

          if (left!= null && right != null) return root;
          return left==null? right:left;

    }

    public static void main(String[] args) {
          TreeNode root = new TreeNode(3);
          TreeNode t1l = new TreeNode(5);
          TreeNode t1r = new TreeNode(1);
          root.left = t1l;
          root.right = t1r;

        TreeNode t2l = new TreeNode(6);
        TreeNode t2r = new TreeNode(2);
        t1l.left = t2l;
        t1l.right = t2r;

        TreeNode t3l = new TreeNode(7);
        TreeNode t3r = new TreeNode(4);
        t2r.left = t3l;
        t2r.right = t3r;


//          lowestCommonAncestor(root, t3l, t1r);
        lowestCommonAncestor(root, t2r, t3r);
        lowestCommonAncestor(root, t2l, t3r);


    }
}
