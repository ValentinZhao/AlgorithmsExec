class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur_counter = 1;
        int store_counter = 1;
        for (int i = 0; i < nums.length -1 ; i++) {
            if (nums[i + 1] - nums[i] > 0){
                cur_counter++;
                if (i == nums.length - 2 && cur_counter > store_counter) {
                    store_counter = cur_counter;
                }
            }
            else {
                if (cur_counter > store_counter) {
                    store_counter = cur_counter;
                }
                cur_counter = 1;
            }
        }
        return store_counter;
    }
}