package interview.natanix;

import java.util.*;

public class Oa {
    public static void main(String[] args) {
        Oa oa = new Oa();
        //nearestPrime
        System.out.println("========nearestPrime=========");
        System.out.println(oa.nearestPrime(10));
        System.out.println(oa.nearestPrime(17));
        System.out.println(oa.nearestPrime(30));

        //brokenCaculator
        System.out.println("========brokenCaculator=========");
        System.out.println(oa.brokenCalc(3, 5));
        System.out.println(oa.brokenCalc(1, 2));

        //Frog Hopping leetcode 45
        System.out.println("========frogHopping=========");
        System.out.println(oa.frogHopping(8, new int[]{2, 1, 4, 3, 2, 5, 1, 6}));
        System.out.println(oa.frogHopping(10, new int[]{4, 3, 2, 6, 8, 3, 1, 9, 6, 2}));

        //Beautiful row
        System.out.println("==========beautifulRow==========");
        System.out.println(oa.beautifulRow(8, new int[]{3, 17, 4, 12, 5, 6, 2, 1})); // 2
        System.out.println(oa.beautifulRow(4, new int[]{1, 2, 100, 9})); // 0

        //paint fence
        System.out.println("==========paintfence==========");
        System.out.println(oa.paintFence(5, new int[]{1, 0, 1, 0, 1}));
        System.out.println(oa.paintFence(2, new int[]{0, 1}));

        //colored loops
        System.out.println("==========coloredLoops===============");
        char[][] loops1 = new char[][]{
                {'B', 'B', 'B', 'B', 'B'},
                {'B', 'G', 'G', 'G', 'B'},
                {'B', 'G', 'B', 'G', 'B'},
                {'B', 'G', 'G', 'G', 'B'},
                {'B', 'B', 'B', 'B', 'B'}
        };
        System.out.println(oa.coloredLoops(loops1));//true
        char[][] loops2 = new char[][]{
                {'A', 'A', 'A', 'A'},
                {'A', 'B', 'C', 'A'},
                {'A', 'A', 'C', 'A'},
        };
        System.out.println(oa.coloredLoops(loops2));//false

        //read all emails
        System.out.println("==========readAllEmail===============");
        System.out.println(oa.readAllEmail(new int[]{0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0})); // 6
        System.out.println(oa.readAllEmail(new int[]{0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1})); // 8
        System.out.println(oa.readAllEmail(new int[]{0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1})); // 10

        //pizza treat
        System.out.println("==========pizza treat==========");
        System.out.println(oa.pizzaTreat(new int[]{1, 2, 1, 2})); //true
        System.out.println(oa.pizzaTreat(new int[]{1, 2, 3})); //true
        System.out.println(oa.pizzaTreat(new int[]{1, 2, 3, 3})); // false

        //cargo port
        System.out.println("===========cargoPort============");
        //cargo port
        // 5 180
        // 30 30 100 90 50
        // 3  3   1   1  3
        // 6
        System.out.println(oa.cargoPort(5, 180, new int[]{30, 30, 100, 90, 50}, new int[]{3, 3, 1, 1, 3}));//6
        //2 150
        //70 60 30
        //2  4  1
        //5
        System.out.println(oa.cargoPort(2, 150, new int[]{70, 60, 30}, new int[]{2, 4, 1}));//5

        //primeString
        System.out.println("===============prime string==============");
        // A  B  c
        // 65 66 99
        // C  C  a
        // 67 67 97
        System.out.println(oa.primeString("ABc"));//CCa
        System.out.println(oa.primeString("CABa"));//CCCa

        /*
         *  Gumball machine
         *  5
         * red green blue red white
         * R(990)
         * R(980) G(990)
         * R(970) G(980) B(990)
         * R(990) G(970) B(980)
         * R(980) W(990) B(970)
         */
        System.out.println("===========gumballMachine==========");
        System.out.println(oa.gumballMachine(new String[]{"red", "green", "blue", "red", "white"}));
        System.out.println(oa.gumballMachine(new String[]{"red", "red"}));

        /*
            Deci-Binary numbers
            4
            1 1 1 1

            21
            10 11
         */
        System.out.println("===============deciBinary=========");
        oa.deciBinary(4);
        oa.deciBinary(21);
        oa.deciBinary(44);

        /*
            stringWeight
         */
        System.out.println("===============stringWeight=========");
        System.out.println(oa.stringWeight("110", 4, 2, 1));//6
        System.out.println(oa.stringWeight("11", 4, 0, 1));//3

        /*
           6 3
           1 3 5 2 5 4
           1 1 0 1 0 0
           16

           4 2
           5 2 1 2
           0 0 1 1
           10
     */
        System.out.println("=========grumpyowner========");
        System.out.println(oa.grumpyBookOwner(6, 3, new int[]{1, 3, 5, 2, 5, 4}, new int[]{1, 1, 0, 1, 0, 0}));//16
        System.out.println(oa.grumpyBookOwner(4, 2, new int[]{5, 2, 1, 2}, new int[]{0, 0, 1, 1}));//10
    }

    private int nearestPrime(int n) {
        if (n <= 2) return -1;
        boolean[] f = new boolean[n + 1];
        f[0] = f[1] = f[n] = true;
        for (int i = 2; i * i <= n; i++) {
            int j = 2 * i;
            while (j < n) {
                f[j] = true;
                j += i;
            }
        }

        for (int i = n - 1; i >= 2; i--) {
            if (!f[i])
                return i;
        }
        return -1;
    }

    //- *
    //get m from n
    // 3 5
    public int brokenCalc(int X, int Y) {
        if (X == Y) return 0;
        if (Y < X) return X - Y;
        return dfs(X, Y, new boolean[2 * Y + 1], new HashMap<>());
    }

    private int dfs(int x, int y, boolean[] v, Map<Integer, Integer> map) {
        if (x >= y) {
            return x - y;
        }

        if (map.containsKey(x)) return map.get(x);
        if (v[x]) {
            return Integer.MAX_VALUE;
        }
        if (x == 0) {
            map.put(0, Integer.MAX_VALUE);
            return Integer.MAX_VALUE;
        }
        v[x] = true;
        int s = Math.min(dfs(x - 1, y, v, map), dfs(x * 2, y, v, map)) + 1;
        map.put(x, s);
        v[x] = false;
        return s;
    }

    //Frog Hopping leetcode 45
    //case1:
    //Input: 8
    //2, 1, 4, 3, 2, 5, 1, 6
    //Output: 3
    //case2:
    //Input: 10
    //4, 3, 2, 6, 8, 3, 1, 9, 6, 2
    //Output:2
    private int frogHopping(int len, int[] arr) {
        if (arr == null || arr.length == 0 || arr.length != len)
            return -1;
        return frogHoppingMethod2(len, arr);
    }

    private int frogHoppingMethod1(int len, int[] arr) {
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] + j >= i && dp[j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[len - 1] == Integer.MAX_VALUE ? -1 : dp[len - 1];
    }

    private int frogHoppingMethod2(int len, int[] arr) {
        int start, end, max, res;
        start = end = max = res = 0;
        while (end < len) {
            res++;
            max = end;
            if (start > max)
                break;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, i + arr[i]);
                if (max >= len - 1)
                    return res;
            }
            start = end + 1;
            end = max;
        }
        return -1;
    }

    private int beautifulRow(int len, int[] arr) {
        if (arr == null || arr.length == 0 || arr.length != len)
            return 0;
        int[] left = new int[len];
        Arrays.fill(left, 1);
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] >= arr[j])
                    left[i] = Math.max(left[i], left[j] + 1);
            }
        }

        int[] right = new int[len];
        Arrays.fill(right, 1);
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] >= arr[j])
                    right[i] = Math.max(right[i], right[j] + 1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            res = Math.min(res, len - (left[i] + right[i + 1]));
        }
        return res;
    }

    private int paintFence(int n, int[] arr) {
        if (arr == null || arr.length != n)
            return 0;
        int cnt = 0;
        int[] pos = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                pos[cnt++] = i + 1;
            }
        }

        if (cnt == 0) return 0;
        int res = 1;
        for (int i = 0; i < cnt - 1; i++) {
            res *= pos[i + 1] - pos[i];
        }
        return res;
    }

    private boolean isLoop;
    private int[] delta;

    private boolean coloredLoops(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        isLoop = false;
        delta = new int[]{0, -1, 0, 1, 0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isLoop) return true;
                if (visited[i][j]) continue;
                visited[i][j] = true;
                helper(matrix, i, j, i, j, visited);
            }
        }
        return isLoop;
    }

    private void helper(char[][] matrix, int x, int y, int prex, int prey, boolean[][] visited) {
        if (isLoop) return;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < 4; i++) {
            int nx = x + delta[i];
            int ny = y + delta[i + 1];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && !(nx == prex && ny == prey) && matrix[nx][ny] == matrix[x][y]) {
                if (visited[nx][ny])
                    isLoop = true;
                visited[nx][ny] = true;
                helper(matrix, nx, ny, x, y, visited);
            }
        }
    }

    //[0,0,0,1,1,0,0,1,0,1,0,0]
    //6
    private int readAllEmail(int[] arr) {
//        if (arr == null || arr.length == 0 || arr.length != n)
//            return 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
            } else if (arr[i] == 0) {
                if (i > 0 && arr[i - 1] == 1)
                    cnt++;
            }
        }
        if (arr[arr.length - 1] == 0) cnt--;
        return cnt;
    }

    //1 2 1 2
    private boolean pizzaTreat(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && prev != 0)
                return false;
            else {
                if ((arr[i] - prev) % 2 == 0)
                    prev = 0;
                else
                    prev = 1;
            }
        }
        return prev == 0;
    }

    //cargo port
    // 5 180
    // 30 30 100 90 50
    // 3  3   1   1  3
    // 6
    private int cargoPort(int climit, int wlimit, int[] nArr, int[] mArr) {
        int cnt = 0;
        int i = 0;
        while (i < nArr.length) {
            int c, w;
            c = w = 0;
            int temp = 2; // loading
            int start = i;
            while (start < nArr.length && c + 1 <= climit && w + nArr[start] <= wlimit) {
                c++;
                w += nArr[start];
                if (start > i && mArr[start] != mArr[start - 1]) {
                    temp++;
                }
                start++;
            }
            i = start;
            cnt += temp;
        }
        return cnt;
    }

    // A  B  c
    // 65 66 99
    // C  C  a
    // 67 67 97
    private String primeString(String str) {
        if (str == null || str.length() == 0) return str;
        boolean[] prime = new boolean[128];
        prime[0] = prime[1] = true;
        for (int i = 2; i * i <= 128; i++) {
            if (prime[i]) continue;
            int j = i * 2;
            while (j < 128) {
                prime[j] = true;
                j += i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < str.length(); k++) {
            char c = str.charAt(k);
            if (!prime[(int) c]) {
                sb.append(c);
                continue;
            }
            int i = (int) c - 1, j = (int) c + 1;
            for (; i >= (int) 'A' && j <= (int) 'z'; i--, j++) {
                if (!prime[i] && ((i <= (int) 'Z') || ((int) 'a' <= i))) {
                    sb.append((char) i);
                    break;
                }
                if (!prime[j] && ((j <= (int) 'Z') || ((int) 'a' <= j))) {
                    sb.append((char) j);
                    break;
                }
            }

            if (sb.length() < k + 1) {
                while (sb.length() < k + 1 && i >= (int) 'A') {
                    if (!prime[i] && ((i <= (int) 'Z') || ((int) 'a' <= i))) {
                        sb.append((char) i);
                        break;
                    }
                    i--;
                }
                while (sb.length() < k + 1 && j <= (int) 'z') {
                    if (!prime[j] && ((j <= (int) 'Z') || ((int) 'a' <= j))) {
                        sb.append((char) j);
                        break;
                    }
                    j++;
                }
            }
        }
        return sb.toString();
    }

    /*
     * 5
     * red green blue red white
     * R(990)
     * R(980) G(990)
     * R(970) G(980) B(990)
     * R(990) G(970) B(980)
     * R(980) W(990) B(970)
     */
    private double gumballMachine(String[] arr) {
        if (arr == null || arr.length == 0)
            return 0.0;
        Map<String, Integer> map = new HashMap<>();
        int discard = 0;
        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, 1000);
            } else {
                if (map.size() < 3) {
                    map.put(s, 1000);
                } else {
                    Map.Entry<String, Integer> min = null;
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (min == null) {
                            min = entry;
                        } else {
                            if (entry.getValue() < min.getValue())
                                min = entry;
                        }
                    }
                    discard += min.getValue();
                    map.remove(min.getKey());
                    map.put(s, 1000);
                }
            }
            for (String key : map.keySet()) {
                map.put(key, map.get(key) - 10);
            }
        }
        return ((double) discard) / 100;
    }

    /*
        deci-binary
        4
        1 1 1 1

        21
        10 11
     */
    private void deciBinary(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int num = n;
            int next = 0, j = 1;
            while (num != 0) {
                int reminder = num % 10;
                num /= 10;
                if (reminder > 0) {
                    next += j;
                }
                j *= 10;
            }
            list.add(next);
            n -= next;
        }
        Collections.sort(list);
        System.out.println(list.size());
        System.out.println(list);
    }

    // 110
    // 4 2 1
    private int stringWeight(String s, int p, int single, int t) {
        int len = s.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = single + dp[i - 1];
            if (i > 1) {
                if (s.charAt(i - 1) == s.charAt(i - 2)) {
                    dp[i] = Math.max(dp[i], dp[i - 2] + p - t);
                } else {
                    dp[i] = Math.max(dp[i], dp[i - 2] + p);
                }
            }
        }
        return dp[len];
    }

    /*
           6 3
           1 3 5 2 5 4
           1 1 0 1 0 0
           16

           4 2
           5 2 1 2
           0 0 1 1
           10
     */
    private int grumpyBookOwner(int t, int p, int[] ctime, int[] gtime) {
        int[] right = new int[t];
        right[t - 1] = gtime[t - 1] == 0 ? 0 : ctime[t - 1];
        for (int i = t - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (gtime[i] == 0 ? 0 : ctime[i]);
        }

        int[] left = new int[t];
        left[0] = gtime[0] == 0 ? 0 : ctime[0];
        for (int i = 1; i < t; i++) {
            left[i] = left[i - 1] + (gtime[i] == 0 ? 0 : ctime[i]);
        }

        int res = Integer.MIN_VALUE;
        int abs = 0;
        for (int i = 0; i < t; i++) {
            abs += Math.abs(ctime[i]);
            if (i >= p - 1) {
                int temp = (i - p >= 0 ? left[i - p] : 0) + abs + (i + 1 < t ? right[i + 1] : 0);
                res = Math.max(res, temp);
                abs -= Math.abs(ctime[i - p + 1]);
            }
        }
        return res;
    }
}
