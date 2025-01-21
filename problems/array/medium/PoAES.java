package problems.array.medium;

import java.util.Arrays;

/*
 * LEETCODE 238: Product of Array Except Self
 * Given an array "nums", return an array "answer" such that answer[i] is 
 * equal to the product of all the elements of nums except nums[i]. 
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in an int.
 * 
 * You must write an algorithm that runs in O(n) time and without using 
 * the division operator.
 * 
 * SOLUTIONS: 
 * - Optimal Time Solution: O(n) time & space
 *   Use precomputation to compute the prefix product and the suffix product array,
 *   then answer[i] = prefixProduct[i-1] * prefixProduct[i+1].
 *   Besides using too much space is tricky working with indexes and suffix prodcut are avoidable.
 * 
 * - Optimal Solution: O(n) time, O(1) space
 *   We do not need to store all the prefix product, we just need the current one. 
 *   We use an accumulator to store the prefix sum so far and assign it "one iteration late" 
 *   to answer[i]. 
 *   After the first for we will have that answer[i] = prefix product until i-1
 *   Resetting the accumulator and usiing it to find the prefix product right to left
 *   and assign it "later" to answer we will have the right result
 */
public class PoAES {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    public static int[] precomputatoinProductExceptSelf(int[] nums) {
        int answer[] = new int[nums.length];

        int prefixProd[] = new int[nums.length];
        int suffixProd[] = new int[nums.length];

        prefixProd[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            prefixProd[i] = prefixProd[i-1] * nums[i];

        suffixProd[nums.length-1] = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--)
            suffixProd[i] = suffixProd[i+1] * nums[i];

        for(int i = 0; i < nums.length; i++) 
            if (i-1 < 0)
                answer[i] = 1 * suffixProd[i+1];
            else if (i+1 >= nums.length)
                answer[i] = prefixProd[i-1] * 1;
            else
                answer[i] = prefixProd[i-1] * suffixProd[i+1];

        return answer;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int accumulator = 1;
        
        // accumulator is the prefix product till i: 
        // i = 0 -> accumulator = nums[0]
        // i = 1 -> accumulator = accumulator * nums[1]
        // ...
        // the main insight is to sse that using accumulator we are giving to 
        // answer[i] the prefix product before i: 
        // answer[i] = accumulator (that is the prefix product accumulated before, till i-1 )

        for(int i = 0; i < nums.length; i++){
            answer[i] = accumulator; 
            accumulator = accumulator * nums[i];
        }
        
        // same as before but with the prefix sum from the right to the left
        accumulator = 1;
        for(int i = nums.length-1; i >= 0; i--){
            // answer[i] now is the prefix product left to right until i-1
            // accumulator is the prefix product right to left until i+1
            // multiplicating them gives the result
            answer[i] = answer[i] * accumulator;
            accumulator = accumulator * nums[i];
        }
        
        return answer;
    }
}
