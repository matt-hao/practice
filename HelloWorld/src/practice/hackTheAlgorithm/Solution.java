package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        getList(num,list);
        int max = Integer.MIN_VALUE;
        int index = -1;
        int[] pair = new int[2];
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            } else {
                pair[0] = index;
                pair[1] = i;
            }
        }

        int temp = list.get(pair[0]);
        list.set(pair[0], list.get(pair[1]));
        list.set(pair[1], temp);

        int res = 0;
        for (int n : list) {
            res = res * 10 + n;
        }
        return res;
    }

    private void getList(int num, List<Integer> list) {
        while (num != 0) {
            int temp = num % 10;
            list.add(temp);
            num /= 10;
        }
        Collections.reverse(list);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximumSwap(2736));
    }
}