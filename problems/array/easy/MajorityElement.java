package problems.array.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * LEETCODE 169: Majority Element
 * Given an array "nums" of size n, return the majority element. 
 * The majority element is the element that appears more than n/2 times. 
 * You may assume that the majiority element always exists.
 * 
 * SOLUTIONS: 
 * - Trivial Solution: O(n^2), two nested loops
 * 
 * - Less Trivial Solution: O(nlog(n)), sort the array and then count
 * 
 * - Time Optimal Solution: O(n) time and space, use a map: element -> occurrences of element
 * 
 * - Optimal Solution: O(n) time, O(1) space, Moore Voting Algorithm
 */
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    // map solution, easy
    public static int mapMajorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int occurrence;
        for (int num : nums) {
            occurrence = map.getOrDefault(num, 0) + 1;
            map.put(num, occurrence);

            if (occurrence > nums.length/2)
                return num;
        }

        return 0;
    }

    // moore voting algorithm, check notes
    public static int majorityElement(int[] nums) {
        int element = nums[0];
        int counter = 1;

        for (int i = 1; i < nums.length; i++) {
            if (counter == 0) {
                element = nums[i];
                counter = 1;
            } else if (element == nums[i])
                counter++;
            else 
                counter--;

        }

        return element;
    }
}
