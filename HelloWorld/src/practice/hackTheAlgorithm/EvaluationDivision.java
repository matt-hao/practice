package practice.hackTheAlgorithm;

import java.util.*;

public class EvaluationDivision {
    private double val;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> res = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(0).equals(queries.get(i).get(1))) {
                result[i] = res.containsKey(queries.get(i).get(0)) ? 1.0 : -1.0;
                continue;
            }
            result[i] = valid(queries.get(i), res) ? val : -1.0;
        }
        return result;
    }


    private boolean valid(List<String> equation, Map<String, Map<String, Double>> map) {
        String start = equation.get(0);
        String end = equation.get(1);
        if (!(map.containsKey(start) && map.containsKey(end))) {
            return false;
        }
        val = Double.MAX_VALUE;
        Set<String> visited = new HashSet<>();
        visited.add(start);
        visited.add(end);
        helper(start, end, 1.0, visited, map);
        return val != Double.MAX_VALUE;
    }

    private void helper(String start, String end, double carry, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (val != Double.MAX_VALUE)
            return;
        Map<String, Double> neighbors = map.get(start);
        if (neighbors.containsKey(end)) {
            val = carry * neighbors.get(end);
            return;
        }
        for (String key : neighbors.keySet()) {
            if (visited.contains(key))
                continue;
            visited.add(key);
            helper(key, end, carry * neighbors.get(key), visited, map);
            visited.remove(key);
        }
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> res = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            if (!res.containsKey(equations.get(i).get(0))) {
                res.put(equations.get(i).get(0), new HashMap<>());
            }
            Map<String, Double> second = res.get(equations.get(i).get(0));
            second.put(equations.get(i).get(1), values[i]);

            if (!res.containsKey(equations.get(i).get(1))) {
                res.put(equations.get(i).get(1), new HashMap<>());
            }
            second = res.get(equations.get(i).get(1));
            second.put(equations.get(i).get(0), 1 / values[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        EvaluationDivision evaluationDivision = new EvaluationDivision();
        //equations = [ ["a", "b"], ["b", "c"] ],
        //values = [2.0, 3.0],
        //queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
//        String[][] equations = {{"a", "b"}, {"b", "c"}};
//        double[] values = {2.0, 3.0};
//        String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
//        System.out.println(Arrays.toString(evaluationDivision.calcEquation(equations, values, queries)));
    }
}
