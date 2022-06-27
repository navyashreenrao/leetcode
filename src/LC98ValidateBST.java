public class LC98ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    private boolean helper(TreeNode root, long highest, long lowest) {
        if(root == null) {
            return true;
        }
        if (!(root.val < highest && root.val > lowest)) {
            return false;
        }
        // For every iteration, the min value of the right sub tree and the max value of the left sub tree
        //  becomes the current node
        boolean left = helper(root.left, root.val, lowest);
        boolean right = helper(root.right, highest, root.val);
        return left && right;
    }
}
