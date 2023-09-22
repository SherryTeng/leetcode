public class MaximumBinaryTree_654 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;this.right = right;
        }
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums==null) return null;

        return construct(nums, 0, nums.length-1);


    }

    public TreeNode construct(int[] nums, int l, int r){
        if (l>r) return null;
        int max = nums[l];
        int maxIndex = l;
        for (int i=l; i<=r;i++) {
            if (nums[i]> max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, l, maxIndex-1);
        root.right = construct(nums, maxIndex+1, r);

        return root;

    }
}


