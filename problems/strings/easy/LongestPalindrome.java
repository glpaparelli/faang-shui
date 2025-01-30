package problems.strings.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * LEETCODE 409: Longest Palindrome
 * Given a string "s" consisting of lowercase or uppercase letters, 
 * return the length of the longest palindrome that can be built with
 * those letters. 
 * 
 * Letters are case sensitive, for example "Aa" is not considered 
 * a palindrome.
 * 
 * SOLUTION: 
 * You build a map: char c -> occurrences of c
 * Then you get a variable "evenChars" and "mostOdd". 
 * The chars that appear an even number of times can always be used. 
 * The chars that appear an odd number of times: 
 *    1) if it is the most frequent odd char then you use it every time, 
 *       you place it one in the middle and then of the edges
 *    2) if it is not the most frequent odd char than you use it 
 *       one time less than it appears
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> charToOcc = new HashMap<>();
        for (char c : s.toCharArray())
            charToOcc.put(c, charToOcc.getOrDefault(c, 0) + 1);

        // even chars used
        int evenChars = 0;
        // how many time occurs the most frequent "odd" char
        int mostOddChar = 0;  
        
        // iterate over the keySet (NOT THE CHARS, avoid considering
        // many times the same character)
        for (char c : charToOcc.keySet()) {
            int cOcc = charToOcc.get(c);

            // if appears even times: use it all of them 
            if (cOcc % 2 == 0)
                evenChars = evenChars + cOcc;
            else 
                // is the current char the new most frequent odd char?
                if (cOcc > mostOddChar) {
                    if (mostOddChar > 0)
                        // use the old most frequent one time less
                        evenChars = evenChars + mostOddChar - 1;
                    // update the most frequent
                    mostOddChar = cOcc;
                } else 
                    // use the odd char one time less
                    evenChars = evenChars + cOcc - 1;
        }
        // add evenChars and the most odd char    
        return evenChars + mostOddChar;
    }
}
