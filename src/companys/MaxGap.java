package companys;

import java.util.Scanner;

public class MaxGap {
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            int maxFull = Integer.MIN_VALUE;
            int minMaxGap = Integer.MAX_VALUE;
            for(int i = 1; i < n; i++){
                maxFull = Math.max(maxFull, arr[i] - arr[i - 1]);
            }
            for(int i = 1; i < n - 1; i++){
                minMaxGap = Math.min(minMaxGap, Math.max(arr[i+1]-arr[i-1], maxFull));
            }
            System.out.println(minMaxGap);
        }
        in.close();
    }
}
