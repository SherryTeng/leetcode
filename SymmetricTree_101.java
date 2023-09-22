import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//Method 1: DFS
//    public boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        return helper(root.left, root.right);
//    }
//
//    private boolean helper(TreeNode left, TreeNode right) {
//        if (left == null && right == null) return true;
//        if (left == null || right == null)  return false;
//        return (left.val == right.val) && helper(left.left, right.right) && helper(left.right, right.left);
//    }

//Method 2: BFS
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
