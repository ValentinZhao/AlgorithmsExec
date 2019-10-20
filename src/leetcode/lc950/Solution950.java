package lc950;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public  class Solution950 {
    // 反正这题的intuition就是排序好，然后把数组元素按照奇数index先排，再把剩下的元素按照偶素元素排好
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Arrays.sort(deck);

        int[] res = new int[N];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) dq.add(i);


        for (int card : deck) {
            res[dq.pollFirst()] = card;
            if (!dq.isEmpty()) dq.add(dq.pollFirst());
        }

        return res;
    }
}
