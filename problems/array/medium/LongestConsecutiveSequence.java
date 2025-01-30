package problems.array.medium;

import java.util.HashSet;
import java.util.Set;

/*
 * LEETCODE 128: Longest Consecutive Sequence
 * Given an unsorted array of integers "nums", return the length 
 * of the longest consecutive elements sequence. 
 * 
 * You must write an algorithm that runs in O(n) time.
 * 
 * SOLUTION: 
 * read the comments
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestSequence(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestSequence(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestSequence(int[] nums) {
        // insert the numbers in a set
        Set<Integer> numbers = new HashSet<>();
        for(int i : nums)
            numbers.add(i);

        int maxLength = 0;
        int currentNum;
        int currentLength;
        
        // iterate the numbers
        for (int num : numbers) {
            // if in the set we have the predecessor of num we skip the iteration, 
            // we consider the "first" element of the sequence to compute the length
            if (numbers.contains(num-1))
                continue;

            // currentNum is the start of the sequence we consider
            currentNum = num;
            // sequence of 1 element, length = 1
            currentLength = 1;
        
            // while we have the consecutive number of current number we 
            // update current number and increase the length found so far
            while (numbers.contains(currentNum+1)) {
                currentNum++; 
                currentLength++;
            }

            // update maxLength
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
