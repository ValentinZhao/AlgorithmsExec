package companys;

import java.util.Scanner;

public class MoveTable {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int r = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
		int x1 = s.nextInt();
		int y1 = s.nextInt();
		double dx = Math.abs((x1 - x)) % (2 * r);
		double dy = Math.abs((y1 - y)) % (2 * r);
		double z = Math.sqrt(dx * dx + dy * dy);
		int step=(int) (z/(2*r))+(int)(Math.abs((x1-x))/(2*r))+(int)(Math.abs((y1-y))/(2*r));
		if(z % (2 * r) != 0){
			step++;
		}
		System.out.println(step);
		s.close();
	}
}
