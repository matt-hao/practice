package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutationII {
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (str == null)
            return res;
        if (str.length() == 0) {
            res.add("");
            return res;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        res.add(new String(chars));
        while (true) {
            int index = getNextPermutation(chars);
            if (index == 0)
                break;
            res.add(String.valueOf(chars));
        }
        return res;
    }

    private int getNextPermutation(char[] chars) {
        int index = chars.length - 1;
        while (index > 0) {
            if (chars[index] > chars[index - 1])
                break;
            index--;
        }

        if (index != 0) {
            int j = chars.length - 1;
            while (j >= index) {
                if (chars[j] > chars[index - 1]) {
                    swap(chars, j, index - 1);
                    break;
                }
                j--;
            }
        }

        inPlace(chars, index, chars.length - 1);
        return index;
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    private void inPlace(char[] chars, int a, int b) {
        while (a < b) {
            swap(chars, a, b);
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        StringPermutationII s = new StringPermutationII();
        System.out.println(s.stringPermutation2("cba"));
    }
}
