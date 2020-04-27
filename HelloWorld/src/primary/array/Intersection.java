package primary.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection {
    public int[] solution(int[] num1, int[] num2) {
        Arrays.sort(num1);
        Arrays.sort(num2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;

        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j])
                i++;
            else if (num1[i] > num2[j])
                j++;
            else {
                list.add(num1[i]);
                i++;
                j++;
            }
        }
        int[] a = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            a[k] = list.get(k);
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 7, 1};
        int[] b = {7, 2};
        Intersection intersection = new Intersection();
        System.out.println(Arrays.toString(intersection.solution(a, b)));
    }

}

