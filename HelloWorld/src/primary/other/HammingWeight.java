package primary.other;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * Example 1:
 * <p>
 * Input: 11
 * Output: 3
 * Explanation: Integer 11 has binary representation 00000000000000000000000000001011
 * Example 2:
 * <p>
 * Input: 128
 * Output: 1
 * Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
//        int count = 0;
//        while (n >= 1) {
//            if (n % 2 == 1)
//                count++;
//            n = n / 2;
//        }
//        return  count;
    }


    public int hammin_weight(int n) {
        int count = 0;
        for (int i = 0; i < 32; n >>>= 1, i++) {
            if ((n & 1) == 1) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
//        System.out.println(hammingWeight.hammingWeight(128));
        System.out.println(hammingWeight.hammingWeight(Integer.MAX_VALUE + 1));
        System.out.println(hammingWeight.hammin_weight(Integer.MAX_VALUE + 1));
    }
}
