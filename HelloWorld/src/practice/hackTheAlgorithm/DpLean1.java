package practice.hackTheAlgorithm;

/**
 * 给定一个数组，要求选择其中的某些数字， 这些数字加起来的和最大
 * 要求，选择的数字不能相邻
 */
public class DpLean1 {

    private int recursive(int[] arr, int index, int[] memo) {
        if (memo[index] != 0)
            return memo[index];
        if (index == 0)
            return memo[0] = arr[0];
        if (index == 1)
            return memo[1] = Math.max(arr[0], arr[1]);
        return memo[index] = Math.max(recursive(arr, index - 2, memo) + arr[index], recursive(arr, index - 1, memo));
    }

    private int dp(int[] arr) {
        if (arr.length == 0)
            return Integer.MIN_VALUE;
        if (arr.length == 1)
            return arr[0];
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            opt[i] = Math.max(opt[i - 2] + arr[i], opt[i - 1]);
        }
        return opt[opt.length - 1];
    }

    public static void main(String[] args) {
        DpLean1 dpLean1 = new DpLean1();
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        System.out.println(dpLean1.recursive(arr, arr.length - 1, new int[arr.length]));
        System.out.println(dpLean1.dp(arr));
    }
}

/**
 * 给定一个数组和target。选取数组中的部分数字，查看这些数字之和是否等于给定的target
 */
class DpLearn2 {
    private boolean isEqual(int[] arr, int index, int target) {
        if (target == 0)
            return true;
        if (index == 0)
            return arr[index] == target;
        if (arr[index] > target)
            return isEqual(arr, index - 1, target);
        return isEqual(arr, index - 1, target - arr[index]) || isEqual(arr, index - 1, target);
    }

    private boolean dp(int[] arr, int target) {
        boolean[][] subsets = new boolean[arr.length][target + 1];
        for (int i = 0; i < subsets.length; i++) {
            subsets[i][0] = true;
        }
        for (int i = 0; i < subsets[0].length; i++) {
            subsets[0][i] = (i == arr[0]);
        }

        for (int i = 1; i < subsets.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (arr[i] > j)
                    subsets[i][j] = subsets[i - 1][j];
                else
                    subsets[i][j] = subsets[i - 1][j - arr[i]] || subsets[i - 1][j];
            }
        }
        return subsets[subsets.length - 1][target];
    }

    public static void main(String[] args) {
        DpLearn2 dpLearn2 = new DpLearn2();
        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(dpLearn2.isEqual(arr, arr.length - 1, 9));
        System.out.println(dpLearn2.isEqual(arr, arr.length - 1, 13));
        System.out.println(dpLearn2.dp(arr, 9));
        System.out.println(dpLearn2.dp(arr, 13));
    }
}