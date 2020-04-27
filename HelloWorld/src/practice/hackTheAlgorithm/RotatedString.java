package practice.hackTheAlgorithm;

public class RotatedString {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length())
            return false;
        int m = A.length();
        if (m == 0)
            return true;

        int lastPos = B.lastIndexOf(A.charAt(0));
        for (int i = 0; i < m; i++) {
            int pos = B.indexOf(A.charAt(0), i);
            if (pos == -1)
                return false;
            for (int j = 0; j < m; j++) {
                if (pos == lastPos && A.charAt(j) != B.charAt((j + pos) % m))
                    return false;
                else if (A.charAt(j) != B.charAt((j + pos) % m))
                    break;
            }
            if(pos == lastPos)
                break;
            i = pos;
        }
        return true;
    }

    public static void main(String[] args) {
        RotatedString r = new RotatedString();
        System.out.println(r.rotateString("abcde", "cdeab"));
    }
}
