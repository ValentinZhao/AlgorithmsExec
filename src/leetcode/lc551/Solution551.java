package lc551;

public class Solution551 {
    public boolean checkRecord(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='A')
                count++;
            // 对于连续不超过两个的比较，我们直接找有没有连续三个，这个思路和LC809有点像
        // 我们不需要去真正去算出现了几次，只要出现三次就不行了。
        // 809也是我们就看有没有连续的三个，不足三个那就必须对应字符一致，不一致直接false
        return count<2 && s.indexOf("LLL")<0;
    }
}
