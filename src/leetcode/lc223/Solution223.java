package lc223;

public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        // C - A第一个矩形长，D - B第一个矩形高，G-E第二个矩形长，H-F第二个矩形高
        // 找重叠部分，就是找两个左边、右边、上边和下边靠内的
        int left = Math.max(A,E), right = Math.max(Math.min(C,G), left);
        int bottom = Math.max(B,F), top = Math.max(Math.min(D,H), bottom);
        return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
    }
}
