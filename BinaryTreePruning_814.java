public class BinaryTreePruning_814 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;this.right = right;
      }
  }
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        if (root.val == 0 && notContainingOne(root.left) && notContainingOne(root.right)) return null;
        if (notContainingOne(root.left)) root.left = null;
        if (notContainingOne(root.right)) root.right = null;
        pruneTree(root.left);
        pruneTree(root.right);
        return root;

    }

    private boolean notContainingOne(TreeNode root) {
        if (root == null) return true;
        return root.val == 0 && notContainingOne(root.left) && notContainingOne(root.right);
    }
}
