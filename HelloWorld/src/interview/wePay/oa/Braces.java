package interview.wePay.oa;

import java.util.*;

/**
 * Braces in a string are considered to be Balanced if the following criteria are met:
 * <p>
 * For every opening brace (i.e.: (, {, or [), there is a matching closing brace (i.e.: (, {, or [) of the same type (i.e.: ( matches ),
 * { matches } and [ matches ]). An opening brace must appear before (to the left of) its matching closing brace (i.e.: ]{}[ is not balanced).
 * No unmatched braces lie between some pair of matched braces. For example, ({[]}) is balanced, but {[}]} are not balanced.
 * Complete the Braces function in your editor. It should take an array of strings named values as a parameter,
 * determine if all its braces are balanced, and then return an array of strings where each elements indicates whether
 * or not the element in the corresponding index of values was balanced. If the string values[i] (where
 * 0 ≤ i ≤ |values| −1) has balanced braces, then index i in the return array should contain the string YES;
 * otherwise, index i in the return array should contain the string NO
 * <p>
 * Input Format
 * <p>
 * Input from stdin is handled by the locked stub code in your editor. The first line contains N, the length of values.
 * Each line i of the N subsequent lines describes values[i].
 * <p>
 * Constraints
 * <p>
 * <p>
 * 1 ≤ |values| ≤ 15
 * <p>
 * 1 ≤ |values[i]| ≤ 100 , where 0 ≤ i ≤ |values|
 * Output Format
 * <p>
 * Printing the contents of your returned array to stdout is handled by the locked stub code in your editor.
 * Each line i of the N lines of output denotes whether or not the string in values[i] was balanced.
 * <p>
 * Sample Input
 * <p>
 * values = {"{}[]()", "{[}]}"}
 * <p>
 * Sample Output
 * <p>
 * return = {"YES", "NO"}
 * <p>
 * Explanation
 * <p>
 * values[0]: {}[]() meets the criterion for a balanced string, so index 0 in our return array should contain the string YES.
 * <p>
 * values[1]: {[}] contains unmatched braces braces between a matched pair (in the substrings [}, {[}, and [}]), so index 1 in our return array should contain the string NO
 */
public class Braces {
    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    private String[] balancedBrace(String[] braces) {
        String[] res = new String[braces.length];
        for (int i = 0; i < braces.length; i++) {
            res[i] = isValid(braces[i]) ? "YES" : "NO";
        }
        return res;
    }

    private boolean isValid(String brace) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < brace.length(); i++) {
            if (map.values().contains(brace.charAt(i)))
                stack.push(brace.charAt(i));
            else {
                if (!stack.isEmpty() && map.get(brace.charAt(i)) == stack.peek())
                    stack.pop();
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }

        String[] braces = new String[n];
        for (int i = 0; i < n; i++) {
            braces[i] = scanner.next();
        }
        scanner.close();
        Braces b = new Braces();
        System.out.println(Arrays.toString(b.balancedBrace(braces)));
    }
}
