// URL: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public String minRemoveToMakeValid(String s) {
        // APPROACH-1: Using Stack. //

        // Stack to store the indices of '('
        Stack<Integer> st = new Stack<>();
        // HashSet to store the unnecessary '(' & ')' indices
        Set<Integer> indicesToRemove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.push(i);

            if (s.charAt(i) == ')') {
                if (st.isEmpty())
                    indicesToRemove.add(i);
                else
                    st.pop();
            }
        }

        // Add any indices of '(' to the stack
        if (!st.isEmpty()) {
            while (!st.isEmpty())
                indicesToRemove.add(st.pop());
        }

        // Build the result string ignoring the unnecessary '(' & ')'
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!indicesToRemove.contains(i))
                sb.append(s.charAt(i));

        return sb.toString();
    }
}