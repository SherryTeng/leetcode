import java.util.*;

public class MinimumAbsoluteDifferenceinBST_530 {

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

    int min = Integer.MAX_VALUE;
    Integer prev = null;

    TreeSet<Integer> set = new TreeSet<>();

    public int getMinimumDifference(TreeNode root) {
        //Method1: in order traversal
        //time complexity: O(N)
        //Space complexity: O(1)
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val-prev);
        }

        prev = root.val;
        getMinimumDifference(root.right);

        return min;


        //Method2: what if it's not a BST: Using TreeSet: Pre-order traversal
        //time complexity: O(NlgN)
        //Space complexity: O(N)

//        if (root == null) return min;
//
//        if (!set.isEmpty()) {
//            if (set.floor(root.val) != null) {
//                min = Math.min(min, root.val - set.floor(root.val));
//            }
//
//            if (set.ceiling(root.val) != null) {
//                min = Math.min(min, set.ceiling(root.val) - root.val);
//            }
//
//        }
//
//        set.add(root.val);
//
//        getMinimumDifference(root.left);
//        getMinimumDifference(root.right);
//
//        return min;
    }

}
