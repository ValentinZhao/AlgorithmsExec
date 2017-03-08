package CodingInterviews;

import java.util.Scanner;

public class Interview9 {
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(fibonacci(n));
	}
	public static long fibonacci(int n){
		int[] result = new int[]{0, 1};
		if(n < 2){
			return result[n];
		}
		long fibMinusOne = 1;
		long fibMinusTwo = 0;
		long fibN = 0;
		for(int i = 2; i <= n; ++i){
			fibN = fibMinusOne + fibMinusTwo;
			fibMinusTwo = fibMinusOne;
			fibMinusOne = fibN;
		}
		return fibN;
	}
}
