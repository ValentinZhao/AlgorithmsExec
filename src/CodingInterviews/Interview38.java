package CodingInterviews;
/**
 * 数字在排序数组中出现的次数
 * @author zhaoziliang
 *
 */
public class Interview38 {
	public int getCountOfK(int[] array, int k){
		if(array == null || array.length == 0){
			return 0;
		}
		int indexFirstK = getFirstK(array, k, 0, array.length - 1);
		int indexLastK = getLastK(array, k, 0, array.length - 1);
		
		int count = 0;
		if(indexFirstK > -1 && indexLastK > -1){
			count = indexLastK - indexFirstK + 1;
		}
		return count;
	}

	private int getLastK(int[] array, int k, int start, int end) {
		if(start > end){
			return -1;
		}
		int midIndex = (start + end) >> 1;
		int midNum = array[midIndex];
		if(midNum == k){
			if((midNum > 0 && array[midIndex + 1] != k) || midIndex == array.length - 1){
				return midIndex;
			} else {
				start = midIndex + 1;
			}
		} else if(midNum > k){
			end = midIndex - 1;
		} else {
			start = midIndex + 1;
		}
		return getLastK(array, k, start, end);
	}

	private int getFirstK(int[] array, int k, int start, int end) {
		if(start > end){
			return -1;
		}
		int midIndex = (start + end) >> 1;
		int midNum = array[midIndex];
		if(midNum == k){
			if((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0){//这个midIndex就是第一个k
				return midIndex;
			} else {
				end = midIndex - 1;//这个midIndex的前面还有k，就通过把end指针前移来前移midIndex
			}
		} else if(midIndex < k){
			start = midIndex + 1;
		} else {
			end = midIndex - 1;
		}
		return getFirstK(array, k, start, end);
	}
}
