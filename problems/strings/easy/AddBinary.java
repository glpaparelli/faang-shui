package problems.strings.easy;
/*
 * LEETCODE 67: Add Binary
 * Given two strings "a" and "b", return their sum as a binary string
 * 
 * SOLUTION: 
 * - myAddBinary
 *   Use string builder and check case by case
 * - addBinary
 *   Use String builder and add stuff
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("1011", "1010101"));
    }

    public static String myAddBinary(String a, String b) {
        // aPointer want the first string as the shortest one
        if (a.length() > b.length())
            return addBinary(b, a);

        int pointer = b.length()-1;

        boolean reminder = false;
        StringBuilder res = new StringBuilder();

        for (int aPointer = a.length()-1; aPointer >=  0; aPointer--) {
            if (reminder) 
                if (a.charAt(aPointer) == '1') 
                    if (b.charAt(pointer) == '1')
                        res.append('1'); 
                    else 
                        res.append('0');
                else
                    if (b.charAt(pointer) == '1') 
                        res.append('0');
                    else {
                        res.append('1');
                        reminder = false;
                    }
            else 
                if (a.charAt(aPointer) == '1' && b.charAt(pointer) == '1') {
                    res.append('0');
                    reminder = true;
                }
                else if (a.charAt(aPointer) == '1' || b.charAt(pointer) == '1') 
                    res.append('1');
                else 
                    res.append('0');

            pointer--;
        }

        if (a.length() < b.length())
            for (int aPointer = pointer; aPointer >= 0; aPointer--) {
                if (reminder) {
                    if (b.charAt(aPointer) == '1')
                        res.append('0');
                    else {
                        res.append('1');
                        reminder = false;
                    }
                } else 
                    res.append(b.charAt(aPointer));
            }

        if (reminder)
            res.append('1');

        return res.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        int carry = 0;
        
        // while there is still a digit in either a or b 
        // or if there is still the carry
        while (aPointer >= 0 || bPointer >= 0 || carry > 0) {
            int sum = carry;
            
            // if a or b have still digits
            if (aPointer >= 0) 
                sum += a.charAt(aPointer--) - '0';
            if (bPointer >= 0) 
                sum += b.charAt(bPointer--) - '0'; 
            
            res.append(sum % 2);
            carry = sum / 2;
        }
    
        return res.reverse().toString();
    }    
}
