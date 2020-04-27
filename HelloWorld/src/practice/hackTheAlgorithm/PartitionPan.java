package practice.hackTheAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PartitionPan {
    public static void main(String[] args) {
        PartitionPan p = new PartitionPan();
        System.out.println(p.palindromePartition("aabbc", 2));
    }

    public int palindromePartition(String s, int k) {
        return method2(s, k);
    }

    private void build(int[][][] dp, String s) {
        for (int i = 0; i < s.length(); i++) {
            //odd
            int cnt = 0;
            for (int l = i, r = i; l >= 0 && r < s.length(); l--, r++) {
                if (s.charAt(l) != s.charAt(r))
                    cnt++;
                dp[l][r][1] = Math.min(dp[l][r][1], cnt);
            }

            //even
            cnt = 0;
            for (int l = i - 1, r = i; l >= 0 && r < s.length(); l--, r++) {
                if (s.charAt(l) != s.charAt(r))
                    cnt++;
                dp[l][r][1] = Math.min(dp[l][r][1], cnt);
            }
        }
    }

    private int method1(String s, int k) {
        if (s.length() == k) return 0;
        int len = s.length();
        int[][][] dp = new int[len][len][k + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int m = 0; m <= k; m++) {
                    dp[i][j][m] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < len; i++) {
            dp[i][i][1] = 0;
        }

        build(dp, s);

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i + l - 1 < len; i++) {
                int j = i + l - 1;
                for (int m = 1; m <= k; m++) {
                    for (int t = i; t < j; t++) {
                        if (dp[i][t][1] == Integer.MAX_VALUE || dp[t + 1][j][m - 1] == Integer.MAX_VALUE)
                            continue;
                        dp[i][j][m] = Math.min(dp[i][j][m], dp[i][t][1] + dp[t + 1][j][m - 1]);
                    }
                }
            }
        }

        return dp[0][len - 1][k];
    }

    private int method2(String s, int k) {
        // index + k
        return helper(s, 0, k, new HashMap<>(), buildDp(s));
    }

    private int helper(String s, int index, int k, Map<String, Integer> map, int[][] dp) {
        String key = index + "/" + k;
        if (map.containsKey(key)) map.get(key);

        if (s.length() - index < k) {
            map.put(key, Integer.MAX_VALUE);
            return map.get(key);
        }
        if (s.length() - index == k || index == s.length()) {
            map.put(key, 0);
            return 0;
        }

        if (k == 1) {
            return dp[index][s.length() - 1];
        }

        int res = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            int next = helper(s, i + 1, k - 1, map, dp);
            if (next == Integer.MAX_VALUE)
                continue;
            res = Math.min(res, dp[index][i] + next);
        }
        map.put(key, res);
        return res;
    }

    // a a a a a a
    private int[][] buildDp(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int l = i, r = i; l >= 0 && r < len; l--, r++) {
                if (s.charAt(l) != s.charAt(r))
                    cnt++;
                dp[l][r] = Math.min(dp[l][r], cnt);
            }
            cnt = 0;
            for (int l = i - 1, r = i; l >= 0 && r < len; l--, r++) {
                if (s.charAt(l) != s.charAt(r))
                    cnt++;
                dp[l][r] = Math.min(dp[l][r], cnt);
            }
        }
        return dp;
    }
}
