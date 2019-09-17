package lc751;

import java.util.ArrayList;
import java.util.List;

public class Solution751 {
    //思路，找到这些IPs中从右往左第一位相同的二进制位
    // x & -x ;-x是x的补码，返回x与2^64的最大公约数，
    //即x最多能被n个2整除就返回2^n,如果x是奇数返回1;返回值为0 ，说明x=0;为其他数，表示x为x与2^64的最大公约数
    //一言以蔽之就是获取32位二进制表示中从右往左首次出现1

    public List<String> ipToCIDR(String ip, int range) {
        long x = 0;
        //以"."划分每个IP
        String[] ips = ip.split("\\.");
        for (int i = 0; i < ips.length; ++i) {
            x = Integer.parseInt(ips[i]) + x * 256;
        }

        List<String> ans = new ArrayList<>();
        while (range > 0) {
            long step = x & -x;//求得该IP用32位二进制表示中从右往左首次出现1的位置
            //-x才是x的补码，~x为反码
            //step如果为奇数，则该IP为第一个CIDR块
            //如果偶数，则该IP用二进制表示下的最低有效位的位数能表示的地址的数量
            while (step > range) step /= 2;
            ans.add(longToIP(x, (int)step));
            x += step;
            range -= step;
        }

        return ans;
    }

    String longToIP(long x, int step) {
        int[] ans = new int[4];
        ans[0] = (int) (x & 255); x >>= 8;
        ans[1] = (int) (x & 255); x >>= 8;
        ans[2] = (int) (x & 255); x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        while (step > 0) {
            len --;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;
    }
}
