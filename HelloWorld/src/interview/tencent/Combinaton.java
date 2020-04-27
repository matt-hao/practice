package interview.tencent;

import java.util.*;

public class Combinaton {

    private static int least;

    private static List<Integer> globalList = new ArrayList<>();

    private int leastMoney(int target, Set<Integer> set) {
        int[] nums = new int[set.size()];
        int count = 0;
        for (int a : set) {
            nums[count++] = a;
        }
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= target; i++) {
            helper(nums, i, 0, new ArrayList<>());
            least = Integer.MAX_VALUE;
            if(globalList.size() == 0)
                return -1;
            list.add(new ArrayList<>(globalList));
        }
        List<Integer> min = new ArrayList<>();
        for (List<Integer> a : list) {
            min = mergeTwoList(min, a);
        }

        return min.size();
    }

    private List<Integer> mergeTwoList(List<Integer> list1, List<Integer> list2) {
        int index1 = 0, index2 = 0;
        List<Integer> temp = new ArrayList<>();
        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1).equals(list2.get(index2))) {
                temp.add(list1.get(index1));
                index1++;
                index2++;
            } else if (list1.get(index1) < list2.get(index2)) {
                temp.add(list1.get(index1));
                index1++;
            } else {
                temp.add(list2.get(index2));
                index2++;
            }
        }
        while (index1 < list1.size()) {
            temp.add(list1.get(index1++));
        }
        while (index2 < list2.size()) {
            temp.add(list2.get(index2++));
        }
        return temp;
    }

    private void helper(int[] nums, int target, int index, List<Integer> subsets) {
        if (target < 0 || index >= nums.length)
            return;
        if (target == 0) {
            if (subsets.size() < least) {
                least = Math.min(least, subsets.size());
                globalList.clear();
                globalList.addAll(subsets);
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            subsets.add(nums[i]);
            helper(nums, target - nums[i], i, subsets);
            subsets.remove(subsets.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = 0;
        int row = 0;
        String firstRow = "";
        if (scanner.hasNextLine()) {
            firstRow = scanner.nextLine();
        }

        String[] pair = firstRow.split(" ");
        target = Integer.parseInt(pair[0]);
        row = Integer.parseInt(pair[1]);

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < row; i++) {
            set.add(Integer.parseInt(scanner.nextLine()));
        }

        least = Integer.MAX_VALUE;

        Combinaton combinaton = new Combinaton();
        System.out.println(combinaton.leastMoney(target, set));
    }
}
