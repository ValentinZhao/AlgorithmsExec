package companys;

public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        if(A == null || n < 0){
            return -1;
        }
        int mid = 0;
        int begin = 0;
        int end = n - 1;
        while(begin < end){
            mid = (begin + end) / 2;
            if(A[mid] == val){
                end = mid;
            } else if(A[mid] < val){
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if(A[begin] == val) return begin;
        return -1;
    }
}