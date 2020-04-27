package practice.hackTheAlgorithm;

public class StringReplace {
    public String stringReplace(String[] a, String[] b, String s) {
        // Write your code here
        if (a == null || b == null || a.length == 0 || b.length == 0)
            return s;

        if (s == null || s.length() == 0)
            return "";

        int lenTemp = 0;
        int pos = Integer.MAX_VALUE;
        int index = 0;
        int start = 0;

        for (int i = 0; i < s.length(); ) {
            for (int j = 0; j < a.length; j++) {
                int curPos = s.indexOf(a[j], i);
                if (curPos != -1) {
                    if (curPos <= pos) {
                        if (a[j].length() > lenTemp) {
                            pos = curPos;
                            lenTemp = a[j].length();
                            index = j;
                            start = pos + lenTemp;
                        }
                    }
                }
            }


            if (start > 0) {
                s = s.substring(0, pos) + b[index] + s.substring(pos + lenTemp);
                i = start;
            } else {
                break;
            }
            start = 0;
            pos = Integer.MAX_VALUE;
            lenTemp = 0;
        }
        return s;
    }

    public static void main(String[] args) {
        StringReplace stringReplace = new StringReplace();
        String[] a = {"cd", "dab", "ab"};
        String[] b = {"cc", "aaa", "dd"};
        String s = "cdab"; //"ccdd"
        System.out.println(stringReplace.stringReplace(a, b, s));
    }

}
