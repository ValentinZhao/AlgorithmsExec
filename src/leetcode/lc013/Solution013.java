package lc013;

import java.util.HashMap;

public class Solution013 {
    private HashMap<Character, Integer> dict = new HashMap<>();
    private int sum = 0;
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] strArray = s.toCharArray();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        for (int i = 0; i < strArray.length - 1; i++) {
            if (dict.get(strArray[i]) < dict.get(strArray[i+1])) sum -= dict.get(strArray[i]);
            else sum += dict.get(strArray[i]);
        }
        return sum + dict.get(strArray[strArray.length - 1]);
    }
}
