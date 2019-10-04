package lc528;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Thanks, this is really a smart way of approaching this question.
 * To my understanding, I think the core trick of this solution is
 * to "translate and map" the individual weight of each index to a certain "region" in [0, tot)
 * where sizes of mapped region are actually proportional to weight of each index.
 *
 * For example, suppose the given input is [1, 3, 1, 5],
 * by using the idea of prefix sum, we will "map" weights to [1, 4, 5, 10],
 * where [0, 1) region belongs to index 0, [1,4) region belong to 1 ... etc.
 * As we can see, the size of region that each index get is proportional to its weight.
 * Then we only need to randomly generate a value in range [0, 10) and use binary search
 * to determine which region it falls upon so that we can tell that the "owner" of that region is the index we want to return.
 *
 * index:      0   1    2     3
 *           [  |     |   |        ]
 * prefix    0  1     4   5       10
 *
 */

public class Solution528 {

    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public Solution528(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            // 只是逼近target就可以落在这个portion里面
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

class Solution {

    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public Solution(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}