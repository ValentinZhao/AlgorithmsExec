package jianzhi;

public class Jz46 {
    public int LastRemaining_Solution(int n, int m) {
        if(n==0||m==0)return -1;
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p+m) % i; // f(N,M)=(f(N−1,M)+M)%N
        }
        return p;
    }
}
