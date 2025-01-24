package problems.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LEETCODE 13: 3Sum
 * Given an integer array "nums", return all the triplets 
 * [nums[left], nums[pointer], nums[right]] such that left != pointer != right, and 
 * nums[left] + nums[pointer] + nums[right] == 0. 
 * 
 * The solution must not contain duplicate triplets.
 * 
 * In other words: we want to find left, pointer, right such that left + pointer + right == 0
 * 
 * SOLUTIONS: 
 * - Optimal Solution: O(n^2) time, O(1) space
 *   check the comments, we use sorting and three pointers
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] input1 = {-1,0,1,2,-1,-4};
        List<List<Integer>> res1 = threeSum(input1);
        res1.forEach(list -> System.out.print(list + ", "));

        System.out.println();

        int[] input2 = {0,1,1};
        List<List<Integer>> res2 = threeSum(input2);
        res2.forEach(list -> System.out.print(list + ", "));

        System.out.println();
        int[] input3 = {0,0,0}; 
        List<List<Integer>> res3 = threeSum(input3);
        res3.forEach(list -> System.out.print(list + ", "));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // we need to sort the array to make some assumptions
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int currentSum = 0;

        // left starts pointing at the starts of the array
        for (int left = 0; left < nums.length; left++){

            //this avoid left to refer to the same value twice, to avoid duplicates
            if (left != 0 && nums[left] == nums[left-1])
                continue;

            // pointer indicates the element just after left
            int pointer = left + 1;
            // right starts at the end of the array
            int right = nums.length - 1;

            // while pointer (left+1) has not reached the end of the interesting portion
            while (pointer < right) {
                // compute the current sum
                currentSum = nums[left] + nums[pointer] + nums[right];

                // if the current sum is zero we have found a triplet
                if (currentSum == 0) {
                    result.add(List.of(nums[left], nums[pointer], nums[right]));
                    pointer++;

                    //this avoid pointer to refere to the same value twice, to avoid duplicates
                    while (pointer < right && nums[pointer] == nums[pointer-1])
                        pointer++;
                
                // if currentSUm is < 0 we need to increase the sum, the array is sorted
                // we move pointer to the right to obtain a bigger sum
                } else if (currentSum < 0)
                    pointer++;
                // analogous
                else
                    right--;
            }
        }

        return result;
    }
}
