package problems.array.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * LEETCODE 560: Subarray Sum Equals K
 * Given an integers array "nums" and an integer "k", return the 
 * total number of subarrays whose prefSum equals k. 
 * 
 * A subarray is a contiguous non-empty sequence of elements 
 * within an array.
 * 
 * SOLUTION: 
 * check the comments
 */
public class SSEK {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
        System.out.println(subarraySum(new int[]{1,2,3}, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;  
        // current prefix sum
        int prefSum = 0;

        // map: prefix sum -> occurrencees of that prefix sum
        Map<Integer,Integer> pTo = new HashMap<>(); 
        
        // before starting the prefix sum is zero, and so far
        // we found it once (meaning this time).
        pTo.put(0,1);

        // we go through every number left to right
        for (int num: nums) {
            // compute the prefix sum so far
            prefSum += num;

            // if the map contains prefixSum - k it means 
            // that we found before a place from where we can 
            // reach the current prefixSum by adding k, hence
            // the subarray from there to here is a subarray 
            // of sum k.
            if (pTo.containsKey(prefSum-k))
                result += pTo.get(prefSum-k);   
            
            // we add to the map the number of times we have seen prefSum
            pTo.put(prefSum, pTo.getOrDefault(prefSum, 0) +1);       
        }
        return result;
    } 
}
