// URL: https://leetcode.com/problems/valid-palindrome/
/*
Learnings: -
    1. `Character.isLetterOrDigit(char)` checks for alphanumeric characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        // APPROACH-1: Two-pointer approach.
        int n = s.length();
        int front = 0;
        int rear = n - 1;

        s = s.toLowerCase();
        while (front < rear) {
            while (front < n && !Character.isLetterOrDigit(s.charAt(front))) {
                front++;
            }

            while (rear >= 0 && !Character.isLetterOrDigit(s.charAt(rear))) {
                rear--;
            }

            if (front < rear && s.charAt(front) != s.charAt(rear))
                return false;
            else {
                front++;
                rear--;
            }
        }

        return true;
    }
}