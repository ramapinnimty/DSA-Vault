
// URL: https://leetcode.com/problems/binary-tree-level-order-traversal/
// Learning resources:
// --
// https://www.youtube.com/watch?v=EoAsWbO7sqg&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=9
// --
// Time : O(n) ; Space : O(n)
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        // Add root to the queue
        q.add(root);
        while (!q.isEmpty()) {
            List<TreeNode> nodesAtLevel = new ArrayList<>();
            while (!q.isEmpty())
                nodesAtLevel.add(q.remove());

            List<Integer> nodeValuesList = new ArrayList<>();
            // Now, for each node at a given level,
            // add it's left and right children to the queue
            for (TreeNode node : nodesAtLevel) {
                // Add the parent node(s) to the result
                nodeValuesList.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            result.add(nodeValuesList);
        }

        return result;
    }
}