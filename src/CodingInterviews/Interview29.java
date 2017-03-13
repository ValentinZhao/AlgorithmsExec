package CodingInterviews;

public class Interview29 {
	public static int numMoreThanHalf(int[] numbers, int length){
		if(numbers == null || length == 0){
			return 0;
		}
		int mid = length >> 1;
		int start = 0;
		int end = length - 1;
		int index = partition(numbers, start, end);
		while(index != mid){
			if(index > mid){
				end = index - 1;//中位数在左边，我们直接在左边部分的数组中查找
				index = partition(numbers, start, end);
			} else {
				start = index + 1;
				index = partition(numbers, start, end);
			}
		}
		int result = numbers[mid];
		if(!checkIfMoreThanHalf(numbers, length, result))
			return 0;
		return result;
	}

	private static boolean checkIfMoreThanHalf(int[] numbers, int length, int result) {
		int times = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] == result)
				times++;
		}
		if(times * 2 >= length){
			return true;
		} else {
			return false;
		}
	}

	/**
	 *partition函数真正要做的，是把比pivot小的数放在pivot，也就是start指针的左边
	 *对于比pivot大的自然就在end的指针右边，最后呢，start和end重合
	 *这也就是pivot应该所在的位置
	 *快速排序就是这个partition函数与分治法的结合，接下来再对pivot两侧的序列进行递归，就可以排序了
	 *此题亦然 
	 */
	private static int partition(int[] numbers, int start, int end) {
		int pivot = numbers[start];
		while(start < end){
			while(start < end && numbers[end] >= pivot)
				end--;
			if(start < end){//只要start < end，这次partition就还未结束，因为最后两指针要重合
				swap(numbers, start, end);
				start++;
			}
			while(start < end && numbers[start] <= pivot)
				start++;
			if(start < end){
				swap(numbers, start, end);
				end--;
			}
		}
		numbers[start] = pivot;
		return start;
	}

	private static void swap(int[] numbers, int start, int end) {
		if(start != end){
			int temp = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = temp;
		}
	}
}
