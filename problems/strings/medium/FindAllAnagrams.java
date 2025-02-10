package problems.strings.medium;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * LEETCODE 438: Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's 
 * anagrams in s. You may return the answer in any order.
 * 
 * SOLUTION: 
 * check the comments
 */
public class FindAllAnagrams {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length())
            return result;

        int pOccurrences[] = new int[26];
        for (char c : p.toCharArray())
            pOccurrences[c - 'a']++;

        // we use a sliding window: the window contains 
        // the occurrences of each char in the window
        int sWindow[] = new int[26];
        // the first window is [0, p.length()-1]
        int start = 0;
        int end = p.length()-1;
        // fill the first window with the occurrences
        //  of the chars in the window
        for (int i = start; i <= end; i++) 
            sWindow[s.charAt(i) - 'a']++;
        
        // if the occurrences in the window are the same 
        // as pOccurence then we have found an anagram and save the start 
        // of the window
        if (Arrays.equals(sWindow, pOccurrences))
            result.add(start);

        while (end < s.length()-1) {
            // the window shift to the right, the left most element exit the window
            sWindow[s.charAt(start) - 'a']--;
            // shift
            start++; end++;
            // a new element is added as the rightmost element of the window
            sWindow[s.charAt(end) - 'a']++;
            
            // if the window has the same occurrences 
            // as pOccurrence we have an anagram
            if (Arrays.equals(sWindow, pOccurrences))
                result.add(start);
        }

        return result;  
    }
}
