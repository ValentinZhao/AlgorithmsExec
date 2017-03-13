package CodingInterviews;
/**
 * 从1到n整数中1出现的次数
 * @author zhaoziliang
 *
 */
public class Interview32 {
	public int countDigitOne(int n) {
	    int ones = 0;
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
	    return ones;
	}
}
