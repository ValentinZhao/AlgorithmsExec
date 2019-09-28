package lc825;

// go check LC Handbook
public class Solution825 {
    public int numFriendRequests(int[] ages) {
        int[] numOfAge = new int[121], sumByAge = new int[121];
        int res = 0;
        for (int age : ages) {
            numOfAge[age]++;
        }

        // sumByAge, 表示包括当前年龄的和比该年龄小的人数的和
        for (int i = 1; i < 121; i++) {
            sumByAge[i] = sumByAge[i-1] + numOfAge[i];
        }

        for (int i = 15; i < 121; i++) {
            if (numOfAge[i] == 0) continue;
            int count = sumByAge[i] - sumByAge[i / 2 + 7]; // 在范围内的人数
            res += numOfAge[i] * (count - 1); // 人不能加自己为朋友
        }
        return res;
    }
}
