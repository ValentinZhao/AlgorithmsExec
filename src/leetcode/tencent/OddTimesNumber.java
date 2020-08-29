package tencent;

public class OddTimesNumber {
    public static int find(int[] arr) {
        int res = 0;
        for (int n : arr) {
            res ^= n;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,5,5,6,6,6,7,7};
        System.out.println(find(arr));
    }
}
