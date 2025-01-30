package problems.strings.easy;
/*
 * LEETCODE 58: Length of Last Word
 * Given a string s consisting of words and spaces, return the length 
 * of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
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
