package lc247;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution247 {
    public List<String> findStrobogrammatic(int n) {
        return findAllStrobos(n, n);
    }

    private List<String> findAllStrobos(int len, int target) {
        if (len == 0) return new ArrayList<String>(Arrays.asList(""));
        if (len == 1) return new ArrayList<String>(Arrays.asList("0","1","8"));
        List<String> list = findAllStrobos(len-2, target);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (len != target) res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("9"+s+"6");
            res.add("8"+s+"8");
        }
        return res;
    }
}
