package lc1055;

public class Solution1055 {
    public int shortestWay(String source, String target) {
        char[] schs = source.toCharArray(), tchs = target.toCharArray();
        boolean[] visited = new boolean[schs.length];
        int j = 0;
        int res = 1;
        for (int i = 0; i < schs.length; i++) {
            visited[schs[i]-'a'] = true;
        }
        for (int i = 0; i < tchs.length; i++, j++) {
            if (!visited[tchs[i]-'a']) return -1;

            while (j < schs.length && schs[j] != tchs[i]) j++;

            if (j == schs.length) {
                j = -1; // 下次循环条件j++会把j加到0，这样就从头读source了
                i--; // 把i回退一个，否则当前i还没被匹配过就跳过就不对了
                res++; // 这时候一个source读完了，相当于要找下一个sub sequence才能拼好，那么计数加一
            }
        }

        return res;
    }
}
