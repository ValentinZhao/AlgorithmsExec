package companys;

import java.util.Scanner;

public class Xiaomi_binary{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int y = m ^ n;
		int count = 0;
		while(y != 0){
			y = y & (y - 1);
			//a&=(a-1)得到的数是将a最低位的1变为0后的数
			//原因就在于当我们取得异或之后的结果后，异或二进制值为1的地方表示原来两个数在此数位不相同
			//则我们每次都去将异或结果的最后一位变为零并于0比较
			//如果此时不为零，说明在最后一位之前还存在1（也就是还有不相同的数位），那就使count++
			//只有我将最后一位变为零使得整个数的数位全为零时，这时候也不存在不相同的数位了，则退出循环
			++count;
		}
		System.out.println(count);
	}
}
