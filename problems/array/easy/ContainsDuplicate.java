package problems.array.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * LEETCODE 217: Contains Duplicate
 * Given an array "nums" return true if any value appears at least twice
 * in the array, and return false if every element is distinct. 
 * 
 * SOLUTIONS: 
 * - trivial solution: O(n^2), two nested loops
 * 
 * - less trivial solution: sort the array and check
 * 
 * - time optimal solution: O(n) time and space, map: element -> occurrences of element
 * 
 * - better time optimal solution: O(n) time and space, use a set. 
 *   This is better: 1) checking presence, sets are better 2) better performance
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) 
            if (set.contains(n))
                return true;
            else 
                set.add(n);

        return false;
    }
}
