package practice.hackTheAlgorithm;

public class SuperPanlindrome {

    public int superpalindromesInRange(String L, String R) {
        int[] arr = new int[18];
        int cnt = 0;
        for(int i = 1; i < Integer.MAX_VALUE; i++){
            if(valid(i)){
                changeArr(i, arr);
                if(com(L, R, arr) && validArr(arr))
                    cnt++;
                reset(arr);
            }
        }
        return cnt;
    }

    private boolean valid(int a){
        long n = a;
        long c = 0;
        while(n > 0){
            c = c * 10 + n % 10;
            n /= 10;
        }
        return c == a;
    }

    private boolean validArr(int[] arr){
        int idx = 0;
        for(; idx < 18; idx++){
            if(arr[idx] != 0)
                break;
        }
        for(int i = idx, j = 17; i < j; i++, j--){
            if(arr[i] == arr[j])
                continue;
            return false;
        }
        return true;
    }

    private void changeArr(int num, int[] arr){
        char[] vArr = (num + "").toCharArray();
        int len = vArr.length;
        int[] a = new int[len + len];
        int i, j;
        for(i = len - 1; i >= 0; i--){
            int carry = 0;
            for(j = len - 1; j >= 0; j--){
                int temp = carry + (vArr[i] - '0') * (vArr[j] - '0') + a[i + j + 1];
                a[i + j + 1] = temp % 10;
                carry = temp / 10;
            }
            a[i + j + 1] = carry;
        }

        int cnt = 0;
        for(int k = a.length - 1; k >= 0; k--){
            arr[17 - cnt++] = a[k];
        }
    }

    private void reset(int[] arr){
        for(int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
    }

    private boolean com(String L, String R, int[] arr){
        char[] l = L.toCharArray();
        char[] r = R.toCharArray();

        int idx = 0;
        for(; idx < 18; idx++){
            if(arr[idx] != 0)
                break;
        }

        int len = 18 - idx;
        if(len < l.length || len > r.length){
            return false;
        }

        if(len == l.length && !compareNumAndArr(idx, L, arr)){
            return false;
        }

        if(len == r.length && !compareNumAndArr(idx, R, arr)){
            return false;
        }

        return true;
    }

    private boolean compareNumAndArr(int idx, String str, int[] arr){
        int s = 0;
        for(int i = idx; i < 18; i++){
            if(arr[i] == str.charAt(s) - '0'){
                s++;
                continue;
            }
            // System.out.println(i + "," + str.length() + "," + s + "," + str);
            if(arr[i] < (str.charAt(s++) - '0'))
                return false;
            else return true;
        }
        return true;
    }
}
