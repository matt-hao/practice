package primary.sort_search;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version.
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion {

    private boolean[] arr;

    public FirstBadVersion(boolean[] arr) {
        this.arr = arr;
    }

    public int firstBadVersion(int n) {
        if (n == 0)
            return 0;
        int left = 1, right = n;
        while (left < right) {
            int middle = left + (right - left) / 2;// this is smart way to handle over the overstackflow
            if (isBadVersion(middle))
                right = middle;
            else
                left = middle + 1;
        }
        return left;
    }

    boolean isBadVersion(int version) {
        return this.arr[version];
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion(new boolean[]{false, true, true});
        System.out.println(firstBadVersion.firstBadVersion(firstBadVersion.arr.length - 1));
    }
}
