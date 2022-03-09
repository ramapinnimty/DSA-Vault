// URL: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Learning resources:
// --
// https://www.youtube.com/watch?v=Z_NEgBgbRVI&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=9
// --
// https://www.youtube.com/watch?v=lxTGsVXjwvM&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=11

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
// APPROACH-1: Using recursion ; Time: O(n) ; Space (auxilary): O(n) in the
// worst case -- in the case of a skewed tree
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return result;

        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);

        return result;
    }
}

// APPROACH-2: Iterative using stack
// Time : O(n) ; Space : O(n) ~ O(H) in the worst-case of a left-skewed tree
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !st.isEmpty()) {
            // Recursively go down the left-subtree to the leaf nodes
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            // Once we reach a leaf node, store it's value and go to
            // the right-subtree
            curr = st.pop();
            result.add(curr.val);
            // Assign the right child to `curr`
            curr = curr.right;
        }

        return result;
    }
}