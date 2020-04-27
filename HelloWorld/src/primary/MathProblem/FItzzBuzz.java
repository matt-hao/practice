package primary.MathProblem;

import java.util.ArrayList;
import java.util.List;

public class FItzzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String a = i + "";
            if (i % 3 == 0)
                a = "Fizz";
            if (i % 5 == 0)
                a = "Buzz";
            if (i % 3 == 0 && i % 5 == 0)
                a = "FizzBuzz";
            list.add(a);
        }
        return list;
    }

    public static void main(String[] args) {
        FItzzBuzz fItzzBuzz = new FItzzBuzz();
        System.out.println(fItzzBuzz.fizzBuzz(15));
    }
}
