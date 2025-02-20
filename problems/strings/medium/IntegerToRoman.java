package problems.strings.medium;
// import java.util.HashMap;
// import java.util.Map;

/*
 * LEETCODE 12: Integer to Roman
 * Given an integer, convert it to a Roman numeral.
 */
public class IntegerToRoman {
    public static void main(String[] args) {
        intToRoman(41);
        // TODO
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();

        // Map<Integer, Character> map = new HashMap<>();

        // map.put(1000, 'M');
        // map.put(500, 'D'); 
        // map.put(100, 'C');
        // map.put(50, 'L');
        // map.put(10, 'X');
        // map.put(5, 'V');
        // map.put(1, 'I');

        // String sNum = Integer.toString(num);

        // int expo = sNum.length() - 1; 

        // for (int i = 0; i < sNum.length(); i++) {

        //     char currentChar = sNum.charAt(i); 

        //     if (currentChar != 4 && currentChar != 9) {
        //         int curr = (int) (Character.getNumericValue(sNum.charAt(i)) * Math.pow(10, expo));

                
        //     }

        // }

        return sb.toString();
    }
}
