package companys;

import java.util.Scanner;

public class AverageAge {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			double W = s.nextDouble();
			double y = s.nextDouble();
			double x = s.nextDouble();
			int N = s.nextInt();
            while(N-- > 0){
                y = (y + 1) * (1 - x) + x * 21;//主要是没注意到随着年龄的增长公司老员工的平均年龄也在上涨！
            }
            System.out.println((int) Math.ceil(y));
		}
		s.close();
	}
}
