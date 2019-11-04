package lc833;

import java.util.Arrays;

public class Solution833 {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        String[] c_sources = new String[1001];
        String[] c_targets = new String[1001];
        StringBuilder sb = new StringBuilder();
        int idx = 0;


        for (int i = 0; i < indexes.length; i++) {
            c_sources[indexes[i]] = sources[i];
            c_targets[indexes[i]] = targets[i];
        }

        Arrays.sort(indexes);

        for (int i = 0; i < S.length(); i++) {
            if (idx < indexes.length && i == indexes[idx] && S.substring(indexes[idx]).indexOf(c_sources[indexes[idx]]) == 0) {
                sb.append(c_targets[indexes[idx]]);
                i += c_sources[indexes[idx]].length()-1;
                idx++;
            } else {
                sb.append(S.charAt(i));
            }
        }

        return sb.toString();
    }
}
