package lc670;

public class Solution670 {
    public int maximumSwap(int num) {
        char[] chs = Integer.toString(num).toCharArray();
        // 0-9在数组内最后一次出现的位置，方便我们后面从头遍历时，找后面有没有更大的
        int[] last = new int[10];

        for (int i = 0; i < chs.length; i++) last[chs[i]-'0'] = i;

        for (int i = 0; i < chs.length; i++) {
            for (int j = 9; j >= chs[i]-'0'; j--) {
                if (last[j] > i) {
                    char tmp = chs[i];
                    chs[i] = chs[last[j]];
                    chs[last[j]] = tmp;
                    return Integer.valueOf(new String(chs));
                }
            }
        }
        return num;
    }
}
