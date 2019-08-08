package lc399;

import java.util.*;

/**
 * 一对一对的除法运算pair其实就是图的一个边，比如a/b=3，那么这条边的value就是3，b/a=1/3，其他同理，那么就很容易想到DFS的解法
 * Query其实就是找某两个点之间的距离，不过注意我们是有向的
 */
public class Solution399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuePairs = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<>());
                valuePairs.put(equation[0], new ArrayList<>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<>());
                valuePairs.put(equation[1], new ArrayList<>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuePairs.get(equation[0]).add(values[i]);
            valuePairs.get(equation[1]).add(1 / values[i]);
        }
        double[] results = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            results[i] = calcEquationGraphDFS(query[0], query[1], pairs, valuePairs, new HashSet<String>(), 1.0);
            if (results[i] == 0.0) results[i] = -1.0;
        }
        return results;

    }

    private double calcEquationGraphDFS(String start, String end, Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> valuePairs, HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        // value不断累乘，在递归之后立刻返回回去，那么这个value其实是被不断记录下并最后返回，数值是不会变成原来的大小的
        if (start.equals(end)) return value;
        // set的作用是防止自我循环，比如pairs给了(a,a)的话就会造成死循环，在向下递归的时候set会保存这个路径并且不被指向自身的循环干扰
        set.add(start);
        ArrayList<String> neighbors = pairs.get(start);
        ArrayList<Double> neighborValues = valuePairs.get(start);
        double temp = 0.0;
        for (int i = 0; i < neighbors.size(); i++) {
            temp = calcEquationGraphDFS(neighbors.get(i), end, pairs, valuePairs, set, value * neighborValues.get(i));
            if (temp != 0.0) break;
        }
        // 运行到这就是递归出来向上了，把这个start取出来（出栈），以免影响其他路径的读取
        // 比如也有其他路径依然依赖当前start，那就要退出当前这个start，在下个递归再加回来
        // 毕竟不退栈的话直接就返回0.0那就不对了
        set.remove(start);
        return temp;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> pairs = new HashMap<>();
        Map<String, List<Double>> valuePairs = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!pairs.containsKey(equation.get(0))) {
                pairs.put(equation.get(0), new ArrayList<>());
                valuePairs.put(equation.get(0), new ArrayList<>());
            }
            if (!pairs.containsKey(equation.get(1))) {
                pairs.put(equation.get(1), new ArrayList<>());
                valuePairs.put(equation.get(1), new ArrayList<>());
            }
            pairs.get(equation.get(0)).add(equation.get(1));
            pairs.get(equation.get(1)).add(equation.get(0));
            valuePairs.get(equation.get(0)).add(values[i]);
            valuePairs.get(equation.get(1)).add(1 / values[i]);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double temp = calcEquationDFS(query.get(0), query.get(1), pairs, valuePairs, new HashSet<>(), 1.0);
            if (temp == 0.0) temp = -1.0;
            result[i] = temp;
        }
        return result;
    }

    private double calcEquationDFS(String start, String end, Map<String, List<String>> pairs, Map<String, List<Double>> valuePairs, HashSet<String> set, double value) {
        if (!pairs.containsKey(start)) return 0.0;
        if (set.contains(start)) return 0.0;
        if (start.equals(end)) return value;
        List<String> neighbors = pairs.get(start);
        List<Double> neighborValues = valuePairs.get(start);
        set.add(start);
        double temp = 0.0;
        for (int i = 0; i < neighbors.size(); i++) {
            temp = calcEquationDFS(neighbors.get(i), end, pairs, valuePairs, set, value * neighborValues.get(i));
            if (temp > 0.0) break;
        }
        set.remove(start);
        return temp;
    }
}