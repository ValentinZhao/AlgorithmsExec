package CodingInterviews;
/**
 * 把字符串转换成整数
 * @author zhaoziliang
 *
 */
public class Interview49 {
	public static int strToInt(String str){
		if(str == null || str.length() == 0){
			return 0;
		}
		int res = 0, n = str.length(), s = 1;
		char[] a = str.toCharArray();
		if(a[0] == '-')
			s = -1;
		for(int i = ('-' == a[0] || a[0] == '+') ? 1 : 0; i < n; ++i){
			if(!('0' <= a[i] && a[i] < '9'))
				return 0;
			//<<左移n位，就是对原来的值作2的n次幂，左移1位，3位，就是res * 2 + res * 8, a[i] & 0xf 就是a[i]-'0',位操作效率高
			res = (res << 1) + (res << 3) + (a[i] & 0xf);//res = res * 10 + a[i];
		}
		return res * s;
	}
}
