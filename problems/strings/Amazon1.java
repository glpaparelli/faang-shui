package problems.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * PROBLEM: Amazon OA Example 1
 * - repository contains a list of currentSuggestions
 * - customerQuery represent the customer typing in a iterativeQuery box
 *     - he types one character at a time without deleting any, and 
 *       we assume he has already typed two chars. 
 * 
 * - return a list of list of stirngs representing the top 3 best suggestion 
 *   based on its iterativeQuery per each keystroke.
 * 
 * - eg: 
 *   - input: 
 *      - repository: ["mobile", "mouse", "moneypot", "monitor", "mousepad"]
 *      - customerquery = "mouse"
 * 
 *   - output: 
 *      ["mobile","moneypot", "monitor"]
 *      ["mouse", "mousepad"]
 *      ["mouse", "mousepad"]
 *      ["mouse", "mousepad"]
 * 
 *   - explaination: 
 *     The chain of words typed by the user will be "mo", "mou", "mous", "mouse"
 * 
 *     For "mo" the currentSuggestions in the repository that match the query are 
 *     ["mobile", "mouse", "moneypot", "monitor", "mousepad"]. 
 *     We save the top three results (ordered alphabetically), hence ["mobile","moneypot", "monitor"]
 * 
 *     For "mou" the only two possible currentSuggestions are ["mouse", "mousepad"]
 * 
 *     ...
 */
public class Amazon1 {
    public static void main(String[] args) {

        List<String> repository = List.of("mobile", "mouse", "moneypot", "monitor", "mousepad");

        List<List<String>> res = searchSuggestion(repository, "mouse");

        res.forEach(s -> System.out.println(s));
    }

    public static List<List<String>> searchSuggestion(List<String> repository, String customerQuery) {
        List<List<String>> result = new ArrayList<>();

        customerQuery = customerQuery.toLowerCase();
        String firstLetter = customerQuery.substring(0,1);

        List<String> sortedRepo = new ArrayList<>();
        for (String word : repository) 
            if (word.startsWith(firstLetter))
                sortedRepo.add(word);
        
        Collections.sort(sortedRepo);

        StringBuilder iterativeQuery = new StringBuilder(firstLetter);

        for (int i = 1; i < customerQuery.length(); i++) {
            iterativeQuery.append(customerQuery.charAt(i));

            List<String> currentSuggestions = new ArrayList<>();

            for (String word : sortedRepo)
                if (word.startsWith(iterativeQuery.toString()))
                    currentSuggestions.add(word);
            
            while (currentSuggestions.size() > 3)
                currentSuggestions.removeLast();
                
            result.add(currentSuggestions);
        }

        return result;
    }
    
}
