package problems.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LEETCODE 435: Non Overlapping Intervals
 * Given an array of intervals "intervals" where intervals[i] = [start_i, end_i], 
 * return the minimum number of intervals you need to remove to make the rest 
 * of the intervals non-overlapping. 
 * 
 * Note that intervals which only touch at a point are non-overlapping. 
 * For example, [1,2] and [2,3] are non-overlapping. 
 * 
 * SOLUTIONS: 
 * - Time Optimal Solution: O(nlog(n)) time and O(n) space
 *   We use a greedy approach. We sort the intervals by their ending time. 
 *   We then create a list and insert in it the first interval. 
 *   Then we go through the rest of the intervals with i = 1. 
 *   Take the last inserted interaval in the list. If it overlaps with 
 *   the current one skip the current interval and increment a counter, 
 *   otherwise insert it in the list. 
 *   Return the counter. 
 * 
 * - Optimal Solution: O(nlog(n)) time and O(1) space. We use two pointer and a 
 *   sliding window approach. 
 *   We sort the intervals by their ending time. Then we start with left = 0 and 
 *   right = 1. We also store "lastEnd" that is the ending time of the last interval
 *   that we selected (it starts with the first interval ending time). 
 *   Now we iterate until right is less than intervals.length. 
 *   If the current interval starts before lastEnd we have an overlap. 
 *   We move right of 1 place to the left and increment the counter.
 *   Otherwise we set left = right and right++, this shifts the window and assures 
 *   that each interval is inspected at most once. 
 *   We return the counter.
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] input1 = new int[][]{{1,2}, {2,3}, {3,4}, {1,4}};
        System.out.println(eraseOverlaps(input1));

        int[][]  input2 = new int[][]{{1,2}, {1,2}, {1,2}};
        System.out.println(eraseOverlaps(input2));

        int[][]  input3 = new int[][]{{1,2}, {2,3}};
        System.out.println(eraseOverlaps(input3));
    }

    public static int listEraseOverlaps(int[][] intervals) {
        List<int[]> tmp = new ArrayList<>();

        int start = 0; 
        int end = 1;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[end], i2[end]));

        tmp.add(intervals[0]);
        int counter = 0;

        for (int i = 1; i < intervals.length; i++) 
            if (tmp.getLast()[end] > intervals[i][start]) 
                counter ++;
             else 
                tmp.add(intervals[i]);
        

        return counter;
    }

    public static int eraseOverlaps(int[][] intervals) {
        int counter = 0;
        int start = 0; 
        int end = 1;

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[end], i2[end]));

        int left = 0; 
        int right = 1;
        int lastEnd = intervals[0][end];

        while (right < intervals.length) 
            // we have an overlaps, we "skip" this interval and count it
            if (lastEnd > intervals[right][start]) {
                right++; 
                counter++;
            } else {
                // not overlapping, we move on
                lastEnd = intervals[right][end];
                left = right; 
                right = left + 1;
            }
        
        return counter;
    }
}
