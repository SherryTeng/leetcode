public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {
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

    /**
     * inorder: left, root, right
     * postorder: left, right, root

     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);

    }

    private TreeNode helper(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder) {
        if (inStart > inEnd || postStart > postEnd || postEnd > postorder.length-1) return null;

        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                rootIndex = i;
                break;
            }
        }
        int numOfLeft = rootIndex - inStart;
        root.left = helper(inStart, rootIndex-1, postStart, postStart+numOfLeft-1, inorder, postorder);
        root.right = helper(rootIndex+1, inEnd, postStart+ numOfLeft, postEnd -1, inorder, postorder);

        return root;
    }
}
