package problems.array.easy;

import java.util.Arrays;

/*
 * LEETCODE 283: Move Zeroes
 * Given an integer array "nums", move all 0's to the end of it while 
 * maintaining the relative order of the non-zero elements. 
 * You must do this in-place without making a copy of the array.
 * 
 * SOLUTIONS:
 * - Trivial Solution: O(n^2), two nested loops
 * 
 * - Optimal Solution: O(n) time, O(1) space. 
 *   Two pointers "left" and "right" starts togheter (both at zero).
 *   They move until they find a zero, now left stays here while right keeps moving. 
 *   When right find a non-zero element it swaps it with left, then left moves and right moves
 */
public class MoveZeroes {
    public static void main(String[] args) {
    
        int[] ex1 = new int[]{0,1,0,3,12};
        System.out.println(Arrays.toString(ex1));
        moveZeroes(ex1);
        System.out.println(Arrays.toString(ex1));

        int[] ex2 = new int[]{0};
        System.out.println(Arrays.toString(ex2));
        moveZeroes(ex2);
        System.out.println(Arrays.toString(ex2));
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0; 

        while (right < nums.length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++; 
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
