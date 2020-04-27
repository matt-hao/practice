package practice.hackTheAlgorithm;

public class ImplementStrStr {
    //brute force
//    public int strStr(String haystack, String needle) {
//        if (haystack == null || needle == null || needle.length() == 0)
//            return 0;
//
//        if (haystack.length() < needle.length())
//            return -1;
//
//        for (int i = 0; i < haystack.length(); i++) {
//            if (haystack.charAt(i) == needle.charAt(0)) {
//                int j = 0;
//                for (int k = i; j < needle.length() && k < haystack.length(); k++, j++) {
//                    if (needle.charAt(j) != haystack.charAt(k))
//                        break;
//                }
//                if (j == needle.length())
//                    return i;
//            }
//
//        }
//        return -1;
//    }

    //aaabbbabab
    //aaabb

    //kp algorithm, use the concept of hashcode
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() == 0)
            return 0;
        int m = needle.length();
        if (haystack.length() < m) {
            return -1;
        }

        int base = 1000000;
        int pw = 1;

        //calculate the power
        for (int i = 0; i < m; i++) {
            pw = (pw * 31) % base;
        }

        //calculate the hashCode of needle
        int nHash = 0;
        for (int i = 0; i < m; i++) {
            nHash = (nHash * 31 + needle.charAt(i)) % base;
        }

        //calculate the hashCode of hayStack
        int hHash = 0;
        for (int i = 0; i < haystack.length(); i++) {
            hHash = (hHash * 31 + haystack.charAt(i)) % base;

            if (i < m - 1)
                continue;

            if (i >= m) {
                hHash = hHash - (haystack.charAt(i - m) * pw) % base;
                if (hHash < 0)
                    hHash += base;
            }

            if (hHash == nHash) {
                if (haystack.substring(i - m + 1, i + 1).equals(needle))
                    return i - m + 1;
            }

        }

        return -1;
    }

    //"aabaaabaaac"
    //"aabaaac"
    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("aabaaabaaac", "aabaaac"));
    }
}
