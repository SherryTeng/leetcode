import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree_366 {
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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return res;

    }

    private int helper(TreeNode node) {
        if (node == null) return -1;
        int leftLevel = helper(node.left);
        int rightLevel = helper(node.right);
        int level = Math.max(leftLevel, rightLevel) +1;
        if (res.size() == level){
            res.add(new ArrayList<>());
        }

        res.get(level).add(node.val);
        return level;
    }

}
