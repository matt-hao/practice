package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolishNotation {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public List<String> convertToPN(String[] expression) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (expression == null || expression.length == 0)
            return res;
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for (String s : expression) {
            if (isNumber(s)) {
                stack1.push(s);
            } else if (s.equals("(")) {
                stack2.push(s);
            } else if (s.equals(")")) {
                String nextPush = stack1.pop();
                while (!stack2.isEmpty()) {
                    if (stack2.peek().equals("(")) {
                        stack2.pop();
                        break;
                    }

                    nextPush = stack2.pop() + nextPush;
                }
                stack1.push(nextPush);
            } else {
                // * / 优先级相等
                // * / 优先级大于 + -
                // + 优先级大于-
                String nextPush = stack1.pop();
                while (!stack2.isEmpty() && priority(s, stack2.peek()) <= 0) {
                    nextPush = stack2.pop() + nextPush;
                }
                stack1.push(nextPush);
                stack2.push(s);
            }
        }

        String rs = stack1.pop();
        while (!stack2.isEmpty()) {
            rs = stack2.pop() + rs;
        }

        for (char c : rs.toCharArray()) {
            res.add(c + "");
        }
        return res;
    }

    private boolean isNumber(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    private int priority(String s1, String s2) {
        return getPriority(s1) - getPriority(s2);
    }

    private int getPriority(String s) {
        if (s.equals("("))
            return 0;
        if (s.equals("+") || s.equals("-"))
            return 1;
        if (s.equals("*") || s.equals("/"))
            return 2;
        return -1;
    }


    public static void main(String[] args) {
        PolishNotation p = new PolishNotation();
        //["(", "5", "-", "6", ")", "*", "7"] --- > * - 5 6 7
        String[] ex1 = {"(", "5", "-", "6", ")", "*", "7"};
        System.out.println(p.convertToPN(ex1));


//        ["3", "+", "(", "1", "-", "2", ")"] --- > + 3 - 1 2
//        String[] ex2 = {"3", "+", "(", "1", "-", "2", ")"};
//        System.out.println(p.convertToPN(ex2));
    }
}
