import java.util.Scanner;

/**
 * test
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }

    public int maximum69Number (int num) {
        int max = num;
        char[] arr = (num + "").toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 9) continue;
            arr[i] = 9;
            max = Math.max(max, Integer.parseInt(String.valueOf(arr)));
            arr[i] = 6;
        }
        return max;
    }
}