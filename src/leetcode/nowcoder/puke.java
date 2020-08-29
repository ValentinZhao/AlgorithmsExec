package nowcoder;

import java.util.Scanner;

public class puke {
    public static int min = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pukes = new int[10];
        int count = 0;
        while (in.hasNextInt()) {
            for (int i = 0; i < 10; i++) {
                int num = in.nextInt();
                pukes[i] = num;
            }

//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
        }
    }

    private static void dfs(int[] pukes, int sum) {
        boolean flag = pukes[5] == 0;
        int index1 = 0, index2 = 9;
        for (int i = 4; i >= 0; i--) {
            if (pukes[i] == 0) {
                index1 = i;
                break;
            }
        }
        for (int i = 5; i <= 9; i++) {
            if (pukes[i] == 0) {
                index2 = i;
                break;
            }
        }
        if (flag || !flag && (index2-index1) < 5) {
            int res = 0;
            for (int i = 0; i < 10; i++) {
                if (pukes[i] != 0) {
                    res++;
                }
            }
            min = Math.min(min, res+sum);
        }
        A:
        for (int i = 0; i < 5; i++) {
            int j = i, count = 0;
            for (; j<10;j++) {
                if (pukes[j]==0 && j-i < 5) continue A;
                if (pukes[j]==0) count=j-i;
                else if (j==pukes.length-1) count=j-i+1;
            }
            while (count!=4) {
                for (int k = i; k < i +count; k++) pukes[k]--;
                dfs(pukes, 1+sum);
                for (int k = i; k < i + count; k++) pukes[k]++;
                count--;
            }
        }
    }
}
