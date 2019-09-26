package lc269;

import java.util.Arrays;

public class Solution269 {
    private final int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {                 // unvisited
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {                        // connected
                if(visited[j] == 1) return false;  // 1 => 1, cycle
                if(visited[j] == 0) {              // 0 = unvisited
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}

class Solution {
    private final int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                // 每个存在的字母我们才DFS
                if (!dfs(adj, visited, builder, i)) return "";
            }
        }
        return builder.reverse().toString();
    }

    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder builder, int index) {
        visited[index] = 1; // visiting
        // 在一个dfs内，我们还要遍历26个字母，其实就相当于它的neighbor了
        for (int i = 0; i < N; i++) {
            if (adj[index][i]) {
                if (visited[i] == 1) return false; // 成环了
                if (visited[i] == 0) {
                    // 一个dfs相当于在图内向下个节点走去，毕竟最后一个参数index更新了
                    if (!dfs(adj, visited, builder, i)) return false;
                }
            }
        }
        visited[index] = 2; // 标记为2的我们从上面代码可知，永远不会被处理
        builder.append((char)(index + 'a'));
        return true;
    }

    private void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);
        char[] pre = words[0].toCharArray();
        // 所有出现过的字母置零
        for(int k=0; k<pre.length;k++) visited[pre[k] - 'a'] = 0;
        for(int i = 1; i< words.length;i++){
            char[] cur = words[i].toCharArray();
            for(int k= 0;k<cur.length;k++) visited[cur[k] - 'a'] =0;
            int length = Math.min(pre.length, cur.length);
            for(int j =0; j<length;j++){
                if(cur[j]!=pre[j]){
                    adj[pre[j]- 'a'][cur[j] - 'a'] = true;
                    // 找到一个非同样字母的对应关系我们就break，避免后面再次出现的其他mapping影响了前面已经设置好的部分
                    break;
                }
            }
            pre = cur;
        }
    }
}