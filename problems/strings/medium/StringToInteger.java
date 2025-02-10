package problems.strings.medium;
/*
 * LEETCODE 8: String To Integer (atoi)
 * Implement the myAtoi(string s) function, which converts a string 
 * to a 32-bit signed integer.
 * 
 * The algorithm for myAtoi(string s) is as follows:
 * - Whitespace: Ignore any leading whitespace (" ").
 * - Signedness: Determine the sign by checking if the next character 
 *   is '-' or '+', assuming positivity if neither present.
 * - Conversion: Read the integer by skipping leading zeros 
 *   until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * - Rounding: If the integer is out of the 32-bit signed integer range
 *   [-231, 231 - 1], then round the integer to remain in the range. 
 *   Specifically, integers less than -231 should be rounded to -231, 
 *   and integers greater than 231 - 1 should be rounded to 231 - 1.
 * 
 * Return the integer as the final result.
 * 
 * SOLUTION:
 * check the comments
 */
public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 4"));
        System.out.println(myAtoi("-3292c23"));
        System.out.println(myAtoi("   32"));
    }

    public static int myAtoi(String s) {
        // if the string is blank or empty return 0
        if (s.isEmpty() || s.isBlank())
            return 0;

        // remove all leading whitespaces
        s = s.trim();

        int start = 0; // start of the "number"
        int end = 0; // end of the number
        int sign = 1;

        if (s.charAt(end) == '-') {
            sign = -1;
            start++;
            end++;
        } else if (s.charAt(end) == '+') {
            start++;
            end++;
        }

        // move "end" until you find a non digit
        while (end < s.length() && Character.isDigit(s.charAt(end)))
            end++;
        
        // isolate the digits in the string
        s = s.substring(start, end);

        // we might have not moved end at all (e.g. s = "ciao")
        // and therefore s is empty
        if (s.isEmpty())
            return 0;

        // try to parse 
        int result; 
        try {
            result = Integer.parseInt(s);
        } catch (Exception e) {
            // this is a NumberFormatException, which in this case 
            // is thrown only if the string is too big for an integer
            if (sign == 1)
                return Integer.MAX_VALUE;
            return Integer.MIN_VALUE;
        }

        return sign * result;
    }
}
