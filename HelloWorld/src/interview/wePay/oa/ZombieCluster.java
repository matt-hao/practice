package interview.wePay.oa;

import java.util.Scanner;

/**
 * There are n zombies in Seattle, and Liv and Ravi are trying to track them down to find out who is creating new zombies
 * - thus preventing an apocalypse. Other than the patient-zero zombies (who became so by mixing MaxRager and tainted Utopium),
 * new people only become zombies after being scratched by an existing zombie; for this reason, zombiism is transitive.
 * This means that if zombie 0 knows zombie 1 and zombie 1 knows zombie 2, then zombie 0 is connected to zombie
 * 2. A zombie cluster is a group of zombies who are directly or indirectly linked through the other zombies they know
 * (such as the one who scratched them or supplies them with brains).
 * <p>
 * Complete the zombieCluster function in your editor. It has 1 parameter: an array of binary strings (i.e., composed of 0s and 1s) named zombies that describes an
 * n × n matrix of known connected zombies; if zombies[i][j] = 0, then the ith and jth zombies do not know one another
 * (otherwise, the cell contains a 1 and they do know one another).
 * Your function must return an integer denoting the number of zombie clusters Liv and Ravi have identified in Seattle.
 * <p>
 * Note: Method signatures may vary depending on the requirements of your chosen language.
 * <p>
 * Input Format
 * <p>
 * The locked stub code in your editor reads the following input from stdin and passes it to your function;
 * <p>
 * The first line contains an integer, n , describing the base size of your zombie association matrix.
 * Each of the n subsequent lines contains a binary string of length n describing a row in the matrix.
 * <p>
 * Constraints
 * <p>
 * <p>
 * 1 ≤ n ≤ 300
 * <p>
 * 0 ≤ i ≤ n
 * <p>
 * |zombie ≡ n|
 * Each zombies[i] contains a binary string of n zeroes and ones.
 * zombies[i][j] = 1, where 0 ≤ i ≤ n
 * zombies[i][j] = zombies[j][i], where 0 ≤ i < j < n.
 * Output Format
 * <p>
 * Your function must return a single integer denoting the number different zombie clusters in Seattle. This is printed to stdout by the locked stub code in your editor.
 * <p>
 * Sample Input 0
 * <p>
 * 4
 * <p>
 * 1100
 * <p>
 * 1110
 * <p>
 * 0110
 * <p>
 * 0001
 * <p>
 * Sample Output 0
 * <p>
 * 2
 * <p>
 * Sample Input 1
 * <p>
 * 5
 * <p>
 * 10000
 * <p>
 * 01000
 * <p>
 * 00100
 * <p>
 * 00010
 * <p>
 * 00001
 * <p>
 * Sample Output 1
 * <p>
 * 5
 * <p>
 * Explanation
 * <p>
 * In the diagrams below, the squares highlighting a known connection between two different zombies are highlighted in green. Because each zombie is already aware that they are personally a zombie, those are highlighted in grey.
 * <p>
 * Sample Case 0
 * <p>
 * For sample case 0, we have n = 4 zombies numbered Z0 through Z3
 * . There are 2 pairs of zombies who directly know each another:(Z0, Z1) and (Z1, Z2). Because of zombiism's transitive property, the set of zombies
 * {Z0, Z1, Z2} is considered to be a single zombie cluster. The remaining zombie, Z3, doesn't know any other zombies and is considered to be his own,
 * separate zombie cluster (Z3). This gives us a total of 2 zombie clusters, so we print 2 on a new line.
 * <p>
 * Sample Case 1
 * <p>
 * For sample case 1, no zombie knows who any other zombie is, so they each form their own zombie clusters:
 * Z0, Z1, Z2, Z3, and Z4. This means we have 5 zombie clusters, so we print 5 on a new line.
 */
public class ZombieCluster {
    private int ZombieCluster(int n, String[] matrix) {
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                helper(matrix, i, visited);
                count++;
            }
        }
        return count;
    }

    private void helper(String[] matrix, int cur, int[] visited) {
        for (int i = 0; i < matrix[cur].length(); i++) {
            if (visited[i] == 0 && matrix[cur].charAt(i) == '1') {
                visited[i] = 1;
                helper(matrix, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        if (n == 0)
            return;

        String[] matrix = new String[n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.next();
        }

        scanner.close();
        ZombieCluster zombieCluster = new ZombieCluster();
        System.out.println(zombieCluster.ZombieCluster(n, matrix));
    }
}
