package servicenow;

public class FindFixPoint {
	public int find(int[] arr) {
		int lo = 0, hi = arr.length;
		int res = binarySearch(arr, lo, hi);

		return res;
	}

	private int binarySearch(int[] arr, int lo, int hi) {
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] < mid) lo = mid + 1;
			else hi = mid; // 找到了但不一定是最左的，继续往左
		}

		return arr[lo] == lo ? lo : -1;
	}
}
