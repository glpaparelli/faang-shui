package problems.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * LEETCODE 1: Two Sum
 * Given an array of integers "nums" and an integer "target", return 
 * the indices of the two numbers such that they add up to "target".
 * 
 * You may assume that each input would have exaclty one solution, and
 * may not use the same element twice. 
 * 
 * You can return the answer in any order. 
 * 
 * SOLUTION: 
 * - trivial solution: O(n^2), two nested loops.
 * 
 * - less trivial solution: O(nlog(n)), sort then two pointers, l = 0 and r = n-1
 *                          if nums[l] + nums[r] = target then [l,r]
 *                          if nums[l] + nums[r] > target then r--
 *                          if nums[l] + nums[r] < target then l++
 *                          Mind that the problem wants the original indexes, you have to remember
 *                          the original ordering of the array.
 * 
 * - optimal solution: O(n), build a hmap: nums[i] -> i
 *                     Go through nums with i: if target - nums[i] is contained within the map
 *                     then the solution [i, map.get(target-nums[i])] is a valid solution.
 * 
 * - optimized optimal solution: O(n), search and fill the map in the same pass, the solution is 
 *                               inverted but by problem specification it is ok.
 */

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }

    public static int[] twoSum(int nums[], int target) {
        Map<Integer, Integer> elemToIndex = new HashMap<>();

        Integer index = null;
        for (int i = 0; i < nums.length; i++) {
            index = elemToIndex.get(target - nums[i]); 
            if (index != null && i != index)
                return new int[]{i, index};

            elemToIndex.put(nums[i], i); 
        }

        return null;
    }
}
