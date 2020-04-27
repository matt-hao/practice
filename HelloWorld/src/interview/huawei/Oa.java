package interview.huawei;

import java.util.*;

public class Oa {
    // Scanner scanner = new Scanner(System.in);
    //        int a = scanner.nextInt();
    //        scanner.nextLine();
    //        int b = scanner.nextInt();
    //        scanner.nextLine();
    //        String temp = scanner.nextLine();
    //
    //        String[] strs = temp.split(" ");
    //        System.out.println("a = " + a);
    //        System.out.println("b = " + b);
    //        System.out.println("arr = " + Arrays.toString(strs));
    public static void main(String[] args) {
//        System.out.println(method1());
        method2();
    }

    // Test1,3
    // Test1,7
    // morale1, 7
    // morale3, 6
    // morale1, 4
    // aaaaaasdf, 5
    private static int method1() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String temp = "";
        while (scanner.hasNextLine()) {
            temp = scanner.nextLine();
            String[] str = temp.split(",");
            map.put(str[0], map.getOrDefault(str[0], 0) + Integer.parseInt(str[1]));
        }

        int res = 0;
        for (int n : map.values()) {
            if (n >= 10) res++;
        }

        return res;
    }

    // 5
    // Apple 1 80
    // Apple 2 62
    // Apple 4 73
    // Orange 4 65
    // Orange 1 90
    // Apple 3 91
    // Orange 3 88
    // Orange 5 90
    // 种类-> 重量->id
    private static void method2() {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        LinkedHashMap<String, List<Wrap>>  map = new LinkedHashMap<>();
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            String[] arr = temp.split(" ");
            if(map.containsKey(arr[0])){
                map.put(arr[0], new ArrayList<>());
            }
            map.get(arr[0]).add(new Wrap(Integer.parseInt(arr[1]), Integer.parseInt(arr[2])));
        }

        for(List<Wrap> l : map.values()){
            Collections.sort(l);
        }

        for (Map.Entry<String, List<Wrap>> e: map.entrySet()){
            for (Wrap w: e.getValue()){
                System.out.println(e.getKey() + " " + w.id + " " + w.weight);
            }
        }
    }

    static class Wrap implements Comparable<Wrap> {
        int id;
        int weight;

        public Wrap(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Wrap o) {
            if (this.weight == o.weight) {
                return this.id - o.id;
            }
            return this.weight - o.weight;
        }
    }
}