package primary.MathProblem;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example:
 * <p>
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class Prime {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3)
            return 1;

        int temp = 0;
        if (n % 2 != 0) {
            temp = isPrime(n - 2) ? 1 : 0;
            return countPrimes(n - 2) + temp;
        }
        temp = isPrime(n - 1) ? 1 : 0;
        return countPrimes(n - 1) + temp;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }


    public int count_prime(int n) {
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            b[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!b[i])
                continue;
            for (int j = i * i; j < n; j += i) {
                b[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (b[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Prime prime = new Prime();
        System.out.println(prime.countPrimes(10000));
        System.out.println(prime.count_prime(10000));
    }
}
