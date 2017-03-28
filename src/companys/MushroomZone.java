package companys;

import java.util.Scanner;

public class MushroomZone {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		boolean[][] map = new boolean[n][m];
		for(int i = 0; i < k; i++){
			int x = s.nextInt() - 1;
			int y = s.nextInt() - 1;
			map[x][y] = true;
		}
		double[][] cw = new double[n][m];
		cw[0][0] = 1;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(map[i][j]) cw[i][j] = 0;
				else if(i == 0 && j == 0){
				} else {
					cw[i][j] = (j-1<0?0:(i+1<n?cw[i][j-1]*0.5:cw[i][j-1]))+(i-1<0?0:(j+1<m?cw[i-1][j]*0.5:cw[i-1][j]));
				}
			}
		}
		double res = cw[n-1][m-1];
		System.out.println(String.format("%.2f", res));
	}
}
