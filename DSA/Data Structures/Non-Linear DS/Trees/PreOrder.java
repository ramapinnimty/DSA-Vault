// URL: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Learning resources:
// --
// https://www.youtube.com/watch?v=RlUu72JrOCQ&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=6
// --
// https://www.youtube.com/watch?v=Bfqd8BsPVuw&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=13

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

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return result;

        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return result;
    }
}

// APPROACH-2: Iterative, using Stack
// Time : O(n) ; Space : O(n) ~ O(H) in the worst case where every node has one
// right child & left subtree keeps growing & keeps getting deeper
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode popped = st.pop();
            result.add(popped.val);
            if (popped.right != null)
                st.push(popped.right);
            if (popped.left != null)
                st.push(popped.left);
        }

        return result;
    }
}