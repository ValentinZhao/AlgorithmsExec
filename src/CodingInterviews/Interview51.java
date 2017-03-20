package CodingInterviews;
/**
 * 数组中重复的数字
 * @author zhaoziliang
 *
 */
public class Interview51 {
	public static boolean hasDuplication(int[] nums){
		if(nums == null || nums.length == 0){
			return false;
		}
		int len = nums.length;
		for(int i = 0; i < len; i++){
			if(nums[i] < 0 || nums[i] > len - 1){
				return false;
			}
		}
		for(int i = 0; i < len; i++){
			while(nums[i] != i){
				if(nums[i] == nums[nums[i]]){
					return true;
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = nums[i];
			}
		}
		return false;
	}
}
