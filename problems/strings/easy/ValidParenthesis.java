package problems.strings.easy;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
 * Given a string "s" containing the characters '(', ')', '[', ']',
 * {' and '}', determine if the input string is valid. 
 * 
 * An input string is valid if: 
 * 1) open brackets must be closed by the same type of bracket
 * 2) open brackets must be closed in the correct order
 * 3) every closed bracket has a corresponding open bracket of the same type
 * 
 * SOLUTION: 
 * - LinkedList: O(n) time & space. 
 *   We create a map that associate a closing bracket to its corresponding open bracket to 
 *   avoid lots of if statements. 
 * 
 *   Then we go char by char the string.
 *   If we find an opening bracket we insert at the end of the list. 
 *   If we find a closening bracket then we have two cases: 
 *   1) the closening bracket close the last opened bracket (hence the last 
 *      bracket of the list) then its ok, we remove the last element of the list 
 *      and go on.
 *   2) the closening bracket closes a different bracket than the last opened bracket. 
 *      Therefore we have a situaion like "( ]", which is not valid and we return false.
 *  
 *   Finally, we check if the list is empty. If it is it means that every opening bracket 
 *   has been closed with its corresponding closing bracket in the right order and we return 
 *   true. Otherwise we return false.
 * 
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{()}"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        // at the end of the list we have the last opened bracket
        List<Character> list = new LinkedList<>();

        for (char c : s.toCharArray())
            if (c == '(' || c == '[' || c == '{') 
                list.add(c);
            else
                if (list.isEmpty() || list.removeLast() != closeToOpen.get(c))
                    return false;

        return list.isEmpty();
    }
}
