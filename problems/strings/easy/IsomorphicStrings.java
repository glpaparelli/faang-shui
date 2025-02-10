package problems.strings.easy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * LEETCODE 205: Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings s and t are isomorphic if the characters 
 * in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another 
 * character while preserving the order of characters. 
 * No two characters may map to the same character, 
 * but a character may map to itself.
 * 
 * Example
 *  - input: s = "egg", t = "add"
 *  - output: true
 *  - explaination: s and t can be made identical by mapping 'g' to 'd'
 *    and 'e' to 'a'
 * 
 * SOLUTION: 
 * read the comments.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> mappedChars = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // if sChar is mapped but it is not associated with 
            // tChar then the strings are not isomorphic
            if (mapping.containsKey(sChar) && mapping.get(sChar) != tChar)
                return false;

            // if sChar is not mapped yet but tChar is already 
            // mapped with something else then the strings are not isom
            if (!mapping.containsKey(sChar) && mappedChars.contains(tChar))
                return false;

            mapping.put(sChar, tChar);
            mappedChars.add(tChar);
        }

        return true;
    }
}
