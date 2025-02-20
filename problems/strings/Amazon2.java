package problems.strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Question 1. 
 * A function is given a decimal number num in string form (so str("12345")) 
 * and an integer parameter k. A number is said to be attractive if all 
 * digits of num that are k units apart are equal. 
 * So, num[i] = num[i+k] for 0<=i<(n-k). 
 * 
 * For example, "25252" for k=2 would be an attractive number. 
 * So will 43214 for k=4, but "25352" for k=2 is not an attractive number. 
 * 
 * Given a string num and a parameter k, our job is to find the smallest 
 * attractive number greater than or equal to num.
 * 
 * Question 2. 
 * We are given an array cost with cost of different items. 
 * A package can contain at most two items. 
 * The cost of the package is equal to the sum of the item(s) it contains.
 * For any given distribution, an item can only be in one package 
 * (i.e, when distributing items in different packages, an item can only 
 * be in one package). 
 * What is the maximum number of packages that can be produced for a 
 * given cost array, such that all the packages have the same cost. 
 * 
 * Remember the constraint that a package must have at least one, 
 * and at most two items
 */
public class Amazon2 {
    
    public static void main(String[] args) {
        // System.out.println(mySmallestAttractiveNumber("25252", 2));
        // System.out.println(mySmallestAttractiveNumber("25352", 2));
        // System.out.println(mySmallestAttractiveNumber("43214", 4));
        // System.out.println(mySmallestAttractiveNumber("1212431", 3));

        // System.out.println(smallestAttractiveNumber("25252", 2));
        // System.out.println(smallestAttractiveNumber("25352", 2));
        // System.out.println(smallestAttractiveNumber("43214", 4));

        System.out.println(numberOfPackages(new int[]{1,2,1,3,2,1,4}));
        System.out.println(numberOfPackages(new int[]{1,6,2,1,3}));
        System.out.println(numberOfPackages(new int[]{1,2}));


    }

    // wrong, do not give the smallest: 
    // eg 25325: my gives 35353, but the smallest would be 26262
    public static int mySmallestAttractiveNumber(String num, int k) {
        boolean attractive = true;
        
        List<Integer> conflictsAt = new ArrayList<>();

        // 1) num is already an attractive number?
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + k; j < num.length(); j+= k) {
                if (num.charAt(i) != num.charAt(j)) {
                    attractive = false;
                    conflictsAt.add(i); 
                    break;
                }
            }
        }
        if (attractive)
            return Integer.parseInt(num);
        
        // 2) num is not an attractive number, lets build the next one
        char[] workingRes = new char[num.length()];        

        for (int i = 0; i < num.length(); i++) 
            if (conflictsAt.contains(i) == false) 
                workingRes[i] = num.charAt(i);
        
        for (int c : conflictsAt) {
            int max = Integer.MIN_VALUE; 
            for (int i = c; i < num.length(); i+=k) 
                max = Math.max(max, Character.getNumericValue(num.charAt(i)));
            
            for (int i = c; i < num.length(); i+=k)    
                workingRes[i] = Character.forDigit(max, 10);
        }

        return Integer.parseInt(new String(workingRes));
    }

    // the key here is that an attractive number is another way of 
    // saying that the number is periodic with period = k. 
    // So you create myNum, which is the first k chars repeated 
    // until the length of myNum is exactly myNum
    public static int smallestAttractiveNumber(String num, int k) {
        String myNum = repeatUntilLength(num.substring(0,k), num.length());

        while (Integer.parseInt(num) > Integer.parseInt(myNum)) {
            int x = Integer.parseInt(myNum.substring(0, k)) + 1;
            myNum = repeatUntilLength(Integer.toString(x), num.length());
        }

        return Integer.parseInt(myNum);
    }   

    private static String repeatUntilLength(String s, int n) {
        StringBuilder sb = new StringBuilder();

        while (sb.length() < n)
            sb.append(s);

        return sb.substring(0, n);
    }

    // almost surely wrong
    public static int numberOfPackages(int[] costs) {
        int max = Arrays.stream(costs).max().getAsInt();
        int columns = max * 2;

        int dp[][] = new int[costs.length][columns+1]; 

        dp[0][costs[0]] = 1;

        for (int i = 1; i < costs.length; i++) {
            int currObjCost = costs[i]; 
            int prevObjCost = costs[i-1];
            
            int tmp = dp[i][currObjCost + prevObjCost] + 1;
            dp[i] = dp[i-1];

            dp[i][currObjCost]++;
            dp[i][currObjCost+prevObjCost] = tmp;
        }

        return Arrays.stream(dp[costs.length-1]).max().getAsInt();
    }



}
