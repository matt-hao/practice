package primary.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class Bracket {

    Map<String, String> map = new HashMap<>();

    {
        map.put("}", "{");
        map.put("]", "[");
        map.put(")", "(");
    }

    public boolean isValid(String s) {
        boolean b = true;
        if (s == null || s.length() == 0)
            return b;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(String.valueOf(s.charAt(i)))) {
                if (stack.isEmpty())
                    return b = false;
                else if (!String.valueOf(stack.pop()).equals(map.get(String.valueOf(s.charAt(i)))))
                    return b = false;
            } else
                stack.push(s.charAt(i));
        }
        if (!stack.empty())
            b = false;
        return b;
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        System.out.println(bracket.isValid("()"));
        System.out.println(bracket.isValid("()[]{}"));
        System.out.println(bracket.isValid("(]"));
        System.out.println(bracket.isValid("([)]"));
        System.out.println(bracket.isValid("{[]}"));
    }
}
