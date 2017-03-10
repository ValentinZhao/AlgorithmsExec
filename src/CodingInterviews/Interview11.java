package CodingInterviews;

import java.util.Scanner;

public class Interview11 {
	public static boolean isValidInput = true;
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		double base = s.nextDouble();
		int exp = s.nextInt();
		System.out.println(power(base, exp));
	}
	public static double power(double base, int exponent){
		if(doubleEquals(base, 0.0) && exponent < 0){
			isValidInput = false;
			return 0.0;
		}
		int absExponent = Math.abs(exponent);
		double result = powerWithAbsExp(base, absExponent);
		if(exponent < 0){
			result = 1 / result;
		}
		return result;
	}
	private static double powerWithAbsExp(double base, int absExponent) {
		double result = 1.0;
		for(int i = 1; i <= absExponent; ++i){
			result *= base;
		}
		return result;
	}
	private static boolean doubleEquals(double base, double d) {
		if(base - d < 0.0000001 && base - d > -0.0000001){
			return true;
		}
		return false;
	}
}
