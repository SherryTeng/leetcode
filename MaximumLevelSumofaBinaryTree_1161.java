import java.util.*;

public class MaximumLevelSumofaBinaryTree_1161 {
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

    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;

        int smallestLevel = 1;
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            int sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }

            }

            if (sum > maxSum) {
                maxSum = sum;
                smallestLevel = level;
            }

        }

        return smallestLevel;

    }


}
