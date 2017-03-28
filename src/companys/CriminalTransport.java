package companys;

import java.util.Scanner;

public class CriminalTransport {
	 public static void main(String[] args){
			Scanner s = new Scanner(System.in);
			while(s.hasNext()){
	        int n = s.nextInt();
	        int t = s.nextInt();
	        int c = s.nextInt();
			int[] a = new int[n];
			for(int i = 0; i < n; i++){
				a[i] = s.nextInt();
			}
			int count = 0;
			int curSum = 0;
			for(int i = 0; i < c; i++){
	            curSum += a[i];
	        }
	            if(curSum <= t) count++;
	        for(int i = c; i < a.length; i++){
	            curSum += a[i] - a[i - c];//利用滑动窗口思想，每次向前滑动后要去掉最开始的那个值
	            if(curSum <= t) count++;
	        }
			System.out.println(count);
	        }
	        s.close();
		}
}
