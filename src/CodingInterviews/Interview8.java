package CodingInterviews;

/**
 * 旋转数组的最小数字
 *
 */
public class Interview8 {
	public int min(int[] nums, int length){
		int preIndex = 0;
		int rearIndex = length - 1;
		int midIndex = 0;
		while(nums[preIndex] >= nums[rearIndex]){
			if(rearIndex - preIndex == 1){
				midIndex = rearIndex;
				break;
			}
			midIndex = (preIndex + rearIndex) / 2;
			if(nums[preIndex] == nums[rearIndex] && nums[preIndex] == nums[midIndex]){
				return minByOrder(nums, preIndex, rearIndex);
			}
			if(nums[preIndex] <= nums[midIndex]){
				preIndex = midIndex;
			} else if(nums[rearIndex] >= nums[midIndex]) {
				rearIndex = midIndex;
			}
		}
		return nums[midIndex];
	}

	private int minByOrder(int[] nums, int preIndex, int rearIndex) {
		int result = nums[preIndex];
		for(int i = preIndex + 1; i <= rearIndex; ++i){
			if(result > nums[i]){
				result = nums[i];
			}
		}
		return result;
	}
}
