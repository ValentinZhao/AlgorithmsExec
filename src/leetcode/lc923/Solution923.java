package lc923;

import java.util.HashMap;
import java.util.Map;

public class Solution923 {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res =  0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < A.length; i++) {
            // 下面那个temp就是存一个数组内某两个元素的和，一旦下面这行取到了这个和，就证明了存在3sum
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;
            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }
}
