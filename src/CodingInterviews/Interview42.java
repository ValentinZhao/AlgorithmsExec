package CodingInterviews;

import java.util.Scanner;

/**
 * 反转单词序列&左旋转字符串
 * @author zhaoziliang
 *
 */
public class Interview42 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		char[] a = s.nextLine().toCharArray();
		reverseSentence(a, 0, a.length - 1);
	}
	public static void reverseString(char[] a, int begin, int end){
		if(a == null){
			return;
		}
		while(begin < end){
			char temp = a[begin];
			a[begin] = a[end];
			a[end] = temp;
			
			begin++;
			end--;
		}
	}
	
	public static void reverseSentence(char[] a, int begin, int end){
		if(a == null){
			return;
		}
		reverseString(a, begin, end);
		end = 0;
		while(a[begin] != '\0'){
			if(a[begin] == ' '){
				begin++;
				end++;
			} else if(a[end] == ' ' || a[end] == '\0') {
				reverseString(a, begin, --end);
				begin = end++;
			} else {
				end++;
			}
		}
		System.out.println(a.toString());
	}
}
