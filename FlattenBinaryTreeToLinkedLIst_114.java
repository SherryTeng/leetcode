public class FlattenBinaryTreeToLinkedLIst_114 {
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
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode leftmost = root.left;
            while (leftmost.right != null) {
                leftmost = leftmost.right;


            }
            leftmost.right = temp;


        }

        root.left = null;

    }
}
