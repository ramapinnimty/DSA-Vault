// URL: https://www.codingninjas.com/codestudio/problems/move-all-negative-numbers-to-beginning-and-positive-to-end_1112620?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0

/*
Learnings: -
    -- In-built 'Swap' function: Collections.swap(arr, idx1, idx2)
*/

import java.util.*;

public class Solution {
    public static ArrayList<Integer> separateNegativeAndPositive(ArrayList<Integer> nums) {
        // Write your code here.
        int N = nums.size();
        int front = 0;
        int rear = N - 1;

        while (front < rear) {
            // Loop till you find a positive element
            while (front < N && nums.get(front) < 0)
                front++;
            // Loop till you find a negative element
            while (rear >= 0 && nums.get(rear) > 0)
                rear--;
            // Found the right elements, simply swap
            if (front < rear)
                Collections.swap(nums, front, rear);
        }

        return nums;
    }
}