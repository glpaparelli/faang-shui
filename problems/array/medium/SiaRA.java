package problems.array.medium;
/*
 * LEETCODE 33: Search in a Rotated Array
 * There is an integer array "nums" sorted in ascending order 
 * with distinct values. 
 * 
 * Prior to being passed to your function, nums is possibly rotated 
 * at an unknown index k (1 <= k <= nums.length) such that the
 * resulting array is 
 * [nums[k], nums[k+1], .., nums[n-1], nums[0], nums[1], ..., nums[k--1]]. 
 * 
 * Given the array nums after the possible rotation and an integer 
 * target, return the index of target if it is in nums, or -1 otherwise. 
 * 
 * The algorithm must have O(log(n)) time complexity.
 * 
 * SOLUTION: 
 * slightly modify BS exploiting the fact that the array is sorted 
 * and that the "partitions" obtained by the rotation are sorted
 */
public class SiaRA {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 3));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int middle;

        while (left <= right) {
            middle = left + (right - left)/2;

            if (nums[middle] == target)
                return middle;

            if (nums[left] > nums[middle])
                //       l     m t   r 
                // nums: 6 7 1 2 3 4 5
                // i   : 0 1 2 3 4 5 6
                if (nums[middle] > target || nums[left] <= target)
                    right = middle -1; 
                else
                    left = middle +1;
            else
                //       l t    m    r
                // nums: 2,3,4,5,6,0,1
                // i:    0,1,2,3,4,5,6
                if (nums[middle] < target || nums[left] > target)
                    left = middle +1;
                else
                    right = middle -1;
        }
        
        return -1;
    }    
}
