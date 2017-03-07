package Search;

/**
 *二分查找
 */
public class BinarySearch {
	int low = 0;
	int high = 0;
	
	public int binarySearch(int[] a, int key){
		if(a == null || a.length <= 0){
			return (Integer) null;
		}
		high = a.length - 1;
		while(low < high){
			int mid = (low + high) / 2;
			if(a[mid] == key){
				return mid;
			} else if(a[mid] < key){
				low = mid + 1; //key小于中值时，提高下限可以把中值向下调，vice versa
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
