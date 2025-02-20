package problems.strings.medium;
/*
 * LEETCODE 6: Zigzag Conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on 
 * a given number of rows (in this example 3) like this:
 *          P   A   H   N
 *          A P L S I I G
 *          Y   I   R
 * 
 * Write the code that will take a string and a number of rows and produce the 
 * concatenation of the rows: "PAHNAPLSIIGYIR"
 * 
 * SOLUTION: 
 * Use an array of stringbuilders and a boolean to simulate the pattern 
 * "go down until the last row" and then "go back and write shifted by one until row = 0"
 */
public class ZigzagConversion {
    public static void main(String[] args) {
        System.out.println((convert("paypalishiring", 3)));
    }

    public static String convert(String s, int n) {
        if (n == 1 || n >= s.length()) 
            return s;

        // arrays of string builders
        StringBuilder[] rows = new StringBuilder[Math.min(n, s.length())];
        for (int i = 0; i < rows.length; i++) 
            rows[i] = new StringBuilder();
        
        // consider the current row to write
        int currentRow = 0;
        // have I to write in the next row?
        boolean goDown = false;

        // iterate for each char in s
        for (char c : s.toCharArray()) {
            // we inser the current char to the current row
            rows[currentRow].append(c);

            // if currentRow == 0 then we have to go down and insert 
            // to the next row (=1). 
            // if currentRow is the last row then we have to climb back
            // by one to follow the zigzag pattern
            if (currentRow == 0 || currentRow == n - 1) 
                goDown = !goDown;

            // if goDown is true then we go to the next row
            if (goDown == true) 
                currentRow += 1;
            // if goDown is false then we go back to the prev row
            else 
                currentRow += -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) 
            result.append(row);

        return result.toString();

        // alternatively, shorter but slower
        // return Arrays.stream(rows).map(sb -> sb.toString()).collect(Collectors.joining());
    }
}
