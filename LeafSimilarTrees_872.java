public class LeafSimilarTrees_872 {
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder root1Leavers = new StringBuilder();
        StringBuilder root2Leavers = new StringBuilder();

        helper(root1, root1Leavers);
        helper(root2, root2Leavers);

        return root1Leavers.toString().equals(root2Leavers.toString());

    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null & root.right == null) {
            sb.append(root.val + '-');
        }

        helper(root.left, sb);
        helper(root.right, sb);
    }


}
