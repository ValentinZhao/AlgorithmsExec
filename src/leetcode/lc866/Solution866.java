package lc866;

public class Solution866 {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;
        // 这里是5位数，因为我们是用substring(1)来取数，会切掉一位，这样最多就是4位拼4位是8位，题目限制最多就是10^8
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString();
            int y = Integer.parseInt(s + r.substring(1));
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0) return false;
        return true;
    }
}
