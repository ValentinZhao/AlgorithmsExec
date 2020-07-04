package jianzhi;

import java.util.ArrayList;

public class Jz41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int lo = 1, hi = 2;
        while (lo < hi) {
            // 由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (lo + hi) * (hi - lo + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = lo; i <= hi; i++) list.add(i);
                result.add(new ArrayList<>(list));
                lo++;
            } else if (cur > sum) {
                lo++;
            } else {
                hi++;
            }
        }
        return result;
    }
}
