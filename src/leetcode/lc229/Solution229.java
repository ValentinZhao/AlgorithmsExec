package lc229;
/**
    思路：摩尔投票升级版，超过n/3的数最多只能有两个；
    先选出两个候选人A,B,遍历数组，如果投A（等于A），则A的票数++;如果投B，B的票数++；
    如果A,B都不投（即与A，B都不相等）,那么检查此时是否AB中候选人的票数是否为0，如果为0,则成为新的候选人；
    如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均--；
    遍历结束后选出两个候选人，但是这两个候选人是否满足>n/3，还需要再遍历一遍数组，找出两个候选人的具体票数
 */
import java.util.ArrayList;
import java.util.List;

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int candiA = nums[0];
        int candiB = nums[0];
        int countA = 0;
        int countB = 0;
        for (int num : nums) {
            if (num == candiA) {
                countA++;
                continue;
            }
            if (num == candiB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                candiA = num;
                countA++;
                continue;
            }
            if (countB == 0) {
                candiB = num;
                countB++;
                continue;
            }
            // 走到这步，意味着A和B都不是，并且A和B都有着一定数量的重复，那就根据moore投票法减去两个candidate的计数
            countA--;
            countB--;
        }
        countA = countB = 0;
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num == candiA) countA++;
            else if (num == candiB) countB++;
        }
        if (countA > nums.length / 3) list.add(candiA);
        if (countB > nums.length / 3) list.add(candiB);
        return list;
    }
}
