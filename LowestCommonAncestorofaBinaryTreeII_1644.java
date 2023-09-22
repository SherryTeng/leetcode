public class LowestCommonAncestorofaBinaryTreeII_1644 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean pFound;
    boolean qFound;


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = LCA(root, p, q);
        return pFound && qFound ? LCA : null;
    }

    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if (root == p) {
            pFound = true;
            return root;
        }

        if (root == q) {
            qFound = true;
            return root;
        }


        if (left!= null && right != null) return root;
        return left==null? right:left;
    }


}
