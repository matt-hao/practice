package interview.wePay.oa;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class PowerNumbers {
    public int getPowerNumber(int index) {
        if (index < 0)
            return Integer.MIN_VALUE;
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();

        int tempIndex = index;

        for (int i = 2; i <= index + 3; i++) {
            long number = i;
            for (int j = 2; j <= 20; j++) {
                number *= i;
                if (tempIndex < 3)
                    tempIndex = 3;
                if (number > (tempIndex + 1) * (tempIndex + 1))
                    break;
                if (set.contains(number))
                    continue;
                queue.offer(number);
                set.add(number);
            }
        }

        for (int i = 0; i < index; i++) {
            queue.poll();
        }
        assert queue.peek() != null;
        return queue.peek().intValue();
    }

    public static void main(String[] args) {
        PowerNumbers powerNumbers = new PowerNumbers();
        System.out.println(powerNumbers.getPowerNumber(0));
        System.out.println(powerNumbers.getPowerNumber(1));
        System.out.println(powerNumbers.getPowerNumber(2));
        System.out.println(powerNumbers.getPowerNumber(3));
        System.out.println(powerNumbers.getPowerNumber(4));
        System.out.println(powerNumbers.getPowerNumber(5));
        System.out.println(powerNumbers.getPowerNumber(6));
        System.out.println(powerNumbers.getPowerNumber(7));
        System.out.println(powerNumbers.getPowerNumber(8));
        System.out.println(powerNumbers.getPowerNumber(9));
        System.out.println(powerNumbers.getPowerNumber(10));
        System.out.println(powerNumbers.getPowerNumber(11));
    }
}
