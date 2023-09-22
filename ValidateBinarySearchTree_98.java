import java.util.Stack;
public class ValidateBinarySearchTree_98 {
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



//  //Method1: Iterative inorder traversal (Using stack)
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) return true;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode prev = null;
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if (prev != null && prev.val >= root.val) return false;
//
//            prev = root;
//            root = root.right;
//        }
//        return true;
//    }

//    //Method2: Recursive inorder traversal
//    boolean flag = true;
//    TreeNode prev = null;
//    public boolean isValidBST(TreeNode root) {
//        inOderTraverse(root);
//        return flag;
//    }
//
//    private void inOderTraverse(TreeNode root) {
//        if (root == null) return;
//        inOderTraverse(root.left);
//
//        if (prev != null && prev.val >= root.val) {
//            flag = false;
//            return;
//        }
//
//        prev = root;
//
//        inOderTraverse(root.right);
//
//    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }


}
