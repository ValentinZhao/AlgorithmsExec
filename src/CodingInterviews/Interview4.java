package CodingInterviews;

import java.util.Scanner;

public class Interview4 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		char[] a = new char[1000];
		a = s.nextLine().toCharArray();
		replaceBlank(a, 1000);
		System.out.println(a);
	}
	
	public static void replaceBlank(char[] string, int length){
		if(string == null || string.length <= 0){
			return;
		}
		int originalLength = 0;//该string的原长度
		int blankCount = 0;//空格数
		int i = 0;
		while(string[i] != '\0'){
			++originalLength;
			if(string[i] == ' '){
				++blankCount;
			}
			++i;
			System.out.println("i = " + i);
		}
		if(string.length > length){
			return;
		}
		int indexOfOrigin = originalLength;
		int indexOfNew = originalLength + blankCount * 2;
		while(indexOfOrigin >= 0 && indexOfNew > indexOfOrigin){
			if(string[indexOfOrigin] == ' '){
				string[indexOfNew--] = '0';
				string[indexOfNew--] = '2';
				string[indexOfNew--] = '%';
			} else {
				string[indexOfNew--] = string[indexOfOrigin];//若不是空格，把origin位置的值复制到new的位置，也就是p2指针，之后再把p2指针前移
			}
			--indexOfOrigin;
		}
	}
}
