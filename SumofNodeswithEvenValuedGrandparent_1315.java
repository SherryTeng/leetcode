public class SumofNodeswithEvenValuedGrandparent_1315 {
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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        helper(root, null, null);
        return sum;

    }

    private void helper(TreeNode curr, TreeNode parent, TreeNode grandparent) {
        if (curr == null) return;
        if (grandparent != null && grandparent.val%2 == 0) {
            sum+=curr.val;
        }
        helper(curr.left, curr, parent);
        helper(curr.right, curr, parent);
    }
}
