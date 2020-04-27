package interview.amazon.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Amazon prime Air / Optimal Utilization
 */
public class PrimeAir_TwoSum {
    public List<List<Integer>> method(int maxTravelDist, List<List<Integer>> forwardR, List<List<Integer>> returnR) {
        Collections.sort(forwardR, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        Collections.sort(returnR, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1) - o2.get(1);
            }
        });

        int start = 0, end = returnR.size() - 1;
        List<List<Integer>> res = new ArrayList<>();
        int optDist = 0;
        while (start < forwardR.size() && end >= 0) {
            int sum = forwardR.get(start).get(1) + returnR.get(end).get(1);
            if (sum > maxTravelDist) {
                end--;
            } else {
                if (sum == optDist) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(forwardR.get(start).get(0));
                    pair.add(returnR.get(end).get(0));
                    res.add(pair);
                } else if (sum > optDist) {
                    optDist = sum;
                    res.clear();
                    List<Integer> pair = new ArrayList<>();
                    pair.add(forwardR.get(start).get(0));
                    pair.add(returnR.get(end).get(0));
                    res.add(pair);
                }
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int maxTravelDist1 = 7000;
        //test case 1
        List<List<Integer>> forwardR1 = new ArrayList<>() {
            {
                add(new ArrayList<>() {{
                    add(1);
                    add(2000);
                }});
                add(new ArrayList<>() {{
                    add(2);
                    add(4000);
                }});
                add(new ArrayList<>() {{
                    add(3);
                    add(6000);
                }});
            }
        };

        List<List<Integer>> returnR1 = new ArrayList<>() {
            {
                add(new ArrayList<>() {{
                    add(1);
                    add(2000);
                }});
            }
        };
        System.out.println(new PrimeAir_TwoSum().method(maxTravelDist1, forwardR1, returnR1));
        //test case 2
        int maxTravelDist2 = 10000;
        List<List<Integer>> forwardR2 = new ArrayList<>() {
            {
                add(new ArrayList<>() {{
                    add(1);
                    add(3000);
                }});
                add(new ArrayList<>() {{
                    add(2);
                    add(5000);
                }});
                add(new ArrayList<>() {{
                    add(3);
                    add(7000);
                }});
                add(new ArrayList<>() {{
                    add(4);
                    add(10000);
                }});
            }
        };

        List<List<Integer>> returnR2 = new ArrayList<>() {
            {
                add(new ArrayList<>() {{
                    add(1);
                    add(2000);
                }});
                add(new ArrayList<>() {{
                    add(2);
                    add(3000);
                }});
                add(new ArrayList<>() {{
                    add(3);
                    add(4000);
                }});
                add(new ArrayList<>() {{
                    add(4);
                    add(5000);
                }});
            }
        };
        System.out.println(new PrimeAir_TwoSum().method(maxTravelDist2, forwardR2, returnR2));
    }
}
