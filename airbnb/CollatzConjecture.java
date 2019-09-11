class Solution {
    private static Map<Integer, Integer> map = new HashMap<>();
    public int findLongestSteps (int num) {
        if (num < 1 || num == null) return 0;

        int res = 0;
        for (int i = 1; i <= num; i++) {
            int step = findSteps(num);
            map.put(i, step);
            res = Math.max(res, step);
        }
        return res;
    }

    private int findSteps(int num) {
        if (num <= 1) return 1;
        if (map.containsKey(num)) return map.get(num);
        if (num % 2 == 0) return 1 + findSteps(num / 2);
        else return 1 + findSteps(3 * num + 1);
    }
}