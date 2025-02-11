package problems.strings.medium;
/*
 * LEETCODE 424: Longest Repeating Character Replacement
 * You are given a string s and an integer k. 
 * You can choose any character of the string and change 
 * it to any other uppercase English character. 
 * You can perform this operation at most k times.
 * 
 * Return the length of the longest substring containing 
 * the same letter you can get after performing the above operations.
 * 
 * SOLUTION: 
 * tricky sliding window, check the comments. 
 * 
 * NOTE: the assumption "take the most frequent char" and add k (or at most k)
 * is not going to help because it do not necessarily lead to the correct answer
 */
public class LRCR {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ababbacabb", 4));
        System.out.println(characterReplacement("abab", 2));
        System.out.println(characterReplacement("AAABBBA", 1));
    }

    // my sliding window attemp, kinda good but wrong
    public static int swCharReplacement(String s, int k) {
        int maxLen = 0;

        int left = 0; 
        int right = 0; 
        int kTmp;

        // simple idea: 
        // window: left and right. 
        // expand right until s[left] == s[right] or if we have 
        // k != 0 (available replacement). 
        // update the max if needed, move left to the right and 
        // put right equal left, then restart. 
        // the window expand and then shrinks
        while (left < s.length()) {
            kTmp = k;
            right = left;
            while (right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) 
                    right++;
                else {
                    if (kTmp == 0)
                        break;

                    right++; 
                    kTmp--;
                }
            }
            
            maxLen = Math.max(maxLen, right - left);
            left++;
        }

        return maxLen;
    }

    // real sliding window
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int left = 0, right = 0, replaced = 0;

            while (right < s.length()) {

                if (s.charAt(right) == c) 
                    right++;
                else if (replaced < k) {
                    right++;
                    replaced++;
                // shrink the window from the left, 
                // this means that for each char we consider every possible substring
                // by considering every possible window
                } else if (s.charAt(left) == c) 
                    left++;
                else {
                    left++;
                    replaced--;
                }

                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen;
    }
}
