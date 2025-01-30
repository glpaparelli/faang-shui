package problems.array.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * LEETCODE 525: Contiguous Array
 * Given a binary array "nums", return the maximum length of a 
 * contiguous subarray with an equal number of 0 and 1.
 * 
 * SOLUTION: 
 * We use the prefix sum. Mind that as often is the case we do not actually need 
 * the prefix sum array, we just need the prefix sum so far. 
 * We consider the "0" in nums as -1, and 1 as 1, any solution subarray will have
 * its sum equal 0.
 * We then exploit the fact that when at two indices we have the same prefix sum 
 * the sum of the subarray between those two indeces is 0.
 * This is useful as we can use a map to store for each pref sum the index it is, 
 * and when we find the same prefix sum again we can compute the length of the 
 * subarray. 
 * 
 * Check the comments
 */
public class ContiguousArray {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1})); 
        System.out.println(findMaxLength(new int[]{0,1,0})); 
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        // prefix sum so far -> index
        Map<Integer, Integer> prefSumToIndex = new HashMap<>();
        int prefSum = 0; 

        for (int i = 0; i < nums.length; i++) {
            // we consider 0 as -1
            if (nums[i] == 0)
                prefSum--;
            else 
                prefSum++;

            // if prefSum is 0 it means that from 0 to i we have the same number 
            // of 0 and 1, and this is by def the longest subarray
            if (prefSum == 0)
                maxLength = i + 1;
            // if this prefSum has already been found before we retrieve its index j
            // and compute i-j. if i-j is bigger than the current maxLength we update it
            else if (prefSumToIndex.containsKey(prefSum))
                maxLength = Math.max(maxLength, i - prefSumToIndex.get(prefSum));
            else 
                // otherwise we simply put the current <prefix sum - i> in the map
                prefSumToIndex.put(prefSum, i);
        }

        return maxLength;
    }
}