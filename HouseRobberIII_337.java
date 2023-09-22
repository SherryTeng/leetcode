public class HouseRobberIII_337 {

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

    public int rob(TreeNode root) {
          int[] amount  = helper(root);
          return Math.max(amount[0],amount[1]);

    }
    private int[] helper(TreeNode node) {
          if (node==null) return new int[2];
          int[] left = helper(node.left);
          int[] right = helper(node.right);


          //root is robbed
        int robbed = node.val+left[1] + right[1];

        //root is not robbed
        int notRobbed = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);


        return new int[] {robbed, notRobbed};
    }
}
