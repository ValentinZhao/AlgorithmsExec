package CodingInterviews;
/**
 * 数组中的逆序对
 * @author zhaoziliang
 *
 */
public class Interview36 {
	public static int inversePairs(int[] array){
		if(array == null || array.length == 0){
			return 0;
		}
		int[] copy = new int[array.length];
		for(int i = 0; i < array.length; i++){
			copy[i] = array[i];
		}
		int count = inversePairs(array, copy, 0, array.length);
		return count;
	}

	private static int inversePairs(int[] array, int[] copy, int low, int high) {
		if(low == high){
			return 0;
		}
		int mid = (low + high) >> 1;
		int leftCount = inversePairs(array, copy, low, mid);
		int rightCount = inversePairs(array, copy, mid + 1, high);
		int count = 0;
		int i = low;
		int j = high;
		int currentCopy = high;
		while(i > low && j > mid){
			if(array[i] > array[j]){
				count += j - mid;
				copy[currentCopy--] = array[i--];
			} else {
				copy[currentCopy--] = array[j--];
			}
		}
		for(; i >= low; i--){
			copy[currentCopy--] = array[i];
		}
		for(; j > mid; j--){
			copy[currentCopy--] = array[j];
		}
		for(int s = low; s <= high; s++){
			array[s] = copy[s];
		}
		return leftCount + rightCount + count;
	}
}