import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceaBinarySearchTree_1382 {
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
    List<TreeNode> sorted = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return convertToBST(0, sorted.size()-1);

    }

    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        sorted.add(root);
        inorderTraversal(root.right);
    }

    private TreeNode convertToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        TreeNode root = sorted.get(mid);
        root.left = convertToBST(start, mid-1);
        root.right = convertToBST(mid+1, end);
        return root;
    }
}
