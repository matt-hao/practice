package primary.other;

import java.util.LinkedList;
import java.util.List;

/**
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalGenerate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new LinkedList<>();
        if (numRows == 0) {
            return lists;
        }

        for (int i = 0; i < numRows; i++) {
            lists.add(new LinkedList<>());
        }

        lists.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            for (int j = 0; j < lists.get(i - 1).size(); j++) {
                if (j == 0)
                    lists.get(i).add(lists.get(i - 1).get(j));
                else
                    lists.get(i).add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                if (j == lists.get(i - 1).size() - 1)
                    lists.get(i).add(lists.get(i - 1).get(j));
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        PascalGenerate pascalGenerate = new PascalGenerate();
        List<List<Integer>> lists = pascalGenerate.generate(5);
        lists.forEach(System.out::println);
    }
}
