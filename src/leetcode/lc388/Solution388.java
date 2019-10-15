package lc388;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution388 {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"，也就是当前目录在第几级
            while(lev+1<stack.size()) stack.pop(); // find parent，这里尝试推出父级的path，让栈顶是当前元素的父级
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"，这样得到结果的长度
            // 从上面就知道了，这是一个单调栈，他只允许更深级或者同级的路径推进去，所以
            // 栈的size其实就是路径深度，这也是为什么我们在上面和size作比较的原因
            // 使用单调栈的原因是我们可以很方便的得到当前节点的父级路径长度
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
        }
        return maxLen;
    }
}
