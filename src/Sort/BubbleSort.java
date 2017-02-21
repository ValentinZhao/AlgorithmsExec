package Sort;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		int[] a = new int[num];
		for(int i = 0; i < num; i++){
			a[i] = s.nextInt();
		}
		bubbleSort(a);
		for(int i = 0; i < num; i++){
			if(i == num - 1){
				System.out.print(a[i]);
				break;
			}
			System.out.print(a[i] + " ");
		}
	}

	private static void bubbleSort(int[] a) {
		if(a == null || a.length == 0){
			return;
		}
		int len = a.length;
		for(int i = 0; i < len; i++){
			for(int j = len - 1; j > i; j--){
				if(a[j] < a[j - 1]){
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}
}
