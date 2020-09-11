package jianzhi;

public class Jz35 {
    public int InversePairs(int [] array) {
        int len = array.length;
        if(array== null || len <= 0){
            return 0;
        }
        return mergeSort(array, 0, len-1);
    }
    public int mergeSort(int [] array, int start, int end){
        if(start == end)
            return 0;
        int mid = (start + end) / 2;
        int left_count = mergeSort(array, start, mid);
        int right_count = mergeSort(array, mid + 1, end);
        int i = mid, j = end;
        int [] copy = new int[end - start + 1];
        int copy_index = end - start;
        int count = 0;
        while(i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[copy_index--] = array[i--];
                count += j - mid;
                if(count > 1000000007) count %= 1000000007;
            }else{
                copy[copy_index--] = array[j--];
            }
        }
        // 以下两个while只会执行一个，由上一个while的条件就知道了
        while(i >= start){
            copy[copy_index--] = array[i--];
        }
        while(j >= mid + 1){
            copy[copy_index--] = array[j--];
        }
        i = 0;
        // 把copy的数据按照start到end复制回array
        while(start <= end) {
            array[start++] = copy[i++];
        }
        return (left_count+right_count+count)%1000000007;
    }
}
