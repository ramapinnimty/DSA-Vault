// URL: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Learning resources:
// --
// https://www.youtube.com/watch?v=eD3tmO66aBA&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=15
// --
// Time : O(n) ; Space(auxilary) : O(N) for a skewed tree
class Solution {
    private int maxDepthUtil(TreeNode node) {
        if (node == null)
            return 0;

        return 1 +
                Math.max(maxDepthUtil(node.left),
                        maxDepthUtil(node.right));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return maxDepthUtil(root);
    }
}