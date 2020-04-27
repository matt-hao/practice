package practice.hackTheAlgorithm;

import java.util.Arrays;

public class SortColors {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0)
            return;
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int start, int end, int minColor, int maxColor) {
        if (start >= end || minColor >= maxColor)
            return;

        int l = start, r = end;
        int pivot = minColor + (maxColor - minColor) / 2;
        while (l <= r) {
            while (l <= r && colors[l] <= pivot)
                l++;
            while (l <= r && colors[r] > pivot)
                r--;

            if (l <= r) {
                int temp = colors[l];
                colors[l] = colors[r];
                colors[r] = temp;
                l++;
                r--;
            }
        }

        rainbowSort(colors, start, r, minColor, pivot);
        rainbowSort(colors, l, end, minColor + 1, maxColor);
    }

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] num = new int[]{4, 2, 1, 2, 5, 3, 2, 3, 2};
        s.sortColors2(num, 5);
        System.out.println(Arrays.toString(num));
    }
}
