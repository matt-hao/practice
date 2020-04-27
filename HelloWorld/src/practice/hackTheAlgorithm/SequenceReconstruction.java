package practice.hackTheAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        if (org == null || seqs == null || seqs.length == 0)
            return false;
        if (org.length == 0 && seqs[0].length == 0)
            return true;
        int m = org.length;
        int[] degree = new int[m + 1];
        ArrayList<Integer>[] neighbors = new ArrayList[m + 1];

        for (int i = 0; i < seqs.length; i++) {
            if (seqs[i].length == 1)
                degree[seqs[i][0]]++;
            for (int j = 0; j < seqs[i].length - 1; j++) {
                degree[seqs[i][j + 1]]++;
                if (neighbors[seqs[i][j]] == null)
                    neighbors[seqs[i][j]] = new ArrayList<>();
                neighbors[seqs[i][j]].add(seqs[i][j + 1]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0)
                queue.offer(i);
        }


        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1)
                return false;
            count++;
            int num = queue.poll();
            for (int i = 0; neighbors[num] != null && i < neighbors[num].size(); i++) {
                degree[neighbors[num].get(i)]--;
                if (degree[neighbors[num].get(i)] == 0)
                    queue.offer(neighbors[num].get(i));
            }
        }

        if (count != m)
            return false;
        return true;
    }

    public static void main(String[] args) {
        SequenceReconstruction s = new SequenceReconstruction();
        System.out.println(s.sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }
}
