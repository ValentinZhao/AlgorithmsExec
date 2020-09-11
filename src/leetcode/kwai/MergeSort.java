package kwai;

public class MergeSort {
    public void mergeSort(int [] array, int start, int end){
        if(start == end) return;
        int mid = (start + end) / 2;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        int i = mid, j = end;
        int [] copy = new int[end - start + 1];
        int copy_index = end - start;
        while(i >= start && j >= mid + 1) {
            if (array[i] > array[j]) {
                copy[copy_index--] = array[i--];
            }else{
                copy[copy_index--] = array[j--];
            }
        }
        // 以下两个while只会执行一个，由上一个while的条件就知道了
        while(i >= start) copy[copy_index--] = array[i--];
        while(j >= mid + 1) copy[copy_index--] = array[j--];

        i = 0;
        // 把copy的数据按照start到end复制回array,copy数组是从0开始的，因为一开始copy的长度就是end-start
        while(start <= end) array[start++] = copy[i++];
    }
}
