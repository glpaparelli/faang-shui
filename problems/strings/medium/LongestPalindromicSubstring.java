package problems.strings.medium;
/*
 * LEETCODE 5: Longest Palindromic Substring
 * Given a string s, return the longest  palindromic substring in s.
 * 
 * SOLUTION: O(n^2)
 * check the comments
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        
    }

    public static String longestPalindrome(String s) {
        if(s.isEmpty())
            return null;
        if(s.length() == 1)
            return s; 
    
        String longest = s.substring(0, 0);

        // for each character we start there and go left and right to see if it is the center
        // of a palindrome substring
        for (int i = 0; i < s.length(); i++) {
            String oddPal = palExpandFromCenterAt(s, i, i);
            String evenPal = palExpandFromCenterAt(s, i, i+1);
            longest = longestOfThreeString(longest, oddPal, evenPal);
        }

        return longest;
    }

    // return the longest string between the three passed strings
    private static String longestOfThreeString(String s1, String s2, String s3) {
        String longest = s1; 
        if (s2.length() > longest.length())
            longest = s2;
        if (s3.length() > longest.length())
            longest = s3;
        
        return longest;
    }

    // starting from a center (or two centers) we go left and right until we find equal 
    // chars, until we are a palindrome
    private static String palExpandFromCenterAt(String s, int leftC, int rightC){
        while (leftC >= 0 && rightC <= s.length() - 1 && s.charAt(leftC) == s.charAt(rightC)) {
            leftC--; 
            rightC++;
        }

        return s.substring(leftC+1, rightC);
    }      
}
