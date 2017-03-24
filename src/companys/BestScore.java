package companys;

import java.util.Scanner;

public class BestScore {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int N = 0;
		int M = 0;
		int A = 0;
		int B = 0;
		while(in.hasNext()){
			N = in.nextInt();
			M = in.nextInt();
			int[] scores = new int[N];
			for(int i = 0; in.hasNext() && i < N; i++){
				scores[i] = in.nextInt();
			}
			String cursor = null;
			for(int i = 0; in.hasNext() && i < M; i++){
				cursor = in.next();
				A = in.nextInt();
				B = in.nextInt();
				operate(cursor, A, B, scores);
			}		
		}
	}

	private static void operate(String c, int a, int b, int[] scores) {
		int begin = 0, end = 0;
		if(c.equals("Q")){
			begin = Math.min(a, b) - 1;
			end = Math.max(a, b);
			int max = scores[begin];
			for(int i = begin; i < end; i++){
				if(max < scores[i]){
					max = scores[i];
				}
			}
			System.out.println(max);
		} else if(c.equals("U")){
			scores[a - 1] = b;
		}
	}
}
