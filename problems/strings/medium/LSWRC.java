package problems.strings.medium;
import java.util.HashSet;
import java.util.Set;
/*
 * LEETCODE 3: Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring 
 * without repeating characters.
 * 
 * SOLUTION:
 * sliding window solution, check the comments
 */
public class LSWRC {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        // set that contains the cars in the current window
        Set<Character> wChars = new HashSet<>();
        int maxLen = 1;
        // extremes of the window
        int left = 0; 
        int right = 1;

        // the first char starts in the window
        wChars.add(s.charAt(left));

        while (right < s.length()) {
            // if the current char of the string is not in 
            // already in the window
            if (wChars.contains(s.charAt(right)) == false) {
                // we add the char to the window
                wChars.add(s.charAt(right));
                // shift the window to the right
                right++;
            } else {
                // the char already appear in the window, 
                // we shrink the window from the left, we remove 
                // the char and move left to left+1
                wChars.remove(s.charAt(left));
                left++;
            }

            // every time update the window and every time we update
            // the max if needed
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
