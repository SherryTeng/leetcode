public class CountGoodNodesinBinaryTree_1448 {
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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxVal) {
        if (node  == null) return 0;
        int res = 0;
        if (node.val >= maxVal) {
            res = 1;
        }

        maxVal = Math.max(maxVal, node.val);

        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);

        return res;
    }


}
