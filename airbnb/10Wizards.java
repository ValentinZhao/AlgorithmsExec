/**
简化下比如说有五个魔法师,求 0 到 4 认识的最少距离 

0 号 认识 1 号，2 号
1 号 认识 3 号
2 号 认识 3 号, 4 号
3 号 认识 4 号 

 */
class Solution {
    public List<Integer> getShortestPath(List<List<Integer>> wizards, int source, int target) {
        int n = wizards.length;
        int[] parents = new int[n];
        // 把wizards都取出来，放到map里面，我们方便用index去取
        for (int i = 0; i < n; i++) {
            parents[i]= i;
            map.put(i, new Wizard(i));
        }
        Queue<Wizard> queue = new LinkedList<>();
        map.get(source).dist = 0; // 起始点距离自己当然是0
        queue.offer(map.get(source));
        while (!queue.isEmpty()) {
            Wizard curr = queue.poll();
            List<Integer> neighbors = wizards.get(curr.id);
            for (int neighbor : neighbors) {
                Wizard next = map.get(neighbor);
                // cost就是距离差的平方
                int weight = Math.pow(next.id - curr.id, 2);
                // 一开始dist都是MAX_VALUE，后面这样的比较能帮我们得到最小的cost
                if (curr.dist + weight < next.dist) {
                    next.dist = curr.dist + weight;
                    parents[next.id] = curr;
                }
                queue.offer(next);
            }
        }
        List<Integer> res = new ArrayList<>();
        int t = target;
        while (t != source) {
            res.add(t);
            t = parents[t];
        }
        Collections.reverse(res);
        return res;
    }

    class Wizard implements Comparable<Wizard>{
        int id;
        int dist; // 从当前点到source的距离

        public Wizard(int id) {
            this.id = id;
            this.dist = Integer.MAX_VALUE;
        }

        @Override
        public int compareTo(Wizard that) {
            return this.dist = that.dist;
        }
    }
}