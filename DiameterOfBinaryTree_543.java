public class DiameterOfBinaryTree_543 {
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

    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;


    }
    private int longestPath(TreeNode node){
        if(node == null) return 0;
        int leftLongest = longestPath(node.left);
        int rightLongest = longestPath(node.right);

        diameter = Math.max(diameter, leftLongest + rightLongest);

        return Math.max(leftLongest, rightLongest) +1;
    }
}
