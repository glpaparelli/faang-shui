package problems.strings.medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * LEETCODE 49: Group Anagrams
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * 
 * SOLUTION: 
 * check the comments
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> result1 = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(result1);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        // map occurrences array to the corresponding strings
        Map<String, List<String>> occurrencesToStrings = new HashMap<>();
        
        // iterate through all strings
        for (String s : strs) {
            // compute the occurrence of each char of s in the occurrences array
            int[] sOccurrences = computeOccurrences(s);
            // put a new List if this occurrence array has never been seen before
            occurrencesToStrings.putIfAbsent(String.valueOf(sOccurrences), new ArrayList<>());
            // get the list corresponding to this array and add s (s is an anagram of the 
            // strings with this sOccurrences array)
            occurrencesToStrings.get(String.valueOf(sOccurrences)).add(s);
        }

        // return a list made of the values of the map (lists)
        return new ArrayList<>(occurrencesToStrings.values());
    }

    private static int[] computeOccurrences(String s) {
        int[] occurrences = new int[26];

        for (char c : s.toCharArray()) 
            occurrences[c - 'a']++;

        return occurrences;
    }
}
