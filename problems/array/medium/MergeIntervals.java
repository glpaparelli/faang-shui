package problems.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * LEETCODE 56: Merge Intervals
 * Given an array "intervals" where intervals[nextInterval] = [start_i, end_i], 
 * mergeUsingList all overlapping intervals and return an array of non-overlapping
 * intervals that cover all the intervals in the input.
 * 
 * SOLUTIONS: check the comments
 * - Optimal Time Solution: O(n) time & space. 
 * - Optimal Solution: O(n) time and O(1) space.
 *   
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] input1 = {{1,3}, {2,6}, {8,10}, {15, 18}};
        int[][] output1 = merge(input1);
        Arrays.stream(output1).forEach(nextInterval -> System.out.println(Arrays.toString(nextInterval)));

        int[][] input2 = {{1,4}, {4,5}};
        int[][] output2 = merge(input2);
        Arrays.stream(output2).forEach(nextInterval -> System.out.println(Arrays.toString(nextInterval)));
    }

    // O(n) time & space
    public static int[][] mergeUsingList(int[][] intervals) {
        List<int[]> tmp = new ArrayList<>();
        int start = 0; 
        int end = 1;

        // sort intervals by their starting time
        Arrays.sort(intervals,  (i1, i2) -> Integer.compare(i1[start], i2[start]));

        int lastEnd = intervals[0][end]; // starts with the end of the first interval
        int currentInterval = 0;
        int nextInterval = 1;

        while (nextInterval < intervals.length) {
            // if the end of the last selected interval is greater 
            // than the starts of the next one we have an overlapping
            if (lastEnd >= intervals[nextInterval][start]) {
                // merge the intervals by selecting the biggest end time 
                lastEnd = Math.max(lastEnd, intervals[nextInterval][end]);
                // consider the next next interval (that might still be merged with the current (merged) one)
                nextInterval++;
            }
            else {
                // we add the current (merged) interval
                tmp.add(new int[]{intervals[currentInterval][start], lastEnd});
                // now we consider the next interval (that might be merged with the following ones)
                currentInterval = nextInterval; 
                // update lastEnd to consider the ending of the latest interval in consideration (currentInterval)
                lastEnd = intervals[currentInterval][end];
                nextInterval = currentInterval+1;
            }
        }
        // lastInterval < intervals.length: one left to consider
        // we either add the merged interval resulting from the last and second last (if they overlapped)
        // or we add the last interval if it did not overlaps with the second last
        tmp.add(new int[]{intervals[currentInterval][start], lastEnd});

        int[][] result = tmp.toArray(new int[tmp.size()][0]);
        return result;
    }

    // O(n) time and O(1) space
    public static int[][] merge(int[][] intervals) { 
        int start = 0; 
        int end = 1;

        // sort by starting time
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[start], i2[start]));

        // currentInterval points to the interval that might be merged with the following ones that overlap with it. 
        // the intervals before currentInterval have already been merged and they are not overlapping (anymore)
        int currentInterval = 0;

        for (int nextInterval = 1; nextInterval < intervals.length; nextInterval++) {
            // we have an overlapping
            if (intervals[currentInterval][end] >= intervals[nextInterval][start]) 
                // we modify the current interval ending point with the biggest ending point: we merge
                intervals[currentInterval][end] = Math.max(intervals[currentInterval][end], intervals[nextInterval][end]);
            // no overlapping
            else {
                // we move currentInterval to the right
                currentInterval++;
                // we "transplant" the next interval to currentInterval: it will be this to be considered now
                intervals[currentInterval] = intervals[nextInterval];
                // nextInterval will be incremented by the for
            }
        }

        // 0 to currentInterval + 1: we merge "backwards", from 0 to currentInterval 
        // we have merged, +1 is the last  interval 
        return Arrays.copyOfRange(intervals, 0, currentInterval + 1);
    }   
}
