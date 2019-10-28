package lc1238;

import java.util.ArrayList;
import java.util.List;

public class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = getOneBitDiffList(n);

        int i = 0;
        for( ; i < tmp.size(); i ++){
            if(tmp.get(i) == start){
                break;
            }
        }

        for(int k = i; k < tmp.size(); k ++){
            res.add(tmp.get(k));
        }

        for(int q = 0; q < i; q ++){
            res.add(tmp.get(q));
        }

        return res;
    }

    // generate one bit diff permutations
    // 0, 1
    // 0, 1, 11, 10
    // 000, 001, 011, 010, 110, 111, 101, 100
    private List<Integer> getOneBitDiffList(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;

        res.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = res.size()-1; j >= 0; j--) {
                res.add(res.get(j) + 1 << n);
            }
        }

        return res;
    }
}
