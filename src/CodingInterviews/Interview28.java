package CodingInterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 字符串排列
 * @author zhaoziliang
 *
 */
public class Interview28 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		ArrayList<String> result = permutation(s.nextLine());
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
	}
	public static ArrayList<String> permutation(String str){
		ArrayList<String> result = new ArrayList<>();
		if(str == null || str.length() == 0){
			return result;
		}
		HashSet<String> set = new HashSet<>();
		permutation(set, str.toCharArray(), 0);
		result.addAll(set);
		Collections.sort(result);
		return result;
	}

	private static void permutation(HashSet<String> set, char[] str, int index) {
		if(index == str.length){
			set.add(str.toString());
			return;
		}
		for(int i = index; i < str.length; i++){
			swap(str, i, index);
			permutation(set, str, index + 1);
			swap(str, i, index);
		}
	}

	private static void swap(char[] str, int i, int index) {
		if(i != index){
			char temp = str[i];
			str[i] = str[index];
			str[index] = temp;
		}
	}
}
