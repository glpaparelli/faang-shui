package problems.array.medium;

import java.util.Arrays;

/*
 * LEETCODE 75: Sort Colors
 * Given an array "nums" with n objects colored red, white, or blue, sort them in-place
 * so that the objects of the same colors are adjiacent, with the colors in the order
 * red, white, and blue.
 * 
 * We use will use integers 0, 1, and 2 to represent the color red, white, and blue. 
 * 
 * You cannot use library's sort to solve the problem. 
 * 
 * MY NOTE: you also cannot use (self-implemented) Counting Sort.
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums1 = {2,0,2,1,1,0};
        sortColors(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {2,0,1};
        sortColors(nums2);
        System.out.println(Arrays.toString(nums2));

    }

    public static void sortColors(int[] nums) {
        int reds = 0; 
        int whites = 0; 

        for (int color : nums)
            if (color == 0)
                reds++;
            else if (color == 1)
                whites++;

        for (int i = 0; i < reds; i++)
            nums[i] = 0;

        for (int i = reds; i < reds + whites; i++)
            nums[i] = 1;

        for (int i = reds + whites; i < nums.length; i++)
            nums[i] = 2;

    }
}
