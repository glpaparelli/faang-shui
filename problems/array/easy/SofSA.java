package problems.array.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * LEETCODE 977: Squares of a Sorted Array
 * Given an integer array "nums" sorted in non-decreasing order, return
 * the array of the squares of each number sorted in non decreasing order. 
 * 
 * SOLUTIONS: 
 * - Time Optimal Solution: O(n) time & space.
 *   Store the square of negatives numbers and positive numbers separately maintaining 
 *   the non-decreasing order. Then merge the lists by comparing the first elements of
 *   the postives (squared) and negative (squared)
 *   NOTE: I went out of my way to not reverse the negatives using Collections.reverse, 
 *         otherwise it were way easier (and asympotically identical)
 * 
 * - Optimal solution: O(n) time, O(1) space
 *   Two pointer, smart exploitation of the sortedness. check comments
 * 
 */
public class SofSA {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSqaures(new int[] { -4, -1, 0, 3, 10 })));
        System.out.println(Arrays.toString(sortedSqaures(new int[] { -7, -3, 2, 3, 11 })));
        System.out.println(Arrays.toString(sortedSqaures(new int[] { -7, -3, -1, 2, 3, 11 })));
        System.out.println(Arrays.toString(sortedSqaures(new int[] { -7, -3, -1 })));
        System.out.println(Arrays.toString(sortedSqaures(new int[] { -1 })));
    }

    public static int[] listSortedSqaures(int[] nums) {
        // store the square of all positives
        List<Integer> positives = new ArrayList<>();
        // store the square of all negatives
        List<Integer> negatives = new ArrayList<>();

        int res[] = new int[nums.length];

        // find the index of the first positive element in nums
        int firstPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                firstPos = i;
                break;
            }
        }

        // if all negatives (no positive is found)
        // just square the elements inserting them backwards (smallest a negative
        // biggest its square)
        if (firstPos == -1) {
            int insertHere = 0;
            for (int i = nums.length - 1; i >= 0; i--)
                res[insertHere++] = square(nums[i]);

            return res;
        }

        // if all positives (the first num in nums is >= 0)
        // just square the elements
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++)
                res[i] = square(nums[i]);

            return res;
        }

        // we have both positive and negatives

        // add to negatives the sorted square of negatives numbers going through them
        // in reverse order. (squaring non decreasing negatives give decreasing numbers)
        for (int i = firstPos - 1; i >= 0; i--)
            negatives.add(square(nums[i]));

        // add to positives the sorted square of positive numbers
        for (int i = firstPos; i < nums.length; i++)
            positives.add(square(nums[i]));

        // now we merge
        int left = 0;
        int right = 0;
        int insertHere = 0;

        // compare the head of the lists
        while (left < negatives.size() && right < positives.size()) {
            if (negatives.get(left) <= positives.get(right)) {
                res[insertHere] = negatives.get(left);
                left++;
            } else {
                res[insertHere] = positives.get(right);
                right++;
            }
            insertHere++;
        }
        // flush the remaining elements
        while (left < negatives.size()) {
            res[insertHere] = negatives.get(left);
            left++;
            insertHere++;
        }
        while (right < positives.size()) {
            res[insertHere] = positives.get(right);
            right++;
            insertHere++;
        }

        return res;
    }

    public static int square(int x) {
        return x * x;
    }

    public static int[] sortedSqaures(int[] nums) {
        int[] res = new int[nums.length];

        int start = 0, end = nums.length - 1;

        // we start from the end to inserting in res, meaning we insert the biggest as the 
        // last element, then the second biggest as the second last, ... arriving at the start.
        int resIndex = nums.length - 1;

        // basically we compare the first element (nums[start]) (the smallest number (often negative))
        // and the last element (nums[end]) (the biggest number, (often positive)). 
        // this works because the biggest squared is given by the comparison of the biggest positve
        // and the smallest negative. 
        while (start <= end) {
            int squareStart = square(nums[start]);
            int squareEnd = square(nums[end]);

            // the square of the smallest negative is bigger than the squared of the biggest positive
            if (squareStart > squareEnd) {
                // insert at the end of the result the biggest square
                res[resIndex] = squareStart;
                // move start to the left (increase the smallest element pointer)
                start++;
            } else {
                // analogous as above 
                res[resIndex] = squareEnd;
                end--;
            }
            resIndex--;
        }

        return res;
    }
}
