package jianzhi;

import java.util.ArrayList;
import java.util.Collections;

public class Jz27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(list, sb, str);
        Collections.sort(list);
        return list;
    }

    private void helper(ArrayList<String> list, StringBuilder sb, String str) {
        if (sb.length() == str.length()) {
            list.add(sb.toString());
            return;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (sb.indexOf(String.valueOf(str.charAt(i))) != -1) continue;
                sb.append(String.valueOf(str.charAt(i)));
                helper(list, sb, str);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
