package problems.strings.easy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * LEETCODE 14: Longest Common Prefix
 * Write a function to find the longest common prefix amongst an 
 * array of strings. 
 * 
 * If there is no common prefix, return an empty string "".
 */
public class LCP {
    public static void main(String[] args) {
        
    }

    public static String longestCommonPrefix(String[] strs) {
        String shortestString = 
            Arrays
                .stream(strs)
                .min(
                    Comparator
                    .comparingInt(String::length))
                    .orElseThrow(() -> new IllegalArgumentException())
            ;
        
        int prefLength = 0;
        for (int i = 0; i < shortestString.length(); i++) {
            for (int j = 0; j < strs.length; j++) 
                if (shortestString.charAt(i) != strs[j].charAt(i))
                    return shortestString.substring(0, prefLength);

            prefLength++;
        }

        return shortestString.substring(0, prefLength);
    }
}
