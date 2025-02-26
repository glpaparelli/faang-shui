import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * Check the file IBM Iterviews > Online Coding Assessment
 */
public class OnlineTestIBM {
    public static void main(String[] args) {
        // QUESTION 1
        // System.out.println(question1(new int[]{3,4,2,1}, 2));
        // System.out.println(question1(new int[]{2,1,5,-1,2,1,6,3}, 3));

        // QUESTION 2
        // System.out.println(question2a(3, 7));
        // System.out.println(question2a(2, 6));
        // System.out.println(question2b(new int[]{1,0,1,1,1,0,0,0,1,1}));

        // QUESTION 3
        // System.out.println(question3("(()))())"));

        // QUESTION 4
        // System.out.println(question4("abba")); // aaba
        // System.out.println(question4("aaabbaaa")); // aaaabaaa
        // System.out.println(question4("aaabaaa")); // aaaaaaa

        // QUESTION 5
        // System.out.println(question5("a4a1c3f4c2")); // expected: a5c5f4
        // System.out.println(question5("a14a1c3f4c2")); // expected: a15c5f4

        // QUESTION 6
        // System.out.println(question6(new int[]{3,2,15}));

        // QUESTION 7
        // System.out.println(question7(List.of(1,2,1,3,1,2,5))); // expected 1
        // System.out.println(question7(List.of(1,2,3,1,2,5))); // expected 2
        // System.out.println(question7(List.of(1,2,3,5))); // expected 0

        // QUESTION 12
        // System.out.println(question12("abba", "baba")); // expected true
        // System.out.println(question12("franco", "cranfo")); // expected true
        // System.out.println(question12("abba", "babba")); // expected false

        // QUESTION 13
        // System.out.println(question13("ABCDEFGHIJKLMNOPQRSTUVWXYZ")); // 6
        // System.out.println(question13("ababiu")); // 4
        // System.out.println(question13("cptr")); // 0

        // QUESTION 15
        // System.out.println(question15(13)); // true
        // System.out.println(question15(7)); // true
        // System.out.println(question15(15)); // false
        // System.out.println(question15(27)); // false

        // QUESTION 16  
        // System.out.println(question16(5)); // 5 
        // System.out.println(question16(18)); // 2584

        // QUESTION 17
        // System.out.println(question17(23)); // 5
        // System.out.println(question17(4)); // 4
        // System.out.println(question17(235)); // 10
        // System.out.println(question17(2352)); // 12

        // QUESTION 18
        // System.out.println(question18(8));

        // QUESTION 19
        // System.out.println(question19(9, 6)); // 3

        // QUESTION 20
        // System.out.println(question20(16));

        // QUESTION 22
        // System.out.println(Arrays.toString(question22(new int[]{3,5,2,10})));

        // QUESTION 23
        // System.out.println(question23("ciao"));
        // System.out.println(question23("0123456789"));

        // QUESTION 25 
        // // 2 1 2        
        // System.out.println(question25(Arrays.asList("bzzz", "bruno", "aziz", "aldo"), Arrays.asList("b", "al", "a")));
        // // []
        // System.out.println(question25(Arrays.asList("bzzz", "bruno", "aziz", "aldo"), Arrays.asList()));
        // // [0, 0, 0]
        // System.out.println(question25(Arrays.asList(), Arrays.asList("b", "al", "a")));
        
        // QUESTION 26
        System.out.println(question26("a?p?e??", "appl")); // appleaa

        // QUESTION 27
        // System.out.println(question27(List.of(1,4,3,6,2), 5)); // (0,1) (2,4)
        // System.out.println(question27(List.of(1,4,3,6,2,1,4), 5));
        // System.out.println(question27(List.of(1,4,3,6,2), 1)); // 
        // System.out.println(question27(List.of(1,4,3,6,2,0), 1)); // (0,5)
        // // (0,4) (0,5) (4,6) (5,6)
        // System.out.println(question27(List.of(-1,4,3,6,-2,-2,-1), -3)); 

        // QUESTION 28
        // question28(10, 2, 3);

        // QUESTION 29
        // System.out.println(question29("aabcdee")); // "bcd"
        // System.out.println(question29("aaaa")); // ""

        // QUESTION 30
        // System.out.println(question30("ciao")); // O a i C
        // System.out.println(question30("bruco")); // O c u r B

        // QUESTION 33
        // System.out.println(question33("aaabbbcde012")); // a
        // System.out.println(question33("aaabbbbcde012")); // b
        // System.out.println(question33("")); // null

        // QUESTION 34
        // [6,1,5,2]
        // System.out.println(Arrays.toString(question34(new int[]{2,5,1,6}))); 
        // [3,-5,2,-1,1]
        // System.out.println(Arrays.toString(question34(new int[]{-1,1,2,3,-5})));
    }   

    public static int[] question34(int[] array) {
        // this is ok
        // int[] res = new int[array.length];
        // int[] sorted = Arrays.copyOf(array, array.length);
        // Arrays.sort(sorted);

        // int left = 0; 
        // int right = array.length-1;

        // for (int i = 0; i < array.length; i+=2) {
        //     res[i] = sorted[right];

        //     if (i+1 == array.length)
        //         break;
            
        //     res[i+1] = sorted[left];

        //     left++;
        //     right--;
        // }

        // return res;

        // better solution: notice that in the resultant array we have
        // at even positions (0, 2, 4, ..) the largest and at odd position
        // the smallest
        Arrays.sort(array);

        int[] result = new int[array.length];

        int left = 0;
        int right = array.length - 1;
        int index = 0;

        while (left <= right) {
            if (index % 2 == 0) {
                result[index] = array[right];  // Place largest
                right--;
            } else {
                result[index] = array[left];   // Place smallest
                left++;
            }

            index++;
        }

        return result;
    }

    public static Character question33(String s) {
        int max = -1;

        if (s == null || s.isEmpty() || s.isBlank())
            return null;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);
            max = Math.max(max, freq);
        }

        for (char c : s.toCharArray())
            if (map.get(c) == max)
                return c;

        return null;
    }

    public static String question30(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--)
            sb.append(s.charAt(i));

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        sb.setCharAt(sb.length()-1, Character.toUpperCase(sb.charAt(sb.length()-1)));

        return sb.toString();
    }

    public static String question29(String s) {
        StringBuilder sb = new StringBuilder();

        // USING A MAP
        // Map<Character, Integer> map = new HashMap<>();
        // for(char c : s.toCharArray())
        //     map.put(c, map.getOrDefault(c, 0)+1);

        // for (char c : s.toCharArray())
        //     if (map.get(c) == 1)
        //         sb.append(c);

        // REMEMBER: for chars you can use arrays!
        int[] freq = new int[256]; // support all ascii chars
        for (char c : s.toCharArray())
            freq[c]++;

        for (char c : s.toCharArray())
            if (freq[c] == 1)
                sb.append(c);

        return sb.toString();
    }

    public static void question28(int n, int p, int q) {        
        for (int i = 1; i <= n; i++) {
            if (i % p == 0 && i % q == 0)
                System.out.println("OUTTHINK");
            else if (i % p == 0) 
                System.out.println("OUT");
            else if (i % q == 0)
                System.out.println("THINK");
            else 
                System.out.println(i);
        }
    }

    public static List<List<Integer>> question27(List<Integer> list, int target) {
        List<List<Integer>> res = new ArrayList<>();

        // // num -> list of indexes where num appear
        Map<Integer, List<Integer>> map = new HashMap<>();

        // DO IT IN TWO PASSES
        for (int i = 0; i < list.size(); i++) 
            map.computeIfAbsent(list.get(i), v -> new ArrayList<>()).add(i);

        for (int i = 0; i < list.size(); i++) {
            // list of complements of the current number
            List<Integer> complementsIndexes = map.get(target - list.get(i));

            if (complementsIndexes == null)
                continue;

            for (int j : complementsIndexes) 
                res.add(new ArrayList<>(List.of(i,j)));
            
            map.remove(list.get(i));
        }

        // DO IT IN ONE PASS
        // for (int i = 0; i < list.size(); i++) {
        //     int currentValue = list.get(i);
        //     int complement = target - currentValue;
        
        //     // If the complement exists in the map, process it
        //     if (map.containsKey(complement)) {
        //         List<Integer> complementsIndexes = map.get(complement);
        
        //         // Create pairs and add to the result
        //         for (int j : complementsIndexes) {
        //             res.add(new ArrayList<>(List.of(i, j)));
        //         }
        //     }
        
        //     // Add the current number to the map for future complements
        //     map.computeIfAbsent(currentValue, k -> new ArrayList<>()).add(i);
        // }

        return res;
    }

    public static String question26(String word, String substr) {
        String res = "z".repeat(word.length());

        int wordLen = word.length();
        int substrLen = substr.length();

        int left = 0; 
        int right = left + substrLen;

        while (left + right < wordLen) {
            String window = word.substring(left, right);

            // this could be avoided exploiting left and right, but asympthotically irrelevant
            int qms = 0; 
            for (char c : window.toString().toCharArray())
                if (c == '?')
                    qms++;

            int diffs = countDifferences(window, substr);

            if (diffs == qms) {
                StringBuilder tmpRes = new StringBuilder();

                tmpRes.append(word.substring(0, left));
                tmpRes.append(substr);
                tmpRes.append(word.substring(right, word.length()));

                for (int i = 0; i < wordLen; i++)
                    if (tmpRes.charAt(i) == '?')
                        tmpRes.setCharAt(i, 'a');

                if (tmpRes.toString().compareTo(res.toString()) < 0)
                    res = tmpRes.toString();
            }

            left++;
            right++;
        }

        return res;
    }
    public static int countDifferences(String a, String b) {
        int res = 0; 
        for (int i = 0; i < a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                res++;

        return res;
    }

    public static List<Integer> question25(List<String> names, List<String> queries) {

        // OK BUT INEFFICIENT, If we sort we have to exploit the sortedness property
        // // #times, index
        // List<Map.Entry<Integer, Integer>> workingRes = new ArrayList<>();

        // // <name - original index in names>
        // List<Map.Entry<String, Integer>> myNames = new ArrayList<>();
        // for (int i = 0; i < names.size(); i++)
        //     myNames.add(Map.entry(names.get(i), i));

        // // <query - original index in queries>
        // List<Map.Entry<String, Integer>> myQueries = new ArrayList<>();
        // for (int i = 0; i < queries.size(); i++)
        //     myQueries.add(Map.entry(queries.get(i), i));

        // // sort myNames to have alphabetically sorted names
        // Collections.sort(myNames, (n1, n2) -> n1.getKey().compareTo(n2.getKey()));
        // // sort myQueries to have alphabetically sorted queries
        // Collections.sort(myQueries, (q1,q2) -> q1.getKey().compareTo(q2.getKey()));

        // // for each query
        // for (Map.Entry<String, Integer> query : myQueries) { 
        //     Integer thisRes = 0;

        //     // for each name
        //     for (Map.Entry<String, Integer> name : myNames) 
        //         // if the query is used in a name we increment this res
        //         if (name.getKey().startsWith(query.getKey()))
        //             thisRes++;
            
        //     // add to the working result the amount of times this query has been used,
        //     // along with the position of this query in the original queries
        //     workingRes.add(Map.entry(thisRes, query.getValue()));    
        // }
        
        // // sort the result based on the original order of the queries
        // Collections.sort(workingRes, (e1, e2) -> Integer.compare(e1.getValue(), e2.getValue()));

        // // return the correct order of usage
        // return workingRes.stream().map(e -> e.getKey()).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>(Collections.nCopies(queries.size(), 0));

        Collections.sort(names);

        // Store original index of queries before sorting
        List<Map.Entry<String, Integer>> indexedQueries = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++)
            indexedQueries.add(Map.entry(queries.get(i), i));
        
        // Sort queries alphabetically to optimize binary search
        indexedQueries.sort(Map.Entry.comparingByKey());

        // Process queries in sorted order
        for (Map.Entry<String, Integer> queryEntry : indexedQueries) {
            
            String query = queryEntry.getKey();
            int originalIndex = queryEntry.getValue();

            // Find first occurrence (or insertion point)
            int here = binarySearch(names, query);

            // Check if prefix exists
            if (here >= names.size() || names.get(here).startsWith(query) == false) {
                result.set(originalIndex, 0); // No match found
                continue;
            }

            // Count occurrences of names that start with the prefix
            // and stop when it change
            int count = 0;
            for (int i = here; i < names.size(); i++) 
                if (names.get(i).startsWith(query)) 
                    count++;
                else 
                    break;
                
            // Store result at original query index
            result.set(originalIndex, count);
        }

        return result;
    }
    private static int binarySearch(List<String> names, String prefix) {
        int low = 0;
        int high = names.size();

        while (low < high) {
            int mid = low + (high - low) / 2; 
            if (names.get(mid).compareTo(prefix) < 0) 
                low = mid + 1;
            else
                high = mid;
        
        }

        return low;  // First possible 
    }

    public static List<Character> question24(String s) {
        List<Character> res = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        for (char c : s.toCharArray())
            if (map.get(c) == 1)
                res.add(c);

        return res;
    }

    public static String question23(String s) {
        if (s == null)
            return null;

        StringBuilder sb = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--)
            sb.append(s.charAt(i));
        
        return sb.toString();
    }

    public static int[] question22(int[] prefXOR) {
        int[] res = new int[prefXOR.length];
        res[0] = prefXOR[0];

        for (int i = 1; i < prefXOR.length; i++) 
            res[i] = prefXOR[i] ^ prefXOR[i - 1];

        return res;
    }

    public static String question20(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.append(n % 2);
            n /= 2;
        }
        return binary.reverse().toString();
    }

    public static int question19(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static long question18(int n) {
        // int res = 1; 

        // if (n == 0 || n == 1) 
        //     return 1;

        // while (n != 1) {
        //     res *= n; 
        //     n--;
        // }
        
        // return res;

        // recursive version
        if (n == 0 || n == 1) 
            return 1;

        return n * question18(n-1);
    }

    public static int question17(int n) {
        n = Math.abs(n);
        int sum = 0; 
        while (n > 0) {
            sum = sum + n % 10;
            n = n / 10;
        }

        return sum;
    }

    public static int question16(int n) {
        int minus2 = 1; 
        int minus1 = 1;

        int current = 0;

        for (int i = 2; i < n; i++) {
            current = minus1 + minus2;
            minus2 = minus1;
            minus1 = current;
        }

        return current;
    }

    public static boolean question15(int n) {
        int limit = (int) Math.sqrt(n);

        if (n % 2 == 0)
            return false;

        for (int i = 3; i <= limit; i+=2)
            if (n % i == 0)
                return false;

        return true;
    }

    public static int question13(String s) {
        // best way to do it:
        int res = 0;
        boolean isVowel[] = new boolean[256];
        for (char c : "aeiouAEIOU".toCharArray())
            isVowel[c] = true;

        for (char c : s.toCharArray())
            if (isVowel[c])
                res++;

        return res;

        // // another good way
        // for (char c : s.toCharArray())
        //     if ("aeiou".indexOf(c) >= 0)   
        //         res++;
        
        // return res;

        // stream way
        // return (int) s.chars().filter((c -> "aeiouAEIOU".indexOf(c) != -1)).count();
    }

    public static boolean question12(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
    
        int freqs[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqs[s1.charAt(i) - 'a'] ++;
            freqs[s2.charAt(i) - 'a'] --;
        }

        return !Arrays.stream(freqs).anyMatch(v -> v != 0);
    }

    public static int question7(List<Integer> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : list)
            map.put(i, map.getOrDefault(i, 0)+1);

        return (int) map.values().stream().filter(v -> v == 2).count();
    }

    public static Map<Integer, Integer> question6(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        // box -> #coins
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = min; i <= max; i++) {
            int sum = sumOfDigits(i);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return map;
    }
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static String question5(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int pointer = 0;

        while (pointer < s.length()) {
            char c = s.charAt(pointer);

            int j = pointer + 1;

            while (j < s.length() && Character.isDigit(s.charAt(j)))
                j++;

            int freq; 
            if (j - pointer == 1) {
                freq = Character.getNumericValue(s.charAt(pointer));
                pointer += 2;
            }
            else {
                freq = Integer.parseInt(s.substring(pointer+1, j));
                pointer += j - pointer;
            }

            map.put(c, map.getOrDefault(c, 0) + freq);
        }

        List<Character> freqs = new ArrayList<>(map.keySet());
        Collections.sort(freqs);

        StringBuilder sb = new StringBuilder();

        for (char c : freqs) {
            sb.append(c);
            sb.append(map.get(c));
        }

        return sb.toString();
    }

    public static String question4(String s) {
        if(s.length() == 1)
            return "IMPOSSIBLE";

        char chars[] = s.toCharArray();

        for (int i = 0; i <= s.length()/2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[s.length()-1] = 'b';
        return new String(chars); 
    }
    
    public static int question3(String s) {
        int closedEarly = 0;
        int stillOpen = 0; 

        for (char p : s.toCharArray()) {
            if (p == '(')
                stillOpen++;
            
            if (p == ')') {
                if (stillOpen <= 0)
                    closedEarly++;
                else
                    stillOpen--;
            }
                
        }

        return closedEarly + stillOpen;
    }

    public static int question2b(int[] array) {
        int res = 0;
        int left = 0; 
        int right = left;

        while (left < array.length) {
            while (left < array.length && array[left] != 1) 
                left++;
            
            if (left == array.length)
                break;

            right = left + 1;

            while (right < array.length && array[right] == 1) 
                right++;

            res = Math.max(res, right - left);

            left = right + 1;
        }


        return res;
    }

    // count even numbers
    public static int question2a(int left, int right) {
        int n = right - left + 1;

        if (n % 2 == 0)
            return n/2;
    
        if (left % 2 == 0)
            return Math.ceilDiv(n, 2);


        return Math.floorDiv(n, 2);
    }

    public static int question1(int bids[], int target) {
        int res = 0;

        Set<Integer> set = new HashSet<>();
        for (int bid : bids)
            set.add(bid);   
            
        for (int element : set) 
            if (set.contains(element - target))
                res++;
        
        return res;
    }    
}