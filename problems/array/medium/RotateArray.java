package problems.array.medium;

import java.util.Arrays;

/*
 * LEETCODE 189: Rotate Array
 * Given an array "nums", rotate the array to the right by "kBackup" steps, 
 * where kBackup is non-negative. 
 * 
 * Example: 
 * Input: nums = [1,2,3,4,5,6,7], kBackup = 3
 * Output: [5,6,7,1,2,3,4]
 * 
 * SOLUTION: 
 * - Optimal Solution: O(n) time and O(1) space. 
 *      - You start with: 
 *                [1,2,3,4,5,6,7]
 *      - reverse the whole array
 *                [7,6,5,4,3,2,1]
 *      - reverse from 0 to k-1
 *                [5,6,7,4,3,2,1]
 *      - reverse from k to n-1
 *                [5,6,7,1,2,3,4]
 *      - return
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] input1 = new int[]{-1};
        System.out.println("nums before rotation: " + Arrays.toString(input1));
        rotate(input1, 2);    
        System.out.println("nums after rotation: " + Arrays.toString(input1));
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length; 
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
     private static void reverse(int[] nums, int i, int j){
        int tmp = 0;       
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
