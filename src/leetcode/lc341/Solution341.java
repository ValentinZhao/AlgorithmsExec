package lc341;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution341 implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    
    public Solution341(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        array2stack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        // 由于hasNext是每次上层append的时候都会调用的，所以频率很高，在执行过过程中，遇到第一个list就把它整个再分解入栈
        // 如果恰好都是Integer了那循环就结束了，hasNext得到了返回值，stack也更新了
        // 如果依然得到list，循环继续把list分解，这样就会造成的现象是，在这一时刻，下面可能还会有list被中间的Integer跟栈顶隔开
        // 但是这些list目前也访问不到，之后不断出栈的时候就能访问到了
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            array2stack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }
    
    private void array2stack (List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i)); // 这一步会把integer和list甚至nested list都推入栈，但是下面我们会通过while来解析
        }
    }
    
    private interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
}
