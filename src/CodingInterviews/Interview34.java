package CodingInterviews;
/**
 * 丑数问题
 * @author zhaoziliang
 *
 */
public class Interview34 {
	public static int getUglyNumOfIndex(int index){
		if(index == 0){
			return 0;
		}
		if(index == 1){
			return 1;
		}
		int u2 = 0, u3 = 0, u5 = 0;
		int[] k = new int[index];
		k[0] = 1;
		for(int i = 1; i < index; i++){
			k[i] = getMin(k[u2] * 2, getMin(k[u3] * 3, k[u5] * 5));//后面的丑数一定是前面的丑数乘2，3或5得到的，选一个最小的作为最近的一个丑数
			if(k[i] == k[u2] * 2) u2++;//如果在本轮循环中最小的是上一轮的丑数乘2的结果，则把u2指针向后移。下面同理
			if(k[i] == k[u3] * 3) u3++;
			if(k[i] == k[u5] * 5) u5++;
		}
		return k[index - 1];
	}

	private static int getMin(int i, int j) {
		if(i != j){
			return i < j ? i : j;
		}
		return 0;
	}
}
