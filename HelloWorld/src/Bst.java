/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 *
 * Example:
 *
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Bst {
    public int method(int a) {
        return bst(a, new int[a + 1]);
    }

    int bst(int a, int[] b) {
        if (b[a] != 0)
            return b[a];

        int count = 0;
        if (a == 0 || a == 1) {
            return b[a] = 1;
        }

        for (int i = 0; i < a; i++)
            count += bst(i, b) * bst(a - 1 - i, b);

        b[a] = count;
        return b[a];
    }

    public static void main(String[] args) {
        Bst bst = new Bst();
        System.out.println(bst.method(2));
        System.out.println(bst.method(3));
        System.out.println(bst.method(4));
        System.out.println(bst.method(19));
    }
}
