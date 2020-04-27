package practice.hackTheAlgorithm;

import java.util.*;

public class CourseScheduel2 {

    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        int[] courses = new int[numCourses];
        int[] degree = new int[numCourses];
        ArrayList<Integer>[] neighbors = new ArrayList[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            if (neighbors[prerequisites[i][1]] == null) {
                neighbors[prerequisites[i][1]] = new ArrayList<>();
            }
            neighbors[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            courses[count++] = course;
            if (neighbors[course] == null)
                continue;
            for (int i = 0; i < neighbors[course].size(); i++) {
                int degreeCourse = neighbors[course].get(i);
                degree[degreeCourse]--;
                if (degree[degreeCourse] == 0)
                    queue.offer(degreeCourse);
            }
        }

        if (count != numCourses)
            return new int[0];

        return courses;
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        // write your code here

        Set<Integer>[] course = new HashSet[numCourses];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int in = prerequisites[i][0];
            int out = prerequisites[i][1];
            // if(!map.containsKey(out))
            //     map.put(out, 0);
            if (!map.containsKey(in))
                map.put(in, 0);
            map.put(in, map.get(in) + 1);

            if (course[out] == null) {
                course[out] = new HashSet<>();
            }
            course[out].add(in);
        }

        for (int i = 0; i < numCourses; i++) {
            if (map.containsKey(i))
                continue;
            map.put(i, 0);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int n : map.keySet()) {
            if (map.get(n) == 0)
                queue.offer(n);
        }

        if (queue.isEmpty())
            return new int[0];

        int[] result = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            result[count++] = temp;
            if (course[temp] == null)
                continue;
            for (int n : course[temp]) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0)
                    queue.offer(n);
            }
        }

        if (count == numCourses) {
            return result;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        CourseScheduel2 courseScheduel2 = new CourseScheduel2();
        int[][] a = new int[][]{
                {5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}
        };
        System.out.println(Arrays.toString(courseScheduel2.findOrder1(10, a)));

    }
}
