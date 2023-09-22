public class BalancedBinaryTree_110 {

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

//      //Method1: O(nlogn)
//    public boolean isBalanced(TreeNode root) {
//
//          if (root == null) return true;
//          int left_height = height(root.left);
//          int right_height = height(root.right);
//          return (Math.abs(left_height-right_height) <=1 && isBalanced(root.left) && isBalanced(root.right));
//
//    }
//    private int height(TreeNode node) {
//
//          if (node == null) return 0;
//          return Math.max(height(node.left), height(node.right))+1;
//    }

    //Method2: O(n)

//    private boolean balanced;
//    public boolean isBalanced(TreeNode root) {
//        this.balanced = true;
//        height(root);
//        return this.balanced;
//
//
//    }
//    private int height(TreeNode node){
//        if (node == null || !this.balanced ) return -1;
//        int l = height(node.left);
//        int r = height((node.right));
//        if (Math.abs(l-r) >1) {
//            this.balanced = false;
//            return -1;
//        }
//        return Math.max(l,r)+1;
//
//    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return (isBalanced(root.left) && isBalanced(root.right));

    }


    private int height(TreeNode node) {
        if (node == null)  return 0;
        return Math.max(height(node.left), height(node.right)) + 1;

    }
}
