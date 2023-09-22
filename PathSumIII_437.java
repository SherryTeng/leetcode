public class PathSumIII_437 {
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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return helper(root, targetSum, 0) + pathSum(root.left, targetSum)+ pathSum(root.right, targetSum);
    }

    private int helper(TreeNode root, int targetSum, long currSum) {
        if (root == null) return 0;

        int res = 0;

        currSum+= root.val;

        if (currSum == targetSum){
            res++;
        }

        res+=helper(root.left, targetSum, currSum);
        res+=helper(root.right, targetSum, currSum);

        return res;

    }


}
