package problems.array.medium;

import java.util.Arrays;

/*
 * LEETCODE 16: 3Sum Closest
 * Given an integer array "nums" of length n and an integer "target", 
 * find three integers in nums such that the sum is closest to target. 
 * 
 * Return the sum of the three integers.
 * 
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
        System.out.println(threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
        System.out.println(threeSumClosest(new int[]{1,1,1,0}, -100));        
    }

    // very similar to three closest sum
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int right; // points to the end
        int pointer; // points next to left

        int currentClosestSum = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int left = 0; left < nums.length; left++) {
            // skip duplicates
            if (left != 0 && nums[left-1] == nums[left])
                continue;

            pointer = left + 1; // sets pointer to point next to left
            right = nums.length -1; // (re)sets right to the end

            // while we have numbers from left+1 to the end
            while (pointer < right) {
                currentSum = nums[left] + nums[right] + nums[pointer];
                
                if (currentSum == target)
                    return currentSum;
                else if (currentSum > target)
                    right--;
                else 
                    pointer++;

                // if the distance between the currentClosestSum and the target
                // is greater than the distance between currentSum and the target we update
                if (Math.abs(currentClosestSum - target) > Math.abs(currentSum - target))
                    currentClosestSum = currentSum;
            }
        }

        return currentClosestSum;
    }
}