package CodingInterviews;

import java.util.Scanner;

/**
 * 打印1到最大的n位数
 *
 */
public class Interview12 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		print1toMaxOfDigits(n);
	}
	
	public static void print1toMaxOfDigits(int n){
		if(n <= 0){
			return;
		}
		char[] number = new char[n + 1];
		number[n] = '\0';
		for(int i = 0; i < 10; ++i){
			number[0] = (char) i;
			print1toMaxOfDigitsRecursively(number, n, 0);
		}
		number = null;
	}

	private static void print1toMaxOfDigitsRecursively(char[] number, int n, int index) {
		if(index == n - 1){
			printNumber(number);
			return;
		}
		for(int i = 0; i < 10; ++i){
			number[index + 1] = (char) i;
			print1toMaxOfDigitsRecursively(number, n, index + 1);
		}
	}

	private static void printNumber(char[] number) {
		boolean isInitWith0 = true;
		int length = number.length;
		for(int i = 0; i < length; ++i){
			if(isInitWith0 && number[i] != '0'){
				isInitWith0 = false;
			}
			if(!isInitWith0){
				System.out.println(number[i]);
			}
		}
	}
}
