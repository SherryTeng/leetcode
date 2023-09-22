public class DistributeCoinsinBinaryTree_979 {
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
    int total;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return total;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);

        total += Math.abs(left) + Math.abs(right);

        return left + right + root.val -1;
    }
}
