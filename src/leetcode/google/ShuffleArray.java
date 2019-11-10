package google;

/**
 * We know that, if we’re picking ai, it has to go to the index 2 * i – 1 and if bi, it has to go 2 * i.
 * We can check from where we have picked a certain number based on the picking index if it greater or less than n.
 *
 * We will have to do this for 2 * n – 2 times, assuming that n = half of length of array.
 */
public class ShuffleArray {
    public void shuffleArray(int[] a, int n) {
        int temp;
        n = n / 2;

        for (int start = n + 1, j = n + 1, done = 0, i;
             done < 2 * n - 2; done++) {
            if (start == j) {
                start--;
                j--;
            }

            i = j > n ? j - n : j;
            j = j > n ? 2 * i : 2 * i - 1; // 在前一半的就是a[i]，在后一半的就是b[i]，因为n是原长度的一半嘛，所以用这种方式来确定到底要交换哪种下标
            temp= a[start];
            a[start]= a[j];
            a[j]= temp;
        }
    }
}
