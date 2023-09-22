public class ConstructBinarySearchTreefromPreorderTraversal_1008 {
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

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(0, preorder.length-1, preorder);

    }

    private TreeNode helper(int start,int end, int[] preorder) {
        if (start > end) return null;

        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);

        int rightSub = 0;
        for (int i = start; i <= end; i++) {
            if (preorder[i] > rootVal) {
                rightSub = i;
                break;
            }
        }
        root.left = helper(start+1,rightSub-1 , preorder);
        root.right = helper(rightSub ,end, preorder);

        return root;
    }
}
