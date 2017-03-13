package CodingInterviews;
/**
 * 最小的k个数
 * @author zhaoziliang
 *
 */
public class Interview30 {
	public static void printLastKNumbers(int[] input, int length, int[] output, int k){
		if(input == null || output == null || k > length || length <= 0|| k <= 0){
			return;
		}
		int start = 0;
		int end = length - 1;
		int index = partition(input, start, end);
		while(index != k - 1){
			if(index > k - 1){
				end = index - 1;
				index = partition(input, start, end);
			} else {
				start = index + 1;
				index = partition(input, start, end);
			}
		}
		for(int i = 0; i < k; i++){
			output[i] = input[i];
		}
	}
	
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
