package problems.array.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * You are given an array of non-overlapping intervals where 
 * intervals[pointer] = [start, end] represent the start and the end of the 
 * pointer-th interval, and intervals is sorted in ascending order by start. 
 * You are also given an interval newInterval = [start, end].
 * 
 * Insert newInterval in intervals such that intervals is still sorted 
 * in ascending order by start_i, and intervals still does not have any 
 * overlapping intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion. 
 * 
 * Note that you do not need to modify intervals in place: you can make
 * a new array and return it. 
 * 
 * SOLUTIONS: 
 *   - Optimal Solution: O(n) time, O(1) space. 
 *   Create a working list to insert first the non overlapping intervals, 
 *   then compute interval handling overlappings and add it to the list, 
 *   then finish by adding to the list the non-overlapping remaining intervals. 
 *   The key insight is that this is done with a single pass by using whiles and 
 *   a pointer: 
 *   1) pointer starts at zero
 *   2) after the first loop pointer is where "we must insert"
 *   3) we compute the merged interval moving pointer and checking the endpoints
 *   4) we add the new merged interval to the list (KEY POINT of USING LISTS)
 *   5) now pointer points to the first interval that did not cause an overlappings 
 *   6) we add all those intervals to the list 
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals1 = {{1,3}, {6,9}}; 
        int[] newInterval1 = {2,5};

        int[][] output1 = insert(intervals1, newInterval1);
        System.out.print("[ "); 
        for(int[] interval : output1) {
            System.out.print(Arrays.toString(interval) + " ");
        }
        System.out.println("]"); 
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> tmp = new ArrayList<>();
        int pointer = 0; 

        int start = 0; 
        int end = 1; 

        // insert in tmp all the intervals that do not overlap with the new one
        while (pointer < intervals.length && intervals[pointer][end] < newInterval[start]) {
            tmp.add(new int[]{intervals[pointer][start], intervals[pointer][end]});
            pointer++;
        } 

        // now we merge: while we have intervals and we overlap we compute the new 
        // merged interval (overwriting newInterval: it becomes the new merged interval)
        while (pointer < intervals.length && intervals[pointer][start] <= newInterval[end]) {
            newInterval[start] = Math.min(intervals[pointer][start], newInterval[start]);
            newInterval[end] = Math.max(intervals[pointer][end], newInterval[end]);
            pointer++;
        }
        // once computer we add the new merged interval
        tmp.add(newInterval);

        // pointer now points just after the new inserted merged intervals, 
        // we just add the intervals that did not cause overlappings with the new interval
        while (pointer < intervals.length) {
            tmp.add(new int[]{intervals[pointer][start], intervals[pointer][end]});
            pointer++;
        }

        // convert tmp to an array and return it
        int[][] res = new int[tmp.size()][2];
        for (int i = 0; i < res.length; i++) 
            res[i] = tmp.get(i);
        
        return res;
    }
}
