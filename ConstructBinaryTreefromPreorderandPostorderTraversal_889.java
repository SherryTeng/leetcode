public class ConstructBinaryTreefromPreorderandPostorderTraversal_889 {

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

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);

    }

    /**
     preOrder: root, left,  right
     postorder: left, right, root

     preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]

     */

    private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
          if (preStart > preEnd || postStart > postEnd) return null;

          TreeNode root = new TreeNode(preorder[preStart]);

          if (preStart + 1 <= preEnd) {
              int rootIndex = 0;
              for (int i = 0; i < postorder.length; i++) {
                  if (postorder[i] == preorder[preStart+1]){
                      rootIndex = i;
                  }
              }

              int numOfLeftSub = rootIndex - postStart;
              root.left = helper(preorder, postorder, preStart+1, preStart +1 + numOfLeftSub, postStart, postStart + numOfLeftSub );
              root.right = helper(preorder, postorder, preStart + 1 + numOfLeftSub +1, preEnd, postStart + numOfLeftSub +1, postEnd-1);

          }

          return root;

    }

}
