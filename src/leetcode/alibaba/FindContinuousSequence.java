package alibaba;

public class FindContinuousSequence {
    public static void find(int n) {

        int start,end,mid,sum;
        mid = (n >> 1);
        start = 1;
        end = 2;
        sum = 3;
        while (start <= mid)
        {
            if (sum < n)
                sum += ++end; // move end forward and update the sum.
            else if (sum > n)
                sum -= start++; // move start forward and update the sum.
            else
            {
                // print the start and end of continuous sequence.
                System.out.println(start + " -> " + end);
                // move start forward, move end forward and update the sum.
                sum -= start++;
                sum += ++end;
            }
        }
    }
}
