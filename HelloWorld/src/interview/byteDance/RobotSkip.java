package interview.byteDance;

import java.util.Scanner;

public class RobotSkip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] height = new int[n + 1];
        int left = 0;
        int right = 0;
        int mid = 0;
        for (int i = 1; i < height.length; i++) {
            height[i] = scanner.nextInt();
            right = Math.max(right, height[i]);
        }
        while (left < right) {
            mid = left + (right - left) / 2;
            if (valid(height, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    private static boolean valid(int[] height, int e) {
        for (int i = 1; i < height.length; i++) {
            if (height[i] > e) {
                e -= height[i] - e;
                if (e < 0) return false;
            } else {
                e += e - height[i];
            }
        }
        return true;
    }
}
