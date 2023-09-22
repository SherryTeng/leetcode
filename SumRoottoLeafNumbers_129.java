public class SumRoottoLeafNumbers_129 {
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

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currSum) {
        if (root == null) return 0;

        currSum = currSum*10 + root.val;

        if (root.left == null && root.right == null) {
            return currSum;
        }else {
            return dfs(root.left, currSum) + dfs(root.right, currSum);
        }
    }


}
