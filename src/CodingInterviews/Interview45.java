package CodingInterviews;
/**
 * 约瑟夫环
 * @author zhaoziliang
 *
 */

/**			0, n=1
 * f(n,m)={
 *			[f(n-1,m)+m]%n, n>1
 */
public class Interview45 {
	public static int lastRemaining(int n, int m){
		if(n < 1 || m < 1){
			return -1;
		}
		int last = 0;
		for(int i = 2; i <= n; i++){
			last = (last + m) % i;
		}
		return last;
	}
}
