package problems.strings.medium;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
/*
 * LEETCODE 179: Largest Number
 * Given a list of non-negative integers nums, arrange them such that
 * they form the largest number and return it.
 * 
 * Since the result may be very large, so you need to return
 *  a string instead of an integer.
 * 
 * SOLUTION: 
 * check the comments
 */
public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{10,2}));
        System.out.println(largestNumber(new int[]{7,21,1,9}));
        System.out.println(largestNumber(new int[]{123,312}));
    }

    public static String largestNumber(int[] nums) {
        // we want to exploit lexicographical order, convert the
        // input array to an array of strings
        String[] sNums = new String[nums.length];
        for (int i = 0; i < sNums.length; i++)
            sNums[i] = Integer.toString(nums[i]);

        // sort the array using the custom comparator that 
        // put the string in an order that maximize the result
        Arrays.sort(sNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                // a.compareTo(b)
                // <0, a va prima
                // =0, sono uguali
                // >0, b va prima
                return order2.compareTo(order1);
            }
        });

        // if the sorted array starts with a 0 it means that 
        // the max number is 0
        if (sNums[0].equals("0"))
            return "0";

        // otsherwise return the concatenation of the array
        return Arrays.stream(sNums).collect(Collectors.joining());
    }
}
