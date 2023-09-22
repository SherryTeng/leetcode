import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = -1;

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            level++;
            for (int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                l.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            if (level %2 != 0) {
                List<Integer> reverse = new ArrayList<>();
                for (int i = l.size()-1; i >= 0; i--) {
                    reverse.add(l.get(i));
                }
                res.add(reverse);
            }else {
                res.add(l);
            }

        }
        return res;

    }
}
