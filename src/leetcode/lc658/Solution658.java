package lc658;

import java.util.LinkedList;
import java.util.List;

public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        List<Integer> res = new LinkedList<>();
        boolean isFront = true;
        int frontCursor = index - 1;
        int rearCursor = index + 1;
        res.add(arr[index]);
        k--;
        while (k > 0) {
            if (isFront) {
                res.add(0, arr[frontCursor--]);
                isFront = false;
            } else {
                res.add(arr[rearCursor++]);
                isFront = true;
            }
            k--;
        }
        return res;
    }

    private int binarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) hi = mid-1;
            else lo = mid + 1;
        }
        return hi;
    }
}
