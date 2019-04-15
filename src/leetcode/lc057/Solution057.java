package lc057;

import java.util.ArrayList;
import java.util.List;

public class Solution057 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // curStart和curEnd就是记录遍历过程中比较大的interval的
        // 要记住merge interval这类题的一个特点就是当我们遇到要合并的情况（start低于前面interval的end，或者end大于后者interval的start）的时候
        // 我们要更新curStart和curEnd，而不推入新的interval，表示合并中，直到找到更大的值替换两指针，否则就是遍历结束了也一直在merging，那我们最后还是要
        // 再推入curStart和curEnd一次。
        // 为了避免说我们遍历到最后一个interval的时候他是独立的，最后再塞入会不会重复呢？应对这个问题我们就在找到一个更大的interval之后，顺便把
        // curStart和curEnd给更新一下就可以了
        List<Interval> ans = new ArrayList<>();
        int curStart = newInterval.start;
        int curEnd = newInterval.end;
        for (int i = 0; i < intervals.size(); i++) {
            int lastStart = intervals.get(i).start;
            int lastEnd = intervals.get(i).end;
            if (lastStart > curEnd) { // 当前元素比带插入元素大
                ans.add(new Interval(curStart, curEnd));
                curStart = lastStart;
                curEnd = lastEnd;
            } else if (lastEnd < curStart) { // 当前元素比带插入元素小
                ans.add(intervals.get(i));
            } else { // 需要合并，这一步绝不能塞入
                curStart = Math.min(curStart, lastStart);
                curEnd = Math.max(curEnd, lastEnd);
            }
        }
        ans.add(new Interval(curStart, curEnd));
        return ans;
    }
    
    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
}
