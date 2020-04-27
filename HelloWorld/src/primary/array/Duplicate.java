package primary.array;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if(!set.add(i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,1};
        int[] a2 = {1,2,3,4};
        int[] a3 = {1,1,1,3,3,4,3,2,4,2};
        Duplicate duplicate = new Duplicate();
        System.out.println(duplicate.containsDuplicate(a1));
        System.out.println(duplicate.containsDuplicate(a2));
        System.out.println(duplicate.containsDuplicate(a3));
    }
}
