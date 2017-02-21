package Sort;

import java.util.Scanner;

public class SelectSort {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int num = scanner.nextInt();
			int[] a = new int[num];
			for(int i = 0; i < num; i++){
				a[i] = scanner.nextInt();
			}
			selectSort(a);
//			System.out.println(a.length);
			for(int i = 0; i < num; i++){
				if(i == num - 1){
					System.out.print(a[i]);
					break;
				}
				System.out.print(a[i] + " ");
			}
		}
	}
	
	public static int[] selectSort(int[] arr){
		if(arr == null || arr.length == 0){
			return null;
		}
		int len = arr.length;
		for(int i = 0, k = 0; i < len; i++, k = i){
			for(int j = i + 1; j < len; j++){
				if(arr[k] > arr[j]){//后面有更小的值,这个for结束之后选一个最小的值
					k = j;
				}
			}
			if(i != k){
				int temp = arr[i];
				arr[i] = arr[k];
				arr[k] = temp;
			}
		}
		return arr;
	}
}
