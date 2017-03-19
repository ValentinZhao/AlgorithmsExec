package CodingInterviews;
/**
 * 不用加减乘除做加法
 * @author zhaoziliang
 *
 */
/**
 * 1.先将两个数进行按位异或，这样就相当于先将两个数不进位地加在一起，因为进位我们要之后算
 * 2.再对两个数进行按位位与，这样的话只有两位都是1的时候才能为1，再左移一位就可模拟进位
 * 3.将前面两个结果加在一起即可。注意在循环时我们要判断进位不为零时要继续算
 */
public class Interview47 {
	public static int binaryAdd(int num1, int num2){
		int sum, carry = 0;
		do{
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		} while(num2 != 0);
		return num1;
	}
}
