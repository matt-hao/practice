package practice.hackTheAlgorithm;

public class DeleteOneDigit {
    public static void main(String[] args) {
        //If s = '3ab' and t = 'cd', return 1. If s = '123ab' and t = '423cd', return 6.
        DeleteOneDigit deleteOneDigit = new DeleteOneDigit();
        System.out.println(deleteOneDigit.deleteMethod("3ab", "cd"));
        System.out.println(deleteOneDigit.deleteMethod("123ab", "423cd"));
    }

    private int deleteMethod(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return 0;
        int way = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                String temp = s.substring(0, i) + s.substring(i + 1);
                if (temp.compareTo(t) < 0) way++;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (Character.isDigit(t.charAt(i))) {
                String temp = t.substring(0, i) + t.substring(i + 1);
                if (s.compareTo(temp) < 0) way++;
            }
        }
        return way;
    }


}
