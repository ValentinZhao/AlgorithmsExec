package CodingInterviews;

import java.util.Scanner;

/**
 * 表示数值的字符串
 * @author zhaoziliang
 *
 */
/**
 * 思路很简单，按照以下这个顺序依次判断即可
 * 1.判断正负（正数也可以没有符号）
 * 2.判断是否是小数
 * 3.扫描数位，有个数字就循环几次同时把指针向后移
 * 4.此时应该是一个e或E用来表示科学计数法，要详细判断
 */
public class Interview54 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		char[] array = input.toCharArray();
		System.out.println("Input is numeric? " + isNumeric(array));
	}
	public static boolean isNumeric(char[] string){
		if(string == null || string.length == 0){
			return false;
		}
		int p = 0;
		boolean numeric = false;
		if(string[p] == '+' || string[p] == '-'){
			numeric = true;
			++p;
		}
		if(string[p] == '\0'){
			return false;
		}
		scanDigits(string, p);
		if(string[p] != '\0'){
			if(string[p] == '.'){
				//if float
				++p;
				scanDigits(string, p);
				
				if(string[p] == 'e' || string[p] == 'E'){
					numeric = isExponential(string, p);
				}
			} else if(string[p] == 'e' || string[p] == 'E'){
				//if integer
				numeric = isExponential(string, p);
			} else {
				numeric = false;
			}
		}
		return numeric && string[p] == '\0';
	}

	/**
	 *用来匹配科学计数法的结尾部分，结尾部分可能有一个E（e），接下来可能是负号，再接着是0-9的数位 
	 */
	private static boolean isExponential(char[] string, int p) {
		if(string[p] != 'E' || string[p] != 'e'){
			return false;
		}
		++p;
		if(string[p] == '+' || string[p] == '-'){
			++p;
		}
		if(string[p] == '\0')
			return false;
		scanDigits(string, p);
		return string[p] == '\0' ? true : false;
	}

	private static void scanDigits(char[] string, int p) {
		while(string[p] != '\0' && string[p] < '9' && string[p] > '0')
			++p;
	}
}
