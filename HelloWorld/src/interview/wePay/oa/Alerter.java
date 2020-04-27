package interview.wePay.oa;

import java.util.*;

public class Alerter {
    public boolean raiseAlert(List<Integer> input, int windowSize, float allowedIncrease) {
        if (input == null || input.size() == 0)
            return false;
        if (windowSize <= 0 || allowedIncrease < 0)
            return false;
        Deque<Integer> deque = new ArrayDeque<>();
        int windowSum = 0;
        for (int i = 0; i < windowSize - 1; i++) {
            inQueue(deque, input.get(i));
            windowSum += input.get(i);
        }


        List<Double> listAvg = new ArrayList<>();
        for (int i = windowSize - 1; i < input.size(); i++) {
            inQueue(deque, input.get(i));

            int windowMax = deque.peekFirst();
            windowSum += input.get(i);

            if (!checkValue(windowMax, windowSum, windowSize, allowedIncrease))
                return true;
            if (!checkAvg(windowSum, windowSize, allowedIncrease, listAvg))
                return true;
            outQueue(deque, input.get(i - windowSize + 1));
            windowSum -= input.get(i - windowSize + 1);
        }
        return false;
    }

    private boolean checkValue(double windowMax, double windowSum, int windowSize, double allowedIncrease) {
        double avg = windowSum / windowSize;
        return windowMax <= (avg * allowedIncrease);
    }

    private boolean checkAvg(double windowSum, int windowSize, double allowedIncrease, List<Double> listAvg) {
        double curAvg = windowSum / windowSize;
        for (double b : listAvg) {
            if (curAvg > (b * allowedIncrease))
                return false;
        }
        listAvg.add(curAvg);
        return true;
    }

    private void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }

    private void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num)
            deque.pollFirst();
    }

    public static void main(String[] args) {
        Alerter alerter = new Alerter();
//        int[] arr1 = new int[]{1, 2, 100, 2, 2};
//        System.out.println(alerter.raiseAlert(arr1, 3, 1.5));//true
//
//        int[] arr2 = new int[]{1, 2, 4, 2, 2};
//        System.out.println(alerter.raiseAlert(arr2, 3, 2));//false
//
//        int[] arr3 = new int[]{1, 2, 100, 2, 2};
//        System.out.println(alerter.raiseAlert(arr3, 2, 2.5));//true
//        Integer[] a = new Integer[]{1, 2, 100, 2, 2};
        List<Integer> l1 = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(100);
                add(2);
                add(2);
            }
        };
        List<Integer> l2 = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(4);
                add(2);
                add(2);
            }
        };
        List<Integer> l3 = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(100);
                add(2);
                add(2);
            }
        };
        List<Integer> l4 = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(4);
                add(2);
                add(2);
            }
        };
        List<Integer> l5 = new ArrayList<>() {
            {
                add(2);
                add(2);
                add(2);
                add(2);
                add(2);
            }
        };
        List<Integer> l6 = new ArrayList<>() {
            {
                add(5);
                add(1);
                add(2);
                add(100);
                add(2);
                add(2);
            }
        };
        boolean r1 = alerter.raiseAlert(l1, 3, 1.5f);
        boolean r2 = alerter.raiseAlert(l2, 3, 2f);
        boolean r3 = alerter.raiseAlert(l3, 2, 2.5f);
        boolean r4 = alerter.raiseAlert(l4, 1, 0.5f);
        boolean r5 = alerter.raiseAlert(l5, 1, 0.5f);
        boolean r6 = alerter.raiseAlert(l6, 3, 1.5f);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println(r5);
        System.out.println(r6);
    }
}
