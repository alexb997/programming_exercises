class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private static TreeNode prev = null;

    public static boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private static boolean inOrder(TreeNode node) {
        if (node == null) return true;

        if (!inOrder(node.left)) return false;

        if (prev != null && node.val <= prev.val) return false;
        prev = node;

        return inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(isValidBST(root1));

    }
}