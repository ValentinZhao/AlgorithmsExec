/**
输入大概是这样，四个矩形，16个vertice
每个矩形只需要两个对角线上的点就可确定一个矩形了
[
    [[a,b],[a,b]],
    [[a,b],[a,b]],
    [[a,b],[a,b]],
    [[a,b],[a,b]],
]
 */
class Solution {
    private boolean intersect(int[][] r1, int[][] r2) {
        return r1[0][0] < r2[0][0] && r1[0][1] < r2[0][1] && r2[0][0] < r1[1][0] && r2[0][1] < r1[1][1] ||
                r1[0][0] < r2[1][0] && r1[0][1] < r2[1][1] && r2[1][0] < r1[1][0] && r2[1][1] < r1[1][1];
    }
    public int countIntersection(int[][][] rectangles) {
        int n = rectangles.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            // 这里就很重要，他的意思是每个元素在union进连通分量之前，root都是他本身
            // 那么如果在后面的path-compression里面没有被加入到任何连通分量中的话
            // 那他自己的root就是自己，也就说明了这个矩形没有和任何矩形相交
            parents[i] = i;
        }
        // 这里是说，i和j不能是同一个矩形，所以j总比i提前一位开始
        // 为了j能遍历到最后，i就得提前一位结束，所以是n-1
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(rectangles[i], rectangles[j])) {
                    int root1 = find(i, parents);
                    int root2 = find(j, parents);
                    if (root1 != root2) {
                        parents[root1] = root2;
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i, parent));
        }
        return set.size();
    }

    private int find(int v, int[] parents) {
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }
}