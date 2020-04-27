package primary.MathProblem;

public class PowerThree {
    public boolean isPowerOfThree(int n) {
        if (n == 1)
            return true;
        if (n / 3 != 0 && n % 3 == 0) {
            for (int i = 1; i <= n; i = i * 3) {
                if (i == n)
                    return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        PowerThree powerThree = new PowerThree();
        System.out.println(powerThree.isPowerOfThree(27));
        System.out.println(powerThree.isPowerOfThree(0));
        System.out.println(powerThree.isPowerOfThree(9));
        System.out.println(powerThree.isPowerOfThree(45));
        System.out.println(powerThree.isPowerOfThree(1));
    }
}
