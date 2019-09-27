package lc721;

import java.util.*;

/**
 * 在这里，由于邮件是字符串不是数字，所以root可以用哈希map来代替，我们还需要一个哈希映射owner，建立每个邮箱和其所有者姓名之前的映射，另外用一个哈希映射来建立用户和其所有的邮箱之间的映射，也就是合并后的结果。
 * 首先我们遍历每个账户和其中的所有邮箱，先将每个邮箱的root映射为其自身，然后将owner赋值为用户名。
 *
 * 然后开始另一个循环，遍历每一个账号，首先对帐号的第一个邮箱调用find函数，得到其父串p，然后遍历之后的邮箱，对每个遍历到的邮箱先调用find函数，将其父串的root值赋值为p
 * 这样做相当于将相同账号内的所有邮箱都链接起来了。
 *
 * 我们接下来要做的就是再次遍历每个账户内的所有邮箱，先对该邮箱调用find函数，找到父串，然后将该邮箱加入该父串映射的集合汇总，这样就我们就完成了合并。
 *
 * 最后只需要将集合转为字符串数组，加入结果res中，通过owner映射找到父串的用户名，加入字符串数组的首位置
 */
public class Solution721 {
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                // 除了parent是自己外，本题特殊的点在于还要记录一个用户名，把用户名跟parent映射起来
                owner.put(a.get(i), a.get(0));
            }
        }
        // 把同一个账号下第一个邮箱之后的邮箱全部给到与第一个邮箱相同的parent下，毕竟这是同一个账号
        // 把一个账户内所有邮箱串联了起来
        for (List<String> a : acts) {
            String p = find(a.get(1), parents);
            for (int i = 2; i < a.size(); i++)
                parents.put(find(a.get(i), parents), p);
        }
        // 在这一步进行Union，有可能在不同账号下会出现相同的parent，这样就合并到一起了
        for(List<String> a : acts) {
            String p = find(a.get(1), parents);
            if (!unions.containsKey(p)) unions.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }

    // find的作用是，找到当前串的parent串，parent就是连通分量的代表，一开始每个串的parent都是自己
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> union = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                parents.put(account.get(i), account.get(i));
                owner.put(account.get(i), account.get(0));
            }
        }
        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            for (int i = 2; i < account.size(); i++) {
                parents.put(find(account.get(i), parents), p);
            }
        }
        for (List<String> account : accounts) {
            String p = find(account.get(1), parents);
            for (int i = 1; i < account.size(); i++) {
                if (!union.containsKey(p)) union.put(p, new TreeSet<>());
                union.get(p).add(account.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : union.keySet()) {
            List<String> list = new ArrayList<>(union.get(p));
            list.add(0, owner.get(p));
            res.add(list);
        }
        return res;
    }

    private String find(String p, Map<String, String> parents) {
        return parents.get(p).equals(p) ? p : find(parents.get(p), parents);
    }
}

/**
 * 这里记录一个更加直观，也更加完整的Union Find实现
 */
class Solution3rd {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) return null;
        List<List<String>> res = new ArrayList<>();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        // 第一步把所有的邮箱地址和他所属的账号位置(i)进行一个映射
        // 目的是，让之后出现的相同的邮箱地址可以用find找到当前的这个index位置
        // 为此，我们对于所有用containsKey找到的邮箱，使用union把它们关联起来
        Map<String, Integer> mailToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String curMail = accounts.get(i).get(j);
                if (mailToIndex.containsKey(curMail)) {
                    int prevIndex = mailToIndex.get(curMail);
                    uf.union(prevIndex, i);
                } else {
                    mailToIndex.put(curMail, i);
                }
            }
        }

        // 第二步是，直接建立并查集，为所有的parent建立一个映射
        // 他应该是一个map<parentRoot, Set<Emails>>，表示连通分量的集合
        // 我们通过遍历所有账户下的emails的方法，把所有同一账户下的邮箱都扔到同一个parentId下
        // 这样做的理由是，在同一账户下的邮箱本来就是连接在一起的
        // 但是在后面find parent的时候有可能找到的是同一个Set，那么这时候就放在一起了
        // 同时又因为是Set，所以后面有重复的也不怕
        Map<Integer, Set<String>> disjointSet = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 注意，建立的UnionFind是关于所有账户index的，而不是某个邮箱，所以找的时候也是用账户index来找
            int parentIdx = uf.find(i);
            disjointSet.putIfAbsent(parentIdx, new HashSet<>());
            Set<String> set = disjointSet.get(parentIdx);
            // 取出来set，然后把相同parent账户下的所有邮箱塞进去
            for (int j = 1; j < accounts.get(i).size(); j++) {
                set.add(accounts.get(i).get(j));
            }
            disjointSet.put(parentIdx, set);
        }
        // 第三步，遍历并查集，把所有元素取出来怼到一个temp list里，排序，再怼回结果list中
        // 最后终于结束了...
        for (int key : disjointSet.keySet()) {
            List<String> temp = new ArrayList<>();
            temp.addAll(disjointSet.get(key));
            Collections.sort(temp);
            // 这里就能看出使用所有账户的index进行uf是很巧妙的
            // 它保证了我们在这里之遍历到具有不同连通分量的账户index
            temp.add(0, accounts.get(key).get(0));
            res.add(temp);
        }
        return res;
    }

    class UnionFind {
        int[] rank;
        int[] parents;

        public UnionFind(int n) {
            rank = new int[n];
            parents = new int[n];

            // 所有人初始化parent都是自己
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int v) {
            if (v != parents[v]) {
                parents[v] = find(parents[v]);
            }
            return parents[v];
        }

        public void union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);
            if (rank[p1] > rank[p2]) parents[p1] = p2;
            else if (rank[p1] < rank[p2]) parents[p2] = p1;
            else {
                parents[p1] = p2;
                rank[p2]++;
            }
        }
    }
}