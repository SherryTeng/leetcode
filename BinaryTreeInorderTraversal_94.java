import java.util.*;

public class BinaryTreeInorderTraversal_94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
         res = new ArrayList<>();
        DFS(root);
        return res;



    }
    private void DFS(TreeNode root) {
        if (root == null) return;
        DFS(root.left);
        res.add(root.val);
        DFS(root.right);
    }
}
