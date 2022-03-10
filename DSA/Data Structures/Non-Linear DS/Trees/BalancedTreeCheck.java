// URL: https://leetcode.com/problems/balanced-binary-tree/
// Learning resources:
// --
// https://www.youtube.com/watch?v=Yt50Jfbd8Po&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=16
// --
// APPROACH-1: Time : O(n^2) -- O(n) for traversal & for every node 
// we need to calculate it's height which takes O(n)
class Solution {
    // Helper function to calculate the height
    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;

        // Recursively check if both left & right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }
}

// APPROACH-2: Time : O(n) ; Space(auxilary) : O(n) for a skewed tree
class Solution {
    // Helper function to calculate the height
    private int maxDepth(TreeNode node) {
        if (node == null)
            return 0;

        int lheight = maxDepth(node.left);
        if (lheight == -1)
            return -1;

        int rheight = maxDepth(node.right);
        if (rheight == -1)
            return -1;

        if (Math.abs(lheight - rheight) > 1)
            return -1;

        return 1 + Math.max(lheight, rheight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return maxDepth(root) != -1;
    }
}