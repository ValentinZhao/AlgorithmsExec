package lc299;

public class Solution299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                // 每次读secret字符的时候，如果它是小于零的，则证明guess字符曾经读到过，那么cow要增加
                // 每次读guess字符的时候，如果它是大于零的，则证明secret曾经读到过，还是增加
                // 那么你会问不会一增一减让计数为0影响统计？不会的，因为上下字符相同时，走的是上面的逻辑
                // 走下面的逻辑时，他们一定不是相同的
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
