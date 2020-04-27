package practice.hackTheAlgorithm;

import java.util.Arrays;
import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        String s = "5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))";
        String[] arr  = new String[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "\"" + s.charAt(i) + "\"";
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(basicCalculator.calculate("5+3-4-(1+2-7+(10-1+3+5+(3-0+(8-(3+(8-(10-(6-10-8-7+(0+0+7)-10+5-3-2+(9+0+(7+(2-(2-(9)-2+5+4+2+(2+9+1+5+5-8-9-2-9+1+0)-(5-(9)-(0-(7+9)+(10+(6-4+6))+0-2+(10+7+(8+(7-(8-(3)+(2)+(10-6+10-(2)-7-(2)+(3+(8))+(1-3-8)+6-(4+1)+(6))+6-(1)-(10+(4)+(8)+(5+(0))+(3-(6))-(9)-(4)+(2))))))-1)))+(9+6)+(0))))+3-(1))+(7))))))))"));
    }
    public int calculate(String s) {
        // Write your code here
        if(s == null || s.length() == 0)
            return 0;
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
                if(i + 1< s.length() && !Character.isDigit(s.charAt(i + 1))){
                    operand.push(num);
                    num = 0;
                }
            }else if(c == '('){
                operator.push(c);
            }else if(c == ')'){
                while(!operator.isEmpty() && operator.peek() != '(' && !operand.isEmpty()){
                    char opt = operator.pop();
                    int second = operand.pop();
                    int first = operand.pop();
                    operand.push(cal(opt, first, second));
                }
                operator.pop();
            }else{
                while(!operator.isEmpty() && priority(c) <= priority(operator.peek())){
                    char opt = operator.pop();
                    int second = operand.pop();
                    int first = operand.pop();
                    operand.push(cal(opt, first, second));
                }
                operator.push(c);
            }
        }

        if(num != 0 || (num == 0 && operand.size() == 1 && operator.size() == 1))
            operand.push(num);

        while(!operator.isEmpty()){
            char opt = operator.pop();
            int second = operand.pop();
            int first = operand.pop();
            operand.push(cal(opt, first, second));
        }
        return operand.isEmpty()? 0 : operand.peek();
    }

    private int cal(char opt, int first, int second){
        int res = 0;
        if(opt == '+')
            res = first + second;
        if(opt == '-')
            res = first - second;
        return  res;
    }

    private int priority(char c){
        if(c == '(')
            return 0;
        if(c == '+' || c == '-')
            return 1;
        return -1;
    }
}
