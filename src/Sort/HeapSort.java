package Sort;

import java.util.Scanner;

public class HeapSort {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < num; i++){
			a[i] = s.nextInt();
		}
		heapSort(a);
		for(int i = 0; i < num; i++){
			if(i == num - 1){
				System.out.print(a[i]);
				break;
			}
			System.out.print(a[i] + " ");
		}
	}

	private static void heapSort(int[] a) {
		if(a == null || a.length == 0){
			return;
		}
		
		/**
		 * 建立大顶堆
		 */
		for(int i = a.length / 2; i >= 0; i--){
			heapAdjust(a, i, a.length - 1);
		}
		
		/**
		 * 不断将堆顶元素与数组最后一个元素调换
		 * 调换之后把这个元素之前的数组再调整成大顶堆
		 * 不断重复就可以把数组调整有序
		 */
		for(int i = a.length - 1; i >= 0; i--){
			swap(a, 0, i);
			heapAdjust(a, 0, i -1);
		}
	}

	private static void swap(int[] a, int from, int to) {
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}

	private static void heapAdjust(int[] a, int start, int end) {
		int temp = a[start];
		for(int i = 2 * start + 1; i < end; i *= 2){
			/**
			 * 左右孩子在数组中的下标为 2*i+1 和 2*i+2
			 * 首先选出两个孩子中较大的那个
			 */
			if(start < end && a[i] < a[i + 1]){
				i++;
			}
			
			if(temp >= a[i]){
				break; //此时本身就满足了大顶堆的要求，直接退出
			}
			
			a[start] = a[i]; //将子节点上移
			
			/**
			 * start向下移动继续循环
			 * 因为此时的temp存在比子节点小的情况，要向下接着找合适的位置插入
			 */
			start = i; 
		}
		a[start] = temp;//插入
	}
}
