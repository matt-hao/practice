package practice.hackTheAlgorithm;

import java.util.*;

public class NextClosetTime {
    private String nextTime;
    private int timeDifference;
    private static int TIMELEN = 4;

    public String nextClosestTime(String time) {
        // write your code here
        if (time == null)
            return null;

        timeDifference = Integer.MAX_VALUE;

        int curTime = convert(time);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 2);
        map.put(1, 9);
        map.put(2, 5);
        map.put(3, 9);
        int[] timeArr = timeIndex(time);
        Arrays.sort(timeArr);
        helper(timeArr, curTime, new ArrayList<Integer>(), map);
        return nextTime;
    }

    private void helper(int[] time, int curTime, List<Integer> permutation, Map<Integer, Integer> timeMap) {
        if (permutation.size() == TIMELEN) {
            int tempNextSec = cal(permutation);
            int timeDiffSec = tempNextSec > curTime ?
                    tempNextSec - curTime : tempNextSec + 86400 - curTime;
            if (timeDiffSec < timeDifference) {
                timeDifference = timeDiffSec;
                nextTime = convertBack(permutation);
            }
            return;
        }
        for (int i = 0; i < TIMELEN; i++) {
            if (i > 0 && time[i - 1] == time[i])
                continue;
            int len = timeMap.get(permutation.size());
            if (permutation.size() == 1) {
                if (permutation.get(0) == 2)
                    len = 3;
            }
            if (time[i] > len)
                continue;

            permutation.add(time[i]);
            helper(time, curTime, permutation, timeMap);
            permutation.remove(permutation.size() - 1);
        }
    }

    private int convert(String time) {
        String[] str = time.split(":");
        return charToInt(str[0].charAt(0)) * 10 * 60 * 60 + charToInt(str[0].charAt(1)) * 60 * 60
                + charToInt(str[1].charAt(0)) * 10 * 60 + charToInt(str[1].charAt(1)) * 60;
    }

    private int charToInt(char a) {
        return Integer.parseInt(String.valueOf(a));
    }

    private String convertBack(List<Integer> time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.size(); i++) {
            sb.append(time.get(i));
            if (i == 1)
                sb.append(":");
        }
        return sb.toString();
    }

    private int cal(List<Integer> permutation) {
        int h1 = permutation.get(0);
        int h2 = permutation.get(1);
        int m1 = permutation.get(2);
        int m2 = permutation.get(3);
        return h1 * 10 * 60 * 60 + h2 * 60 * 60 + m1 * 10 * 60 + m2 * 60;
    }

    private int[] timeIndex(String time) {
        int[] timeArr = new int[TIMELEN];
        String[] str = time.split(":");
        timeArr[0] = charToInt(str[0].charAt(0));
        timeArr[1] = charToInt(str[0].charAt(1));
        timeArr[2] = charToInt(str[1].charAt(0));
        timeArr[3] = charToInt(str[1].charAt(1));
        return timeArr;
    }

    public static void main(String[] args) {
        NextClosetTime nextClosetTime = new NextClosetTime();
        System.out.println(nextClosetTime.nextClosestTime("19:34"));
    }
}
