package CodingInterviews;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 * @author zhaoziliang
 *
 */
public class Interview33 {
	public static String getMinNum(int[] numbers){
		if(numbers == null || numbers.length == 0){
			return null;
		}
		String[] str = new String[numbers.length];
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < numbers.length; i++){
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);//比较正反拼接的字符串的大小
			}
		});
		for(int i = 0; i < numbers.length; i++){
			builder.append(str[i]);
		}
		return builder.toString();
	}
}
