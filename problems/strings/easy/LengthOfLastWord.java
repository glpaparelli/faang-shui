package problems.strings.easy;
/*
 * LEETCODE 58: Length of Last Word
 * Given a string s consisting of words and spaces, return the length 
 * of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * SOLUTION: 
 * Its trivial: find the first the index of the first char != 0 
 * starting from the end of the string. 
 * 
 * Then start from the index and go backwards: every char != 0 is 
 * part of the last word, hence increase length by 1. 
 * When you find a " " you exit and return length.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));

    }

    public static int lengthOfLastWord(String s) {
        int length = 0;
        int lastCharIndex = -1;

        for (int i = s.length()-1; i >= 0; i--)
            if (s.charAt(i) != ' ') {
                lastCharIndex = i;
                break;
            }
            
        for (int i = lastCharIndex; i >= 0; i--) 
            if (s.charAt(i) != ' ')
                length++;
            else 
                break;
        
        return length; 
    }
}
