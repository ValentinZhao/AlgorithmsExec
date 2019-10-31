package lc1087;

import java.util.TreeSet;

public class Solution1087 {
    public String[] expand(String S) {
        if (S.length() == 0) {
            return new String[0];
        } else if (S.length() == 1) {
            return new String[]{S};
        }
        TreeSet<String> set = new TreeSet<>();

        int i = 0;
        // 我们直接从开始就判断是不是{，因为这是用来递归的，那么如果第一位不是{怎么办呢？
        if (S.charAt(0) == '{') {
            while (S.charAt(i) != '}') i++;
            String[] subs = expand(S.substring(i+1));
            String[] strs = S.substring(1, i).split(",");
            for (String str : strs) {
                for (String sub : subs) {
                    set.add(str + sub);
                }
            }
            // 那就要看这里了，我们发现如果开头是plain string，我们直接把该位之后的所有substring都扔进recursive里
            // 得到返回用charAt(0)来append，意思就是
            // 比如你是'abcd'，那么就会直接出发三次DFS，每次都返回后面几个拼好的字符串
            // 所以你就懂了，这个expand方法只会在开头是{才开始处理，除此以外我们就直接向下穿substring
            // 也就是说这是一个bottom-up的方法
        } else {
            String[] strs = expand(S.substring(1));
            for (String str : strs) {
                set.add(S.charAt(0) + str);
            }
        }

        return set.toArray(new String[0]);
    }
}
