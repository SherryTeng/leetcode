import java.util.*;
public class BinaryTreeLevelOrderTraversal_102 {
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

  //Method 1: BFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) return res;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            List<Integer> level = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.remove();
//                level.add(node.val);
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//            res.add(level);
//        }
//        return res;
//
//    }

    //Method 2: DFS
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int level) {
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);

        if (root.left != null) {
            helper(root.left, level +1);
        }

        if (root.right != null) {
            helper(root.right, level +1);
        }
    }

}
