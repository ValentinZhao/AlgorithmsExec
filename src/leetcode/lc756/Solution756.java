package lc756;

import java.util.*;

public class Solution756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> map = new HashMap<>();
        // 构建一个graph
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.substring(2));
        }

        return dfs(bottom, map);
    }

    private boolean dfs(String bottom, Map<String, List<String>> map) {
        if (bottom.length() == 1) return true;
        // 检查是否当前row的任意两个相邻的元素是否存在topping，如果有任何不存在的组合，直接返回错误，毕竟这对就无法继续向上搭建了
        for (int i = 0; i < bottom.length() - 1; i++) {
            if (!map.containsKey(bottom.substring(i, i+2))) return false;
        }

        List<String> list = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        // 利用回溯，组合出所有topping的组合，毕竟每两个的topping可能有多个
        // 比如底层是ABCD，然后映射关系有ABC, ABG, CDE, CDF
        // 那么topping level可能就有 CE, CF, GE, GF这样的组合
        // 那么这不就是backtracking嘛
        backtracking(bottom, builder, list, map, 0);

        for (String s : list) {
            // 这里的s就是一层新的toppings，它们即将作为新的bottom继续向上DFS了
            if (dfs(s, map)) return true;
        }
        return false;
    }

    private void backtracking(String bottom, StringBuilder builder, List<String> list, Map<String, List<String>> map, int index) {
        if (index == bottom.length() - 1) {
            list.add(builder.toString());
            return;
        }

        // 这个迭代器中的s，就是一个可行的toppping字母，用来组合的
        for (String s : map.get(bottom.substring(index, index+2))) {
            builder.append(s);
            backtracking(bottom, builder, list, map, index + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
