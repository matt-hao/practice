import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MidToPre {

    static Map<String, Priority> map = new HashMap<>();

    enum Priority {
        LOW, MEDIUM, HIGH
    }

    static {
        map.put("+", Priority.LOW);
        map.put("-", Priority.LOW);
        map.put(")", Priority.LOW);
        map.put("*", Priority.MEDIUM);
        map.put("/", Priority.MEDIUM);
        map.put("(", Priority.HIGH);
    }

    public static void main(String[] args) {
        //前缀表达式
//        String s = "a+b*c+(d*e+f)*g";
        String s = "a+b*c*g*(d*e+f)";

        Stack<String> stringStack = new Stack<>();

        //输出后缀表达式 abc*+de*f+g*+
        for (int i = 0; i < s.length(); i++) {
            String temp = String.valueOf(s.charAt(i));
            if (map.containsKey(temp)) {
                if (stringStack.empty()) {
                    stringStack.push(temp);
                } else {
                    while (map.get(temp).ordinal() <= map.get(stringStack.peek()).ordinal()) {
                        String pop = stringStack.peek();
                        if (pop.equals("(")) {
                            if (temp.equals(")"))
                                stringStack.pop();
                            break;
                        }
                        System.out.print(stringStack.pop());
                        if(stringStack.empty())
                            break;
                    }
                    if (!temp.equals(")"))
                        stringStack.push(temp);

                }
            } else {
                System.out.print(temp);
            }
        }
        while(!stringStack.empty()){
            System.out.print(stringStack.pop());
        }
    }
}
