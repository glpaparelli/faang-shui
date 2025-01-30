package problems.strings.easy;
/*
 * LEETCODE 125: Valid Palindrome
 * A phrase is palindrome if, after coverting all uppercase into lowercase
 * letters and removing all non-alphanumeric characters, it reads the same
 * forward and backward. 
 * 
 * Alphanumeric characters include letters and numbers. 
 * 
 * Given a string "s", return true if it is a palindrome, or false otherwise
 * 
 * SOLUTION: 
 * Remove all non-alphanumeric chars and convert all to lower case. 
 * Then use two pointers, one at the start and one at the end of the string. 
 * If the chars at those pointers do not match return false, otherwise
 * increase "start" and decrease "end" by one. 
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(""));
    }

    public static boolean isPalindrome(String s){
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        int sLen = s.length();
        int start = 0; 
        int end = sLen - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}
