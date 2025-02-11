package problems.strings.medium;
import java.util.ArrayList;
import java.util.List;
/*
 * Leetcode 271: Encode and Decode String
 * Design an algorithm to encode a list of strings to a single string. 
 * The encoded string is then decoded back to the original list of strings.
 * 
 * Please implement encode and decode. 
 * 
 * SOLUTION: 
 * dumb exercise (you can always make an example that break my solution or 
 * the provided solution, UTF-8 are all "classic" chars)
 */
public class EncodeAndDecode {
    public static void main(String[] args) {
        String encoded1 = encode(List.of("neet","code","love","you"));
        System.out.println("encoded: " + encoded1);
        System.out.println("decoded: " + decode(encoded1));

        System.out.println();

        String encoded2 = encode(List.of("we","say",":","yes"));
        System.out.println("encoded: " + encoded2);
        System.out.println("decoded: " + decode(encoded2));        
    }   

    public static String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String s : strs) {
            encoded.append(s.length());
            encoded.append("#"); 
            encoded.append(s);
        }

        return encoded.toString();
    }

    public static List<String> decode(String s) {
        List<String> strs = new ArrayList<>();

        int pointer = 0;

        while (pointer < s.length()) {
            int length = Character.getNumericValue(s.charAt(pointer));
            pointer = pointer +  2;
            strs.add(s.substring(pointer, pointer + length));
            pointer = pointer + length + 1;
        }

        return strs;
    }
}
