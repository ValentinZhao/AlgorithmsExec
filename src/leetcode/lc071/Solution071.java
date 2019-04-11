package lc071;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 利用".."来出栈，从头开始构建一个新的串，没遍历到..就入栈，最后再遍历出来拼接
 */
public class Solution071 {
    public String simplifyPath(String path) {
        Set<String> skips = new HashSet<>(Arrays.asList("..", ".", ""));
        Stack<String> stack = new Stack<>();
        for (String dir : path.split("/")) {
            if (!stack.isEmpty() && dir.equals("..")) stack.pop();
            else if (!skips.contains(dir)) stack.push(dir);
        }
        StringBuilder builder = new StringBuilder();
        for (String dir : stack) builder.append("/").append(dir);
        String res = builder.toString();
        return res.isEmpty() ? "/" : res;
    }
}
