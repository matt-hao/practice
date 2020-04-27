package practice.hackTheAlgorithm;

import java.math.BigInteger;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 || n == 0)
            return 1;
        BigInteger[] fac = factorial(m + n - 2);
        return (fac[m + n - 2].divide (fac[m - 1] .multiply(fac[n - 1]))).intValue();
    }

    private BigInteger[] factorial(int n) {
        BigInteger[] result = new BigInteger[n + 1];
        result[0] = new BigInteger("1");
        result[1] = new BigInteger("1");
        for (int i = 2; i < n + 1; i++) {
            result[i] = result[i - 1].multiply(new BigInteger(i + ""));
        }
        return result;
    }

    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        System.out.println(uniquePath.uniquePaths(2, 62));
    }
}
