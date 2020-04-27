package primary.string;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "olleh"
 * Example 2:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class StringReverse {
    //O(n),T(n)
    public String reverseString(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(s.length() - 1 - i);
        }
        return new String(c);
    }

    //O(n),T(n/2)
    public String reverseString1(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < Math.ceil(s.length() / 2); i++) {
            c[i] = s.charAt(s.length() - 1 - i);
            c[s.length() - 1 - i] = s.charAt(i);
        }
        if (s.length() % 2 == 1)
            c[s.length() / 2] = s.charAt(s.length() / 2);
        return new String(c);
    }

    public static void main(String[] args) {
        String s = "hello";
        String s1 = "A man, a plan, a canal: Panama";
        StringReverse stringReverse = new StringReverse();
        System.out.println(stringReverse.reverseString(s));

        System.out.println(stringReverse.reverseString1(s1));
    }
}
