package companys;

import java.util.Scanner;

public class FishingRace {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int x = s.nextInt() - 1;
		int y = s.nextInt() - 1;
		int t = s.nextInt();
		s.nextLine();
		double[][] rect = new double[n][m];
		for(int i = 0; i < n; i++){
			String[] content = s.nextLine().split(" ");
			for(int j = 0; j < m; j++){
				rect[i][j] = Double.parseDouble(content[j]);
			}
		}
		fish(rect, rect[x][y], t);
	}

	private static void fish(double[][] rect, double cc, int t) {
		double ss = 0;
		for(int i = 0; i < rect.length; i++){
			for(int j = 0; j < rect[0].length; j++){
				ss += rect[i][j];
			}
		}
		ss /= (rect.length * rect[0].length);
		if(ss > cc){
			System.out.println("ss");
			System.out.println(String.format("%.2f", 1 - Math.pow(1- ss, t)));
		} else if(ss < cc){
			System.out.println("cc");
			System.out.println(String.format("%.2f", 1 - Math.pow(1 - cc, t)));
		} else {
			System.out.println("equal");
			System.out.println(String.format("%.2f", 1 - Math.pow(1 - ss, t)));
		}
	}
}
