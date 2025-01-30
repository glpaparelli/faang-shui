package problems.strings.easy;
import java.util.HashMap;
import java.util.Map;
/*
 * LEETCODE 242: Valid Anagram
 * Given two strings "s" and "t", return true if t is an anagram 
 * of s, and false otherwise.
 * 
 * Solution: 
 * Use a map to map chars of the first string to how many times they 
 * appear in the first string. 
 * Then iterate through the chars of the second string: if a char is not 
 * found or if its occurrence is 0 return false, otherwise decrease
 * its occurrence by one.
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("aacc", "ccac"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> charToOcc = new HashMap<>();

        for (char c : s.toCharArray()) 
            charToOcc.put(c, charToOcc.getOrDefault(c, 0) + 1);
        
        for (char c : t.toCharArray()) {
            Integer cOcc = charToOcc.get(c);
            if (cOcc == null || cOcc == 0)
                return false; 
            charToOcc.put(c, cOcc-1);
        }

        return true;
    }
}
