package CodingInterviews;
/**
 * 连续数组的最大和
 * @author zhaoziliang
 *
 */
public class Interview31 {
	private static boolean isValidInput = true;
	
	public static int findGreatestSumOfSubArray(int[] data, int length){
		if(data == null || length == 0){
			isValidInput = false;
			return 0;
		}
		int currentSum = 0;
		int greatestSum = 0;
		for(int i = 0; i < length; i++){
			if(currentSum < 0){
				currentSum = data[i];//如果一段子数组的和是负数，则这组子数组全部放弃掉，选下一个数作数组头重新开始
			} else {
				currentSum += data[i];
			}
			if(currentSum > greatestSum){
				greatestSum = currentSum;
			}
		}
		return greatestSum;
	}
}