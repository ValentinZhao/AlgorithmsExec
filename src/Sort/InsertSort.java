package Sort;

import java.util.Scanner;

public class InsertSort {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < num; i++){
			a[i] = s.nextInt();
		}
		insertSort(a);
		for(int i = 0; i < num; i++){
			if(i == num - 1){
				System.out.print(a[i]);
				break;
			}
			System.out.print(a[i] + " ");
		}
	}
	
	public static int[] insertSort(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		int len = arr.length;
		for(int i = 1; i < len; i++){
			int j = i;
			int target = arr[i];
			while(j > 0 && target < arr[j - 1]){//target之前的这个数比较大的时候
				arr[j] = arr[j - 1]; //后移
				j--;
			}
			arr[j] = target;//target一直就是比较小的这个数，j在上面的while中也不断左移,插入
		}
		return arr;
	}
}
