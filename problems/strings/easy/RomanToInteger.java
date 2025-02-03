package problems.strings.easy;
import java.util.HashMap;
import java.util.Map;
/*
 * LEETCODE 13: Roman To Integer
 * Given a roman numeral, convert it to an integer.
 * 
 * SOLUTION: 
 * two solutions, identical but where the index starts. 
 * the key insight is to see that a subtraction only occurs 
 * if a smaller number is placed before a bigger number.
 */
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt1("III"));
        System.out.println(romanToInt1("LVIII"));
        System.out.println(romanToInt1("MCMXCIV"));
        System.out.println(romanToInt1("MDCXCV"));
    }

    public static int romanToInt1(String s) {
        Map<Character, Integer> c2v = new HashMap<>();
        c2v.put('I', 1);
        c2v.put('V', 5);
        c2v.put('X', 10);
        c2v.put('L', 50);
        c2v.put('C', 100);
        c2v.put('D', 500);
        c2v.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            // needed to avoid nextChar to go out of bound
            if (i == s.length()-1)
                // we are at the last char, no subtractions possible, we just add the last
                return sum + c2v.get(s.charAt(i));
                
            char currentChar = s.charAt(i);
            char nextChar = s.charAt(i+1);

            // the currentChar is smaller than the next, hence we have a subtraction
            if (c2v.get(currentChar) < c2v.get(nextChar)) {
                sum += c2v.get(nextChar) - c2v.get(currentChar);
                // we move i (and the for moves it again) as we used the current and 
                // the next char to make a single number.
                i++;
            }
            else 
                sum += c2v.get(currentChar);
        }
    
        return sum;
    }

    public static int romanToInt2(String s) {
        Map<Character, Integer> c2v = new HashMap<>();
        c2v.put('I', 1);
        c2v.put('V', 5);
        c2v.put('X', 10);
        c2v.put('L', 50);
        c2v.put('C', 100);
        c2v.put('D', 500);
        c2v.put('M', 1000);

        if (s.length() == 1)
            return c2v.get(s.charAt(0));

        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            char curChar = s.charAt(i);
            char prevChar = s.charAt(i-1);

            if (c2v.get(prevChar) < c2v.get(curChar)) {
                sum += c2v.get(curChar) - c2v.get(prevChar);
                i++;
            }
            else 
                sum += c2v.get(prevChar);

            if (i == s.length()-1)
                return sum + c2v.get(s.charAt(i));
        }
    
        return sum;
    }    
}
