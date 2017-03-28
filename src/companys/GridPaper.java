package companys;

import java.util.Arrays;
import java.util.Scanner;

public class GridPaper {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i < n; i++){
			x[i] = s.nextInt();
			y[i] = s.nextInt();
		}
		Arrays.sort(x);
		Arrays.sort(y);
		int edge = (x[n - 1] - x[0]) > (y[n - 1] - y[0]) ? (x[n - 1] - x[0]) : (y[n - 1] - y[0]);
		System.out.println((int) Math.pow(edge, 2));
	}
}
