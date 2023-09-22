public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
        }


    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length-1 || inStart > inEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
            }
        }

        TreeNode left = helper(preStart+1, inStart, rootIndex-1, preorder, inorder);
        TreeNode right = helper(preStart + rootIndex - inStart + 1, rootIndex+1, inEnd, preorder, inorder);

        root.left = left;
        root.right = right;

        return root;

    }
}
