import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorofaBinaryTreeIV_1676 {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node);
        }

        return LCA(root, set);

    }

    private TreeNode LCA(TreeNode root, Set<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) return root;
        TreeNode left = LCA(root.left, nodes);
        TreeNode right = LCA(root.right, nodes);
        if (left != null && right!= null) return root;

        return left == null? right: left;
    }
}
