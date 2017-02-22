package Sort;

import java.util.Scanner;

public class SwiftSort {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < num; i++){
			a[i] = s.nextInt();
		}
		swiftSort(a, 0, num - 1);
		for(int i = 0; i < num; i++){
			if(i == num - 1){
				System.out.print(a[i]);
				break;
			}
			System.out.print(a[i] + " ");
		}
	}

	private static void swiftSort(int[] a, int start, int end) {
		if(end - start > 1){
			int mid = partition(a, start, end);
			swiftSort(a, start, mid);//对pivot的左部分进行排序
			swiftSort(a, mid + 1, end);//对pivot的右部分进行排序
		}
	}
	
	private static int partition(int[] args, int start, int end){
		int pivot = args[start];
        while (start < end) {
            // 从右向左寻找，一直找到比参照值还小的数值，进行替换
            // 这里要注意，循环条件必须是 当后面的数 小于 参照值的时候
            // 我们才跳出这一层循环
            while (start < end && args[end] >= pivot)
                end--;

            if (start < end) {
                swap(args, start, end);
                start++;
            }
            /**
             * start在上面一般来说就已经向后移动过了，并且前面的start经过的值肯定是小于pivot的
             * 再从左向右移动就从新的start位置向后移动即可
             */
            while (start < end && args[start] < pivot)
                start++;

            if (start < end) {
                swap(args, end, start);
                end--;
            }
        }
        args[start] = pivot;
        return start;
	}

	private static void swap(int[] args, int start, int end) {
		int temp = args[start];
		args[start] = args[end];
		args[end] = temp;
	}
}
