package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class FindCLosetEle {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return list;
        int pos = closetTarget(arr, x);
        int i = pos, j = pos + 1;
        for (; i >= 0 && j < arr.length; ) {
            int absLeft = Math.abs(arr[i] - x);
            int absRight = Math.abs(arr[j] - x);
            if (absLeft <= absRight) {
                i--;
            } else {
                j++;
            }
            k--;
            if (k == 0)
                break;
        }
        if (k > 0) {
            while (k > 0 && i >= 0) {
                k--;
                i--;
            }
            while (k > 0 && j < arr.length) {
                k--;
                j++;
            }
        }
        for (int m = i + 1; m <= j - 1; m++) {
            list.add(arr[m]);
        }
        return list;
    }

    private int closetTarget(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        int abs = Math.abs(arr[start] - arr[end]);
        int pos = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x)
                return mid;
            int absNew = Math.abs(arr[mid] - x);
            if (arr[mid] < x) {
                start = mid + 1;
            }

            if (arr[mid] > x) {
                end = mid - 1;
            }

            if (absNew < abs) {
                pos = mid;
                abs = absNew;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        //[0,0,1,2,3,3,4,7,7,8]
        //3
        //5
        FindCLosetEle findCLosetEle = new FindCLosetEle();
        System.out.println(findCLosetEle.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5));
    }
}
